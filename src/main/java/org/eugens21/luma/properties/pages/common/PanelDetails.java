package org.eugens21.luma.properties.pages.common;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.properties.pages.AbstractDetails;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = false)
@Data
public class PanelDetails extends AbstractDetails {

    @NestedConfigurationProperty
    PanelLinksDetails links;

}
