package org.eugens21.luma.properties.user_interface;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor(force = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class HttpCredentials {

    String username;
    String password;

}
