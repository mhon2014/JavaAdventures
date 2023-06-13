package com.example.springsecuritycontracts.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectConfig {
    //User Details
    //UserDetailsService -> UserDetailsManager
    //PasswordEncoder

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
    @Bean
    public UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        UserDetails u1 = User.withUsername("bill")
                                .password("12345")
                                .roles("ADMIN")
                                .authorities("write")
                                .build();

        UserDetails u2 = User.withUsername("john")
                .password("12345")
                .roles("MANAGER")
                .authorities("read")
                .build();

        manager.createUser(u1);
        manager.createUser(u2);

        return manager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers(HttpMethod.POST).hasAuthority("read")
                        .requestMatchers(HttpMethod.GET).hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET).hasAuthority("read")
                        .anyRequest().permitAll()
                );
        http.httpBasic(withDefaults());
        return http.build();
    }
}
