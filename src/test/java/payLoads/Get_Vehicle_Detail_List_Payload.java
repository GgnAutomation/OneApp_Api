package payLoads;

import pojo_Class_GetVehicle_List.Valid_CustomerIdentifier_Root_Input;
import pojo_Class_GetVehicle_List.valid_Customer_identifier_Data_Input;

public class Get_Vehicle_Detail_List_Payload {

	public Valid_CustomerIdentifier_Root_Input addDetails(String customerIdentifier) {

		valid_Customer_identifier_Data_Input customer_identifier_Data_Input = new valid_Customer_identifier_Data_Input(
				customerIdentifier);
		Valid_CustomerIdentifier_Root_Input customerIdentifier_Root_Input = new Valid_CustomerIdentifier_Root_Input(
				customer_identifier_Data_Input);

		return customerIdentifier_Root_Input;

	}

}
