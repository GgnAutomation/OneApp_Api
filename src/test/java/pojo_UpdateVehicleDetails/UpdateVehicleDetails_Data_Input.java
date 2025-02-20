package pojo_UpdateVehicleDetails;

public class UpdateVehicleDetails_Data_Input {
	public String vinId;
	public String customerIdentifier;
	public String fitmentStatus;

	public UpdateVehicleDetails_Data_Input() {
	}

	public UpdateVehicleDetails_Data_Input(String vinId, String customerIdentifier, String fitmentStatus) {
		this.vinId = vinId;
		this.customerIdentifier = customerIdentifier;
		this.fitmentStatus = fitmentStatus;
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

	public String getFitmentStatus() {
		return fitmentStatus;
	}

	public void setFitmentStatus(String fitmentStatus) {
		this.fitmentStatus = fitmentStatus;
	}

}
