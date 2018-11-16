package dao.member;

import dto.member.MemberDto;

public interface MemberDao {
	// 영우
	public MemberDto selectByEmail(String email);
	public int memberModify(MemberDto memberDto);
	public int changePassword(MemberDto memberDto);
	
	//가혜 일단
	public void registerMember(MemberDto memberDto); // 회원가입
	public MemberDto emailCheck(String email); // 이메일 체크
	
	// 소영
	//phone번호로 멤버정보 찾을꺼야 - email(id) 찾을 때 사용
	public MemberDto selectByPhone(String phone);
	//회원탈퇴시 사용
	public void deleteMember(MemberDto memberDto);

}
