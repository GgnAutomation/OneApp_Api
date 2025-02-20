package pojo_Update_Emergency_Contact;

public class Update_Emergency_Contact_Data_Input {

	public String customerIdentifier;
	public Emergency_Input emergency;
	public String action;

	public Update_Emergency_Contact_Data_Input() {
	}

	public Update_Emergency_Contact_Data_Input(String customerIdentifier, Emergency_Input emergency, String action) {
		this.customerIdentifier = customerIdentifier;
		this.emergency = emergency;
		this.action = action;
	}

	public String getCustomerIdentifier() {
		return customerIdentifier;
	}

	public void setCustomerIdentifier(String customerIdentifier) {
		this.customerIdentifier = customerIdentifier;
	}

	public Emergency_Input getEmergency() {
		return emergency;
	}

	public void setEmergency(Emergency_Input emergency) {
		this.emergency = emergency;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

}
