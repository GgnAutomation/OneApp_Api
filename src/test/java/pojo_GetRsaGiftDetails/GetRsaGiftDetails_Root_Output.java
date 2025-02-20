package pojo_GetRsaGiftDetails;

public class GetRsaGiftDetails_Root_Output {
	public boolean success;
	public String message;
	public GetRsaGiftDetails_Data_Output data;

	public GetRsaGiftDetails_Root_Output() {
	}

	public GetRsaGiftDetails_Root_Output(boolean success, String message, GetRsaGiftDetails_Data_Output data) {
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

	public GetRsaGiftDetails_Data_Output getData() {
		return data;
	}

	public void setData(GetRsaGiftDetails_Data_Output data) {
		this.data = data;
	}

}
