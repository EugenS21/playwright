package org.eugens21.luma.web.utils;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.*;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
@Slf4j
public class EnvironmentDetailsWriter {

    List<String> systemPropertiesToIncludeInTheReport;

    public EnvironmentDetailsWriter() {
        this.systemPropertiesToIncludeInTheReport = new ArrayList<>() {{
            add("cucumber.options.tags");
            add("os.name");
            add("os.version");
            add("os.arch");
            add("java.specification.version");
            add("java.specification.vendor");
            add("java.class.version");
            add("java.runtime.name");
            add("java.runtime.version");
            add("java.vendor.version");
            add("java.vm.version");
            add("user.name");
            add("user.language");
            add("user.country");
            add("user.timezone ");
            add("java.class.path");
        }};
    }

    @SneakyThrows({ParserConfigurationException.class, TransformerConfigurationException.class, TransformerException.class})
    public void write(Set<Map.Entry<Object, Object>> detailsMap) {
        Document xmlDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element element = xmlDocument.createElement("environment");
        xmlDocument.appendChild(element);
        getMapWithSupportedProperties(detailsMap).forEach((k, v) -> {
            Element parameter = xmlDocument.createElement("parameter");
            Element key = xmlDocument.createElement("key");
            Element value = xmlDocument.createElement("value");
            key.appendChild(xmlDocument.createTextNode(k.toString()));
            value.appendChild(xmlDocument.createTextNode(v.toString()));
            parameter.appendChild(key);
            parameter.appendChild(value);
            element.appendChild(parameter);
        });
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        DOMSource source = new DOMSource(xmlDocument);
        File allureResultsDir = new File(System.getProperty("user.dir") + "/target/allure-results");
        if (!allureResultsDir.exists()) {
            log.debug("Allure directory {} not created, added {}", allureResultsDir, allureResultsDir.mkdirs());
        }
        StreamResult result = new StreamResult(new File(System.getProperty("user.dir") + "/target/allure-results/environment.xml"));
        transformer.transform(source, result);
    }

    private Map<Object, Object> getMapWithSupportedProperties(Set<Map.Entry<Object, Object>> inputMap) {
        return inputMap.stream()
                .filter(e -> systemPropertiesToIncludeInTheReport.contains(e.getKey().toString()))
                .collect(HashMap::new, (map, entry) -> map.put(entry.getKey(), entry.getValue()), HashMap::putAll);
    }

}
