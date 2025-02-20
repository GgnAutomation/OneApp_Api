package pojo_GetServiceDetail;

public class GetServiceDetail_Data_Input {

	public String mobileNo;
	public String vinNo;
	public String customerIdentifier;

	public GetServiceDetail_Data_Input() {
	}

	public GetServiceDetail_Data_Input(String mobileNo, String vinNo, String customerIdentifier) {
		this.mobileNo = mobileNo;
		this.vinNo = vinNo;
		this.customerIdentifier = customerIdentifier;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getVinNo() {
		return vinNo;
	}

	public void setVinNo(String vinNo) {
		this.vinNo = vinNo;
	}

	public String getCustomerIdentifier() {
		return customerIdentifier;
	}

	public void setCustomerIdentifier(String customerIdentifier) {
		this.customerIdentifier = customerIdentifier;
	}

}
