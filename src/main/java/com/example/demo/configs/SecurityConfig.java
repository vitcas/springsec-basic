package com.example.demo.configs;

import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // desativa a proteção CSRF para facilitar o teste de APIs
            //.authorizeHttpRequests(authz -> authz
            //    .requestMatchers("/api/test/**").permitAll() // permite todos acessarem os endpoints de teste
            //    .anyRequest().authenticated()
            //)
            .authorizeRequests()
            .anyRequest().authenticated()  // Exige autenticação em todos os endpoints
            .and()
            .httpBasic(); // usa autenticação básica

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // Gera uma senha aleatória
        String generatedPassword = UUID.randomUUID().toString();
        
        // Exibe a senha gerada no console
        System.out.println("Generated Security Password: " + generatedPassword);

        // Cria um usuário com a senha gerada
        UserDetails user = User
            .withUsername("user")
            .password("{noop}" + generatedPassword) // Noop para evitar encriptação na senha
            .roles("USER")
            .build();

        return new InMemoryUserDetailsManager(user);
    }
}