package pojo_GetVinDetailsForRsa;

import java.util.ArrayList;

public class GetVinDetailsForRsa_Data_Output {

	public ArrayList<VehicleSearchListRsa> vehicleSearchList;

	public GetVinDetailsForRsa_Data_Output() {

	}

	public GetVinDetailsForRsa_Data_Output(ArrayList<VehicleSearchListRsa> vehicleSearchList) {
		this.vehicleSearchList = vehicleSearchList;
	}

	public ArrayList<VehicleSearchListRsa> getVehicleSearchList() {
		return vehicleSearchList;
	}

	public void setVehicleSearchList(ArrayList<VehicleSearchListRsa> vehicleSearchList) {
		this.vehicleSearchList = vehicleSearchList;
	}

}
