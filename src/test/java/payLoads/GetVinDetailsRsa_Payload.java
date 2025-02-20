package payLoads;

import pojo_GetVinDetailsForRsa.GetVinDetailsForRsa_Data_Input;
import pojo_GetVinDetailsForRsa.GetVinDetailsForRsa_Root_Input;

public class GetVinDetailsRsa_Payload {

	public GetVinDetailsForRsa_Root_Input addDetails(String loginId, String searchType, String value) {

		GetVinDetailsForRsa_Data_Input input = new GetVinDetailsForRsa_Data_Input(loginId, searchType, value);
		GetVinDetailsForRsa_Root_Input root_Input = new GetVinDetailsForRsa_Root_Input(input);
		return root_Input;
	}
}
