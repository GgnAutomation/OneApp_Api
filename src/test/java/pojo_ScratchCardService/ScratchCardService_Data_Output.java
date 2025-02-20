package pojo_ScratchCardService;

public class ScratchCardService_Data_Output {

	public String status;
	public PriceDetails priceDetails;
	public String rewardType;
	public String scratchCardId;
	public String scratchCardType;

	public ScratchCardService_Data_Output() {
	}

	public ScratchCardService_Data_Output(String status, PriceDetails priceDetails, String rewardType,
			String scratchCardId, String scratchCardType) {
		this.status = status;
		this.priceDetails = priceDetails;
		this.rewardType = rewardType;
		this.scratchCardId = scratchCardId;
		this.scratchCardType = scratchCardType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public PriceDetails getPriceDetails() {
		return priceDetails;
	}

	public void setPriceDetails(PriceDetails priceDetails) {
		this.priceDetails = priceDetails;
	}

	public String getRewardType() {
		return rewardType;
	}

	public void setRewardType(String rewardType) {
		this.rewardType = rewardType;
	}

	public String getScratchCardId() {
		return scratchCardId;
	}

	public void setScratchCardId(String scratchCardId) {
		this.scratchCardId = scratchCardId;
	}

	public String getScratchCardType() {
		return scratchCardType;
	}

	public void setScratchCardType(String scratchCardType) {
		this.scratchCardType = scratchCardType;
	}

}
