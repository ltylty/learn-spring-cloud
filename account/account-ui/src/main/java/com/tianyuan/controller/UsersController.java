package com.tianyuan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tianyuan.sdk.AccountServiceClient;

@Controller
public class UsersController {
	
	@Autowired
	private AccountServiceClient accountServiceClient;
	
	@RequestMapping("/test")
	public String addUser() {
		return accountServiceClient.add();
	}

}
