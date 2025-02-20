package payLoads;

import pojo_GetSrId.GetSrId_Data_Input;
import pojo_GetSrId.GetSrId_Root_Input;


public class Get_srId_Payload {

	public GetSrId_Root_Input addDetails(String custIdentifier, String srNo) {

		GetSrId_Data_Input data_Input = new GetSrId_Data_Input(custIdentifier, srNo);
		GetSrId_Root_Input root_Input = new GetSrId_Root_Input(data_Input);
		return root_Input;
	}

}
