package com.example.springsecuritycontracts.config;

import com.example.springsecuritycontracts.security.AppUserDetailsManager;
import com.example.springsecuritycontracts.security.PlainTextPasswordEncoder;
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
        return new PlainTextPasswordEncoder();
    }
    @Bean
    public UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        AppUserDetailsManager manager = new AppUserDetailsManager();
//        manager.createUser(new com.example.springsecuritycontracts.security.User("John", "12345"));

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
        http.formLogin(withDefaults());
        http
                .authorizeHttpRequests(
                        (authz) -> authz.anyRequest().authenticated()
//                        .requestMatchers(HttpMethod.POST).hasAuthority("read")
//                        .requestMatchers(HttpMethod.GET).hasRole("ADMIN")
//                        .requestMatchers(HttpMethod.GET).permitAll()
//                        .requestMatchers("/error").permitAll()

                );
        http.httpBasic(withDefaults());
        return http.build();
    }
}
