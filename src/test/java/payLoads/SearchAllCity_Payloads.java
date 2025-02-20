package payLoads;

import pojo_Search_All_City.Search_All_City_Data_Input;
import pojo_Search_All_City.Search_All_City_Root_Input;

public class SearchAllCity_Payloads {

	public Search_All_City_Root_Input addDetails(String searchBy, String value) {

		Search_All_City_Data_Input data_Input = new Search_All_City_Data_Input(searchBy, value);
		Search_All_City_Root_Input root_Input = new Search_All_City_Root_Input(data_Input);
		return root_Input;
	}
}
