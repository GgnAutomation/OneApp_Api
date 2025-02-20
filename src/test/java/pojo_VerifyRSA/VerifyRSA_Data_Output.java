package pojo_VerifyRSA;

public class VerifyRSA_Data_Output {

	public String isRsaMember;
	public String isGaMember;
	public String rsaMembershipStatus;
	public String membershipStartDate;
	public String membershipEndDate;
	public String rsaPolicyNumber;
	public String rsaVendorName;

	public VerifyRSA_Data_Output() {
	}

	public VerifyRSA_Data_Output(String isRsaMember, String isGaMember, String rsaMembershipStatus,
			String membershipStartDate, String membershipEndDate, String rsaPolicyNumber, String rsaVendorName) {
		this.isRsaMember = isRsaMember;
		this.isGaMember = isGaMember;
		this.rsaMembershipStatus = rsaMembershipStatus;
		this.membershipStartDate = membershipStartDate;
		this.membershipEndDate = membershipEndDate;
		this.rsaPolicyNumber = rsaPolicyNumber;
		this.rsaVendorName = rsaVendorName;
	}

	public String getIsRsaMember() {
		return isRsaMember;
	}

	public void setIsRsaMember(String isRsaMember) {
		this.isRsaMember = isRsaMember;
	}

	public String getIsGaMember() {
		return isGaMember;
	}

	public void setIsGaMember(String isGaMember) {
		this.isGaMember = isGaMember;
	}

	public String getRsaMembershipStatus() {
		return rsaMembershipStatus;
	}

	public void setRsaMembershipStatus(String rsaMembershipStatus) {
		this.rsaMembershipStatus = rsaMembershipStatus;
	}

	public String getMembershipStartDate() {
		return membershipStartDate;
	}

	public void setMembershipStartDate(String membershipStartDate) {
		this.membershipStartDate = membershipStartDate;
	}

	public String getMembershipEndDate() {
		return membershipEndDate;
	}

	public void setMembershipEndDate(String membershipEndDate) {
		this.membershipEndDate = membershipEndDate;
	}

	public String getRsaPolicyNumber() {
		return rsaPolicyNumber;
	}

	public void setRsaPolicyNumber(String rsaPolicyNumber) {
		this.rsaPolicyNumber = rsaPolicyNumber;
	}

	public String getRsaVendorName() {
		return rsaVendorName;
	}

	public void setRsaVendorName(String rsaVendorName) {
		this.rsaVendorName = rsaVendorName;
	}

}
