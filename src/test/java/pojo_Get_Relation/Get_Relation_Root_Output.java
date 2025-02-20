package pojo_Get_Relation;

public class Get_Relation_Root_Output {
	public boolean success;
	public String message;
	public Get_Relation_Data_Output data;

	public Get_Relation_Root_Output() {
	}

	public Get_Relation_Root_Output(boolean success, String message, Get_Relation_Data_Output data) {
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

	public Get_Relation_Data_Output getData() {
		return data;
	}

	public void setData(Get_Relation_Data_Output data) {
		this.data = data;
	}

}
