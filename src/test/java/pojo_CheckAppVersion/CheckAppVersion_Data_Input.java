package pojo_CheckAppVersion;

public class CheckAppVersion_Data_Input {
	public String deviceType;
	public String userAppVersion;

	public CheckAppVersion_Data_Input() {
	}

	public CheckAppVersion_Data_Input(String deviceType, String userAppVersion) {
		this.deviceType = deviceType;
		this.userAppVersion = userAppVersion;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getUserAppVersion() {
		return userAppVersion;
	}

	public void setUserAppVersion(String userAppVersion) {
		this.userAppVersion = userAppVersion;
	}

}
