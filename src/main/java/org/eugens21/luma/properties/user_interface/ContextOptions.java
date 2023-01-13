package org.eugens21.luma.properties.user_interface;

import com.microsoft.playwright.options.*;
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
public class ContextOptions {

    Boolean acceptDownloads;
    String baseUrl;
    Boolean bypassCSP;
    ColorScheme colorScheme;
    Double deviceScaleFactor;
    Map<String, String> extraHTTPHeaders;
    ForcedColors forcedColors;
    GeoLocation geoLocation;
    Boolean hasTouch;
    HttpCredentials httpCredentials;
    Boolean ignoreHTTPSErrors;
    Boolean isMobile;
    Boolean javaScriptEnabled;
    String locale;
    Boolean offline;
    List<String> permissions;
    String proxy;
    HarContentPolicy recordHarContent;
    HarMode recordHarMode;
    Boolean recordHarOmitContent;
    Path recordHarPath;
    String recordHarUrlFilter;
    Path recordVideoDir;
    Size recordVideoSize;
    ReducedMotion reducedMotion;
    Size screenSize;
    ServiceWorkerPolicy serviceWorkers;
    String storageState;
    Path storageStatePath;
    Boolean strictSelectors;
    Integer timezoneId;
    String userAgent;
    Size viewportSize;

}
