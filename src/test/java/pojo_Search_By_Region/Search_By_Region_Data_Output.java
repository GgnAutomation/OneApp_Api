package pojo_Search_By_Region;

import java.util.ArrayList;

public class Search_By_Region_Data_Output {
	public ArrayList<DealerLocation> dealerLocation;

	public Search_By_Region_Data_Output() {
	}

	public Search_By_Region_Data_Output(ArrayList<DealerLocation> dealerLocation) {
		this.dealerLocation = dealerLocation;
	}

	public ArrayList<DealerLocation> getDealerLocation() {
		return dealerLocation;
	}

	public void setDealerLocation(ArrayList<DealerLocation> dealerLocation) {
		this.dealerLocation = dealerLocation;
	}

}
