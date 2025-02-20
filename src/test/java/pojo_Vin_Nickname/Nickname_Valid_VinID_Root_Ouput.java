package pojo_Vin_Nickname;

public class Nickname_Valid_VinID_Root_Ouput {
	public boolean success;
	public String message;
	public Nickname_Valid_VinID_Data_Ouput data;

	public Nickname_Valid_VinID_Root_Ouput() {
	}

	public Nickname_Valid_VinID_Root_Ouput(boolean success, String message, Nickname_Valid_VinID_Data_Ouput data) {
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

	public Nickname_Valid_VinID_Data_Ouput getData() {
		return data;
	}

	public void setData(Nickname_Valid_VinID_Data_Ouput data) {
		this.data = data;
	}

}
