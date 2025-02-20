package pojo_Search_All_City;

public class DealerLocationCity {
	public String city;
	public String state;
	public String displayName;

	public DealerLocationCity() {
	}

	public DealerLocationCity(String city, String state, String displayName) {
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
