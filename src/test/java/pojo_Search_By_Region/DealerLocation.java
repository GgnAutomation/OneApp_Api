package pojo_Search_By_Region;

public class DealerLocation {
	public String city;
	public String state;
	public String displayName;

	public DealerLocation() {
	}

	public DealerLocation(String city, String state, String displayName) {
		this.city = city;
		this.state = state;
		this.displayName = displayName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

}
