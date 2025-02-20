package pojo_Get_Dealers;

public class TsmService {
	public String email;
	public String id;
	public String mobileNo;
	public String name;

	public TsmService() {
	}

	public TsmService(String email, String id, String mobileNo, String name) {
		this.email = email;
		this.id = id;
		this.mobileNo = mobileNo;
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

}
