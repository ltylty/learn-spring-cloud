package com.tianyuan.ui.account.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableOAuth2Sso
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Value("${auth-server}/exit")
    private String logoutUrl;
	
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**")	//默认所有请求被保护
		.authorizeRequests()
		.antMatchers("/", "/index", "/login**", "/images/**", "/css/**").permitAll() //首页，静态资源等请求被除外
		.anyRequest().authenticated()	// 其他请求都需要用户认证
		.and()
		.logout().logoutSuccessUrl(logoutUrl).permitAll();
    }
   
}