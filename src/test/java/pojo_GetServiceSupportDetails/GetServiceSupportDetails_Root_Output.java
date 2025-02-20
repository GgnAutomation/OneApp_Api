package pojo_GetServiceSupportDetails;

public class GetServiceSupportDetails_Root_Output {

	public boolean success;
	public String message;
	public GetServiceSupportDetails_Data_Output data;

	public GetServiceSupportDetails_Root_Output() {
	}

	public GetServiceSupportDetails_Root_Output(boolean success, String message,
			GetServiceSupportDetails_Data_Output data) {
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

	public GetServiceSupportDetails_Data_Output getData() {
		return data;
	}

	public void setData(GetServiceSupportDetails_Data_Output data) {
		this.data = data;
	}

}
