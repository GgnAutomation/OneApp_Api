package pojo_UpdateVehicleDetails;

public class UpdateVehicleDetails_Root_Output {
	public boolean success;
	public String message;
	public UpdateVehicleDetails_Data_Output data;

	public UpdateVehicleDetails_Root_Output() {
	}

	public UpdateVehicleDetails_Root_Output(boolean success, String message, UpdateVehicleDetails_Data_Output data) {
		this.success = success;
		this.message = message;
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UpdateVehicleDetails_Data_Output getData() {
		return data;
	}

	public void setData(UpdateVehicleDetails_Data_Output data) {
		this.data = data;
	}

}
