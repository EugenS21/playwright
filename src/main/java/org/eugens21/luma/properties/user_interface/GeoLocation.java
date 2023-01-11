package org.eugens21.luma.properties.user_interface;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor(force = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class GeoLocation {

    Double latitude;
    Double longitude;
    Double accuracy;

}
