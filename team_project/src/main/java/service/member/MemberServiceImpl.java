package service.member;

import org.springframework.transaction.annotation.Transactional;

import dao.member.MemberDao;
import dto.member.MemberDto;
import dto.member.UserInfo;

public class MemberServiceImpl implements MemberService {
	private MemberDao memberDao;

	public MemberServiceImpl(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	//로그인 여부 세션용 로직 & 탈퇴 로직 중복되는 부분이 있음
	//묶어서 AOP사용?

	//로그인 여부 세션용 로직(email이랑 password 일치하면 Userinfo 객체 생성할꺼야)
	@Override
	public UserInfo authenticate(String email, String password) {
		MemberDto memberDto = (MemberDto) memberDao.selectByEmail(email);
		if(memberDto == null) {
			//exception 추가해야함
			//throw new MemberNotFoundException();
			System.out.println("없눈사람임미당 에러에러");
		}
		//memberDto에 matchPassword 메서드 추가함
		if(!memberDto.matchPassword(password)) {
			//exception 추가해야함
			//throw new IdPasswordNotMatchingException();
			System.out.println("아이디랑 패스워드가 일치하지않음 에러에러");
		}
		return new UserInfo(memberDto.getEmail(), memberDto.getName());
	}

	//탈퇴 로직
	@Override
	@Transactional
	public void outMember(String email, String password) {
		MemberDto memberDto = (MemberDto) memberDao.selectByEmail(email);
		if(memberDto == null) {
			//exception 추가해야함
			//throw new MemberNotFoundException();
			System.out.println("없눈사람임미당 에러에러");
		}
		//memberDto에 matchPassword 메서드 추가함
		if(!memberDto.matchPassword(password)) {
			//exception 추가해야함
			//throw new IdPasswordNotMatchingException();
			System.out.println("아이디랑 패스워드가 일치하지않음 에러에러");
		}
		memberDao.deleteMember(memberDto);
	}

	//아이디찾기
	@Override
	public String searchByPhone(String phone) {
		MemberDto memberDto = (MemberDto) memberDao.selectByPhone(phone);
		if(memberDto == null) {
			//exception 추가해야함
			//throw new MemberNotFoundException();
			System.out.println("없눈사람임미당 에러에러");
		}
		return memberDto.getEmail();
	}

	//비번 찾기
	@Override
	public String searchforPassword(String email, String phone, String name) {
		MemberDto memberDto = (MemberDto) memberDao.selectByEmail(email);
		if(memberDto == null) {
			//exception 추가해야함
			//throw new MemberNotFoundException();
			System.out.println("없눈사람임미당 에러에러");
		}
		if(!(memberDto.getName().equals(name) && memberDto.getPhone().equals(phone))) {
			//exception 추가해야함
			//throw new MemberNotFoundException();
			System.out.println("땡 입력이 잘못되었습니다.");
		} 
		return memberDto.getPassword();
	}
	
}
