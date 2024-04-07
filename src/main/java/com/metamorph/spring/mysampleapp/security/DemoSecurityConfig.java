package com.metamorph.spring.mysampleapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    // inject data source (auto-configured by spring boot)
    // add support for JDBC
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        // define query to retrieve a user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery("select username, password, active from system_users where username=?");

        // define query to retrieve the authorities/roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select username, role from roles where username=?");

        return jdbcUserDetailsManager;
    }

    /*
    // in-memory authentication: won't use security auth from application.properties
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails john = User.builder()
                .username("john")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();

        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(john, mary, susan);
    }
    */
    /*@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        *//*http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/hello").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/helloworld").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/student").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/student/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/student").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/student/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/student/**").hasRole("ADMIN")
        );*//*

        http.authorizeHttpRequests(requests -> requests.anyRequest().permitAll());

        // use HTTP Basic authentication
        http.httpBasic(Customizer.withDefaults());

        // disable CSRF
        // in general, not required for stateless REST APIs (POST,PUT,DELETE and/or PATCH)
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }*/

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer
                        .anyRequest()
                        .authenticated()
            ).formLogin(form ->
                form
                        .loginPage("/showMyLoginPage")
                        .loginProcessingUrl("/authenticateTheUser") // provided by spring security
                        .permitAll()
        );
        return http.build();
    }
}


