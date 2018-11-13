package service.qna;

import dao.qna.QnaDao;

public class QnaServiceImpl implements QnaService{
	private QnaDao qnaDao;

	public QnaServiceImpl(QnaDao qnaDao) {
		this.qnaDao = qnaDao;
	}
	
}
