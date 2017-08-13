package com.tianyuan.ui.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tianyuan.sdk.account.client.AccountServiceClient;
import com.tianyuan.sdk.account.dto.UsersDTO;

@Controller
@RequestMapping("/ui/account/users")
public class UsersController {

	@Autowired
	private AccountServiceClient accountServiceClient;

	@RequestMapping("/add")
	public String add() {
		String result = accountServiceClient.add();
		return result;
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(Model model) {
		List<UsersDTO> list = accountServiceClient.list();
		model.addAttribute("list", list);
		return "list";
	}

}
