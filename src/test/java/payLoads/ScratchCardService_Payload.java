package payLoads;

import pojo_ScratchCardService.ScratchCardService_Data_Input;
import pojo_ScratchCardService.ScratchCardService_Root_Input;

public class ScratchCardService_Payload {

	public ScratchCardService_Root_Input addDetails(String mobileNo, String vinId, String scratchCardType) {

		ScratchCardService_Data_Input data_Input = new ScratchCardService_Data_Input(mobileNo, vinId, scratchCardType);
		ScratchCardService_Root_Input root_Input = new ScratchCardService_Root_Input(data_Input);
		return root_Input;
	}

}
