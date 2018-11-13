package service.notice;

import dao.notice.NoticeDao;

public class NoticeServiceImpl implements NoticeService{
	private NoticeDao noticeDao;

	public NoticeServiceImpl(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}
	
}
