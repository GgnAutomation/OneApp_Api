package pojo_Get_External_Cust_Details;

public class Get_External_Customer_Detail_Root_Ouput {

	public boolean success;
	public String message;
	public Get_External_Customer_Detail_Data_Ouput data;

	public Get_External_Customer_Detail_Root_Ouput() {
	}

	public Get_External_Customer_Detail_Root_Ouput(boolean success, String message,
			Get_External_Customer_Detail_Data_Ouput data) {
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

	public Get_External_Customer_Detail_Data_Ouput getData() {
		return data;
	}

	public void setData(Get_External_Customer_Detail_Data_Ouput data) {
		this.data = data;
	}

}
