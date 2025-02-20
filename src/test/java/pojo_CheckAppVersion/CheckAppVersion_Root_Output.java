package pojo_CheckAppVersion;

public class CheckAppVersion_Root_Output {

	public boolean success;
	public String message;
	public CheckAppVersion_Data_Output data;

	public CheckAppVersion_Root_Output() {
	}

	public CheckAppVersion_Root_Output(boolean success, String message, CheckAppVersion_Data_Output data) {
		this.success = success;
		this.message = message;
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public CheckAppVersion_Data_Output getData() {
		return data;
	}

	public void setData(CheckAppVersion_Data_Output data) {
		this.data = data;
	}

}
