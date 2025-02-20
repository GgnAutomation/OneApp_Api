package pojo_Search_Vehicle_Details_List;

import java.util.ArrayList;

public class Search_Vehicle_Details_List_Data_Output {

	public ArrayList<VehicleSearchList> vehicleSearchList;

	public Search_Vehicle_Details_List_Data_Output() {
	}

	public Search_Vehicle_Details_List_Data_Output(ArrayList<VehicleSearchList> vehicleSearchList) {
		this.vehicleSearchList = vehicleSearchList;
	}

	public ArrayList<VehicleSearchList> getVehicleSearchList() {
		return vehicleSearchList;
	}

	public void setVehicleSearchList(ArrayList<VehicleSearchList> vehicleSearchList) {
		this.vehicleSearchList = vehicleSearchList;
	}

}
