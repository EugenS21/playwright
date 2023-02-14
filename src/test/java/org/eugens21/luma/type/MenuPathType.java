package org.eugens21.luma.type;

import io.cucumber.java.ParameterType;
import org.eugens21.luma.data_table.model.MenuPath;
import org.eugens21.luma.web.pages.enums.NavigationMenuEnum;

import java.util.Arrays;

public class MenuPathType {

    @ParameterType(value = ".*", name = "menuPath")
    public MenuPath getMenuPath(String path) {
        String[] split = path.split(">>");
        return MenuPath.builder()
                .mainMenu(NavigationMenuEnum.of(split[0]))
                .pathToVisit(split.length > 1 ? Arrays.copyOfRange(split, 1, split.length) : null)
                .build();
    }

}
