package payLoads;

import pojo_Update_Active_Warranty.Update_Active_Warranty_Data_Input;
import pojo_Update_Active_Warranty.Update_Active_Warranty_Root_Input;

public class Is_Warranty_Payload {

	public Update_Active_Warranty_Root_Input addDetails(String vinId, String customerIdentifier,
			String isWarrantyActive) {

		Update_Active_Warranty_Data_Input input1 = new Update_Active_Warranty_Data_Input(vinId, customerIdentifier,
				isWarrantyActive);
		Update_Active_Warranty_Root_Input input2 = new Update_Active_Warranty_Root_Input(input1);
		return input2;
	}

}
