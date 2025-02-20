package pojo_Check_Complaints;

public class Check_Complaint_Root_Input {

	public Check_Complaint_Data_Input data;

	public Check_Complaint_Root_Input() {

	}

	public Check_Complaint_Root_Input(Check_Complaint_Data_Input data) {
		this.data = data;
	}

	public Check_Complaint_Data_Input getData() {
		return data;
	}

	public void setData(Check_Complaint_Data_Input data) {
		this.data = data;
	}

}
