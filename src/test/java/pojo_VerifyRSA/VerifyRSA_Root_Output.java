package pojo_VerifyRSA;

public class VerifyRSA_Root_Output {

	public String message;
	public VerifyRSA_Data_Output data;
	public boolean success;

	public VerifyRSA_Root_Output() {
	}

	public VerifyRSA_Root_Output(String message, VerifyRSA_Data_Output data, boolean success) {
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

	public VerifyRSA_Data_Output getData() {
		return data;
	}

	public void setData(VerifyRSA_Data_Output data) {
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}
