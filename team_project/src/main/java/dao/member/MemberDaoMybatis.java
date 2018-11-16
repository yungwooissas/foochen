package dao.member;

import org.mybatis.spring.SqlSessionTemplate;

import dto.member.MemberDto;

public class MemberDaoMybatis implements MemberDao{

	private SqlSessionTemplate sqlSessionTemplate;
	
	public MemberDaoMybatis(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	//email로 로그인시
	@Override
	public Object selectByEmail(String email) {
		return sqlSessionTemplate.selectOne("selectByEmail", email);
	}

	//phone번호로 email꺼낼꺼야(id찾기)
	@Override
	public Object selectByPhone(String phone) {
		return sqlSessionTemplate.selectOne("selectByPhone", phone);
	}

	//유저 탈퇴 할꺼야
	@Override
	public void deleteMember(MemberDto memberDto) {
		sqlSessionTemplate.update("deleteMember", memberDto.getEmail());
	}
	
}
