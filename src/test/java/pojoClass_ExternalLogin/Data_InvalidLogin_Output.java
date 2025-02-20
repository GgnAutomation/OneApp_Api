package pojoClass_ExternalLogin;

public class Data_InvalidLogin_Output {

	public boolean success;
	public int errorCode;
	public String errorDescription;
	public String message;

	public Data_InvalidLogin_Output() {
	}

	public Data_InvalidLogin_Output(boolean success, int errorCode, String errorDescription, String message) {
		this.success = success;
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
