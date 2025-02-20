package pojo_Class_GetVehicle_List;

import java.util.ArrayList;

public class Valid_Customer_Identifier_Data_Output {

	public ArrayList<VehicleDetail> vehicleDetails;

	public Valid_Customer_Identifier_Data_Output() {
	}

	public Valid_Customer_Identifier_Data_Output(ArrayList<VehicleDetail> vehicleDetails) {
		this.vehicleDetails = vehicleDetails;
	}

	public ArrayList<VehicleDetail> getVehicleDetails() {
		return vehicleDetails;
	}

	public void setVehicleDetails(ArrayList<VehicleDetail> vehicleDetails) {
		this.vehicleDetails = vehicleDetails;
	}

}
