package com.isariev.keycloakdockerpostgresql.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
class SecurityConfig {

    private final JwtAuthenticationConverter authenticationConverter;

    SecurityConfig(JwtAuthenticationConverter authenticationConverter) {
        this.authenticationConverter = authenticationConverter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(requests -> {
                    requests.requestMatchers(HttpMethod.GET, "/api/orders").permitAll();
                    requests.anyRequest().authenticated();
                })
                .oauth2Login(Customizer.withDefaults())
                .oauth2ResourceServer(oauth2Configurer -> oauth2Configurer
                        .jwt(jwtConfigurer -> jwtConfigurer
                                .jwtAuthenticationConverter(authenticationConverter)))
                .csrf(csrf ->
                        csrf.csrfTokenRepository(new HttpSessionCsrfTokenRepository())
                );

        return http.build();
    }
}
