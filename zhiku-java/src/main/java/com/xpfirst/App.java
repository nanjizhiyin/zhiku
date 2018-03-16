package com.xpfirst;

import org.apache.catalina.filters.RemoteIpFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.filter.HttpPutFormContentFilter;

/**
 * Hello world!
 *
 */
@SpringBootApplication
//启注解事务管理
@MapperScan(basePackages= {"com.xpfirst.dao"})
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
        System.out.println( "智库已经启动" );
    }

    @Bean
    public RemoteIpFilter remoteIpFilter() {
        return new RemoteIpFilter();
    }

    @Bean
    public FilterRegistrationBean httpPutFormContentFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        HttpPutFormContentFilter httpPutFormContentFilter = new HttpPutFormContentFilter();
        registration.setFilter(httpPutFormContentFilter);
        registration.addUrlPatterns("/*");
        return registration;
    }
    @Bean
    public FilterRegistrationBean testFilterRegistration() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new VisitFilter());
        registration.addUrlPatterns("/*");
        registration.setName("visitFilter");
        registration.setOrder(1);
        return registration;
    }
}
