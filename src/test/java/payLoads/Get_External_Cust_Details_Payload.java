package payLoads;


import pojo_Get_External_Cust_Details.Get_External_Cust_Details_Data_Input;
import pojo_Get_External_Cust_Details.Get_External_Cust_Details_Root_Input;

public class Get_External_Cust_Details_Payload {

	public Get_External_Cust_Details_Root_Input addDetails(String customerIdentifier) {

		Get_External_Cust_Details_Data_Input data_Input = new Get_External_Cust_Details_Data_Input(customerIdentifier);
		Get_External_Cust_Details_Root_Input root_Input = new Get_External_Cust_Details_Root_Input(data_Input);
		return root_Input;
		
	}

}
