package pojo_ServiceHistory;

public class ServiceHistory_Root_Input {
	public ServiceHistory_Data_Input data;

	public ServiceHistory_Root_Input() {
	}

	public ServiceHistory_Root_Input(ServiceHistory_Data_Input data) {
		this.data = data;
	}

	public ServiceHistory_Data_Input getData() {
		return data;
	}

	public void setData(ServiceHistory_Data_Input data) {
		this.data = data;
	}

}
