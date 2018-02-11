/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hyhy.config;

//import javax.sql.DataSource;

//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.hyhy.security.HyUserDetailsService;

//import ch.qos.logback.classic.Logger;

/**
 * @author Joe Grandja
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//	private static final Logger logger = (Logger) LoggerFactory.getLogger(SecurityConfig.class);
	
	@Autowired
    public HyUserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
//			.authorizeRequests()
//			.anyRequest()
//			.authenticated()
//			.withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
//				@Override
//				public <O extends FilterSecurityInterceptor> O postProcess(O fsi) {
//					//fsi.setPublishAuthorizationSuccess(true);
//					return fsi;
//				}
//			})
//		.and()
			.authorizeRequests()
			.antMatchers("/css/**", "/index").permitAll()
//			.antMatchers("/user/**").hasAnyRole("USER")
			.antMatchers("/user/**").access("hasAnyRole('ADMIN','USER')")
			.antMatchers("/test/**").hasRole("USER")
//			.anyRequest().access("@hySecurity.check(authentication,request)")
		.and()
			.formLogin().loginPage("/login").failureUrl("/login-error");
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
		auth.userDetailsService(userDetailsService)
			.passwordEncoder(new BCryptPasswordEncoder());
		//auth.authenticationProvider(authenticationProvider);
//		auth.userDetailsService(userDetailsService()).and().jdbcAuthentication().dataSource(dataSource);
		
	}
}
