package dto.talk;

import java.sql.Timestamp;

public class TalkDto {
	private int tNumber;
	private String email;
	private String name;
	private Timestamp tDate;
	private String tImage;
	private String talk;
	private int tScore;
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
	public Timestamp gettDate() {
		return tDate;
	}
	public void settDate(Timestamp tDate) {
		this.tDate = tDate;
	}
	public String gettImage() {
		return tImage;
	}
	public void settImage(String tImage) {
		this.tImage = tImage;
	}
	public String getTalk() {
		return talk;
	}
	public void setTalk(String talk) {
		this.talk = talk;
	}
	public int gettScore() {
		return tScore;
	}
	public void settScore(int tScore) {
		this.tScore = tScore;
	}
	
	
}
