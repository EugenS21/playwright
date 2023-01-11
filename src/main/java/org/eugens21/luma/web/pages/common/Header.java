package org.eugens21.luma.web.pages.common;

import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Header {

    Search search;
    Cart cart;

    public Header(Page page) {
        cart = new Cart(page);
        search = new Search(page);
    }

}
