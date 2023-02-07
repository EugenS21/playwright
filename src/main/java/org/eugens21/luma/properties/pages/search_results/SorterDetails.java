package org.eugens21.luma.properties.pages.search_results;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.properties.pages.AbstractDetails;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@EqualsAndHashCode(callSuper = false)
@Data
public class SorterDetails extends AbstractDetails {

    SorterOptionDetails sorterOptions;

}
