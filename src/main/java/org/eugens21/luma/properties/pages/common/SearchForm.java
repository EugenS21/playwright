package org.eugens21.luma.properties.pages.common;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.properties.pages.AbstractDetails;

@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class SearchForm extends AbstractDetails {

    String searchButton;

}