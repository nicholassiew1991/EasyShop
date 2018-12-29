package com.easyshop.controllers;

import com.easyshop.services.MemberService;
import com.easyshop.viewmodels.LoginVM;
import com.easyshop.viewmodels.RegisterMemberVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/member")
public class MemberController extends BaseController {

	private static final String LOGIN_USER_ATTRIBUTE_NAME = "loginUserForm";
	private static final String REGISTER_USER_ATTRIBUTE_NAME = "registerUserForm";

	@Autowired
	private MemberService memberService;

	@GetMapping("/login")
	public String login(Model model) {
		HttpSession session = request.getSession();
		model.addAttribute(LOGIN_USER_ATTRIBUTE_NAME, new LoginVM());
		return "/member/login";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute(LOGIN_USER_ATTRIBUTE_NAME) @Valid LoginVM login, Errors errors) {
		if (errors.hasErrors()) {
			return "/member/login";
		}
		return "/member/login";
	}

	@GetMapping("/register")
	public String register(Model model, HttpSession session) {
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
