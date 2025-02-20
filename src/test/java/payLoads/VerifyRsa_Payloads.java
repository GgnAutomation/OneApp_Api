package payLoads;

import pojo_VerifyRSA.VerifyRSA_Data_Input;
import pojo_VerifyRSA.VerifyRSA_Root_Input;

public class VerifyRsa_Payloads {

	public VerifyRSA_Root_Input addDetails(String mobileNo, String vinNo) {

		VerifyRSA_Data_Input data_Input = new VerifyRSA_Data_Input(mobileNo, vinNo);
		VerifyRSA_Root_Input root_Input = new VerifyRSA_Root_Input(data_Input);
		return root_Input;
	}
}
