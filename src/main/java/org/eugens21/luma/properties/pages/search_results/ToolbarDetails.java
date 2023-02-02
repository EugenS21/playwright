package org.eugens21.luma.properties.pages.search_results;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.properties.pages.AbstractDetails;

@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = false)
@Data
public class ToolbarDetails extends AbstractDetails {

    ViewModesDetails viewModes;
    AmountDetails amount;
    SorterDetails sorter;

}
