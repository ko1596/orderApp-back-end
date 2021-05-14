package com.example.restservice.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


@Configuration
public class AppConfig {
    @Bean
    public CorsFilter corsFilter(){
        
        CorsConfiguration config = new CorsConfiguration();

        //允許跨網域請求的來源
        config.addAllowedOriginPattern("*");

        //允許某些網域
        // config.addAllowedOrigin(URL);

        //允許跨域攜帶cookie資訊，預設跨網域請求是不攜帶cookie資訊的。
        config.setAllowCredentials(true);

        //允許使用那些請求方式
        config.setAllowedMethods(Arrays.asList("GET", "PUT", "POST","DELETE"));

        config.addAllowedHeader("*");

        config.addExposedHeader("/*");

        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
        configSource.registerCorsConfiguration("/**", config);

        return new CorsFilter(configSource);
    }
}
