package com.taxholic.core.configuration.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.taxholic.core.authority.AuthService;
import com.taxholic.core.authority.DaoAuthenticationProvider;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration  extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth
//		.inMemoryAuthentication()
//	        .withUser( "admin" )
//	            .password( "admin" )
//	            .roles( "ADMIN" )
//	            .and()
//	        .withUser( "user" )
//	            .password( "user" )
//	            .roles( "USER" );
		
		 auth        
		 	.authenticationProvider(authenticationProvider())
//             .passwordEncoder( new BCryptPasswordEncoder())
             ;
		
	}
	
	@Override
	public void configure( WebSecurity web ) throws Exception {
		web
		    .ignoring()
		        .antMatchers( "/js/**" )
		        .antMatchers( "/css/**" )
		        .antMatchers( "/images/**" )
		        ;
	}
 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
 
		http
		.authorizeRequests()
		 	.antMatchers( "/login**" ).permitAll()
			.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
			.antMatchers("/dba/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_DBA')")
			.and()
		.formLogin()
//			.loginPage( "/login.do" )
	        .loginProcessingUrl( "/login" )
	        .defaultSuccessUrl( "/" )
	        .failureUrl( "/login?err=1" )
	        .usernameParameter( "userNm" )
	        .passwordParameter( "password" )
	        .and()
		.logout()
			.logoutRequestMatcher( new AntPathRequestMatcher( "/logout" ) )
			.logoutSuccessUrl( "/" )
			.deleteCookies( "JSESSIONID" )
			.invalidateHttpSession( true )
			.and()
		.rememberMe()
			.tokenValiditySeconds(864000)
			.and()
		.sessionManagement()			//첫번째 로그인 사용자는 로그아웃, 두번째 사용자 로그인 session-registry-alias : 접속자 정보보기
			.maximumSessions(2)
			.expiredUrl("/expireSession")
		;
			 
	}
	@Bean
	public DaoAuthenticationProvider authenticationProvider(){
		DaoAuthenticationProvider  authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(authService());
        return authenticationProvider;
    }
	
	@Bean
    public UserDetailsService authService(){
        UserDetailsService service = new AuthService();
        return service;
    }
	
  
}