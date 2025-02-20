package pojo_SOS;

public class SOS_Data1_Input {
	public String customerIdentifier;
	public String userLocation;
	public String vinId;
	public String vehicleSosType;

	public SOS_Data1_Input() {
	}

	public SOS_Data1_Input(String customerIdentifier, String userLocation, String vinId, String vehicleSosType) {
		this.customerIdentifier = customerIdentifier;
		this.userLocation = userLocation;
		this.vinId = vinId;
		this.vehicleSosType = vehicleSosType;
	}

	public String getCustomerIdentifier() {
		return customerIdentifier;
	}

	public void setCustomerIdentifier(String customerIdentifier) {
		this.customerIdentifier = customerIdentifier;
	}

	public String getUserLocation() {
		return userLocation;
	}

	public void setUserLocation(String userLocation) {
		this.userLocation = userLocation;
	}

	public String getVinId() {
		return vinId;
	}

	public void setVinId(String vinId) {
		this.vinId = vinId;
	}

	public String getVehicleSosType() {
		return vehicleSosType;
	}

	public void setVehicleSosType(String vehicleSosType) {
		this.vehicleSosType = vehicleSosType;
	}

}
