package payLoads;

import pojo_SOS.SOS_Data1_Input;
import pojo_SOS.SOS_Data_Input;
import pojo_SOS.SOS_Root1_Input;
import pojo_SOS.SOS_Root_Input;

public class SOS_Payload {

	public SOS_Root_Input addDetails(String customerIdentifier, String userLocation) {

		SOS_Data_Input data_Input = new SOS_Data_Input(customerIdentifier, userLocation);
		SOS_Root_Input root_Input = new SOS_Root_Input(data_Input);
		return root_Input;
	}

	public SOS_Root1_Input addDetails1(String customerIdentifier, String userLocation, String vinId,
			String vehicleSosType) {

		SOS_Data1_Input data_Input = new SOS_Data1_Input(customerIdentifier, userLocation, vinId, vehicleSosType);
		SOS_Root1_Input root_Input = new SOS_Root1_Input(data_Input);
		return root_Input;
	}

}
