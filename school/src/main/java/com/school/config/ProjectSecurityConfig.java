package com.school.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SuppressWarnings("deprecation")

@Configuration
public class ProjectSecurityConfig extends WebSecurityConfigurerAdapter {
 
	protected void configure(HttpSecurity http) throws Exception {
		 
		http.authorizeHttpRequests().mvcMatchers("/contact").permitAll().
		mvcMatchers("/home").authenticated()
		.mvcMatchers("/holidays").permitAll()
		.and().formLogin().and().httpBasic();
		
		
	}
}
