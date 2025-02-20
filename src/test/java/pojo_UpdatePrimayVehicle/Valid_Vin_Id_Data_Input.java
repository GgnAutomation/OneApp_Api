package pojo_UpdatePrimayVehicle;

public class Valid_Vin_Id_Data_Input {

	public String vinId;
	public String customerIdentifier;

	public Valid_Vin_Id_Data_Input() {
	}

	public Valid_Vin_Id_Data_Input(String vinId, String customerIdentifier) {
		this.vinId = vinId;
		this.customerIdentifier = customerIdentifier;
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

}
