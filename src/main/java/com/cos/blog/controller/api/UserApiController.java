package com.cos.blog.controller.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.vote.AuthenticatedVoter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.config.auth.PrincipalDetail;
import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.service.UserService;

@RestController
public class UserApiController {

	@Autowired
	private UserService userService;
	
	//@Autowired
	//private HttpSession session; <- 이렇게 하면 session에 user 정보가 담기지 않는다. 왜인지 모르겠다.
	
	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody User user) {
		
		userService.회원가입(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
		
	}
	
	@PutMapping("/user")
	public ResponseDto<Integer> update(@RequestBody User user, @AuthenticationPrincipal PrincipalDetail principal, HttpSession session) {
		
		userService.회원수정(user);
		Authentication authentication = new UsernamePasswordAuthenticationToken(principal, null, principal.getAuthorities());
		SecurityContext securityContext = SecurityContextHolder.getContext();
		securityContext.setAuthentication(authentication);
		session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
		
	}
	
//	@PostMapping("/api/user/login")
//	public ResponseDto<Integer> login(@RequestBody User user, HttpSession session) {
//		
//		User principal = userService.로그인(user);
//		
//		if (principal != null) {
//			session.setAttribute("principal", principal);
//		}
//		
//		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
//		
//	}
	
}
