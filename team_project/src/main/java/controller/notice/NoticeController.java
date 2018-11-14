package controller.notice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.notice.NoticeService;

@Controller
public class NoticeController {
	private NoticeService noticeService;

	public NoticeController(NoticeService noticeService) {
		this.noticeService = noticeService;
	}
	
	@RequestMapping(value="/boardnotice/list")
	@ResponseBody
	public String list() {
		return noticeService.list().toString();
	}
	
}
