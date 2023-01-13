package org.eugens21.luma.web.service;

import com.microsoft.playwright.BrowserType;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.properties.Application;
import org.eugens21.luma.properties.user_interface.LaunchOptions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
@Service
public class LaunchOptionsService {

    LaunchOptions launchOptions;
    ModelMapper modelMapper;

    @Autowired
    public LaunchOptionsService(Application application, ModelMapper modelMapper) {
        this.launchOptions = application.getUserInterface().getPlaywright().getBrowser().getLaunchOptions();
        this.modelMapper = modelMapper;
        this.modelMapper.createTypeMap(LaunchOptions.class, BrowserType.LaunchOptions.class)
                .addMapping(LaunchOptions::getDevTools, BrowserType.LaunchOptions::setDevtools);
    }

    public BrowserType.LaunchOptions getLaunchOptions() {
        return modelMapper.map(launchOptions, BrowserType.LaunchOptions.class);
    }

}
