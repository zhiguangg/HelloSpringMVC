package com.java.spring.HelloSpringMVC.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

public class SpringWebAppInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext cxt = new AnnotationConfigWebApplicationContext();
		cxt.register(ApplicationContextConfig.class);
		cxt.setServletContext(servletContext);
		//Dispatcher Servlet
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(cxt));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
		
		dispatcher.setInitParameter("contextClass", cxt.getClass().getName());
		
		servletContext.addListener(new ContextLoaderListener(cxt));
		
		//UTF8 Character Filter
		FilterRegistration.Dynamic fr = servletContext.addFilter("encodingFiler", CharacterEncodingFilter.class);
		
		fr.setInitParameter("encoding", "UTF-8");
		fr.setInitParameter("forceEncoding", "true");
		fr.addMappingForUrlPatterns(null, true, "/");
	}

}
