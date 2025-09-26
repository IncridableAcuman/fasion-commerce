package com.app.backend.configs;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

public interface WebConfiguration {
    void addResourceHandler(ResourceHandlerRegistry registry);
}
