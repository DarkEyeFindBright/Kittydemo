package com.kitty.hotel.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfiguration implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/images/**")
                .addResourceLocations("classpath:/templates/images/");
        registry.addResourceHandler("/css/**")
                .addResourceLocations("classpath:/templates/css/");
        registry.addResourceHandler("/js/**")
                .addResourceLocations("classpath:/templates/js/");
        registry.addResourceHandler("/fonts/**")
                .addResourceLocations("classpath:/templates/fonts/");
        registry.addResourceHandler("/jquery/**")
                .addResourceLocations("classpath:/templates/jquery/");
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/templates/");
        registry.addResourceHandler("/RoomInfo/css/**")
                .addResourceLocations("classpath:/templates/css/");
        registry.addResourceHandler("/StaffInfo/css/**")
                .addResourceLocations("classpath:/templates/css/");
        registry.addResourceHandler("/AppInfo/css/**")
                .addResourceLocations("classpath:/templates/css/");
        registry.addResourceHandler("/img/**")
                .addResourceLocations("classpath:/templates/images/");

    }


}
