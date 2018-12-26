package com.easyshop.services;

import com.easyshop.entities.MemberEntity;
import com.easyshop.viewmodels.LoginVM;
import com.easyshop.viewmodels.RegisterMemberVM;

public interface MemberService {

	MemberEntity login(LoginVM login);

	MemberEntity register(RegisterMemberVM request);
}
