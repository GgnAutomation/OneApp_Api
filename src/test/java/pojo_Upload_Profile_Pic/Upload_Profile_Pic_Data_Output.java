package pojo_Upload_Profile_Pic;

public class Upload_Profile_Pic_Data_Output {

	public String filePath;
	public String status;
	public String message;

	public Upload_Profile_Pic_Data_Output() {
		super();
	}

	public Upload_Profile_Pic_Data_Output(String filePath, String status, String message) {
		super();
		this.filePath = filePath;
		this.status = status;
		this.message = message;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
