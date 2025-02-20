package payLoads;

import pojo_Cart_Count_integration.Cart_Count_integration_Data_Input;
import pojo_Cart_Count_integration.Cart_Count_integration_Root_Input;

public class Cart_Count_integration_Payload {

	public Cart_Count_integration_Root_Input addDetails(String mobileNumber) {
		Cart_Count_integration_Data_Input data_Input = new Cart_Count_integration_Data_Input(mobileNumber);
		Cart_Count_integration_Root_Input root_Input = new Cart_Count_integration_Root_Input(data_Input);
		return root_Input;
	}

}
