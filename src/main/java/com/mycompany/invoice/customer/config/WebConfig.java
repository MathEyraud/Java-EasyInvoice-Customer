package com.mycompany.invoice.customer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // Injecter la propriété cors.allowed.origins définie dans application.properties
    @Value("${cors.allowed.origins}")
    private String[] allowedOrigins;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")                                // Appliquer la configuration CORS à toutes les routes
                .allowedOrigins(allowedOrigins)                             // Utiliser les origines autorisées définies dans application.properties
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Autoriser ces méthodes HTTP
                .allowedHeaders("*")                                        // Autoriser tous les en-têtes
                .allowCredentials(true);                                    // Autoriser l'envoi des cookies et des informations d'authentification
    }
}
