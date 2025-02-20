package pojo_UpdateRsaStatus;

public class UpdateRsaStatus_Data_Input {

	public String loginId;
	public String vinNo;
	public String programStatus;
	public String giftCardStatus;
	public String giftCardMessage;
	public String giftCardImage;

	public UpdateRsaStatus_Data_Input() {
	}

	public UpdateRsaStatus_Data_Input(String loginId, String vinNo, String programStatus, String giftCardStatus,
			String giftCardMessage, String giftCardImage) {
		this.loginId = loginId;
		this.vinNo = vinNo;
		this.programStatus = programStatus;
		this.giftCardStatus = giftCardStatus;
		this.giftCardMessage = giftCardMessage;
		this.giftCardImage = giftCardImage;
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

	public String getProgramStatus() {
		return programStatus;
	}

	public void setProgramStatus(String programStatus) {
		this.programStatus = programStatus;
	}

	public String getGiftCardStatus() {
		return giftCardStatus;
	}

	public void setGiftCardStatus(String giftCardStatus) {
		this.giftCardStatus = giftCardStatus;
	}

	public String getGiftCardMessage() {
		return giftCardMessage;
	}

	public void setGiftCardMessage(String giftCardMessage) {
		this.giftCardMessage = giftCardMessage;
	}

	public String getGiftCardImage() {
		return giftCardImage;
	}

	public void setGiftCardImage(String giftCardImage) {
		this.giftCardImage = giftCardImage;
	}

}
