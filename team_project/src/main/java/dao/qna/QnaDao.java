package dao.qna;

import java.util.List;

import dto.qna.QnaDto;

public interface QnaDao {
	public abstract List<QnaDto> list(int start, int end);
	public abstract int delete(QnaDto qnaDto);
//	public abstract int deleteAll();
	public abstract int update(QnaDto qnaDto);
	public abstract void insert(QnaDto qnaDto);
	public abstract QnaDto select(int nNumber);
	public abstract int count();
}
