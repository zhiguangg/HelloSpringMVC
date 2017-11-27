package com.java.spring.HelloSpringMVC.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
@EnableWebMvc
//public class WebMvcConfig extends WebMvcConfigurerAdapter {
public class WebMvcConfig extends WebMvcConfigurationSupport {
 
    // Static Resource Config 
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	// Css resource.
       registry.addResourceHandler("resources/**").addResourceLocations("/resources/").setCachePeriod(31556926);
       // registry.addResourceHandler("/img/**").addResourceLocations("/img/").setCachePeriod(31556926);
       // registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(31556926);
    }
 
     
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable("dispatcher");
    }
}
