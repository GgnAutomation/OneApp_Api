package pojo_Class_GetVehicle_List;

public class Valid_Customer_Identifier_Root_Output {

	public boolean success;
	public String message;
	public Valid_Customer_Identifier_Data_Output data;

	public Valid_Customer_Identifier_Root_Output() {
	}

	public Valid_Customer_Identifier_Root_Output(boolean success, String message,
			Valid_Customer_Identifier_Data_Output data) {
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

	public Valid_Customer_Identifier_Data_Output getData() {
		return data;
	}

	public void setData(Valid_Customer_Identifier_Data_Output data) {
		this.data = data;
	}

}
