package com.example.JWTAuthentication.config;

import com.example.JWTAuthentication.security.JWTAthenticationEntryPoint;
import com.example.JWTAuthentication.security.JWTAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {
    private final JWTAthenticationEntryPoint point;
    private final JWTAuthenticationFilter filter;

    public SecurityConfig(JWTAthenticationEntryPoint point, JWTAuthenticationFilter filter) {
        this.point = point;
        this.filter = filter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // configuration
        http.csrf(csrf->csrf.disable())
                .cors(cors->cors.disable())
                .authorizeHttpRequests(auth->auth.requestMatchers("/home/**").authenticated()
                        .requestMatchers("/auth/login").permitAll().anyRequest()
                        .authenticated())
                        .exceptionHandling(ex->ex.authenticationEntryPoint(point))
                        .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.addFilterBefore(filter,UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
