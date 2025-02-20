package pojo_Search_All_City;

public class Search_All_City_Data_Input {

	public String searchBy;
	public String value;

	public Search_All_City_Data_Input() {
	}

	public Search_All_City_Data_Input(String searchBy, String value) {
		this.searchBy = searchBy;
		this.value = value;
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
