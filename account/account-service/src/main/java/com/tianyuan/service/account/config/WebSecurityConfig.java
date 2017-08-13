package com.tianyuan.service.account.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableOAuth2Sso
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/account/**")	//默认account接口请求被保护
		.authorizeRequests()
		.antMatchers("/", "/index", "/images/**", "/css/**").permitAll() //首页，静态资源等请求被除外
		.anyRequest().authenticated()	// 其他请求都需要用户认证
		;
    }
   
}