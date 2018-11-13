package dao.qna;

import org.mybatis.spring.SqlSessionTemplate;

public class QnaDaoMybatis implements QnaDao{
	private SqlSessionTemplate sqlSessionTemplate;

	public QnaDaoMybatis(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
}
