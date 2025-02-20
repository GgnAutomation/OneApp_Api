package pojo_SOS;

public class SOS_Root_Output {
	public boolean success;
	public String message;
	public SOS_Data_Output data;

	public SOS_Root_Output() {
	}

	public SOS_Root_Output(boolean success, String message, SOS_Data_Output data) {
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

	public SOS_Data_Output getData() {
		return data;
	}

	public void setData(SOS_Data_Output data) {
		this.data = data;
	}
}
