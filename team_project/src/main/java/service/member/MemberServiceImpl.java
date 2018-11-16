package service.member;

import java.util.Date;

import org.springframework.transaction.annotation.Transactional;

import dao.member.MemberDao;
import dto.member.ChangePassword;
import dto.member.MemberDto;
import dto.member.RegisterRequest;
import dto.member.UserInfo;
import exception.AlreadyExistingMemberException;

public class MemberServiceImpl implements MemberService {
	private MemberDao memberDao;

	public MemberServiceImpl(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	@Override
	public MemberDto selectByEmail(String email) {
		return memberDao.selectByEmail(email);
	}

	@Override
	public int memberModify(MemberDto memberDto) {
		return memberDao.memberModify(memberDto);
	}

	@Override
	public int changePassword(ChangePassword changePassword) {
		
		String password = memberDao.selectByEmail(changePassword.getEmail()).getPassword();
		
		if(!password.equals(changePassword.getNowPassword())) {
			System.out.println("비번x");
			// 비밀번호를 잘 못 입력하셨습니다.
		}
		if(!changePassword.getNewPassword().equals(changePassword.getNewPasswordConfirm())) {
			// 새 비밀번호를 다시 확인해주십시오.
			System.out.println("새 비번x");
		}
		MemberDto memberDto = new MemberDto();
		memberDto.setEmail(changePassword.getEmail());
		memberDto.setPassword(changePassword.getNewPassword());
		return memberDao.changePassword(memberDto);
	}
	
	
	// 가혜 회원가입 수정중
	@Override
	public void registerMember(RegisterRequest regReq) {
		MemberDto memberDto = memberDao.selectByEmail(regReq.getEmail());
		if(memberDto != null) {
			throw new AlreadyExistingMemberException(
					"dup email" + regReq.getEmail());
		}
		MemberDto newMember = new MemberDto(
				regReq.getEmail(),
				regReq.getPassword(),
				regReq.getName(),
				regReq.getPhone(),
				regReq.getGender(),
				regReq.getBirth(),
				regReq.getLike1(),
				regReq.getLike2(),
				regReq.getLike3(),
				new Date()
				);
		memberDao.registerMember(newMember);
	}
	
	
	@Override
	public MemberDto emailCheck(String email) { //일단 추가		
		return memberDao.emailCheck(email); // 쿼리 넣는 메서드
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
