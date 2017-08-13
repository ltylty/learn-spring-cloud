package com.tianyuan.service.account.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianyuan.service.account.dao.UsersDao;
import com.tianyuan.service.account.dto.UsersDTO;
import com.tianyuan.service.account.po.UsersPO;
import com.tianyuan.service.framework.service.BaseService;

@Service
public class UsersService extends BaseService<UsersDTO, UsersPO> {
	
	@Autowired
	private UsersDao usersDao; 
	
	public void add(UsersDTO usersDTO) {
		UsersPO usersPO = new UsersPO();
		BeanUtils.copyProperties(usersDTO, usersPO);
		usersDao.insert(usersPO);
	}

}
