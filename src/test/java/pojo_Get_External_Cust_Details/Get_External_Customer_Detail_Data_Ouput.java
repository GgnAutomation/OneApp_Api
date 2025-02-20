package pojo_Get_External_Cust_Details;

import java.util.ArrayList;

public class Get_External_Customer_Detail_Data_Ouput {

	public String customerIdentifier;
	public String customerIdAppId;
	public Profile_Detail profile;
	public ArrayList<Emergency_Detail> emergency;
	public ArrayList<Document_Details> documents;

	public Get_External_Customer_Detail_Data_Ouput() {
	}

	public Get_External_Customer_Detail_Data_Ouput(String customerIdentifier, String customerIdAppId,
			Profile_Detail profile, ArrayList<Emergency_Detail> emergency, ArrayList<Document_Details> documents) {
		this.customerIdentifier = customerIdentifier;
		this.customerIdAppId = customerIdAppId;
		this.profile = profile;
		this.emergency = emergency;
		this.documents = documents;
	}

	public String getCustomerIdentifier() {
		return customerIdentifier;
	}

	public void setCustomerIdentifier(String customerIdentifier) {
		this.customerIdentifier = customerIdentifier;
	}

	public String getCustomerIdAppId() {
		return customerIdAppId;
	}

	public void setCustomerIdAppId(String customerIdAppId) {
		this.customerIdAppId = customerIdAppId;
	}

	public Profile_Detail getProfile() {
		return profile;
	}

	public void setProfile(Profile_Detail profile) {
		this.profile = profile;
	}

	public ArrayList<Emergency_Detail> getEmergency() {
		return emergency;
	}

	public void setEmergency(ArrayList<Emergency_Detail> emergency) {
		this.emergency = emergency;
	}

	public ArrayList<Document_Details> getDocuments() {
		return documents;
	}

	public void setDocuments(ArrayList<Document_Details> documents) {
		this.documents = documents;
	}
}
