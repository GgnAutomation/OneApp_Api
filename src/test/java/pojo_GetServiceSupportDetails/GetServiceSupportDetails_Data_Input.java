package pojo_GetServiceSupportDetails;

public class GetServiceSupportDetails_Data_Input {

	public String dealerCode;
	public String customerIdentifier;

	public GetServiceSupportDetails_Data_Input() {
	}

	public GetServiceSupportDetails_Data_Input(String dealerCode, String customerIdentifier) {
		this.dealerCode = dealerCode;
		this.customerIdentifier = customerIdentifier;
	}

	public String getDealerCode() {
		return dealerCode;
	}

	public void setDealerCode(String dealerCode) {
		this.dealerCode = dealerCode;
	}

	public String getCustomerIdentifier() {
		return customerIdentifier;
	}

	public void setCustomerIdentifier(String customerIdentifier) {
		this.customerIdentifier = customerIdentifier;
	}

}
