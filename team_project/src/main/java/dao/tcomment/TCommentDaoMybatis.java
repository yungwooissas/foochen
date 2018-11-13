package dao.tcomment;

import org.mybatis.spring.SqlSessionTemplate;

public class TCommentDaoMybatis implements TCommentDao {
	private SqlSessionTemplate sqlSessionTemplate;

	public TCommentDaoMybatis(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	
}
