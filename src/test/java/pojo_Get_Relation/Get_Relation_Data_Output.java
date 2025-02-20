package pojo_Get_Relation;

import java.util.ArrayList;

public class Get_Relation_Data_Output {

	public ArrayList<DataList> dataList;

	public Get_Relation_Data_Output() {
		this.dataList = new ArrayList<>(); // Initialize the list
	}

	public Get_Relation_Data_Output(ArrayList<DataList> dataList) {
		this.dataList = dataList;
	}

	public ArrayList<DataList> getDataList() {
		return dataList;
	}

	public void setDataList(ArrayList<DataList> dataList) {
		this.dataList = dataList;
	}

}
