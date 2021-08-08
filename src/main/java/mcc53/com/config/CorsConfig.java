package mcc53.com.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    private final String[] DOMAINS = {"http://localhost:8080/"};
    private final String[] METHODS = {"GET", "PUT", "POST", "DELETE"};

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")
                .allowedOrigins(DOMAINS)
                .allowedMethods(METHODS)
                .allowCredentials(true);

    }
}