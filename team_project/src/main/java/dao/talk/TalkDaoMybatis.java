package dao.talk;

import org.mybatis.spring.SqlSessionTemplate;

public class TalkDaoMybatis implements TalkDao {
	private SqlSessionTemplate sqlSessionTemplate;

	public TalkDaoMybatis(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
}
