package service.notice;

import java.util.List;

import org.springframework.stereotype.Service;

import dao.notice.NoticeDao;
import dto.notice.NoticeDto;

@Service
public class NoticeServiceImpl implements NoticeService{
	private NoticeDao noticeDao;

	public NoticeDao getBoardDao() {
		return noticeDao;
	}
	
	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}

	@Override
	public List<NoticeDto> list() {
		return noticeDao.list();
	}

	@Override
	public int delete(NoticeDto noticeDto) {
		return noticeDao.delete(noticeDto);
	}

	@Override
	public int edit(NoticeDto noticeDto) {
		return noticeDao.update(noticeDto);
	}

	@Override
	public void write(NoticeDto noticeDto) {
		noticeDao.insert(noticeDto);
	}

	@Override
	public NoticeDto read(int nNumber) {
		noticeDao.updateReadCount(nNumber);
		return noticeDao.select(nNumber);
	}
	
}
