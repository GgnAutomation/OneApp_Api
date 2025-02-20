package pojo_ScratchCardService;

public class PriceDetails {
	public String priceAmount;
	public String priceText;
	public String priceTextDescription;
	public String stepsToRedeem;
	public String redeemSteps;
	public String tnc;
	public String priceImage;

	public PriceDetails() {
	}

	public PriceDetails(String priceAmount, String priceText, String priceTextDescription, String stepsToRedeem,
			String redeemSteps, String tnc, String priceImage) {
		this.priceAmount = priceAmount;
		this.priceText = priceText;
		this.priceTextDescription = priceTextDescription;
		this.stepsToRedeem = stepsToRedeem;
		this.redeemSteps = redeemSteps;
		this.tnc = tnc;
		this.priceImage = priceImage;
	}

	public String getPriceAmount() {
		return priceAmount;
	}

	public void setPriceAmount(String priceAmount) {
		this.priceAmount = priceAmount;
	}

	public String getPriceText() {
		return priceText;
	}

	public void setPriceText(String priceText) {
		this.priceText = priceText;
	}

	public String getPriceTextDescription() {
		return priceTextDescription;
	}

	public void setPriceTextDescription(String priceTextDescription) {
		this.priceTextDescription = priceTextDescription;
	}

	public String getStepsToRedeem() {
		return stepsToRedeem;
	}

	public void setStepsToRedeem(String stepsToRedeem) {
		this.stepsToRedeem = stepsToRedeem;
	}

	public String getRedeemSteps() {
		return redeemSteps;
	}

	public void setRedeemSteps(String redeemSteps) {
		this.redeemSteps = redeemSteps;
	}

	public String getTnc() {
		return tnc;
	}

	public void setTnc(String tnc) {
		this.tnc = tnc;
	}

	public String getPriceImage() {
		return priceImage;
	}

	public void setPriceImage(String priceImage) {
		this.priceImage = priceImage;
	}

}
