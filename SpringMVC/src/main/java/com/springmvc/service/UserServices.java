// Service Layer
package com.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.dao.UserDao;
import com.springmvc.model.UserContact;
import com.springmvc.model.UserCredentials;
import com.springmvc.model.UserDetails;

@Service
public class UserServices {
	@Autowired
	private UserDao dao;

	public void saveUser(UserDetails user) {
		dao.saveUser(user);
	}

	public int saveUser(UserCredentials user) {
		return dao.saveUser(user);
	}

	public int saveUserQuery(UserContact contact) {
		return dao.saveUserQuery(contact);
	}

	public UserDetails get_User_Details_By_Id(String id) {
		return dao.get_User_Detail_By_Id(id);
	}

	public UserCredentials get_User_Credentail_By_Id(int id) {
		return dao.get_User_Credential_By_Id(id);
	}

}
