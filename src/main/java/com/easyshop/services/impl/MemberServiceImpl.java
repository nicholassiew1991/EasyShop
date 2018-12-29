package com.easyshop.services.impl;

import com.easyshop.data.jpa.MemberRepository;
import com.easyshop.entities.MemberEntity;
import com.easyshop.services.MemberService;
import com.easyshop.utils.RedisUtils;
import com.easyshop.viewmodels.LoginVM;
import com.easyshop.viewmodels.RegisterMemberVM;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);

	@Autowired
	private MemberRepository memberRepo;

	@Autowired
	private RedisUtils redisUtils;

	@Override
	public MemberEntity login(LoginVM login, HttpServletRequest request) {
		String hashedPassword = DigestUtils.sha256Hex(login.getPassword());

		MemberEntity memberEntity = memberRepo.findByUsernameAndAndPassword(login.getUsername(), hashedPassword);

		if (memberEntity != null) {
			HttpSession session = request.getSession();

			Map<String, String> hash = new HashMap<>();
			hash.put("memberId", String.valueOf(memberEntity.getId()));
			hash.put("username", memberEntity.getUsername());
			//redisUtils.connection.get().hset(session.getId(), )
		}

		return memberEntity;
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
