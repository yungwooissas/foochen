package controller.notice;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

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
	public String list(Model model, @RequestParam(value="pageNum", defaultValue="1") String pageNum, HttpSession session) {
//		세션 아이디 검색부분!!!!!!!!	
		session.setAttribute("ID", "admin");
		String ID = (String)session.getAttribute("ID");
		if(ID.equals("admin")) {
			model.addAttribute("approval", "approval");
		}
		int count = noticeService.count();
		int pageSize = 5;
		int currentPage = Integer.parseInt(pageNum);
		int startRow = count - (currentPage-1) * pageSize;
		int endRow = startRow -pageSize + 1;
		
		List<NoticeDto> noticeList = null;
		if(count > 0) {
			noticeList = noticeService.list(startRow, endRow);
		} else {
			noticeList = Collections.emptyList();
		}
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("count", count);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("pageNum",pageNum);
		return "/notice/list";
	}
	
	@RequestMapping(value="/notice/read/{nNumber}")
	public String read(Model model, @PathVariable int nNumber, HttpSession session) {
//		세션 아이디 검색부분!!!!!!!!	
		session.setAttribute("ID", "admin");
		String ID = (String)session.getAttribute("ID");
		if(ID.equals("admin")) {
			model.addAttribute("approval", "approval");
		}
		model.addAttribute("noticeDto", noticeService.read(nNumber));
		return "/notice/read";
	}
	
	@RequestMapping(value="/notice/write", method=RequestMethod.GET)
	public String write(Model model) {
		model.addAttribute("noticeDto", new NoticeDto());
		return "/notice/write";
	}
	
	@RequestMapping(value="/notice/write", method=RequestMethod.POST)
	public String write(@Valid NoticeDto noticeDto, BindingResult bindingResult, HttpSession session, Model model) {
//		세션 아이디 검색부분!!!!!!!!		
		session.setAttribute("ID", "k");
		String ID =(String)session.getAttribute("ID");
		if(ID.equals("admin")) {
			if(bindingResult.hasErrors()) {
				return "/notice/write";
			}
			noticeService.write(noticeDto);
			return "redirect:/notice/list";
		} else {
			model.addAttribute("msg", "관리자만 작성할 수 있습니다.");
			return "redirect:/notice/list";
		}
		
	}
	
	@RequestMapping(value="/notice/edit/{nNumber}", method=RequestMethod.GET)
	public String edit(@PathVariable int nNumber, Model model) {
		NoticeDto noticeDto = noticeService.read(nNumber);
		model.addAttribute("noticeDto", noticeDto);
		return "/notice/edit";
	}
	
	@RequestMapping(value="/notice/edit/{nNumber}", method=RequestMethod.POST)
	public String edit(@ModelAttribute NoticeDto noticeDto, BindingResult result, HttpSession session, Model model) {
//		세션 아이디 검색부분!!!!!!!!
		session.setAttribute("ID", "admin");
		String ID =(String)session.getAttribute("ID");
		if(ID.equals("admin")) {
		if(result.hasErrors()) {
			return "/notice/edit";
		} 
		else {
				noticeService.edit(noticeDto);
				return "redirect:/notice/list";
			}
		} else {
			model.addAttribute("msg", "관리자만 편집할 수 있습니다.");
			return "redirect:/notice/list";
		}
	}
	
	@RequestMapping(value="/notice/delete/{nNumber}", method=RequestMethod.GET)
	public String delete(@PathVariable int nNumber, Model model) {
		model.addAttribute("nNumber", nNumber);
		return "/notice/delete";
	}
	
	@RequestMapping(value="/notice/delete", method=RequestMethod.POST)
	public String delete(int nNumber, String email, Model model, HttpSession session) {
//		세션 아이디 검색부분!!!!!!!!
		session.setAttribute("ID", "admin");
		String ID =(String)session.getAttribute("ID");
		if(ID.equals("admin")) {
			NoticeDto noticeDto = new NoticeDto();
			noticeDto.setnNumber(nNumber);
			noticeService.delete(noticeDto);
			return "redirect:/notice/list";
		} else {
		model.addAttribute("nNumber", nNumber);
		model.addAttribute("msg", "관리자만 삭제할 수 있습니다.");
		return "/notice/delete";
		}
	}
}