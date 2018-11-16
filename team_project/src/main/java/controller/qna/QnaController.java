package controller.qna;

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

import dto.qna.QnaDto;
import service.qna.QnaService;

@Controller
@SessionAttributes("qnaDto")
public class QnaController {
	private QnaService qnaService;
	
	public void setQnaService(QnaService qnaService) {
		this.qnaService = qnaService;
	}
	
	@RequestMapping(value="/qna/list")
	public String list(Model model, @RequestParam(value="pageNum", defaultValue="1") String pageNum, HttpSession session) {
//		세션 아이디 검색부분!!!!!!!!	
		session.setAttribute("ID", "admin");
		session.setAttribute("ID2", "k");
		String ID = (String)session.getAttribute("ID");
		if(ID.equals("admin")) {
			model.addAttribute("approval", "approval");
		}
		int count = qnaService.count();
		int pageSize = 5;
		int currentPage = Integer.parseInt(pageNum);
		int startRow = count - (currentPage-1) * pageSize;
		int endRow = startRow -pageSize + 1;
		
		List<QnaDto> qnaList = null;
		if(count > 0) {
			qnaList = qnaService.list(startRow, endRow);
		} else {
			qnaList = Collections.emptyList();
		}
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("qnaList", qnaList);
		model.addAttribute("count", count);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("pageNum",pageNum);
		return "/qna/list";
	}
	
	@RequestMapping(value="/qna/read/{nNumber}")
	public String read(Model model, @PathVariable int nNumber, HttpSession session) {
//		세션 아이디 검색부분!!!!!!!!	
		session.setAttribute("ID", "admin");
		String ID = (String)session.getAttribute("ID");
		if(ID.equals("admin")) {
			model.addAttribute("approval", "approval");
		}
		model.addAttribute("qnaDto", qnaService.read(nNumber));
		return "/qna/read";
	}
	
	@RequestMapping(value="/qna/write", method=RequestMethod.GET)
	public String write(Model model) {
		model.addAttribute("qnaDto", new QnaDto());
		return "/qna/write";
	}
	
	@RequestMapping(value="/qna/write", method=RequestMethod.POST)
	public String write(@Valid QnaDto qnaDto, BindingResult bindingResult, HttpSession session, Model model) {
//		세션 아이디 검색부분!!!!!!!!		
		session.setAttribute("ID", "k");
		String ID =(String)session.getAttribute("ID");
		if(ID.equals("admin")) {
			if(bindingResult.hasErrors()) {
				return "/qna/write";
			}
			qnaService.write(qnaDto);
			return "redirect:/qna/list";
		} else {
			model.addAttribute("msg", "관리자만 작성할 수 있습니다.");
			return "redirect:/qna/list";
		}
		
	}
	
	@RequestMapping(value="/qna/edit/{nNumber}", method=RequestMethod.GET)
	public String edit(@PathVariable int nNumber, Model model) {
		QnaDto qnaDto = qnaService.read(nNumber);
		model.addAttribute("qnaDto", qnaDto);
		return "/qna/edit";
	}
	
	@RequestMapping(value="/qna/edit/{nNumber}", method=RequestMethod.POST)
	public String edit(@ModelAttribute QnaDto qnaDto, BindingResult result, HttpSession session, Model model) {
//		세션 아이디 검색부분!!!!!!!!
		session.setAttribute("ID", "admin");
		String ID =(String)session.getAttribute("ID");
		if(ID.equals("admin")) {
		if(result.hasErrors()) {
			return "/qna/edit";
		} 
		else {
				qnaService.edit(qnaDto);
				return "redirect:/qna/list";
			}
		} else {
			model.addAttribute("msg", "관리자만 편집할 수 있습니다.");
			return "redirect:/qna/list";
		}
	}
	
	@RequestMapping(value="/qna/delete/{nNumber}", method=RequestMethod.GET)
	public String delete(@PathVariable int nNumber, Model model) {
		model.addAttribute("nNumber", nNumber);
		return "/qna/delete";
	}
	
	@RequestMapping(value="/qna/delete", method=RequestMethod.POST)
	public String delete(int nNumber, String email, Model model, HttpSession session) {
//		세션 아이디 검색부분!!!!!!!!
		session.setAttribute("ID", "admin");
		String ID =(String)session.getAttribute("ID");
		if(ID.equals("admin")) {
			QnaDto qnaDto = new QnaDto();
			qnaDto.setqNumber(nNumber);
			qnaService.delete(qnaDto);
			return "redirect:/qna/list";
		} else {
		model.addAttribute("nNumber", nNumber);
		model.addAttribute("msg", "관리자만 삭제할 수 있습니다.");
		return "/qna/delete";
		}
	}
}