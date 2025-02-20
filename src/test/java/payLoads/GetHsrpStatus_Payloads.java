package payLoads;

import pojo_GetHsrpStatus.GetHsrpStatus_Data_Input;
import pojo_GetHsrpStatus.GetHsrpStatus_Root_Input;

public class GetHsrpStatus_Payloads {

	public GetHsrpStatus_Root_Input addDetails(String mobileNo, String vinNo) {

		GetHsrpStatus_Data_Input data_Input = new GetHsrpStatus_Data_Input(mobileNo, vinNo);
		GetHsrpStatus_Root_Input root_Input = new GetHsrpStatus_Root_Input(data_Input);
		return root_Input;
	}
}
