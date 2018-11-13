package dao.notice;

import org.mybatis.spring.SqlSessionTemplate;

public class NoticeDaoMybatis implements NoticeDao {
	private SqlSessionTemplate sqlSessionTemplate;

	public NoticeDaoMybatis(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
}
