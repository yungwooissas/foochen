package controller.qna;

import org.springframework.stereotype.Controller;

import service.qna.QnaService;

@Controller
public class QnaController {
	private QnaService qnaService;

	public QnaController(QnaService qnaService) {
		this.qnaService = qnaService;
	}
	
}
