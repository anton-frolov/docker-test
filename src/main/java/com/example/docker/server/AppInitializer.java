package com.example.docker.server;


import org.springframework.context.annotation.Configuration;

import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.util.ObjectUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.*;

@Configuration
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    private AnnotationConfigWebApplicationContext appContext;

    public AppInitializer() {}

    protected AnnotationConfigWebApplicationContext getAppContext() {
        return ContextHolder.APP_CONTEXT;
    }

    public static class ContextHolder {
        public static final AnnotationConfigWebApplicationContext APP_CONTEXT = new AnnotationConfigWebApplicationContext();
    }


    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SecurityConfig.class, AppConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MvcConfig.class,};
    }

    @Override
    protected String[] getServletMappings() {

        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        DelegatingFilterProxy securityDelegatingFilterProxy = new DelegatingFilterProxy("springSecurityFilterChain");
        return new Filter[]{
                securityDelegatingFilterProxy
        };
    }


    @Override
    protected WebApplicationContext createServletApplicationContext() {
        AnnotationConfigWebApplicationContext servletAppContext = getAppContext();
        Class<?>[] configClasses = getServletConfigClasses();
        if (!ObjectUtils.isEmpty(configClasses)) {
            servletAppContext.register(configClasses);
        }
        return servletAppContext;
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        super.onStartup(servletContext);

        servletContext.addListener(new HttpSessionEventPublisher());
        servletContext.addListener(new RequestContextListener());


		/*ServletRegistration.Dynamic servlet = servletContext.addServlet("appServiceServlet", new AppServiceImpl());
		servlet.addMapping("/main/service");
		servlet.setLoadOnStartup(1);*/

    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(new MultipartConfigElement("", 1024 * 1024 * 10, 1024 * 1024 * 50, 1024 * 1024 * 100));
    }
}
