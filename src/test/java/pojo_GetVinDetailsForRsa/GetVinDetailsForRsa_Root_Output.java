package pojo_GetVinDetailsForRsa;

public class GetVinDetailsForRsa_Root_Output {
	public boolean success;
	public String message;
	public GetVinDetailsForRsa_Data_Output data;

	public GetVinDetailsForRsa_Root_Output() {

	}

	public GetVinDetailsForRsa_Root_Output(boolean success, String message, GetVinDetailsForRsa_Data_Output data) {
		super();
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

	public GetVinDetailsForRsa_Data_Output getData() {
		return data;
	}

	public void setData(GetVinDetailsForRsa_Data_Output data) {
		this.data = data;
	}

}
