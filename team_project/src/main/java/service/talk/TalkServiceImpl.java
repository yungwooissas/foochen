package service.talk;

import dao.talk.TalkDao;

public class TalkServiceImpl implements TalkService {
	private TalkDao talkDao;

	public TalkServiceImpl(TalkDao talkDao) {
		this.talkDao = talkDao;
	}
	
}
