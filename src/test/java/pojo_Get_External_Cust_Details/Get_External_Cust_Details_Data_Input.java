package pojo_Get_External_Cust_Details;

public class Get_External_Cust_Details_Data_Input {
	public String customerIdentifier;

	public Get_External_Cust_Details_Data_Input() {
	}

	public Get_External_Cust_Details_Data_Input(String customerIdentifier) {
		this.customerIdentifier = customerIdentifier;
	}

	public String getCustomerIdentifier() {
		return customerIdentifier;
	}

	public void setCustomerIdentifier(String customerIdentifier) {
		this.customerIdentifier = customerIdentifier;
	}

}
