package pojo_GetVinDetailsForRsa;

public class GetVinDetailsForRsa_InvalidKey {

	public int statusCode;
	public String message;

	public GetVinDetailsForRsa_InvalidKey() {
	}

	public GetVinDetailsForRsa_InvalidKey(int statusCode, String message) {
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
