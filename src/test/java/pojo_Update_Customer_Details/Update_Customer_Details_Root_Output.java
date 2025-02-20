package pojo_Update_Customer_Details;

public class Update_Customer_Details_Root_Output {
	public boolean success;
	public String message;
	public Update_Customer_Details_Data_Output data;

	public Update_Customer_Details_Root_Output() {
	}

	public Update_Customer_Details_Root_Output(boolean success, String message,
			Update_Customer_Details_Data_Output data) {
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

	public Update_Customer_Details_Data_Output getData() {
		return data;
	}

	public void setData(Update_Customer_Details_Data_Output data) {
		this.data = data;
	}

}
