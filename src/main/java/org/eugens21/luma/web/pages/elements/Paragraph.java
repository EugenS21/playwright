package org.eugens21.luma.web.pages.elements;

import com.microsoft.playwright.Locator;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.web.pages.elements.interfaces.IParagraph;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class Paragraph implements IParagraph {

    Locator locator;

    @Override
    public String getContent() {
        return locator.innerText();
    }
}
