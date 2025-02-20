package payLoads;

import pojo_GetServiceSupportDetails.GetServiceSupportDetails_Data_Input;
import pojo_GetServiceSupportDetails.GetServiceSupportDetails_Root_Input;

public class GetServiceSupportDetails_Payload {

	
	public GetServiceSupportDetails_Root_Input addDetails(String dealercode,String customerIdentifier)
	{
		GetServiceSupportDetails_Data_Input data_Input = new GetServiceSupportDetails_Data_Input(dealercode, customerIdentifier);
		GetServiceSupportDetails_Root_Input root_Input = new GetServiceSupportDetails_Root_Input(data_Input);
		return root_Input;
		
	}
}
