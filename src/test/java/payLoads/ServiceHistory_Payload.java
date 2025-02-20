package payLoads;

import pojo_ServiceHistory.ServiceHistory_Data_Input;
import pojo_ServiceHistory.ServiceHistory_Root_Input;

public class ServiceHistory_Payload {

	public ServiceHistory_Root_Input addDetails(String customerIdentifier, String vin, String rowNum) {

		ServiceHistory_Data_Input input = new ServiceHistory_Data_Input(customerIdentifier, vin, rowNum);
		ServiceHistory_Root_Input root_Input = new ServiceHistory_Root_Input(input);
		return root_Input;

	}
}
