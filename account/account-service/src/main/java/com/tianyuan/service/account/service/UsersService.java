package com.tianyuan.service.account.service;

import java.util.ArrayList;
import java.util.List;

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
	
	public List<UsersDTO> list() {
		List<UsersPO> usersPOList = usersDao.selectAll();
		List<UsersDTO> UsersDTOList = new ArrayList<UsersDTO>();
		for(UsersPO usersPO : usersPOList) {
			UsersDTO usersDTO = new UsersDTO();
			BeanUtils.copyProperties(usersPO, usersDTO);
			UsersDTOList.add(usersDTO);
		}
		return UsersDTOList;
	}

}
