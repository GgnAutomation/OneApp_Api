package pojo_VerifyRSA;

public class VerifyRSA_Data_Input {

	public String mobileNo;
	public String vinNo;

	public VerifyRSA_Data_Input() {
	}

	public VerifyRSA_Data_Input(String mobileNo, String vinNo) {
		this.mobileNo = mobileNo;
		this.vinNo = vinNo;
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

}
