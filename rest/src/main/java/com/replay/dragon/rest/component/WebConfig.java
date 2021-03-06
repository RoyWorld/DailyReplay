package com.replay.dragon.rest.component;

import com.replay.dragon.rest.util.ContentUtil;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.nio.charset.Charset;

/**
 * Created by RoyChan on 2018/10/18.
 */
@Configuration
public class WebConfig {
    @Bean
    public HttpMessageConverters fastJsonMessageConverters() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter(ContentUtil.getObjectMapper());
        converter.setDefaultCharset(Charset.forName("UTF-8"));
        return new HttpMessageConverters(converter);
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(source);
    }
}
