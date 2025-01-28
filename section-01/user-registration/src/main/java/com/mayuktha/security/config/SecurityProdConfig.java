package com.mayuktha.security.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.mayuktha.controller.UserRegistrationController;

@Configuration
public class SecurityProdConfig {
	
	private static final Logger log = LoggerFactory.getLogger(SecurityProdConfig.class);

    @Bean
    @Profile("prod")
    SecurityFilterChain configure(HttpSecurity http) throws Exception {
    	
    	log.debug("SecurityConfig:::::prod::");
		
		
    	http.authorizeHttpRequests((auth)->auth.anyRequest().permitAll());
    	http.cors(cors->cors.disable());
    	http.formLogin(form->form.disable());
    	http.httpBasic(htba->htba.disable());
    	http.csrf(csrf->csrf.disable());
		 
		return http.build();
	}
	

}
