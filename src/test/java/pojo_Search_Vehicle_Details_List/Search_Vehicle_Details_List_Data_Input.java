package pojo_Search_Vehicle_Details_List;

public class Search_Vehicle_Details_List_Data_Input {
	public String loginId;
	public String searchType;
	public String value;

	public Search_Vehicle_Details_List_Data_Input() {
	}

	public Search_Vehicle_Details_List_Data_Input(String loginId, String searchType, String value) {
		this.loginId = loginId;
		this.searchType = searchType;
		this.value = value;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
