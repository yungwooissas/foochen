package service.talk;

import java.util.List;

import dao.talk.TalkDao;
import dto.talk.TalkDto;

public class TalkServiceImpl implements TalkService {
	private TalkDao talkDao;
	
	public TalkServiceImpl() {}

	public TalkServiceImpl(TalkDao talkDao) {
		this.talkDao = talkDao;
	}

	public TalkDao getTalkDao() {
		return talkDao;
	}

	public void setTalkDao(TalkDao talkDao) {
		this.talkDao = talkDao;
	}

	@Override
	public List<TalkDto> tList() {
		return talkDao.list();
	}

	@Override
	public int tDelete(TalkDto talkDto) {
		return talkDao.delete(talkDto);
	}

	@Override
	public int tEdit(TalkDto talkDto) {
		return talkDao.update(talkDto);
	}

	@Override
	public void tWrite(TalkDto talkDto) {
		talkDao.insert(talkDto);		
	}

	@Override
	public TalkDto tDetail(int tNumber) {
		return talkDao.select(tNumber);
	}
	
}