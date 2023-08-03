// Data access layer
package com.springmvc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.model.UserContact;
import com.springmvc.model.UserCredentials;
import com.springmvc.model.UserDetails;

@Repository
public class UserDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Transactional
	public void saveUser(UserDetails details) {
		hibernateTemplate.saveOrUpdate(details);
	}

	@Transactional
	public int saveUser(UserCredentials credentials) {
		return (Integer) hibernateTemplate.save(credentials);
	}

	@Transactional
	public int saveUserQuery(UserContact contact) {
		return (Integer) hibernateTemplate.save(contact);
	}

	@Transactional
	public UserDetails get_User_Detail_By_Id(String id) {
		return hibernateTemplate.get(UserDetails.class, id);
	}

	@Transactional
	public UserCredentials get_User_Credential_By_Id(int id) {
		return hibernateTemplate.get(UserCredentials.class, id);
	}
}
