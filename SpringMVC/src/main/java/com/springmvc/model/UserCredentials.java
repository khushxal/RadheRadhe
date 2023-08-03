package com.springmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.UniqueElements;

@Entity
@Table(name = "user_credential")
public class UserCredentials {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Email
	@Column(unique = true)
	private String email;

	@Column(name = "password")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$", message = "It contains at least 8 characters and at most 20 characters.\r\n"
			+ "It contains at least one digit.\r\n" + "It contains at least one upper case alphabet.\r\n"
			+ "It contains at least one lower case alphabet.\r\n"
			+ "It contains at least one special character which includes !@#$%&*()-+=^.\r\n"
			+ "It doesn’t contain any white space.")
	private String password;

//	private HttpSession session;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	public HttpSession getSession() {
//		return session;
//	}
//
//	public void setSession(HttpSession session) {
//		this.session = session;
//	}

	@Override
	public String toString() {
		return "UserCredentials [id=" + id + ", email=" + email + ", password=" + password;
	}

}
