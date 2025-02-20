package pojo_Update_Emergency_Contact;

public class Emergency_Output {

	public String id;
	public String name;
	public String mobile;
	public String relation;
	public Object profilePic;

	public Emergency_Output() {
	}

	public Emergency_Output(String id, String name, String mobile, String relation, Object profilePic) {
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

	public Object getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(Object profilePic) {
		this.profilePic = profilePic;
	}

}
