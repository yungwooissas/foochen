package service.member;

import dto.member.ChangePassword;
import dto.member.MemberDto;
import dto.member.RegisterRequest;
import dto.member.UserInfo;

public interface MemberService {
	// 회원정보 수정
	public abstract MemberDto selectByEmail(String email);
	public abstract int memberModify(MemberDto memberDto);
	public abstract int changePassword(ChangePassword changePassword);

	// 회원가입
	public abstract void registerMember(RegisterRequest regReq);
	public abstract MemberDto emailCheck(String email);
	
	//로그인
	public UserInfo authenticate(String email, String password);
	//회원 탈퇴
	public void outMember(String email, String password);
	//아이디(email) 찾기
	public String searchByPhone(String phone);
	//비번찾기
	public String searchforPassword(String email, String phone, String name);
}
