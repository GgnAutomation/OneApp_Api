package pojo_Get_External_Cust_Details;

public class Emergency_Detail {
	public String id;
	public String name;
	public String mobile;
	public String relation;
	public String profilePic;

	public Emergency_Detail() {
	}

	public Emergency_Detail(String id, String name, String mobile, String relation, String profilePic) {
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.relation = relation;
		this.profilePic = profilePic;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

}
