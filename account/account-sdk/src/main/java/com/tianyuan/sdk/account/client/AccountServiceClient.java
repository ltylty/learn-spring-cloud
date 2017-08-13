package com.tianyuan.sdk.account.client;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tianyuan.sdk.account.dto.UsersDTO;

@FeignClient(name = "account-service", fallback = AccountServiceClient.AccountServiceClientFallback.class)
public interface AccountServiceClient {

	@RequestMapping(value="/service/account/users/add", method=RequestMethod.POST)
	public String add();
	
	@RequestMapping(value="/service/account/users/list", method=RequestMethod.GET)
	public List<UsersDTO> list();

    @Component
    class AccountServiceClientFallback implements AccountServiceClient {

        private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceClientFallback.class);

		@Override
		public String add() {
			 LOGGER.info("异常发生，进入fallback方法");
	         return "FALLING BACK";
		}

		@Override
		public List<UsersDTO> list() {
			LOGGER.info("异常发生，进入fallback方法");
	         return Collections.emptyList();
		}
      
    }
}