package pojo_GetHsrpStatus;

public class GetHsrpStatus_Root_Output {

	public String message;
	public GetHsrpStatus_Data_Output data;
	public boolean success;

	public GetHsrpStatus_Root_Output() {
	}

	public GetHsrpStatus_Root_Output(String message, GetHsrpStatus_Data_Output data, boolean success) {
		this.message = message;
		this.data = data;
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public GetHsrpStatus_Data_Output getData() {
		return data;
	}

	public void setData(GetHsrpStatus_Data_Output data) {
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}
