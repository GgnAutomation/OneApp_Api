package payLoads;

import pojo_Search_Vehicle_Details_List.Search_Vehicle_Details_List_Data_Input;
import pojo_Search_Vehicle_Details_List.Search_Vehicle_Details_List_Root_Input;

public class Search_Vehicle_Details_List_Payload {

	public Search_Vehicle_Details_List_Root_Input addDetails(String loginId, String loginType,
			String notificationType) {

		Search_Vehicle_Details_List_Data_Input data_Input = new Search_Vehicle_Details_List_Data_Input(loginId,
				loginType, notificationType);
		Search_Vehicle_Details_List_Root_Input root_Input = new Search_Vehicle_Details_List_Root_Input(data_Input);
		return root_Input;
	}

}
