package pojo_External_Login_Otp;

public class Invalid_url_Root_Output_Pojo {
	public int statusCode;
	public String message;

	public Invalid_url_Root_Output_Pojo() {

	}

	public Invalid_url_Root_Output_Pojo(int statusCode, String message) {

		this.statusCode = statusCode;
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
