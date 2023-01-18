package org.eugens21.luma.web.pages.elements;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.properties.pages.search_results.RelatedTermsBlockDetails;
import org.eugens21.luma.web.pages.elements.interfaces.IDescritionList;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
public class DescriptionList implements IDescritionList {

    String selfLocator;
    Page page;

    public DescriptionList(Page page, RelatedTermsBlockDetails relatedTermsBlock) {
        this.selfLocator = relatedTermsBlock.getSelf();
        this.page = page;
    }

    @Override
    public Locator getLocator() {
        return page.locator(selfLocator);
    }

}
