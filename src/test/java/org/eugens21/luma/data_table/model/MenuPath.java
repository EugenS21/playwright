package org.eugens21.luma.data_table.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.web.pages.enums.NavigationMenuEnum;

@Getter
@Builder
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class MenuPath {

    NavigationMenuEnum mainMenu;
    String[] pathToVisit;

}
