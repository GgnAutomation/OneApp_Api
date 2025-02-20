package payLoads;

import pojo_Get_Sr_Details.Get_Sr_Details_Data_Input;
import pojo_Get_Sr_Details.Get_Sr_Details_Root_Input;

public class Get_Sr_Details_Payload {

	public Get_Sr_Details_Root_Input addDetails(String customerIdentifier, String vinNo, String srNo) {

		Get_Sr_Details_Data_Input data_Input = new Get_Sr_Details_Data_Input(customerIdentifier, vinNo, srNo);
		Get_Sr_Details_Root_Input root_Input = new Get_Sr_Details_Root_Input(data_Input);
		return root_Input;
	}

}
