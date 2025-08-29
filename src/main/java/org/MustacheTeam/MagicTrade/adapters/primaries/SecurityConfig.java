package org.MustacheTeam.MagicTrade.adapters.primaries;

import org.MustacheTeam.MagicTrade.adapters.security.JwtAuthenticationFilter;
import org.MustacheTeam.MagicTrade.adapters.security.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

@Configuration
@EnableWebSecurity
//@EnableMethodSecurity // Préparation admin
public class SecurityConfig {

    @Value("${cors.allowed-origin}")
    private String allowedOrigin;

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final CustomUserDetailsService customUserDetailsService;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter, CustomUserDetailsService customUserDetailsService) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.customUserDetailsService = customUserDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .cors(cors -> cors
                        .configurationSource(request -> {
                            CorsConfiguration config = new CorsConfiguration();
                            config.setAllowedOrigins(List.of(allowedOrigin));
                            config.setAllowedMethods(List.of("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
                            config.setAllowedHeaders(List.of("*"));
                            config.setAllowCredentials(true);
                            return config;
                        })
                )
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/magicTrade-api/auth/**",
                                "/magicTrade-api/users",
                                "/magicTrade-api/cards/**",
                                "/magicTrade-api/sets/**",
                                "/magicTrade-api/catalog/**",
                                "/magicTrade-api/double-cards"
                        ).permitAll()
                                .requestMatchers(HttpMethod.GET,
                                        "magicTrade-api/trade_proposal/**",
                                        "magicTrade-api/collections/**",
                                        "magicTrade-api/trade/**"
                                ).permitAll()
                                .requestMatchers(HttpMethod.POST,
                                        "magicTrade-api/trade_proposal/**",
                                        "magicTrade-api/collections/**",
                                        "magicTrade-api/trade/**"
                                ).authenticated()
                                .requestMatchers(HttpMethod.PUT,
                                        "magicTrade-api/trade_proposal/**",
                                        "magicTrade-api/collections/**",
                                        "magicTrade-api/trade/**"
                                ).authenticated()
                                .requestMatchers(HttpMethod.DELETE,
                                        "magicTrade-api/trade_proposal/**",
                                        "magicTrade-api/collections/**",
                                        "magicTrade-api/trade/**"
                                ).authenticated()
    //                    .requestMatchers("/admin/**").hasRole("ADMIN") // Préparation admin
                        .anyRequest().authenticated()
                )
                .userDetailsService(customUserDetailsService)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

}

