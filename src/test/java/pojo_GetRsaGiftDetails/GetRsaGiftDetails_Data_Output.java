package pojo_GetRsaGiftDetails;

public class GetRsaGiftDetails_Data_Output {

	public String vinNo;
	public String giftCardStatus;
	public String giftCardMessage;
	public String giftCardImage;

	public GetRsaGiftDetails_Data_Output() {
	}

	public GetRsaGiftDetails_Data_Output(String vinNo, String giftCardStatus, String giftCardMessage,
			String giftCardImage) {
		this.vinNo = vinNo;
		this.giftCardStatus = giftCardStatus;
		this.giftCardMessage = giftCardMessage;
		this.giftCardImage = giftCardImage;
	}

	public String getVinNo() {
		return vinNo;
	}

	public void setVinNo(String vinNo) {
		this.vinNo = vinNo;
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
