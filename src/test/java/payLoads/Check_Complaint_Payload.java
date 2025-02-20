package payLoads;

import pojo_Check_Complaints.Check_Complaint_Data_Input;
import pojo_Check_Complaints.Check_Complaint_Root_Input;

public class Check_Complaint_Payload {

	public Check_Complaint_Root_Input addDetails(String VinNo) {
		Check_Complaint_Data_Input data_Input = new Check_Complaint_Data_Input(VinNo);
		Check_Complaint_Root_Input root_Input = new Check_Complaint_Root_Input(data_Input);
		return root_Input;
	}
}
