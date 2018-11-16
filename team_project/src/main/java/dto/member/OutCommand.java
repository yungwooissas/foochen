package dto.member;

//탈퇴를 위한 커맨드 객체
public class OutCommand {

	private String password; //최종확인용 패스워드
	private boolean outSuccess; //아이디와 패스워드 인증성공여부(성공하면 탈퇴가능)
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isOutSuccess() {
		return outSuccess;
	}
	public void setOutSuccess(boolean outSuccess) {
		this.outSuccess = outSuccess;
	}
	
}
