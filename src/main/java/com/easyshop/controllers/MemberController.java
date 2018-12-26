package com.easyshop.controllers;

import com.easyshop.viewmodels.LoginVM;
import com.easyshop.viewmodels.RegisterMemberVM;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/member")
public class MemberController {

	private static final String LOGIN_USER_ATTRIBUTE_NAME = "loginUserForm";
	private static final String REGISTER_USER_ATTRIBUTE_NAME = "registerUserForm";

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute(LOGIN_USER_ATTRIBUTE_NAME, new LoginVM());
		return "/member/login";
	}

	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute(REGISTER_USER_ATTRIBUTE_NAME, new RegisterMemberVM());
		return "/member/register";
	}

	@PostMapping("/register")
	public String register(@ModelAttribute(REGISTER_USER_ATTRIBUTE_NAME) @Valid RegisterMemberVM request, Errors errors) {
		if (errors.hasErrors()) {
			return "/member/register";
		}
		return "/member/login";
	}
}
