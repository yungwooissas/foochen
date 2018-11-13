package dto.tcomment;

import java.util.Date;

public class TCommentDto {
	private int tcNumber;
	private int tNumber;
	private String email;
	private String name;
	private Date tDate;
	private String tComment;
	
	public int getTcNumber() {
		return tcNumber;
	}
	public void setTcNumber(int tcNumber) {
		this.tcNumber = tcNumber;
	}
	public int gettNumber() {
		return tNumber;
	}
	public void settNumber(int tNumber) {
		this.tNumber = tNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date gettDate() {
		return tDate;
	}
	public void settDate(Date tDate) {
		this.tDate = tDate;
	}
	public String gettComment() {
		return tComment;
	}
	public void settComment(String tComment) {
		this.tComment = tComment;
	}
	
	
}
