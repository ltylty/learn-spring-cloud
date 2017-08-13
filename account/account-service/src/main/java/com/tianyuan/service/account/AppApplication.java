package com.tianyuan.service.account;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.RequestContextListener;

import com.tianyuan.service.framework.EnableServiceFramework;


@SpringBootApplication
@EnableDiscoveryClient
@EnableServiceFramework
@MapperScan(basePackages = "com.tianyuan.service.account.dao")
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}
	
	@Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }
}
