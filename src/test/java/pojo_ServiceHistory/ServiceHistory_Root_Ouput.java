package pojo_ServiceHistory;

public class ServiceHistory_Root_Ouput {

	public boolean success;
	public String message;
	public ServiceHistory_Data_Ouput data;

	public ServiceHistory_Root_Ouput() {
	}

	public ServiceHistory_Root_Ouput(boolean success, String message, ServiceHistory_Data_Ouput data) {
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

	public ServiceHistory_Data_Ouput getData() {
		return data;
	}

	public void setData(ServiceHistory_Data_Ouput data) {
		this.data = data;
	}

}
