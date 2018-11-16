package dto.member;

import java.util.Date;

public class MemberDto {
	private int mNumber;
	private String email;
	private String name;
	private String password;
	private String phone;
	private int gender;
	private String birth;
	private String like1;
	private String like2;
	private String like3;
	private Date joinDate;
	private int grade;
	private int point;
	//private String recent;
	//private String fork;
	
	public int getmNumber() {
		return mNumber;
	}
	public void setmNumber(int mNumber) {
		this.mNumber = mNumber;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getLike1() {
		return like1;
	}
	public void setLike1(String like1) {
		this.like1 = like1;
	}
	public String getLike2() {
		return like2;
	}
	public void setLike2(String like2) {
		this.like2 = like2;
	}
	public String getLike3() {
		return like3;
	}
	public void setLike3(String like3) {
		this.like3 = like3;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	//이거 추가했또
	public boolean matchPassword(String password) {
		return this.password.equals(password);
	}
	
	
}
