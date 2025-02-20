package pojo_Get_External_Cust_Details;

public class In_Valid_Customer_Identifer_Root_Output {

	public boolean success;
	public String message;
	public int errorCode;
	public String errorDescription;

	public In_Valid_Customer_Identifer_Root_Output() {
	}

	public In_Valid_Customer_Identifer_Root_Output(boolean success, String message, int errorCode,
			String errorDescription) {
		this.success = success;
		this.message = message;
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
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

}
