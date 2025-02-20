package pojoClass_ExternalLogin;

public class Data_ExternalLogin_Output_Pojo {

	public String loginId;
	public boolean registeredUser;

	public Data_ExternalLogin_Output_Pojo() {
	}

	public Data_ExternalLogin_Output_Pojo(String loginId, boolean registeredUser) {
		this.loginId = loginId;
		this.registeredUser = registeredUser;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public boolean isRegisteredUser() {
		return registeredUser;
	}

	public void setRegisteredUser(boolean registeredUser) {
		this.registeredUser = registeredUser;
	}
}
