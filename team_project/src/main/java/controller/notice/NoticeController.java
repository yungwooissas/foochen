package controller.notice;

import org.springframework.stereotype.Controller;

import service.notice.NoticeService;

@Controller
public class NoticeController {
	private NoticeService noticeService;

	public NoticeController(NoticeService noticeService) {
		this.noticeService = noticeService;
	}
	
}
