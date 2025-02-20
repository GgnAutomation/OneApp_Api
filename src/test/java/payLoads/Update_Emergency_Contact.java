package payLoads;

import pojo_Update_Emergency_Contact.Emergency_Input;
import pojo_Update_Emergency_Contact.Update_Emergency_Contact_Data_Input;
import pojo_Update_Emergency_Contact.Update_Emergency_Contact_Root_Input;

public class Update_Emergency_Contact {

	public Update_Emergency_Contact_Root_Input addDetails(String id, String name, String mobile, String relation,
			String customerIdentifier, String action) {

		Emergency_Input emergency = new Emergency_Input();
		emergency.id = id;
		emergency.name = name;
		emergency.mobile = mobile;
		emergency.relation = relation;

		Update_Emergency_Contact_Data_Input data = new Update_Emergency_Contact_Data_Input();
		data.customerIdentifier = customerIdentifier;
		data.emergency = emergency;
		data.action = action;

		Update_Emergency_Contact_Root_Input root = new Update_Emergency_Contact_Root_Input();
		root.data = data;
		return root;
	}
}
