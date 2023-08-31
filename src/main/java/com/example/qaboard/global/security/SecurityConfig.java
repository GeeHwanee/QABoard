package com.example.qaboard.global.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@EnableMethodSecurity(securedEnabled = false)
@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf().disable();
        http.formLogin().loginPage("/login")
                .loginProcessingUrl("/login").defaultSuccessUrl("/",true);
        http.logout().logoutUrl("/logout").logoutSuccessUrl("/");
        return http.build();
    }

}
