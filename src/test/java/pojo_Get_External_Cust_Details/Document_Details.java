package pojo_Get_External_Cust_Details;

public class Document_Details {

	public String name;
	public String path;
	public String type;

	public Document_Details() {
	}

	public Document_Details(String name, String path, String type) {
		this.name = name;
		this.path = path;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
