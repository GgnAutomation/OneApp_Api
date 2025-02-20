package pojo_External_Login_Otp;

public class Verify_Otp_Tc2_Data_Input_Pojo {

	public String loginId;
	public String otp;
	public String isdCode;
	public String deviceType;
	public String osVersion;
	public String appVersion;
	public String deviceModel;
	public String firebaseToken;

	public Verify_Otp_Tc2_Data_Input_Pojo() {

	}

	public Verify_Otp_Tc2_Data_Input_Pojo(String loginId, String otp, String isdCode, String deviceType,
			String osVersion, String appVersion, String deviceModel, String firebaseToken) {

		this.loginId = loginId;
		this.otp = otp;
		this.isdCode = isdCode;
		this.deviceType = deviceType;
		this.osVersion = osVersion;
		this.appVersion = appVersion;
		this.deviceModel = deviceModel;
		this.firebaseToken = firebaseToken;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getIsdCode() {
		return isdCode;
	}

	public void setIsdCode(String isdCode) {
		this.isdCode = isdCode;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public String getDeviceModel() {
		return deviceModel;
	}

	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}

	public String getFirebaseToken() {
		return firebaseToken;
	}

	public void setFirebaseToken(String firebaseToken) {
		this.firebaseToken = firebaseToken;
	}

}
