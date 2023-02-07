package org.eugens21.luma.type;

import io.cucumber.java.ParameterType;
import org.eugens21.luma.enums.PageNavigationEnum;
import org.eugens21.luma.web.pages.enums.SortByEnum;
import org.eugens21.luma.web.pages.enums.SortEnum;
import org.eugens21.luma.web.pages.enums.ViewModeEnum;

public class EnumTypes {

    @ParameterType(value = "LIST|GRID", name = "viewMode")
    public ViewModeEnum getViewMode(String viewMode) {
        return ViewModeEnum.valueOf(viewMode);
    }

    @ParameterType(value = "RELEVANCE|PRICE|PRODUCT_NAME", name = "sortBy")
    public SortByEnum getSortBy(String sortBy) {
        return SortByEnum.valueOf(sortBy);
    }

    @ParameterType(value = "ASC|DESC", name = "sort")
    public SortEnum getSort(String sort) {
        return SortEnum.valueOf(sort);
    }

    @ParameterType(value = "next|previous", name = "page")
    public PageNavigationEnum getPageNavigation(String page) {
        return PageNavigationEnum.valueOf(page.toUpperCase());
    }

}
