package org.eugens21.luma.hook;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.storage.ScenarioContext;
import org.eugens21.luma.web.service.BrowserService;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
@RequiredArgsConstructor
public class BrowserHooks {

    BrowserService browserService;
    ScenarioContext scenarioContext;

}
