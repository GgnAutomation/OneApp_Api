package payLoads;

import pojo_Update_Customer_Details.Update_Customer_Details_Data_Input;
import pojo_Update_Customer_Details.Update_Customer_Details_Root_Input;

public class Update_Customer_Details_Payload {

	public Update_Customer_Details_Root_Input addDetails(String customerIdentifier, String birthDate, String firstName,
			String lastName, String gender, String email, String bloodGroup, String addressLine1, String city,
			String state, String pincode, int isExisting) {

		Update_Customer_Details_Data_Input input = new Update_Customer_Details_Data_Input(customerIdentifier, birthDate,
				firstName, lastName, gender, email, bloodGroup, addressLine1, city, state, pincode, isExisting);
		Update_Customer_Details_Root_Input root_Input = new Update_Customer_Details_Root_Input(input);
		return root_Input;
	}

}
