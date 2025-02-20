package pojo_ServiceHistory;

import java.util.ArrayList;

public class ServiceHistory_Data_Ouput {

	public ArrayList<ServiceHistory> serviceHistory;

	public ServiceHistory_Data_Ouput() {
	}

	public ServiceHistory_Data_Ouput(ArrayList<ServiceHistory> serviceHistory) {
		this.serviceHistory = serviceHistory;
	}

	public ArrayList<ServiceHistory> getServiceHistory() {
		return serviceHistory;
	}

	public void setServiceHistory(ArrayList<ServiceHistory> serviceHistory) {
		this.serviceHistory = serviceHistory;
	}

}
