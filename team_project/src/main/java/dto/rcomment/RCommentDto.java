package dto.rcomment;

import java.util.Date;

public class RCommentDto {
	private int rcNumber;
	private int rNumber;
	private String email;
	private String name;
	private Date rcDate;
	private String rComment;
	
	public int getRcNumber() {
		return rcNumber;
	}
	public void setRcNumber(int rcNumber) {
		this.rcNumber = rcNumber;
	}
	public int getrNumber() {
		return rNumber;
	}
	public void setrNumber(int rNumber) {
		this.rNumber = rNumber;
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
	public Date getRcDate() {
		return rcDate;
	}
	public void setRcDate(Date rcDate) {
		this.rcDate = rcDate;
	}
	public String getrComment() {
		return rComment;
	}
	public void setrComment(String rComment) {
		this.rComment = rComment;
	}
	

	
	
	
}
