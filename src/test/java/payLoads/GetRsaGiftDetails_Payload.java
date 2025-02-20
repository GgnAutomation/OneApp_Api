package payLoads;

import pojo_GetRsaGiftDetails.GetRsaGiftDetails_Data_Input;
import pojo_GetRsaGiftDetails.GetRsaGiftDetails_Root_Input;

public class GetRsaGiftDetails_Payload {

	public GetRsaGiftDetails_Root_Input addDetails(String loginId, String vinNo) {
		GetRsaGiftDetails_Data_Input data_Input = new GetRsaGiftDetails_Data_Input(loginId, vinNo);
		GetRsaGiftDetails_Root_Input root_Input = new GetRsaGiftDetails_Root_Input(data_Input);
		return root_Input;
	}
}
