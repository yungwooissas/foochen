package dto.member;

//세션에 보관할 로그인 된 상태 클래스
//정보가 이메일이랑 이름 두개면 될까?
public class UserInfo {

	private String email;
	private String name;
	
	public UserInfo(String email, String name) {
		this.email = email;
		this.name = name;
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
	
}
