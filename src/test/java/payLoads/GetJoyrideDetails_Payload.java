package payLoads;

import pojo_GetJoyRideDetails.GetJoyRideDetails_Data_Input;
import pojo_GetJoyRideDetails.GetJoyRideDetails_Root_Input;

public class GetJoyrideDetails_Payload {

	public GetJoyRideDetails_Root_Input addDetails(String vinNo) {

		GetJoyRideDetails_Data_Input data_Input = new GetJoyRideDetails_Data_Input(vinNo);
		GetJoyRideDetails_Root_Input root_Input = new GetJoyRideDetails_Root_Input(data_Input);
		return root_Input;
	}
}
