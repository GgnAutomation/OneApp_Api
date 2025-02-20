package payLoads;

import pojo_Get_Dealers.Get_Dealers_Data_Input;
import pojo_Get_Dealers.Get_Dealers_Root_Input;

public class Get_Dealers_Payloads {

	public Get_Dealers_Root_Input addDetails(String customerIdentifier, String city, String state) {
		Get_Dealers_Data_Input data_Input = new Get_Dealers_Data_Input(customerIdentifier, city, state);
		Get_Dealers_Root_Input root_Input = new Get_Dealers_Root_Input(data_Input);
		return root_Input;
	}

}
