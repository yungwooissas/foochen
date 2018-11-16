package service.qna;

import java.util.List;

import dao.qna.QnaDao;
import dao.qna.QnaDao;
import dto.qna.QnaDto;

public class QnaServiceImpl implements QnaService{
	private QnaDao qnaDao;

	public QnaServiceImpl(QnaDao qnaDao) {
		this.qnaDao = qnaDao;
	}
	public QnaDao getBoardDao() {
		return qnaDao;
	}
	
	public void setQnaDao(QnaDao qnaDao) {
		this.qnaDao = qnaDao;
	}

	@Override
	public List<QnaDto> list(int start, int end) {
		return qnaDao.list(start, end);
	}

	@Override
	public int delete(QnaDto qnaDto) {
		return qnaDao.delete(qnaDto);
	}

	@Override
	public int edit(QnaDto qnaDto) {
		return qnaDao.update(qnaDto);
	}

	@Override
	public void write(QnaDto qnaDto) {
		qnaDao.insert(qnaDto);
	}

	@Override
	public QnaDto read(int nNumber) {
		return qnaDao.select(nNumber);
	}

	@Override
	public int count() {
		return qnaDao.count();
	}
}
