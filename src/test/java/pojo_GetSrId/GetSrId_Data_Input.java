package pojo_GetSrId;

public class GetSrId_Data_Input {
	public String customerIdentifier;
	public String srNo;

	public GetSrId_Data_Input() {
	}

	public GetSrId_Data_Input(String customerIdentifier, String srNo) {
		this.customerIdentifier = customerIdentifier;
		this.srNo = srNo;
	}

	public String getCustomerIdentifier() {
		return customerIdentifier;
	}

	public void setCustomerIdentifier(String customerIdentifier) {
		this.customerIdentifier = customerIdentifier;
	}

	public String getSrNo() {
		return srNo;
	}

	public void setSrNo(String srNo) {
		this.srNo = srNo;
	}

}
