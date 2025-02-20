package pojo_Update_Active_Warranty;

public class Update_Active_Warranty_Root_Ouput {

	public boolean success;
	public String message;
	public Update_Active_Warranty_Data_Ouput data;

	public Update_Active_Warranty_Root_Ouput() {
	}

	public Update_Active_Warranty_Root_Ouput(boolean success, String message, Update_Active_Warranty_Data_Ouput data) {
		super();
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

	public Update_Active_Warranty_Data_Ouput getData() {
		return data;
	}

	public void setData(Update_Active_Warranty_Data_Ouput data) {
		this.data = data;
	}

}
