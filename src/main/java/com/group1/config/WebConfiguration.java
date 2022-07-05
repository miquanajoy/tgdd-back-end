package com.group1.config;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/*@Configuration 
public class WebConfiguration extends WebMvcConfigurationSupport{

	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    { 
            registry.addResourceHandler("/resources/**")
                 .addResourceLocations("classpath:/static/images/**")
                 .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
    }

}*/
