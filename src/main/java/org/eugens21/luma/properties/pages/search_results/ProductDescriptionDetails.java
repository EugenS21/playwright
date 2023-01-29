package org.eugens21.luma.properties.pages.search_results;

import com.microsoft.playwright.options.AriaRole;
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
public class ProductDescriptionDetails extends AbstractDetails {

    AriaRole learnMore;

}
