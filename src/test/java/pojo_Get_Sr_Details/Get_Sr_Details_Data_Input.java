package pojo_Get_Sr_Details;

public class Get_Sr_Details_Data_Input {
	public String customerIdentifier;
	public String vinNo;
	public String srNo;

	public Get_Sr_Details_Data_Input() {
	}

	public Get_Sr_Details_Data_Input(String customerIdentifier, String vinNo, String srNo) {
		this.customerIdentifier = customerIdentifier;
		this.vinNo = vinNo;
		this.srNo = srNo;
	}

	public String getCustomerIdentifier() {
		return customerIdentifier;
	}

	public void setCustomerIdentifier(String customerIdentifier) {
		this.customerIdentifier = customerIdentifier;
	}

	public String getVinNo() {
		return vinNo;
	}

	public void setVinNo(String vinNo) {
		this.vinNo = vinNo;
	}

	public String getSrNo() {
		return srNo;
	}

	public void setSrNo(String srNo) {
		this.srNo = srNo;
	}

}
