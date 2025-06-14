
package vn.group27.buildingManagement.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Cho phép tất cả đường dẫn
                        .allowedOrigins("http://localhost:63343") // Cho phép từ origin này
                        .allowedMethods("*") // GET, POST, PUT, DELETE, ...
                        .allowedHeaders("*");
            }
        };
    }

}