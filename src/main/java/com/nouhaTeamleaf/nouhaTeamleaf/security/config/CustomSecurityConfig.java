package com.nouhaTeamleaf.nouhaTeamleaf.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class CustomSecurityConfig {
    private final UserDetailsService service;
    private final PasswordEncoder passwordEncoder;

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(service);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        return daoAuthenticationProvider;
    }

    // Authorisation a moment ou l'authentification est correcte
    @Bean // creer au démarrage
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // http contient la requete
        return http.csrf(AbstractHttpConfigurer::disable)
                .formLogin(form ->form
                        .loginPage("/login")
                        .permitAll()

                ).authorizeHttpRequests( auth -> auth
                        /*
                        .requestMatchers("/rp/**").hasAuthority("RP")
                        .requestMatchers("/attache/**").hasAuthority("ATTACHE")
                        .requestMatchers("/etudiant/**").hasAuthority("ETUDIANT")
                        .requestMatchers("/professeur/**").hasAuthority("PROFESSEUR")*/
                        .anyRequest()
                        .authenticated()
                )
                .build();
            /*.formLogin(form ->form
                             .loginPage("/login")
                             .permitAll()

            ).authorizeHttpRequests( auth -> auth
                    .requestMatchers("/rp/**").hasAuthority("RP")
                    .requestMatchers("/attache/**").hasAuthority("ATTACHE")
                        .requestMatchers("/etudiant/**").hasAuthority("ETUDIANT")
                        .requestMatchers("/professeur/**").hasAuthority("PROFESSEUR")
                    .anyRequest()
                    .authenticated()
            )
                .build();*/

    }


}
