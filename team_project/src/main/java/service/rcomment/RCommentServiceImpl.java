package service.rcomment;

import dao.rcomment.RCommentDao;

public class RCommentServiceImpl implements RCommentService {
	private RCommentDao rcommentDao;

	public RCommentServiceImpl(RCommentDao rcommentDao) {
		this.rcommentDao = rcommentDao;
	}
	
	
}
