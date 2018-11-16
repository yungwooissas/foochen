package dao.qna;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import dto.qna.QnaDto;

public class QnaDaoMybatis implements QnaDao{
	private SqlSessionTemplate sqlSessionTemplate;

	public QnaDaoMybatis(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	public void setSqlMapClient(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public List<QnaDto> list(int start, int end) {
		HashMap<String, Integer> params = new HashMap<String, Integer>();
		params.put("start", start);
		params.put("end", end);
		return sqlSessionTemplate.selectList("nList",params);
	}

	@Override
	public int delete(QnaDto qnaDto) {
		return sqlSessionTemplate.delete("nDelete", qnaDto);
	}

//	@Override
//	public int deleteAll() {
//		return sqlSessionTemplate.delete("nDeleteAll");
//	}

	@Override
	public int update(QnaDto qnaDto) {
		return sqlSessionTemplate.update("nUpdate", qnaDto);
	}

	@Override
	public void insert(QnaDto qnaDto) {
		sqlSessionTemplate.insert("nInsert", qnaDto);
	}

	@Override
	public QnaDto select(int nNumber) {
		QnaDto dto = (QnaDto) sqlSessionTemplate.selectOne("nSelect", nNumber);
		return dto;
	}

	@Override
	public int count() {
		return sqlSessionTemplate.selectOne("nCount");
	}
}
