package controller.talk;

import service.talk.TalkService;
import service.tcomment.TCommentService;

public class TalkController {
	private TalkService talkService;
	private TCommentService tcommentService;
	
	public TalkController(TalkService talkService, TCommentService tcommentService) {
		super();
		this.talkService = talkService;
		this.tcommentService = tcommentService;
	}
	public static void main(String[] args) {
		System.out.println("test");
	}
	
	
}
