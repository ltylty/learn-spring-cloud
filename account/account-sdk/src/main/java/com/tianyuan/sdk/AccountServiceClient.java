package com.tianyuan.sdk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "account-service", fallback = AccountServiceClient.AccountServiceClientFallback.class)
public interface AccountServiceClient {

	@RequestMapping(value="/service/account/users/add", method=RequestMethod.GET)
	public String add();

    @Component
    class AccountServiceClientFallback implements AccountServiceClient {

        private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceClientFallback.class);

		@Override
		public String add() {
			 LOGGER.info("异常发生，进入fallback方法");
	         return "FALLING BACK";
		}

      
    }
}