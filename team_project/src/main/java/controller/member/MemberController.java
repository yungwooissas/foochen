package controller.member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dto.member.LoginCommand;
import dto.member.OutCommand;
import dto.member.SearchPasswordCommand;
import dto.member.UserInfo;
import service.member.MemberService;

@Controller
public class MemberController {
	private MemberService memberService;

	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping(value="/member/main")
	public String main(){
		return "/member/main";
	}
	
	
	
	//로그인 form
	@RequestMapping(value="/member/login", method=RequestMethod.GET)
	public String loginForm(LoginCommand loginCommand, @CookieValue(value="REMEMBER", required=false) Cookie cookie) {
		//아이디 기억하기 쿠키
		if(cookie != null) {
			loginCommand.setEmail(cookie.getValue());
			loginCommand.setRememberEmail(true);
		}
		return "member/login";
	}
	
	//로그인 post
	@RequestMapping(value="/member/login", method=RequestMethod.POST)
	public String loginSubmit(LoginCommand loginCommand, Errors errors, HttpSession session, HttpServletResponse response) {
		//검증필요(공백있는지 등등)
		
		if(errors.hasErrors()) {
			return "member/login";
		}
		try { //로그인 처리 할꺼야
			UserInfo userInfo = memberService.authenticate(loginCommand.getEmail(), loginCommand.getPassword());
			session.setAttribute("userInfo", userInfo);
			
			Cookie rememberEmail = new Cookie("REMEMBER", loginCommand.getEmail());
			rememberEmail.setPath("/");
			if(loginCommand.isRememberEmail()) {
				rememberEmail.setMaxAge(60*60*24*30);
			} else {
				rememberEmail.setMaxAge(0);
			}
			response.addCookie(rememberEmail);
//체크필요 	로긴 성공하면 메인으로 보내줄껀데 테스트로 욜로 보냅니당
			return "member/main";
		//IdPasswordNotMatchingException 디테일한 exception으로 바꿀지?
		} catch(Exception e) {
			errors.reject("IdPasswordNotMatchingException");
			return "member/login";
		}
	}
	
	//로그아웃
	@RequestMapping("/member/logout")
	public String logout(HttpSession session) {
		session.invalidate(); //세션 정보삭제
//체크필요	메인으로 보내줄껀데 테스트로 욜로 보냅니당
		return "member/main";
	}
	
	
	//탈퇴 form
	@RequestMapping(value="/member/out", method=RequestMethod.GET)
	public String outForm(OutCommand outCommand) {
		return "member/out";
	}
	
	
	//탈퇴 post
	@RequestMapping(value="/member/out", method=RequestMethod.POST)
	public String outSubmit(OutCommand outCommand, HttpSession session) {
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		try {
			memberService.outMember(userInfo.getEmail(), outCommand.getPassword());
			outCommand.setOutSuccess(true); //탈퇴성공
			session.invalidate(); //로그아웃(세션정보삭제)
//체크필요 	탈퇴성공하면 메인으로
			return "member/outSuccess";
			//IdPasswordNotMatchingException 디테일한 exception으로 바꿀지?
		}catch(Exception e) {
			//exception 잡아줄 것
			System.out.println("탈퇴서브밋에러");
			return "member/out";
		}
	}
	
	//id찾기(phone으로 email찾기)
	@RequestMapping(value="/member/searchId", method=RequestMethod.GET)
	public String searchIdForm() {
		return "member/searchId";
	}
	
	//찾은 id 알려 줄꺼야
	@RequestMapping(value="/member/searchId", method=RequestMethod.POST)
	public String searchIdSubmit(HttpServletRequest request) {
		//검증필요(공백있는지 등등)
//		(request 대신 command객체를 쓰는 방법 외에 다른방법이 있는지? , errors 사용할라모)
//		if(errors.hasErrors()) {
//			return "member/searchId";
//		}
		String email = memberService.searchByPhone(request.getParameter("phone"));
		request.setAttribute("email", email);
		return "member/searchId";
}
	
	//password찾기
	@RequestMapping(value="/member/searchPassword", method=RequestMethod.GET)
	public String searchPasswordForm(SearchPasswordCommand searchPwdCommand) {
		return "member/searchPassword";
	}
	
	//password찾기
	@RequestMapping(value="/member/searchPassword", method=RequestMethod.POST)
	public String searchPasswordSumit(SearchPasswordCommand searchPwdCommand) {
		String password = memberService.searchforPassword(searchPwdCommand.getEmail(), searchPwdCommand.getPhone(), searchPwdCommand.getName());
		searchPwdCommand.setPassword(password);
		return "member/searchPassword";
	}
	
	
}
