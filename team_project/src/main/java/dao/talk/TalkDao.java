package dao.talk;

import java.util.List;

import dto.talk.TalkDto;

public interface TalkDao {
	// 사용할 메서드 선언
	public abstract List<TalkDto> list();
	
	public abstract int delete(TalkDto talkDto);
	
	public abstract int deleteAll();
	
	public abstract int update(TalkDto talkDto);
	
	public abstract void insert(TalkDto talkDto);
	
	public abstract TalkDto select(int tNumber);
	
}
