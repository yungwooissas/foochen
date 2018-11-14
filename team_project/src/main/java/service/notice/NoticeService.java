package service.notice;

import java.util.List;

import dto.notice.NoticeDto;

public interface NoticeService {
	public abstract List<NoticeDto> list();
	public abstract int delete(NoticeDto noticeDto);
	public abstract int edit(NoticeDto noticeDto);
	public abstract void write(NoticeDto noticeDto);
	public abstract NoticeDto read(int nNumber);
}
