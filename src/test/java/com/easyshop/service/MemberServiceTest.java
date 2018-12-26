package com.easyshop.service;

import com.easyshop.entities.MemberEntity;
import com.easyshop.services.MemberService;
import com.easyshop.viewmodels.LoginVM;
import com.easyshop.viewmodels.RegisterMemberVM;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberServiceTest {

	@Autowired
	private MemberService memberService;

	@Test
	public void testServiceInstance() {
		Assert.assertNotNull(memberService);
	}

	@Test
	public void testLoginSuccess() {
		LoginVM vm = new LoginVM();
		vm.setUsername("nicholassiew1991");
		vm.setPassword("nicholas");

		MemberEntity result = memberService.login(vm);

		System.out.println(result);
	}

	@Test
	public void testRegisterUser() {
		RegisterMemberVM vm = new RegisterMemberVM();
		vm.setUsername("nicholassiew1991");
		vm.setPassword("nicholas");
		vm.setEmail("nicholas_siew1991@hotmail.com");

		memberService.register(vm);
	}
}
