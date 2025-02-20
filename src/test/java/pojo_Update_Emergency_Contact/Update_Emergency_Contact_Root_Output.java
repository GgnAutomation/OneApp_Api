package pojo_Update_Emergency_Contact;

public class Update_Emergency_Contact_Root_Output {
	public boolean success;
	public String message;
	public Update_Emergency_Contact_Data_Output data;

	public Update_Emergency_Contact_Root_Output() {
	}

	public Update_Emergency_Contact_Root_Output(boolean success, String message,
			Update_Emergency_Contact_Data_Output data) {
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

	public Update_Emergency_Contact_Data_Output getData() {
		return data;
	}

	public void setData(Update_Emergency_Contact_Data_Output data) {
		this.data = data;
	}

}
