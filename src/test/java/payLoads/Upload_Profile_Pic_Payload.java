package payLoads;

import pojo_Upload_Profile_Pic.Upload_Profile_Pic_Data_Input;
import pojo_Upload_Profile_Pic.Upload_Profile_Pic_Root_Input;

public class Upload_Profile_Pic_Payload {

	public Upload_Profile_Pic_Root_Input addDetails(String base64Data, String extension, String customerID,
			String vinID, String documentIdentifier, String category, String subCategory, String emergencyId) {

		Upload_Profile_Pic_Data_Input data_Input = new Upload_Profile_Pic_Data_Input(base64Data, extension, customerID,
				vinID, documentIdentifier, category, subCategory, emergencyId);
		Upload_Profile_Pic_Root_Input root_Input = new Upload_Profile_Pic_Root_Input(data_Input);
		return root_Input;

	}
}
