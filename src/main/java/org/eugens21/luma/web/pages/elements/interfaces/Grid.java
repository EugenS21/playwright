package org.eugens21.luma.web.pages.elements.interfaces;

import java.util.List;

public interface Grid<T> extends Element {

    List<T> getElements();

    T searchForElement(T element);

}
