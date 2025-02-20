package pojo_GetDealerOffDays;

import java.util.ArrayList;

public class GetDealerOffDays_Data_Output {

	public String divisionName;
	public ArrayList<String> weekOff;
	public ArrayList<String> additionalOffDays;

	public GetDealerOffDays_Data_Output() {
	}

	public GetDealerOffDays_Data_Output(String divisionName, ArrayList<String> weekOff,
			ArrayList<String> additionalOffDays) {
		this.divisionName = divisionName;
		this.weekOff = weekOff;
		this.additionalOffDays = additionalOffDays;
	}

	public String getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	public ArrayList<String> getWeekOff() {
		return weekOff;
	}

	public void setWeekOff(ArrayList<String> weekOff) {
		this.weekOff = weekOff;
	}

	public ArrayList<String> getAdditionalOffDays() {
		return additionalOffDays;
	}

	public void setAdditionalOffDays(ArrayList<String> additionalOffDays) {
		this.additionalOffDays = additionalOffDays;
	}

}
