package pojo_GetServiceDetail;

public class GetServiceDetail_Root_Output {

	public boolean success;
	public String message;
	public GetServiceDetail_Data_Output data;

	public GetServiceDetail_Root_Output() {
	}

	public GetServiceDetail_Root_Output(boolean success, String message, GetServiceDetail_Data_Output data) {
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

	public GetServiceDetail_Data_Output getData() {
		return data;
	}

	public void setData(GetServiceDetail_Data_Output data) {
		this.data = data;
	}

}
