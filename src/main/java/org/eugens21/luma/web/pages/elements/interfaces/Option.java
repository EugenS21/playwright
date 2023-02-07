package org.eugens21.luma.web.pages.elements.interfaces;

import java.util.List;

public interface Option extends Element {

    void selectOption(String element);

    List<String> getOptions();

}
