package org.eugens21.luma.web.service;

import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.options.Geolocation;
import com.microsoft.playwright.options.RecordVideoSize;
import com.microsoft.playwright.options.ScreenSize;
import com.microsoft.playwright.options.ViewportSize;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.properties.Application;
import org.eugens21.luma.properties.user_interface.ContextOptions;
import org.eugens21.luma.properties.user_interface.GeoLocation;
import org.eugens21.luma.properties.user_interface.HttpCredentials;
import org.eugens21.luma.properties.user_interface.Size;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
@Service
public class ContextOptionsService {

    ContextOptions contextOptions;
    ModelMapper modelMapper;

    @Autowired
    public ContextOptionsService(Application application, ModelMapper modelMapper) {
        this.contextOptions = application.getUserInterface().getPlaywright().getBrowser().getContextOptions();
        this.modelMapper = modelMapper;
        this.modelMapper.createTypeMap(ContextOptions.class, NewContextOptions.class)
                .addMappings(mapper -> mapper.using(geoLocationConverter())
                        .<Geolocation>map(ContextOptions::getGeoLocation, NewContextOptions::setGeolocation))
                .addMappings(mapper -> mapper.using(httpCredentialsConverter())
                        .<com.microsoft.playwright.options.HttpCredentials>map(ContextOptions::getHttpCredentials, NewContextOptions::setHttpCredentials))
                .addMappings(mapper -> mapper.using(recordVideoSizeConverter())
                        .<RecordVideoSize>map(ContextOptions::getRecordVideoSize, NewContextOptions::setRecordVideoSize))
                .addMappings(mapper -> mapper.using(screenSizeConverter())
                        .<ScreenSize>map(ContextOptions::getScreenSize, NewContextOptions::setScreenSize))
                .addMappings(mapper -> mapper.using(viewportSizeConverter())
                        .<ViewportSize>map(ContextOptions::getViewportSize, NewContextOptions::setViewportSize));

    }

    private Converter<GeoLocation, Geolocation> geoLocationConverter() {
        return ctx -> {
            GeoLocation source = ctx.getSource();
            Geolocation geolocation = new Geolocation(source.getLatitude(), source.getLongitude());
            geolocation.setAccuracy(source.getAccuracy());
            return geolocation;
        };
    }

    private Converter<HttpCredentials, com.microsoft.playwright.options.HttpCredentials> httpCredentialsConverter() {
        return ctx -> {
            HttpCredentials source = ctx.getSource();
            return new com.microsoft.playwright.options.HttpCredentials(source.getUsername(), source.getPassword());
        };
    }

    private Converter<Size, RecordVideoSize> recordVideoSizeConverter() {
        return ctx -> {
            Size source = ctx.getSource();
            return new RecordVideoSize(source.getWidth(), source.getHeight());
        };
    }

    private Converter<Size, ScreenSize> screenSizeConverter() {
        return ctx -> {
            Size source = ctx.getSource();
            return new ScreenSize(source.getWidth(), source.getHeight());
        };
    }

    private Converter<Size, ViewportSize> viewportSizeConverter() {
        return ctx -> {
            Size source = ctx.getSource();
            return new ViewportSize(source.getWidth(), source.getHeight());
        };
    }

    public NewContextOptions getContextOptions() {
        return modelMapper.map(contextOptions, NewContextOptions.class);
    }

}
