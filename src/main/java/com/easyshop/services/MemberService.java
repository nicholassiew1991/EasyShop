package com.easyshop.services;

import com.easyshop.entities.MemberEntity;
import com.easyshop.viewmodels.LoginVM;
import com.easyshop.viewmodels.RegisterMemberVM;

import javax.servlet.http.HttpServletRequest;

public interface MemberService {

	MemberEntity login(LoginVM login, HttpServletRequest request);

	MemberEntity register(RegisterMemberVM request);
}
