package pojo_Get_External_Cust_Details;

public class Invalid_Customer_Identifier_Root_Output {

	public String message;
	public boolean success;
	public int errorCode;

	public Invalid_Customer_Identifier_Root_Output() {
	}

	public Invalid_Customer_Identifier_Root_Output(String message, boolean success, int errorCode) {
		this.message = message;
		this.success = success;
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
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

}
