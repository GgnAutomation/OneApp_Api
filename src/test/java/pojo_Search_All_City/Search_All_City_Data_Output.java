package pojo_Search_All_City;

import java.util.ArrayList;

public class Search_All_City_Data_Output {
	public ArrayList<DealerLocationCity> dealerLocation;

	public Search_All_City_Data_Output() {
	}

	public Search_All_City_Data_Output(ArrayList<DealerLocationCity> dealerLocation) {
		this.dealerLocation = dealerLocation;
	}

	public ArrayList<DealerLocationCity> getDealerLocation() {
		return dealerLocation;
	}

	public void setDealerLocation(ArrayList<DealerLocationCity> dealerLocation) {
		this.dealerLocation = dealerLocation;
	}

}
