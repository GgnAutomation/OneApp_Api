package pojo_Check_Complaints;

public class Check_Complaint_Root_Output {

	public boolean success;
	public String message;
	public Object data;
	public String statusCode;

	public Check_Complaint_Root_Output() {
	}

	public Check_Complaint_Root_Output(boolean success, String message, Object data, String statusCode) {
		this.success = success;
		this.message = message;
		this.data = data;
		this.statusCode = statusCode;
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

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

}
