package service.talk;

import java.util.List;

import dto.talk.TalkDto;

public interface TalkService {
	// 사용할 메서드 선언
	public abstract List<TalkDto> tList();
	
	public abstract int tDelete(TalkDto talkDto);
	
	public abstract int tEdit(TalkDto talkDto);
	
	public abstract void tWrite(TalkDto talkDto);
	
	public abstract TalkDto tDetail(int tNumber);
}
