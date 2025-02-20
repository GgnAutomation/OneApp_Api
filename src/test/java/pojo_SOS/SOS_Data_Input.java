package pojo_SOS;

public class SOS_Data_Input {
	public String customerIdentifier;
	public String userLocation;

	public SOS_Data_Input() {
	}

	public SOS_Data_Input(String customerIdentifier, String userLocation) {
		this.customerIdentifier = customerIdentifier;
		this.userLocation = userLocation;
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

}
