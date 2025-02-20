package payLoads;

import pojo_UpdateVehicleDetails.UpdateVehicleDetails_Data_Input;
import pojo_UpdateVehicleDetails.UpdateVehicleDetails_Root_Input;

public class UpdateVehicleDetails_Payload {

	public UpdateVehicleDetails_Root_Input addDetails(String vinId, String customerIdentifier, String fitmentStatus) {

		UpdateVehicleDetails_Data_Input data_Input = new UpdateVehicleDetails_Data_Input(vinId, customerIdentifier,
				fitmentStatus);
		UpdateVehicleDetails_Root_Input root_Input = new UpdateVehicleDetails_Root_Input(data_Input);
		return root_Input;
	}
}
