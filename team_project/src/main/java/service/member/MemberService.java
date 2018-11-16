package service.member;

import dto.member.UserInfo;

public interface MemberService {
	// 사용할 메서드 선언
	
	//로그인
	public UserInfo authenticate(String email, String password);

	//회원 탈퇴
	public void outMember(String email, String password);

	//아이디(email) 찾기
	public String searchByPhone(String phone);

	//비번찾기
	public String searchforPassword(String email, String phone, String name);

}
