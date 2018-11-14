package controller.talk;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
/*import org.springframework.web.bind.annotation.ResponseBody;*/

import service.talk.TalkService;
import service.tcomment.TCommentService;

@Controller
public class TalkController {
	private TalkService talkService;
	private TCommentService tcommentService;
	
	public TalkController(TalkService talkService, TCommentService tcommentService) {
		super();
		this.talkService = talkService;
		this.tcommentService = tcommentService;
	}
	
	public void setTalkService(TalkService talkService) {
		this.talkService = talkService;
	}
	
	@RequestMapping(value="/talk/talklist")
	public String list(Model model) {
		model.addAttribute("talkList", talkService.tList());
		return "/talk/talklist";
	}
}
