package com.lyn.spring.config;

import com.lyn.spring.filter.MyFilter;
import com.lyn.spring.servlet.MyServlet;
import com.lyn.spring.servletlistener.MyServletListener;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author lyn
 * @create 2020-05-09 18:24
 */
@Configuration
public class MySeverConfig {

    /**
     * 配置嵌入式的servlet容器
     * @return
     */
    @Bean
    public WebServerFactoryCustomizer webServerFactoryCustomizer(){
        return new WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>() {
            @Override
            public void customize(ConfigurableServletWebServerFactory  factory) {
                //factory.setPort(8093);
            }
        };
    }

    /**
     * 注册自定义servlet
     * @return
     */
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        ServletRegistrationBean servletServletRegistrationBean = new ServletRegistrationBean(new MyServlet(),"/myservlet");
        return servletServletRegistrationBean;
    }

    /**
     * 注册自定义filter
     * @return
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/hello","/myservlet"));
        return filterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean(){
        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean(new MyServletListener());
        return servletListenerRegistrationBean;
    }
}
