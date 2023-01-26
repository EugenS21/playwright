package org.eugens21.luma.properties.pages.search_results;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.properties.pages.AbstractDetails;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class ResultsDetails extends AbstractDetails {

    @NestedConfigurationProperty
    HeaderDetails header;
    @NestedConfigurationProperty
    RelatedTermsBlockDetails relatedTermsBlock;
    @NestedConfigurationProperty
    ContentDetails content;
    @NestedConfigurationProperty
    FooterDetails footer;

}