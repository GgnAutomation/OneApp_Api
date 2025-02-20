package pojoClass_ExternalLogin;

public class Root_ExternalLogin_Output_Pojo {

	public boolean success;
	public String message;
	public Data_ExternalLogin_Output_Pojo data;

	public Root_ExternalLogin_Output_Pojo() {
	}

	public Root_ExternalLogin_Output_Pojo(boolean success, String message, Data_ExternalLogin_Output_Pojo data) {
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

	public Data_ExternalLogin_Output_Pojo getData() {
		return data;
	}

	public void setData(Data_ExternalLogin_Output_Pojo data) {
		this.data = data;
	}

}
