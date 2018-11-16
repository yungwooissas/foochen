package dao.member;

import dto.member.MemberDto;

public interface MemberDao {
	// 사용할 메서드 선언
	
	//email로 멤버정보 찾을꺼야 - 로그인시 사용
	public Object selectByEmail(String email);

	//phone번호로 멤버정보 찾을꺼야 - email(id) 찾을 때 사용
	public Object selectByPhone(String phone);

	//회원탈퇴시 사용
	public void deleteMember(MemberDto memberDto);

}
