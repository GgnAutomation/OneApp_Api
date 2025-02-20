package payLoads;

import pojo_CheckAppVersion.CheckAppVersion_Data_Input;
import pojo_CheckAppVersion.CheckAppVersion_Root_Input;

public class CheckAppVersion_Payloads {

	public CheckAppVersion_Root_Input addDetails(String deviceType, String userAppVersion) {

		CheckAppVersion_Data_Input data_Input = new CheckAppVersion_Data_Input(deviceType, userAppVersion);
		CheckAppVersion_Root_Input root_Input = new CheckAppVersion_Root_Input(data_Input);
		return root_Input;
	}

}
