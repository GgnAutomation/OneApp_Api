package pojo_GetDealerOffDays;

public class GetDealerOffDays_Data_Input {

	public String customerIdentifier;
	public String divisionName;

	public GetDealerOffDays_Data_Input() {
	}

	public GetDealerOffDays_Data_Input(String customerIdentifier, String divisionName) {
		this.customerIdentifier = customerIdentifier;
		this.divisionName = divisionName;
	}

	public String getCustomerIdentifier() {
		return customerIdentifier;
	}

	public void setCustomerIdentifier(String customerIdentifier) {
		this.customerIdentifier = customerIdentifier;
	}

	public String getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

}
