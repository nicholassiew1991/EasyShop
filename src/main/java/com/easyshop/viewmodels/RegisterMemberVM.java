package com.easyshop.viewmodels;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class RegisterMemberVM {

	@NotEmpty
	private String username;

	@NotEmpty
	@Email
	private String email;

	@NotEmpty
	private String password;

	@NotEmpty
	private String confirmPassword;
}
