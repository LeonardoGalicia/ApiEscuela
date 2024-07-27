package com.example.escuela.configuration;


import com.example.escuela.jwt.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authProvider;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter, AuthenticationProvider authProvider) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.authProvider = authProvider;
    }





    @Bean
    public SecurityFilterChain cadenaDeFiltros(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authRequest ->
                        authRequest
                                .requestMatchers("/auth/**").permitAll()  //END POINT PUBLICO todos los endpoints que macheen con esto no pedirá autenticacion
                                .anyRequest().authenticated()  // END POINT PRIVADO todos los demas endpoint pedirán autenticación
                )
                .sessionManagement( sessionManager -> //desabilidta sesiones
                        sessionManager
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authenticationProvider(authProvider) //especificamos provedor en este caso es autenticasion con acceso a bd
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class) // especificamos el filtro en este caso jwt
                .build();
    }

    /*@Bean
    public SecurityFilterChain cadenaDeFiltros(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.httpBasic(Customizer.withDefaults()). //tener una autorizacion basica por defaul
                authorizeHttpRequests((authz) -> authz.anyRequest().authenticated()); //cualquier petición debe estar autenticada
        return httpSecurity.build();
    }*/

    /*@Bean
    public InMemoryUserDetailsManager crearUsuario() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("Leonardo")
                .password("123leo")
                .roles("USER")
                .build();
        UserDetails user2 = User.withDefaultPasswordEncoder()
                .username("Juan")
                .password("123Pass")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(List.of(user,user2));
    }*/


}
