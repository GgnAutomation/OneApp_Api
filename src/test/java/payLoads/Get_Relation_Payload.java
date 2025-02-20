package payLoads;

import pojo_Get_Relation.Valid_CustomerIdentifier_Root_Input;
import pojo_Get_Relation.Valid_Customer_identifier_Data_Input;

public class Get_Relation_Payload {

	public Valid_CustomerIdentifier_Root_Input addDetails(String customerIdentifier) {

		Valid_Customer_identifier_Data_Input data_Input = new Valid_Customer_identifier_Data_Input(customerIdentifier);
		Valid_CustomerIdentifier_Root_Input root_Input = new Valid_CustomerIdentifier_Root_Input(data_Input);
		return root_Input;

	}

}
