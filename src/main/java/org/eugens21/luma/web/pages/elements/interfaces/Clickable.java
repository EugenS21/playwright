package org.eugens21.luma.web.pages.elements.interfaces;

public interface Clickable extends Element{

    default void click() {
        getLocator().click();
    }

}
