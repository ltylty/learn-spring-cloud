package com.tianyuan.sdk.account.config;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Import;

@Target({ java.lang.annotation.ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@EnableFeignClients(basePackages="com.tianyuan.sdk.account.client")
@Import(AccountSDKConfiguration.class)
public @interface EnableAccountSDK {
	
}