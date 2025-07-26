package io.myLogTrace.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    //
    http
      .csrf(AbstractHttpConfigurer::disable)
      .formLogin(AbstractHttpConfigurer::disable)
      .httpBasic(AbstractHttpConfigurer::disable)
      .cors(cors -> cors.configurationSource(corsConfigurationSource()))
      .authorizeHttpRequests(authorize -> authorize
        .requestMatchers(org.springframework.http.HttpMethod.GET, "/**").permitAll()
        .requestMatchers(org.springframework.http.HttpMethod.POST, "/**").permitAll()
        .requestMatchers(org.springframework.http.HttpMethod.PUT, "/**").permitAll()
        .requestMatchers(org.springframework.http.HttpMethod.DELETE, "/**").permitAll()
        .requestMatchers(org.springframework.http.HttpMethod.PATCH, "/**").permitAll()
        .anyRequest().permitAll()
      )
      .exceptionHandling(exception -> exception
        .authenticationEntryPoint((request, response, authException) -> {
          response.sendError(org.springframework.http.HttpStatus.UNAUTHORIZED.value(), "Unauthorized");
        })
        .accessDeniedHandler((request, response, accessDeniedException) -> {
          response.sendError(org.springframework.http.HttpStatus.FORBIDDEN.value(), "Forbidden");
        })
      );

    return http.build();
  }

  @Bean
  public CorsConfigurationSource corsConfigurationSource() {
    //
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.setAllowedOrigins(List.of("http://localhost:3000"));
    configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "PATCH"));
    configuration.setAllowedHeaders(List.of("*"));
    configuration.setAllowCredentials(true);
    configuration.setMaxAge(3600L);

    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return source;
  }
}