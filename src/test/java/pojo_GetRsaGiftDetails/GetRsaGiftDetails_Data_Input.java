package pojo_GetRsaGiftDetails;

public class GetRsaGiftDetails_Data_Input {

	public String loginId;
	public String vinNo;

	public GetRsaGiftDetails_Data_Input() {
	}

	public GetRsaGiftDetails_Data_Input(String loginId, String vinNo) {
		this.loginId = loginId;
		this.vinNo = vinNo;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getVinNo() {
		return vinNo;
	}

	public void setVinNo(String vinNo) {
		this.vinNo = vinNo;
	}

}
