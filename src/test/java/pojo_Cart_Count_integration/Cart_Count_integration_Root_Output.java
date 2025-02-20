package pojo_Cart_Count_integration;

public class Cart_Count_integration_Root_Output {

	public String message;
	public String data;
	public boolean success;

	public Cart_Count_integration_Root_Output() {
	}

	public Cart_Count_integration_Root_Output(String message, String data, boolean success) {
		this.message = message;
		this.data = data;
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}
