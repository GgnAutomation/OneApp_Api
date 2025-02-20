package payLoads;

import pojo_Search_By_Region.Search_By_Region_Data_Input;
import pojo_Search_By_Region.Search_By_Region_Root_Input;

public class SearchByRegion_Payload {

	public Search_By_Region_Root_Input addDetails(String customerIdentifier, String searchBy, String value) {
		Search_By_Region_Data_Input input = new Search_By_Region_Data_Input(customerIdentifier, searchBy, value);
		Search_By_Region_Root_Input root_Input = new Search_By_Region_Root_Input(input);
		return root_Input;
	}
}
