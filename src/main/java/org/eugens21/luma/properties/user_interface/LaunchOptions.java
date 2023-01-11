package org.eugens21.luma.properties.user_interface;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;

@NoArgsConstructor(force = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class LaunchOptions {

    List<String> args;
    String channel;
    Boolean chromiumSandbox;
    Boolean devTools;
    Path downloadsPath;
    Map<String, String> env;
    Path executablePath;
    Boolean ignoreAllDefaultArgs;
    List<String> ignoreDefaultArgs;
    Boolean headless;
    String proxy;
    Double slowMo;
    Double timeout;
    Path tracesDir;

}
