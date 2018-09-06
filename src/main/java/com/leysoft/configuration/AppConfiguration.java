
package com.leysoft.configuration;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.leysoft.beans.MicroOneFallbackProvider;
import com.leysoft.filter.CustomPostZuulFilter;
import com.leysoft.filter.CustomPreZuulFilter;

@Configuration
public class AppConfiguration {

    @Bean
    public CustomPreZuulFilter preFilter() {
        return new CustomPreZuulFilter();
    }

    @Bean
    public CustomPostZuulFilter postFilter() {
        return new CustomPostZuulFilter();
    }

    @Bean
    public FallbackProvider fallbackProvider() {
        return new MicroOneFallbackProvider();
    }
}
