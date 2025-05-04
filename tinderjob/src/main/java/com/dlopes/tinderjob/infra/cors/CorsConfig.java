package com.dlopes.tinderjob.infra.cors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Project: tinderjob
 * Package: com.dlopes.tinderjob.infra.cors
 * <p>
 * User: MegaD
 * Email: davylopes866@gmail.com
 * Date: 02/05/2025
 * Time: 01:55
 * <p>
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200") // ou setAllowedOriginPatterns para múltiplos domínios
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("Authorization", "Content-Type")
                .allowCredentials(true); // necessário se usar cookies ou autenticação baseada em sessão
    }
}
