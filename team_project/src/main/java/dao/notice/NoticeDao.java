package dao.notice;

import java.util.List;

import dto.notice.NoticeDto;

public interface NoticeDao {
	public abstract List<NoticeDto> list(int start, int end);
	public abstract int delete(NoticeDto noticeDto);
//	public abstract int deleteAll();
	public abstract int update(NoticeDto noticeDto);
	public abstract void insert(NoticeDto noticeDto);
	public abstract NoticeDto select(int nNumber);
	public abstract int count();
}
