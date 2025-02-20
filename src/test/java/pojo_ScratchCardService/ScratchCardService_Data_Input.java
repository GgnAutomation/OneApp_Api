package pojo_ScratchCardService;

public class ScratchCardService_Data_Input {
	public String mobileNo;
	public String vinId;
	public String scratchCardType;

	public ScratchCardService_Data_Input() {
	}

	public ScratchCardService_Data_Input(String mobileNo, String vinId, String scratchCardType) {
		this.mobileNo = mobileNo;
		this.vinId = vinId;
		this.scratchCardType = scratchCardType;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getVinId() {
		return vinId;
	}

	public void setVinId(String vinId) {
		this.vinId = vinId;
	}

	public String getScratchCardType() {
		return scratchCardType;
	}

	public void setScratchCardType(String scratchCardType) {
		this.scratchCardType = scratchCardType;
	}

}
