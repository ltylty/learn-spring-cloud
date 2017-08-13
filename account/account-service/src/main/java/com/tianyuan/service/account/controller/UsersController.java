package com.tianyuan.service.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tianyuan.service.account.dto.UsersDTO;
import com.tianyuan.service.account.service.UsersService;
import com.tianyuan.service.framework.controller.BaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "用户管理")
@RestController
@RequestMapping("/service/account/users")
public class UsersController extends BaseController<UsersDTO> {

	@Autowired
	private UsersService usersService;
	
	@ApiOperation(value="新增用户", notes="")
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String add() {
		UsersDTO usersDTO = new UsersDTO();
		usersDTO.setUsername("test");
		usersDTO.setPassword("test");
		usersDTO.setEnabled("1");
		usersService.add(usersDTO);
		return "add";
	}
	
}
