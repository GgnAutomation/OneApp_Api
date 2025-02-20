package pojo_External_Login_Otp;

public class Verify_Otp_Tc2_Root_Output_Pojo {

	public boolean success;
	public String message;
	public Verify_Otp_Tc2_Data_Output_Pojo data;

	public Verify_Otp_Tc2_Root_Output_Pojo() {
	}

	public Verify_Otp_Tc2_Root_Output_Pojo(boolean success, String message, Verify_Otp_Tc2_Data_Output_Pojo data) {
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

	public Verify_Otp_Tc2_Data_Output_Pojo getData() {
		return data;
	}

	public void setData(Verify_Otp_Tc2_Data_Output_Pojo data) {
		this.data = data;
	}

}
