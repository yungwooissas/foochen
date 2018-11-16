package dto.member;

//회원가입 요청에 따라 필요한 데이터를 담는 클래스 
public class RegisterRequest {
	private String email;
	private String password;
	private String confirmPassword;
	private String name;
	private String phone;
	private int gender;
	private String birth;
	private String like1;
	private String like2;
	private String like3;
	
	public boolean isPasswordEqualToConfirmPassword() {
		return password.equals(confirmPassword);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
}
