package com.tianyuan.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

	@RequestMapping("/users/add")
	public String add() {
		return "add";
	}
	
}
