package payLoads;

import pojo_GetDealerOffDays.GetDealerOffDays_Data_Input;
import pojo_GetDealerOffDays.GetDealerOffDays_Root_Input;

public class GetDealerOffDays_Payload {

	public GetDealerOffDays_Root_Input addDetails(String customerIdentifier, String divisionName) {
		GetDealerOffDays_Data_Input data_Input = new GetDealerOffDays_Data_Input(customerIdentifier, divisionName);
		GetDealerOffDays_Root_Input root_Input = new GetDealerOffDays_Root_Input(data_Input);
		return root_Input;

	}
}
