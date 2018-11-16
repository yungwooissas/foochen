package dao.notice;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import dto.notice.NoticeDto;

public class NoticeDaoMybatis implements NoticeDao {
	private SqlSessionTemplate sqlSessionTemplate;

	public NoticeDaoMybatis(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	public void setSqlMapClient(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public List<NoticeDto> list(int start, int end) {
		HashMap<String, Integer> params = new HashMap<String, Integer>();
		params.put("start", start);
		params.put("end", end);
		return sqlSessionTemplate.selectList("nList",params);
	}

	@Override
	public int delete(NoticeDto noticeDto) {
		return sqlSessionTemplate.delete("nDelete", noticeDto);
	}

//	@Override
//	public int deleteAll() {
//		return sqlSessionTemplate.delete("nDeleteAll");
//	}

	@Override
	public int update(NoticeDto noticeDto) {
		return sqlSessionTemplate.update("nUpdate", noticeDto);
	}

	@Override
	public void insert(NoticeDto noticeDto) {
		sqlSessionTemplate.insert("nInsert", noticeDto);
	}

	@Override
	public NoticeDto select(int nNumber) {
		NoticeDto dto = (NoticeDto) sqlSessionTemplate.selectOne("nSelect", nNumber);
		return dto;
	}

	@Override
	public int count() {
		return sqlSessionTemplate.selectOne("nCount");
	}
}
