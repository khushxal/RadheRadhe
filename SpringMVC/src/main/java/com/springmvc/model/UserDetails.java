// Entity
package com.springmvc.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "user_detail")
public class UserDetails {

	@Id
	@Email(message = "input valid email id")
	@NotEmpty(message = "input valid email id")
	private String email;

	@NotNull
	@NotEmpty(message = "cannot be null")
	private String name;

	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@NotEmpty(message = "select date")
	private String dob;

	@NotNull
	@NotEmpty(message = "cannot be null")
	private String gender;

	@Size(max = 10, min = 10, message = "10 digit only")
	private String phone;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "UserDetails [email=" + email + ", name=" + name + ", dob=" + dob + ", gender=" + gender + ", phone="
				+ phone + "]";
	}

}
