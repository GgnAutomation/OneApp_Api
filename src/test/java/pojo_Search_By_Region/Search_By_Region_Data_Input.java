package pojo_Search_By_Region;

public class Search_By_Region_Data_Input {

	public String customerIdentifier;
	public String searchBy;
	public String value;

	public Search_By_Region_Data_Input() {
	}

	public Search_By_Region_Data_Input(String customerIdentifier, String searchBy, String value) {
		this.customerIdentifier = customerIdentifier;
		this.searchBy = searchBy;
		this.value = value;
	}

	public String getCustomerIdentifier() {
		return customerIdentifier;
	}

	public void setCustomerIdentifier(String customerIdentifier) {
		this.customerIdentifier = customerIdentifier;
	}

	public String getSearchBy() {
		return searchBy;
	}

	public void setSearchBy(String searchBy) {
		this.searchBy = searchBy;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
