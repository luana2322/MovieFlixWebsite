package com.MovieFlix.MovieFlixWebsite.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

	
	@Bean
    public SecurityFilterChain securityFilterChain	(HttpSecurity http) throws Exception {
		 http.authorizeRequests()
         .requestMatchers(HttpMethod.OPTIONS,"/**").permitAll()
         .requestMatchers("/*").permitAll()
          .and()
	          .formLogin()
	          .usernameParameter("username")
              .passwordParameter("password")
	          .loginPage("/login")
	          .loginProcessingUrl("/do-login")
	          .defaultSuccessUrl("/logged")
	          .failureUrl("/login?error")
	          .permitAll()
	        .and()
	          .logout()
	          .logoutSuccessUrl("/login")
	          .invalidateHttpSession(true)
	          .deleteCookies("JSESSIONID")
	          .permitAll()
	        .and()
	          .csrf()
	          .disable();

        return http.build();
    }  
}
