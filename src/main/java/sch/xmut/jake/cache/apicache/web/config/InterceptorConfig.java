package sch.xmut.jake.cache.apicache.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import sch.xmut.jake.cache.apicache.web.interceptor.KeyCheckInterceptor;

/**
 * Created by Jake.lin on 2019/12/09
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(keyCheckInterceptor());
    }

    @Bean
    public KeyCheckInterceptor keyCheckInterceptor() {
        return new KeyCheckInterceptor();
    }
}
