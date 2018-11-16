package controller.talk;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import dto.talk.TalkDto;

import org.springframework.ui.Model;
/*import org.springframework.web.bind.annotation.ResponseBody;*/

import service.talk.TalkService;
import service.tcomment.TCommentService;


@Controller
@SessionAttributes("talkDto")
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
	
	@RequestMapping(value="/talk/talkupdate/{tNumber}", method=RequestMethod.GET)
	public String update(@PathVariable int tNumber, Model model) {
		TalkDto talkDto = talkService.tDetail(tNumber);
		model.addAttribute("talkDto", talkDto);
		return "/talk/talkupdate";
	}
	
	@RequestMapping(value="/talk/talkupdate/{tNumber}", method=RequestMethod.POST)
	public String update(
			@Valid @ModelAttribute TalkDto talkDto,
			BindingResult result,
			String name,
			SessionStatus sessionStatus,
			Model model) {
		if(result.hasErrors()) {
			return "/talk/talkupdate";
		} else {
			if(talkDto.getName().equals(name)) {
				talkService.tEdit(talkDto);
				return "redirect:/talk/talklist";
			}
		}
		model.addAttribute("msg","닉네임이 일치하지 않습니다.");
		return "/talk/talkupdate";		
	}
	
	@RequestMapping(value="/talk/talkdelete/{tNumber}", method=RequestMethod.GET)
	public String delete(@PathVariable int tNumber, Model model) {
		model.addAttribute("tNumber", tNumber);
		return "/talk/talkdelete";
	}
	
	@RequestMapping(value="/talk/talkdelete", method=RequestMethod.POST)
	public String delete(int tNumber, String name, Model model) {
		int rowCount;
		TalkDto talkDto = new TalkDto();
		talkDto.settNumber(tNumber);
		talkDto.setName(name);
		
		rowCount = talkService.tDelete(talkDto);
		
		if(rowCount == 0) {
			model.addAttribute("tNumber", tNumber);
			model.addAttribute("msg", "회원이 일치하지 않습니다.");
			return "/talk/talkdelete";
		}
		else {
			return "redirect:/talk/talklist";
		}		
	}
}
