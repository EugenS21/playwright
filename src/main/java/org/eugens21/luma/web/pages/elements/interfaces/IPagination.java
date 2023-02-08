package org.eugens21.luma.web.pages.elements.interfaces;

import org.eugens21.luma.web.pages.elements.Anchor;
import org.eugens21.luma.web.pages.elements.Span;

import java.util.List;

public interface IPagination extends Element {

    Anchor previous();

    Anchor next();

    Span getCurrentPage();

    void selectPage(Integer pageNumber);

    List<String> pages();

}
