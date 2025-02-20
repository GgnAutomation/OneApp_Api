package pojo_Update_Active_Warranty;

public class Update_Active_Warranty_Data_Input {
	public String vinId;
	public String customerIdentifier;
	public String isWarrantyActive;

	public Update_Active_Warranty_Data_Input() {
	}

	public Update_Active_Warranty_Data_Input(String vinId, String customerIdentifier, String isWarrantyActive) {
		this.vinId = vinId;
		this.customerIdentifier = customerIdentifier;
		this.isWarrantyActive = isWarrantyActive;
	}

	public String getVinId() {
		return vinId;
	}

	public void setVinId(String vinId) {
		this.vinId = vinId;
	}

	public String getCustomerIdentifier() {
		return customerIdentifier;
	}

	public void setCustomerIdentifier(String customerIdentifier) {
		this.customerIdentifier = customerIdentifier;
	}

	public String getIsWarrantyActive() {
		return isWarrantyActive;
	}

	public void setIsWarrantyActive(String isWarrantyActive) {
		this.isWarrantyActive = isWarrantyActive;
	}
}
