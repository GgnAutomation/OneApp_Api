package pojoClass_ExternalLogin;

public class Data_External_Login_Input_Pojo {

	public String loginId;
	public String loginType;
	public String notificationType;

	public Data_External_Login_Input_Pojo() {
	}

	public Data_External_Login_Input_Pojo(String loginId, String loginType, String notificationType) {
		this.loginId = loginId;
		this.loginType = loginType;
		this.notificationType = notificationType;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	public String getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(String notificationType) {
		this.notificationType = notificationType;
	}
}
