package my.project.app.requesthandler.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Overriding default config. Initially solved the Access-Control-Allow-Origin problem by setting the header
 * on each REST response. But when doing POST from FE, protocol first does an OPTIONS request. The response from spring
 * didn't have the header, so CORS failed.
 * In the end, overriding everything here and removing extra header in REST response.
 *
 */
@Configuration
@EnableWebMvc
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowedOrigins("*").maxAge(30);
    }
}