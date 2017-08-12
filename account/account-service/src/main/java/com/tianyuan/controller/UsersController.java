package com.tianyuan.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "用户管理")
@RestController
@RequestMapping("/account/users")
public class UsersController {

	@ApiOperation(value="新增用户", notes="")
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String add() {
		return "add";
	}
	
}
