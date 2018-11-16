package service.qna;

import java.util.List;

import dto.qna.QnaDto;

public interface QnaService {
	public abstract List<QnaDto> list(int start, int end);
	public abstract int delete(QnaDto qnaDto);
	public abstract int edit(QnaDto qnaDto);
	public abstract void write(QnaDto qnaDto);
	public abstract QnaDto read(int nNumber);
	public abstract int count();
}
