package org.eugens21.luma.web.pages.elements;

import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.web.pages.elements.interfaces.ISpan;

@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class Span implements ISpan {

    Locator locator;

    @Override
    public String getContent() {
        return locator.textContent().trim();
    }

}
