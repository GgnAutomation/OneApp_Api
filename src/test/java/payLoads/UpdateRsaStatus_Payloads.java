package payLoads;

import pojo_UpdateRsaStatus.UpdateRsaStatus_Data_Input;
import pojo_UpdateRsaStatus.UpdateRsaStatus_Root_Input;

public class UpdateRsaStatus_Payloads {

	public UpdateRsaStatus_Root_Input addDetails(String loginId, String vinNo, String programStatus,
			String giftCardStatus, String giftCardMessage, String giftCardImage) {

		UpdateRsaStatus_Data_Input input = new UpdateRsaStatus_Data_Input(loginId, vinNo, programStatus, giftCardStatus,
				giftCardMessage, giftCardImage);
		UpdateRsaStatus_Root_Input root_Input = new UpdateRsaStatus_Root_Input(input);
		return root_Input;

	}
}
