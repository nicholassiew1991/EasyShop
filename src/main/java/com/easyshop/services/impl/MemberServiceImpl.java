package com.easyshop.services.impl;

import com.easyshop.data.jpa.MemberRepository;
import com.easyshop.entities.MemberEntity;
import com.easyshop.services.MemberService;
import com.easyshop.viewmodels.LoginVM;
import com.easyshop.viewmodels.RegisterMemberVM;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);

	@Autowired
	private MemberRepository memberRepo;

	@Override
	public MemberEntity login(LoginVM login) {
		String hashedPassword = DigestUtils.sha256Hex(login.getPassword());
		return memberRepo.findByUsernameAndAndPassword(login.getUsername(), hashedPassword);
	}

	@Override
	public MemberEntity register(RegisterMemberVM request) {

		String hashedPassword = DigestUtils.sha256Hex(request.getPassword());

		MemberEntity memberEntity = new MemberEntity();
		memberEntity.setUsername(request.getUsername());
		memberEntity.setPassword(hashedPassword);
		memberEntity.setEmail(request.getEmail());

		try {
			return memberRepo.save(memberEntity);
		}
		catch (Exception e) {
			logger.error("Failed to save member - " + e.getMessage(), e);
			return null;
		}
	}
}
