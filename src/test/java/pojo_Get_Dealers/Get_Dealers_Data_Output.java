package pojo_Get_Dealers;

import java.util.ArrayList;

public class Get_Dealers_Data_Output {

	public ArrayList<DealerDetail> dealerDetails;

	public Get_Dealers_Data_Output() {
	}

	public Get_Dealers_Data_Output(ArrayList<DealerDetail> dealerDetails) {
		this.dealerDetails = dealerDetails;
	}

	public ArrayList<DealerDetail> getDealerDetails() {
		return dealerDetails;
	}

	public void setDealerDetails(ArrayList<DealerDetail> dealerDetails) {
		this.dealerDetails = dealerDetails;
	}

}
