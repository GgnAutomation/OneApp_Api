package pojo_External_Login_Otp;

public class Verify_InvalidOtp_Root_Output_Pojo {

	public boolean success;
	public String message;
	public int errorCode;
	public String errorDescription;

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

	public Verify_InvalidOtp_Root_Output_Pojo() {

	}

	public Verify_InvalidOtp_Root_Output_Pojo(boolean success, String message, int errorCode, String errorDescription) {

		this.success = success;
		this.message = message;
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
	}

}
