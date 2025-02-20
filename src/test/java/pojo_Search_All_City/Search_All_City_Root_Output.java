package pojo_Search_All_City;

public class Search_All_City_Root_Output {
	public boolean success;
	public String message;
	public Search_All_City_Data_Output data;

	public Search_All_City_Root_Output() {
	}

	public Search_All_City_Root_Output(boolean success, String message, Search_All_City_Data_Output data) {
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

	public Search_All_City_Data_Output getData() {
		return data;
	}

	public void setData(Search_All_City_Data_Output data) {
		this.data = data;
	}

}
