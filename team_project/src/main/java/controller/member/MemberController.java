package controller.member;

import org.springframework.stereotype.Controller;

import service.member.MemberService;

@Controller
public class MemberController {
	private MemberService memberService;

	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
}
