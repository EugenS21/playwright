package org.eugens21.luma.properties;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.properties.pages.common.CommonPageDetails;
import org.eugens21.luma.properties.pages.search_results.SearchResultsDetails;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import static lombok.AccessLevel.PRIVATE;

@Data
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@ConfigurationPropertiesScan
@ConfigurationProperties(prefix = "pages")
public class PageLocators {

    @NestedConfigurationProperty
    CommonPageDetails common;
    @NestedConfigurationProperty
    SearchResultsDetails searchResults;

}
