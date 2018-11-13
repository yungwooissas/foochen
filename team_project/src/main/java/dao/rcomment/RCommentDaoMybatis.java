package dao.rcomment;

import org.mybatis.spring.SqlSessionTemplate;

public class RCommentDaoMybatis implements RCommentDao{
	private SqlSessionTemplate sqlSessionTemplate;

	public RCommentDaoMybatis(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
}
