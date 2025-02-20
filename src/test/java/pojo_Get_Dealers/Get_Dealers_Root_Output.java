package pojo_Get_Dealers;

public class Get_Dealers_Root_Output {

	public boolean success;
	public String message;
	public Get_Dealers_Data_Output data;

	public Get_Dealers_Root_Output() {
	}

	public Get_Dealers_Root_Output(boolean success, String message, Get_Dealers_Data_Output data) {
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

	public Get_Dealers_Data_Output getData() {
		return data;
	}

	public void setData(Get_Dealers_Data_Output data) {
		this.data = data;
	}

}
