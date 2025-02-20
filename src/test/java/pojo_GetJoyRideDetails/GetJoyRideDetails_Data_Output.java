package pojo_GetJoyRideDetails;

public class GetJoyRideDetails_Data_Output {
	public String amcBalance;
	public String amcExpiryDate;
	public String joyridePackageId;
	public String joyrideCardNumber;
	public String joyrideIssueDate;
	public String connectedSimStatus;

	public GetJoyRideDetails_Data_Output() {
	}

	public GetJoyRideDetails_Data_Output(String amcBalance, String amcExpiryDate, String joyridePackageId,
			String joyrideCardNumber, String joyrideIssueDate, String connectedSimStatus) {
		this.amcBalance = amcBalance;
		this.amcExpiryDate = amcExpiryDate;
		this.joyridePackageId = joyridePackageId;
		this.joyrideCardNumber = joyrideCardNumber;
		this.joyrideIssueDate = joyrideIssueDate;
		this.connectedSimStatus = connectedSimStatus;
	}

	public String getAmcBalance() {
		return amcBalance;
	}

	public void setAmcBalance(String amcBalance) {
		this.amcBalance = amcBalance;
	}

	public String getAmcExpiryDate() {
		return amcExpiryDate;
	}

	public void setAmcExpiryDate(String amcExpiryDate) {
		this.amcExpiryDate = amcExpiryDate;
	}

	public String getJoyridePackageId() {
		return joyridePackageId;
	}

	public void setJoyridePackageId(String joyridePackageId) {
		this.joyridePackageId = joyridePackageId;
	}

	public String getJoyrideCardNumber() {
		return joyrideCardNumber;
	}

	public void setJoyrideCardNumber(String joyrideCardNumber) {
		this.joyrideCardNumber = joyrideCardNumber;
	}

	public String getJoyrideIssueDate() {
		return joyrideIssueDate;
	}

	public void setJoyrideIssueDate(String joyrideIssueDate) {
		this.joyrideIssueDate = joyrideIssueDate;
	}

	public String getConnectedSimStatus() {
		return connectedSimStatus;
	}

	public void setConnectedSimStatus(String connectedSimStatus) {
		this.connectedSimStatus = connectedSimStatus;
	}

}
