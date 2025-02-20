package pojo_GetHsrpStatus;

public class GetHsrpStatus_Data_Output {

	public String licenceNumber;
	public String fitmentStatus;

	public GetHsrpStatus_Data_Output() {
	}

	public GetHsrpStatus_Data_Output(String licenceNumber, String fitmentStatus) {
		this.licenceNumber = licenceNumber;
		this.fitmentStatus = fitmentStatus;
	}

	public String getLicenceNumber() {
		return licenceNumber;
	}

	public void setLicenceNumber(String licenceNumber) {
		this.licenceNumber = licenceNumber;
	}

	public String getFitmentStatus() {
		return fitmentStatus;
	}

	public void setFitmentStatus(String fitmentStatus) {
		this.fitmentStatus = fitmentStatus;
	}

}
