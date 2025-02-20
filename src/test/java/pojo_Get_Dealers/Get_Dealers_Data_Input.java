package pojo_Get_Dealers;

public class Get_Dealers_Data_Input {
	public String customerIdentifier;
	public String city;
	public String state;

	public Get_Dealers_Data_Input() {
	}

	public Get_Dealers_Data_Input(String customerIdentifier, String city, String state) {
		this.customerIdentifier = customerIdentifier;
		this.city = city;
		this.state = state;
	}

	public String getCustomerIdentifier() {
		return customerIdentifier;
	}

	public void setCustomerIdentifier(String customerIdentifier) {
		this.customerIdentifier = customerIdentifier;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
