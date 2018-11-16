package dto.notice;

import java.security.Timestamp;
import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("NoticeDto")
public class NoticeDto {
	private int nNumber;
	private String nTitle;
	private String notice;
	private String name;
	private Date nDate;
	
	public NoticeDto() {}
	
	public NoticeDto(int nNumber, String nTitle, String notice, String name) {
		super();
		this.nNumber = nNumber;
		this.nTitle = nTitle;
		this.notice = notice;
		this.name = name;
	}

	public int getnNumber() {
		return nNumber;
	}

	public void setnNumber(int nNumber) {
		this.nNumber = nNumber;
	}

	public String getnTitle() {
		return nTitle;
	}

	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getnDate() {
		return nDate;
	}

	public void setnDate(Date nDate) {
		this.nDate = nDate;
	}
	
}

