package com.springmvc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user_query")
public class UserContact {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	@NotEmpty(message = "cannot be null")
	@NotNull(message = "Name mandatory")
	private String name;

	@Email
	@NotEmpty(message = "cannot be null")
	@NotNull(message = "Email mandatory")
	private String email;

	@NotEmpty(message = "cannot be null")
	@NotNull(message = "minimum 1 character")
	private String message;

	@NotNull
	private String doq;

	public String getDoq() {
		return doq;
	}

	public void setDoq(String date) {
		this.doq = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "UserContact [id=" + id + ", name=" + name + ", email=" + email + ", message=" + message + ", doq=" + doq
				+ "]";
	}
}
