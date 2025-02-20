package pojo_Update_Emergency_Contact;

public class Update_Emergency_Contact_Data_Output {
	public String customerIdentifier;
	public Emergency_Output emergency;
	public String action;

	public Update_Emergency_Contact_Data_Output() {
	}

	public Update_Emergency_Contact_Data_Output(String customerIdentifier, Emergency_Output emergency, String action) {
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

	public Emergency_Output getEmergency() {
		return emergency;
	}

	public void setEmergency(Emergency_Output emergency) {
		this.emergency = emergency;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

}
