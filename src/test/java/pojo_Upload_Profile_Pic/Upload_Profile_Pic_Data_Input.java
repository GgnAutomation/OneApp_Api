package pojo_Upload_Profile_Pic;

public class Upload_Profile_Pic_Data_Input {
	public String base64Data;
	public String extension;
	public String customerID;
	public String vinID;
	public String documentIdentifier;
	public String category;
	public String subCategory;
	public String emergencyId;

	public Upload_Profile_Pic_Data_Input() {
	}

	public Upload_Profile_Pic_Data_Input(String base64Data, String extension, String customerID, String vinID,
			String documentIdentifier, String category, String subCategory, String emergencyId) {
		this.base64Data = base64Data;
		this.extension = extension;
		this.customerID = customerID;
		this.vinID = vinID;
		this.documentIdentifier = documentIdentifier;
		this.category = category;
		this.subCategory = subCategory;
		this.emergencyId = emergencyId;
	}

	public String getBase64Data() {
		return base64Data;
	}

	public void setBase64Data(String base64Data) {
		this.base64Data = base64Data;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getVinID() {
		return vinID;
	}

	public void setVinID(String vinID) {
		this.vinID = vinID;
	}

	public String getDocumentIdentifier() {
		return documentIdentifier;
	}

	public void setDocumentIdentifier(String documentIdentifier) {
		this.documentIdentifier = documentIdentifier;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public String getEmergencyId() {
		return emergencyId;
	}

	public void setEmergencyId(String emergencyId) {
		this.emergencyId = emergencyId;
	}

}
