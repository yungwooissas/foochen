package dto.member;

public class ChangePassword {
	private String email;
	private String nowPassword;
	private String newPassword;
	private String newPasswordConfirm;
	
	public ChangePassword() {}
	
	public ChangePassword(String email,String nowPassword, String newPassword, String newPasswordConfirm) {
		this.email = email;
		this.nowPassword = nowPassword;
		this.newPassword = newPassword;
		this.newPasswordConfirm = newPasswordConfirm;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNowPassword() {
		return nowPassword;
	}
	public void setNowPassword(String nowPassword) {
		this.nowPassword = nowPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getNewPasswordConfirm() {
		return newPasswordConfirm;
	}
	public void setNewPasswordConfirm(String newPasswordConfirm) {
		this.newPasswordConfirm = newPasswordConfirm;
	}
	
	public boolean matchPassword(String tmppassword) {
		if(this.nowPassword.equals(tmppassword)) {
			return false;
		}
		return true;
	}
	
	public boolean confirmPassword() {
		if(newPassword.equals(newPasswordConfirm)) {
			return false;
		}
		return true;
	}
}
