package pojo_SOS;

public class SOS_Root_Input {
	public SOS_Data_Input data;

	public SOS_Root_Input() {
	}

	public SOS_Root_Input(SOS_Data_Input data) {
		this.data = data;
	}

	public SOS_Data_Input getData() {
		return data;
	}

	public void setData(SOS_Data_Input data) {
		this.data = data;
	}
}
