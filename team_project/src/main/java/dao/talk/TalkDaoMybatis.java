package dao.talk;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import dto.talk.TalkDto;

@Repository
public class TalkDaoMybatis implements TalkDao {
	
	private SqlSessionTemplate sqlSessionTemplate;

	public TalkDaoMybatis(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	public void setSqlMapClient(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public List<TalkDto> list() {
		return sqlSessionTemplate.selectList("Tlist");
	}

	@Override
	public int delete(TalkDto talkDto) {
		return sqlSessionTemplate.delete("delete", talkDto);
	}

	@Override
	public int deleteAll() {
		return sqlSessionTemplate.delete("deleteAll");
	}

	@Override
	public int update(TalkDto talkDto) {
		return sqlSessionTemplate.update("update", talkDto);
	}

	@Override
	public void insert(TalkDto talkDto) {
		sqlSessionTemplate.insert("insert", talkDto);
	}

	@Override
	public TalkDto select(int tNumber) {
		TalkDto td = (TalkDto) sqlSessionTemplate.selectOne("select", tNumber);
		return td;
	}
	
}
