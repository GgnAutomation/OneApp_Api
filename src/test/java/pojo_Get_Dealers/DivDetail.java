package pojo_Get_Dealers;

public class DivDetail {
	public String addrLn1;
	public String divLoc;
	public String divName;
	public String divType;

	public DivDetail() {
	}

	public DivDetail(String addrLn1, String divLoc, String divName, String divType) {
		this.addrLn1 = addrLn1;
		this.divLoc = divLoc;
		this.divName = divName;
		this.divType = divType;
	}

	public String getAddrLn1() {
		return addrLn1;
	}

	public void setAddrLn1(String addrLn1) {
		this.addrLn1 = addrLn1;
	}

	public String getDivLoc() {
		return divLoc;
	}

	public void setDivLoc(String divLoc) {
		this.divLoc = divLoc;
	}

	public String getDivName() {
		return divName;
	}

	public void setDivName(String divName) {
		this.divName = divName;
	}

	public String getDivType() {
		return divType;
	}

	public void setDivType(String divType) {
		this.divType = divType;
	}

}
