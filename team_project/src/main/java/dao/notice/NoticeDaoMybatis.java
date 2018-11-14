package dao.notice;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import dto.notice.NoticeDto;

public class NoticeDaoMybatis implements NoticeDao {
	private SqlSessionTemplate sqlSessionTemplate;

	public NoticeDaoMybatis(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public List<NoticeDto> list() {
		return sqlSessionTemplate.selectList("list");
	}

	@Override
	public int delete(NoticeDto noticeDto) {
		return sqlSessionTemplate.delete("delete", noticeDto);
	}

	@Override
	public int deleteAll() {
		return sqlSessionTemplate.delete("deleteAll");
	}

	@Override
	public int update(NoticeDto noticeDto) {
		return sqlSessionTemplate.update("update", noticeDto);
	}

	@Override
	public void insert(NoticeDto noticeDto) {
		sqlSessionTemplate.insert("insert", noticeDto);
	}

	@Override
	public NoticeDto select(int nNumber) {
		NoticeDto dto = (NoticeDto) sqlSessionTemplate.selectOne("select", nNumber);
		return dto;
	}

	@Override
	public int updateReadCount(int nNumber) {
		return sqlSessionTemplate.update("updateCount", nNumber);
	}
	
}
