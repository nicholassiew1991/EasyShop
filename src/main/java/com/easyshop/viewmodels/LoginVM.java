package com.easyshop.viewmodels;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginVM {

	@NotEmpty
	private String username;

	@NotEmpty
	private String password;
}
