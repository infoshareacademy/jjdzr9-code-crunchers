package com.isa.jjdzr.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class WebSecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        System.out.println("=====================================");
        System.out.println("REDIRECT 5");
            http.csrf()
                .disable()
                    .authorizeRequests(request ->
                        request.requestMatchers("/", "/registration", "/login", "/search/by-name", "/css/*.css", "/js/*.js", "/assets/**", "/search/list")
                                .permitAll()
                                .anyRequest()
                                .authenticated())
                .formLogin(form -> form
                        .failureUrl("/login")
                        .successForwardUrl("/"))
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                        .logoutSuccessUrl("/"));
        return http.build();
    }

}
