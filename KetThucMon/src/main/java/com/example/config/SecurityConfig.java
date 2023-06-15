package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorize) -> authorize
                                .requestMatchers("/register/**").permitAll()
                                .requestMatchers("/login/**").permitAll()
                                .requestMatchers("/api/**").permitAll()
                                .requestMatchers("/provider/list").hasAnyRole("USER", "ADMIN")
                                .requestMatchers("/product/list").hasAnyRole("USER", "ADMIN")
                                .requestMatchers("/producer/list").hasAnyRole("USER", "ADMIN")
                                .requestMatchers("/order/list").hasAnyRole("USER", "ADMIN")
                                .requestMatchers("/employee/list").hasAnyRole("USER", "ADMIN")
                                .requestMatchers("/customer/list").hasAnyRole("USER", "ADMIN")
                                .requestMatchers("/provider/**").hasRole("ADMIN")
                                .requestMatchers("/product/**").hasRole("ADMIN")
                                .requestMatchers("/producer/**").hasRole("ADMIN")
                                .requestMatchers("/order/**").hasRole("ADMIN")
                                .requestMatchers("/employee/**").hasRole("ADMIN")
                                .requestMatchers("/customer/**").hasRole("ADMIN")
                                .requestMatchers("/users/**").hasRole("ADMIN")
                                .anyRequest().authenticated()
                ).authenticationProvider(authenticationProvider()
                ).headers((headers) -> headers
                        .frameOptions(HeadersConfigurer.FrameOptionsConfig::disable)
                ).csrf(AbstractHttpConfigurer::disable
                ).formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/product/list", true)
                        .permitAll()
                ).logout(logout -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .permitAll()
                );
        return http.build();
    }

    @Bean
    WebSecurityCustomizer webSecurityCustomizer() {
        // Set of login unnecessary page
        return (web) -> web.ignoring().requestMatchers("/webjars/**").requestMatchers("/css/**")
                .requestMatchers("/js/**");
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder()); // Password encryption
        return provider;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }
}