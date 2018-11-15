package controller.talk;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dto.talk.TalkDto;

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
	
	@RequestMapping(value="/talk/talkdetail/{tNumber}")
	public String detail(Model model, @PathVariable int tNumber) {
		model.addAttribute("talkDto", talkService.tDetail(tNumber));
		return "/talk/talkdetail";
	}
	
	@RequestMapping(value="/talk/talkwrite", method=RequestMethod.GET)
	public String write(Model model) {
		model.addAttribute("talkDto", new TalkDto());
		return "/talk/talkwrite";
	}
	
	@RequestMapping(value="/talk/talkwrite", method=RequestMethod.POST)
	public String write(TalkDto talkDto, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "/talk/talkwrite";
		}
		talkService.tWrite(talkDto);
		return "redirect:/talk/talklist";
	}
}
