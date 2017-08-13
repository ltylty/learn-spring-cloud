package com.tianyuan.sdk.account.config;

import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;

import feign.RequestInterceptor;


@Configuration
public class AccountSDKConfiguration {

	@Bean
	public RequestInterceptor oauth2FeignRequestInterceptor(OAuth2ClientContext oauth2ClientContext,
			AuthorizationCodeResourceDetails resource) {
		return new OAuth2FeignRequestInterceptor(oauth2ClientContext, resource);
	}
	
}