package org.eugens21.luma.data_table.type;

import io.cucumber.java.DataTableType;
import org.eugens21.luma.data_table.model.HeaderLinkProperty;

import java.util.Map;

import static java.lang.Boolean.valueOf;

public class HeaderLinksProperties {

    @DataTableType
    public HeaderLinkProperty getHeaderProperty(Map<String, String> entry) {
        return HeaderLinkProperty.builder()
                .link(entry.get("Link"))
                .isClickable(valueOf(entry.get("Clickable")))
                .isDisplayed(valueOf(entry.get("Displayed")))
                .build();
    }

}
