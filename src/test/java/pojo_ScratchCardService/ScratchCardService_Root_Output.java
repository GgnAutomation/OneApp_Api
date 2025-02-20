package pojo_ScratchCardService;

public class ScratchCardService_Root_Output {

	public String message;
	public ScratchCardService_Data_Output data;
	public boolean success;

	public ScratchCardService_Root_Output() {
	}

	public ScratchCardService_Root_Output(String message, ScratchCardService_Data_Output data, boolean success) {
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

	public ScratchCardService_Data_Output getData() {
		return data;
	}

	public void setData(ScratchCardService_Data_Output data) {
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}
