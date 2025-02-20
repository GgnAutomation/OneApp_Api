package pojo_ServiceHistory;

public class ServiceHistory_Data_Input {
	public String customerIdentifier;
	public String vin;
	public String rowNum;

	public ServiceHistory_Data_Input() {
	}

	public ServiceHistory_Data_Input(String customerIdentifier, String vin, String rowNum) {
		this.customerIdentifier = customerIdentifier;
		this.vin = vin;
		this.rowNum = rowNum;
	}

	public String getCustomerIdentifier() {
		return customerIdentifier;
	}

	public void setCustomerIdentifier(String customerIdentifier) {
		this.customerIdentifier = customerIdentifier;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getRowNum() {
		return rowNum;
	}

	public void setRowNum(String rowNum) {
		this.rowNum = rowNum;
	}

}
