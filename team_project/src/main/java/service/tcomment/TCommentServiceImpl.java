package service.tcomment;

import dao.tcomment.TCommentDao;

public class TCommentServiceImpl implements TCommentService {
	private TCommentDao tcommentDao;

	public TCommentServiceImpl(TCommentDao tcommentDao) {
		super();
		this.tcommentDao = tcommentDao;
	}


}
