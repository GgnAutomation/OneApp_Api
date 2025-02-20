package pojo_Vin_Nickname;

public class Nickname_Valid_VinID_Data_Input {

	public String vinId;
	public String customerIdentifier;
	public String vehicleNickName;

	public Nickname_Valid_VinID_Data_Input() {
	}

	public Nickname_Valid_VinID_Data_Input(String vinId, String customerIdentifier, String vehicleNickName) {
		this.vinId = vinId;
		this.customerIdentifier = customerIdentifier;
		this.vehicleNickName = vehicleNickName;
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

	public String getVehicleNickName() {
		return vehicleNickName;
	}

	public void setVehicleNickName(String vehicleNickName) {
		this.vehicleNickName = vehicleNickName;
	}

}
