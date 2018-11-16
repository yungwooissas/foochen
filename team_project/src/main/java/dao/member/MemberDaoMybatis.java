package dao.member;

import org.mybatis.spring.SqlSessionTemplate;

import dto.member.MemberDto;

public class MemberDaoMybatis implements MemberDao{

	private SqlSessionTemplate sqlSessionTemplate;
	
	public MemberDaoMybatis(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	//공통
	@Override
	public MemberDto selectByEmail(String email) {
		return sqlSessionTemplate.selectOne("selectByEmail",email);
	}
	
	//영우
	@Override
	public int memberModify(MemberDto memberDto) {
		return sqlSessionTemplate.update("memberModify", memberDto);
	}
	
	@Override
	public int changePassword(MemberDto memberDto) {
		return sqlSessionTemplate.update("changePassword", memberDto);
	}
	
	//가혜
	@Override
	public void registerMember(MemberDto memberDto) { 
		sqlSessionTemplate.insert("registerMember",memberDto); // insert기능의 sqlmap의 id="insertMember"
	}

	@Override
	public MemberDto emailCheck(String email) { // 이메일 체크용
		return sqlSessionTemplate.selectOne("emailCheck",email);
	}
	
	//소영
	//phone번호로 email꺼낼꺼야(id찾기)
	@Override
	public MemberDto selectByPhone(String phone) {
		return sqlSessionTemplate.selectOne("selectByPhone", phone);
	}

	//유저 탈퇴 할꺼야
	@Override
	public void deleteMember(MemberDto memberDto) {
		sqlSessionTemplate.update("deleteMember", memberDto.getEmail());
	}
}
