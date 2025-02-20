package pojo_GetJoyRideDetails;

public class GetJoyRideDetails_Root_Output {
	public String message;
	public GetJoyRideDetails_Data_Output data;
	public boolean success;

	public GetJoyRideDetails_Root_Output() {
	}

	public GetJoyRideDetails_Root_Output(String message, GetJoyRideDetails_Data_Output data, boolean success) {
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

	public GetJoyRideDetails_Data_Output getData() {
		return data;
	}

	public void setData(GetJoyRideDetails_Data_Output data) {
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}
