package payLoads;

import pojo_GetServiceDetail.GetServiceDetail_Data_Input;
import pojo_GetServiceDetail.GetServiceDetail_Root_Input;

public class GetServiceDetail_Payload {

	public GetServiceDetail_Root_Input addDetails(String mobileNo,String vinNo,String customerIdentifier) {
		
		GetServiceDetail_Data_Input data_Input = new  GetServiceDetail_Data_Input(mobileNo, vinNo, customerIdentifier);
		GetServiceDetail_Root_Input root_Input = new GetServiceDetail_Root_Input(data_Input);
		return root_Input;
	}
}
