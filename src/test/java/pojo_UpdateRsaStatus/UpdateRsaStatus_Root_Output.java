package pojo_UpdateRsaStatus;

public class UpdateRsaStatus_Root_Output {

	public boolean success;
	public String message;
	public UpdateRsaStatus_Data_Output data;

	public UpdateRsaStatus_Root_Output() {
	}

	public UpdateRsaStatus_Root_Output(boolean success, String message, UpdateRsaStatus_Data_Output data) {
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

	public UpdateRsaStatus_Data_Output getData() {
		return data;
	}

	public void setData(UpdateRsaStatus_Data_Output data) {
		this.data = data;
	}

}
