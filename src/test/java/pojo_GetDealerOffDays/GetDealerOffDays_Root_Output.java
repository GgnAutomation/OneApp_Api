package pojo_GetDealerOffDays;

public class GetDealerOffDays_Root_Output {

	public boolean success;
	public String message;
	public GetDealerOffDays_Data_Output data;

	public GetDealerOffDays_Root_Output() {
	}

	public GetDealerOffDays_Root_Output(boolean success, String message, GetDealerOffDays_Data_Output data) {
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

	public GetDealerOffDays_Data_Output getData() {
		return data;
	}

	public void setData(GetDealerOffDays_Data_Output data) {
		this.data = data;
	}

}
