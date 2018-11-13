package service.member;

import dao.member.MemberDao;

public class MemberServiceImpl implements MemberService {
	private MemberDao memberDao;

	public MemberServiceImpl(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
}
