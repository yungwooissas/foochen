package controller.notice;

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

import dto.notice.NoticeDto;
import service.notice.NoticeService;

@Controller
@SessionAttributes("noticeDto")
public class NoticeController {
	private NoticeService noticeService;
	
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}
	
	@RequestMapping(value="/notice/list")
	public String list(Model model) {
		model.addAttribute("noticeList", noticeService.list());
		return "/notice/list";
	}
	
	@RequestMapping(value="/notice/read/{nNumber}")
	public String read(Model model, @PathVariable int nNumber) {
		model.addAttribute("noticeDto", noticeService.read(nNumber));
		return "/notice/read";
	}
	
	@RequestMapping(value="/notice/write", method=RequestMethod.GET)
	public String write(Model model) {
		model.addAttribute("noticeDto", new NoticeDto());
		return "/notice/write";
	}
	
	@RequestMapping(value="/notice/write", method=RequestMethod.POST)
	public String write(@Valid NoticeDto noticeDto, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "/notice/write";
		}
		noticeService.write(noticeDto);
		return "redirect:/notice/write";
	}
	
	@RequestMapping(value="/notice/edit/{nNumber}", method=RequestMethod.GET)
	public String edit(@PathVariable int nNumber, Model model) {
		NoticeDto noticeDto = noticeService.read(nNumber);
		model.addAttribute("noticeDto", noticeDto);
		return "/notice/edit";
	}
	
	@RequestMapping(value="/notice/edit/{nNumber}", method=RequestMethod.POST)
	public String edit(@Valid @ModelAttribute NoticeDto noticeDto, BindingResult result, int pwd, SessionStatus sessionStatus, Model model) {
		if(result.hasErrors()) {
			return "/notice/edit";
		} 
//		관리자만 edit가능하게 수정
//			else {
//			if(noticeDto.getPassword() == pwd) {
//				noticeService.edit(noticeDto);
//				sessionStatus.setComplete();
//				return "redirect:/boardnotice/list";
//			}
//		}
//		model.addAttribute("msg", "비밀번호가 일치하지 않습니다.");
		return "/notice/edit";
	}
	
	@RequestMapping(value="/notice/delete/{seq}", method=RequestMethod.GET)
	public String delete(@PathVariable int nNumber, Model model) {
		model.addAttribute("nNumber", nNumber);
		return "/notice/delete";
	}
	
	@RequestMapping(value="/notice/delete", method=RequestMethod.POST)
	public String delete(int nNumber, int pwd, Model model) {
		int rowCount;
		NoticeDto noticeDto = new NoticeDto();
//		noticeDto.setSeq(seq);
//		noticeDto.setPassword(pwd); 
// 사용자 확인 부분!!!
		
		rowCount = noticeService.delete(noticeDto);
		//관리자만 삭제 추가
		if(rowCount == 0) {
			model.addAttribute("nNumber", nNumber);
			model.addAttribute("msg", "비밀번호가 일치하지 않습니다.");
			return "/notice/delete";
		} else {
			return "redirect:/notice/list";
		}
	}
}