package pojo_GetServiceSupportDetails;

public class RmTct {
	public String mobileNo;
	public String name;
	public String position;

	public RmTct() {
	}

	public RmTct(String mobileNo, String name, String position) {
		this.mobileNo = mobileNo;
		this.name = name;
		this.position = position;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}
