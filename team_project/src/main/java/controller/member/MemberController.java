package controller.member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dto.member.ChangePassword;
import dto.member.LoginCommand;
import dto.member.MemberDto;
import dto.member.OutCommand;
import dto.member.RegisterRequest;
import dto.member.SearchPasswordCommand;
import dto.member.UserInfo;
import exception.AlreadyExistingMemberException;
import exception.IdPasswordMatchingException;
import service.member.MemberService;

@Controller
public class MemberController {
	private MemberService memberService;

	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@RequestMapping(value="/main") 
	public String main() {
		return "member/main"; 
	}
	
	
	// 회원가입 get/post 모두.
	@RequestMapping(value="/register") 
	public String bothRegister() {
		return "register/step1"; // 확인용
	}


	//회원가입 완료 페이지 get 요청 시
	@RequestMapping(value="/regResult", method=RequestMethod.GET)
	public String getRegisterResult() {
		return "redirect:/register/step1"; 
	}

	//회원가입 완료 post
	@RequestMapping(value="/regResult", method=RequestMethod.POST) 
	public String postRegisterResult(@ModelAttribute("regData")RegisterRequest regReq) { //컨트롤러에 커맨드 객체를 받아 회원가입 기능 메서드 추가
		try {
			memberService.registerMember(regReq);
			return "register/step2";
		}catch(AlreadyExistingMemberException e) {
			return "register/step1"; // 같은 애 있으면 일단 뒤로 가는 개념
		}
	}

	// 회원확인
	@ResponseBody
	@RequestMapping(value="/emailCheck", method=RequestMethod.POST) 
	public int postEmailCheck(HttpServletRequest req) {
		String email = req.getParameter("email");
		MemberDto emailCheck = memberService.emailCheck(email);
		int result = 0;
		if(emailCheck != null) {
			result = 1;
		}
		System.out.println(emailCheck.getEmail() + " : "+ result);
		return result;
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////

	//로그인 form
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginForm(LoginCommand loginCommand, @CookieValue(value="REMEMBER", required=false) Cookie cookie) {
		//아이디 기억하기 쿠키
		if(cookie != null) {
			loginCommand.setEmail(cookie.getValue());
			loginCommand.setRememberEmail(true);
		}
		return "member/login";
	}

	//로그인 post
	@RequestMapping(value="/login", method=RequestMethod.POST)
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
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate(); //세션 정보삭제
		//체크필요	메인으로 보내줄껀데 테스트로 욜로 보냅니당
		return "member/main";
	}


	//탈퇴 form
	@RequestMapping(value="/mypage/out", method=RequestMethod.GET)
	public String outForm(OutCommand outCommand) {
		return "member/mypage/out";
	}


	//탈퇴 post
	@RequestMapping(value="/mypage/out", method=RequestMethod.POST)
	public String outSubmit(OutCommand outCommand, HttpSession session) {
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		try {
			memberService.outMember(userInfo.getEmail(), outCommand.getPassword());
			outCommand.setOutSuccess(true); //탈퇴성공
			session.invalidate(); //로그아웃(세션정보삭제)
			//체크필요 	탈퇴성공하면 메인으로
			return "member/mypage/outSuccess";
			//IdPasswordNotMatchingException 디테일한 exception으로 바꿀지?
		}catch(Exception e) {
			//exception 잡아줄 것
			System.out.println("탈퇴서브밋에러");
			return "member/mypage/out";
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

	////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	// 마이페이지 메인
	@RequestMapping(value="/mypage")
	public String mypage(HttpSession session, HttpServletRequest req) {
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		MemberDto member = memberService.selectByEmail(userInfo.getEmail());		// id를 이용해 멤버 객체 생성
		req.setAttribute("member", member);						// 멤버
		return "member/mypage/main";
	}


	//회원 정보 수정 시작
	@RequestMapping(value="/mypage/modifyStep1",method=RequestMethod.GET)
	public String modifyStep1() {
		return "member/mypage/modifyStep1";
	}
	@RequestMapping(value="/mypage/modifyStep1",method=RequestMethod.POST)
	public String modifyStep1(HttpServletRequest req, HttpSession session) {
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		String input = (String) req.getParameter("tmppassword");
		MemberDto member = memberService.selectByEmail(userInfo.getEmail());		// id를 이용해 멤버 객체 생성
		try {
			if(!input.equals(member.getPassword())) {
				throw new IdPasswordMatchingException("비밀번호를 틀리셨습니다.");
			}
		}
		catch(IdPasswordMatchingException e) {
			req.setAttribute("errormessage", e.getMessage());
			return "member/mypage/modifyStep1";
		}
		req.setAttribute("member", member);
		return "member/mypage/modifyStep2";
	}

	@RequestMapping(value="/mypage/modifyStep2", method=RequestMethod.POST)
	public String modify(Model model, HttpSession session, HttpServletRequest req, RedirectAttributes redirect) {
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		MemberDto member = memberService.selectByEmail(userInfo.getEmail());		// id를 이용해 멤버 객체 생성

		req.setAttribute("member", member);
		model.addAttribute("member",member);
		return "member/mypage/modifyPost";
	}

	@RequestMapping(value="/mypage/modifyResult",method=RequestMethod.POST)
	public String modifyResult(@ModelAttribute("member")MemberDto member,HttpServletRequest req) {
		int result = memberService.memberModify(member);
		req.setAttribute("result", result);
		return "member/mypage/modifyResult";
	}

	// 회원 정보 수정 끝


	// 비밀번호 변경 시작

	@RequestMapping(value="/mypage/chpasswordStep1",method=RequestMethod.GET)
	public String chpasswordStep1(Model model) {
		model.addAttribute("changePassword",new ChangePassword());
		return "member/mypage/chpasswordStep1";
	}
	@RequestMapping(value="/mypage/chpasswordStep1",method=RequestMethod.POST)
	public String chpasswordStep1(@ModelAttribute("changePassword")ChangePassword changePassword ,Model model, HttpSession session, HttpServletRequest req) {
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		changePassword.setEmail(userInfo.getEmail());

		model.addAttribute("changePassword", changePassword);
		return "member/mypage/chpasswordStep1";
	}

	@RequestMapping(value="/mypage/chpasswordResult",method=RequestMethod.POST)
	public String chpasswordResult(@ModelAttribute("changePassword")ChangePassword changePassword ,HttpSession session, HttpServletRequest req) {
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		changePassword.setEmail(userInfo.getEmail());

		try {
			if(changePassword.matchPassword(memberService.selectByEmail(userInfo.getEmail()).getPassword()))
				throw new IdPasswordMatchingException("비밀번호를 틀리셨습니다.");
			if(changePassword.confirmPassword()) 
				throw new IdPasswordMatchingException("비밀번호를 다시 확인해주세요.");
		}
		catch(IdPasswordMatchingException e) {
			req.setAttribute("errormessage", e.getMessage());
			return "member/mypage/chpasswordStep1";
		}

		int result = memberService.changePassword(changePassword);
		req.setAttribute("result", result);
		return "member/mypage/chpasswordResult";
	}

	// 비밀번호 변경 끝
}
