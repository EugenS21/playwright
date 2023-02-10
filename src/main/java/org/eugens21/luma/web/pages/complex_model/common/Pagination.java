package org.eugens21.luma.web.pages.complex_model.common;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.properties.pages.search_results.PageDetails;
import org.eugens21.luma.web.functional.ScrollTo;
import org.eugens21.luma.web.pages.elements.Anchor;
import org.eugens21.luma.web.pages.elements.Span;
import org.eugens21.luma.web.pages.elements.interfaces.IPagination;

import java.util.List;
import java.util.stream.Stream;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
@Getter
public class Pagination implements IPagination {

    Locator locator;
    PageDetails pageDetails;

    public Pagination(Page page, PageDetails pageDetails) {
        this.locator = page.locator(pageDetails.getSelf()).last();
        this.pageDetails = pageDetails;

    }

    @Override
    @ScrollTo
    public Anchor previous() {
        return new Anchor(locator.locator(pageDetails.getPrevious()));
    }

    @Override
    @ScrollTo
    public Anchor next() {
        return new Anchor(locator.locator(pageDetails.getNext()));
    }

    @Override
    @ScrollTo
    public Span getCurrentPage() {
        return new Span(locator.locator(pageDetails.getCurrent()));
    }

    @Override
    @ScrollTo
    public void selectPage(Integer pageNumber) {
        Locator pages = locator.locator(pageDetails.getPages());
        Stream.iterate(0, i -> i + 1)
                .limit(pages.count())
                .map(pages::nth)
                .filter(el -> el.textContent().equals(pageNumber.toString()))
                .findFirst()
                .ifPresent(Locator::click);
    }

    @Override
    @ScrollTo
    public List<String> pages() {
        Locator pages = locator.locator(pageDetails.getPages());
        return Stream.iterate(0, i -> i + 1)
                .limit(pages.count())
                .map(pages::nth)
                .map(Span::new)
                .map(Span::getContent)
                .toList();
    }

}
