package pojo_GetServiceSupportDetails;

import java.util.ArrayList;

public class DealerDetails {
	public String dealerCode;
	public String dealerName;
	public String areaOffice;
	public String zonalOffice;
	public String dealerMobileNo;
	public String dealerMail;
	public String addressline1;
	public Object addressline2;
	public String city;
	public String state;
	public String district;
	public String pincode;
	public String dealerstatus;
	public String servicePricelist;
	public ArrayList<TsmSale> tsmSales;
	public ArrayList<TsmService> tsmService;
	public ArrayList<AsmSale> asmSales;
	public ArrayList<AsmService> asmService;
	public ArrayList<DivDetail> divDetails;
	public ArrayList<RmTct> rmTct;
	public Object brandName;

	public DealerDetails() {
	}

	public DealerDetails(String dealerCode, String dealerName, String areaOffice, String zonalOffice,
			String dealerMobileNo, String dealerMail, String addressline1, Object addressline2, String city,
			String state, String district, String pincode, String dealerstatus, String servicePricelist,
			ArrayList<TsmSale> tsmSales, ArrayList<TsmService> tsmService, ArrayList<AsmSale> asmSales,
			ArrayList<AsmService> asmService, ArrayList<DivDetail> divDetails, ArrayList<RmTct> rmTct,
			Object brandName) {
		this.dealerCode = dealerCode;
		this.dealerName = dealerName;
		this.areaOffice = areaOffice;
		this.zonalOffice = zonalOffice;
		this.dealerMobileNo = dealerMobileNo;
		this.dealerMail = dealerMail;
		this.addressline1 = addressline1;
		this.addressline2 = addressline2;
		this.city = city;
		this.state = state;
		this.district = district;
		this.pincode = pincode;
		this.dealerstatus = dealerstatus;
		this.servicePricelist = servicePricelist;
		this.tsmSales = tsmSales;
		this.tsmService = tsmService;
		this.asmSales = asmSales;
		this.asmService = asmService;
		this.divDetails = divDetails;
		this.rmTct = rmTct;
		this.brandName = brandName;
	}

	public String getDealerCode() {
		return dealerCode;
	}

	public void setDealerCode(String dealerCode) {
		this.dealerCode = dealerCode;
	}

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	public String getAreaOffice() {
		return areaOffice;
	}

	public void setAreaOffice(String areaOffice) {
		this.areaOffice = areaOffice;
	}

	public String getZonalOffice() {
		return zonalOffice;
	}

	public void setZonalOffice(String zonalOffice) {
		this.zonalOffice = zonalOffice;
	}

	public String getDealerMobileNo() {
		return dealerMobileNo;
	}

	public void setDealerMobileNo(String dealerMobileNo) {
		this.dealerMobileNo = dealerMobileNo;
	}

	public String getDealerMail() {
		return dealerMail;
	}

	public void setDealerMail(String dealerMail) {
		this.dealerMail = dealerMail;
	}

	public String getAddressline1() {
		return addressline1;
	}

	public void setAddressline1(String addressline1) {
		this.addressline1 = addressline1;
	}

	public Object getAddressline2() {
		return addressline2;
	}

	public void setAddressline2(Object addressline2) {
		this.addressline2 = addressline2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getDealerstatus() {
		return dealerstatus;
	}

	public void setDealerstatus(String dealerstatus) {
		this.dealerstatus = dealerstatus;
	}

	public String getServicePricelist() {
		return servicePricelist;
	}

	public void setServicePricelist(String servicePricelist) {
		this.servicePricelist = servicePricelist;
	}

	public ArrayList<TsmSale> getTsmSales() {
		return tsmSales;
	}

	public void setTsmSales(ArrayList<TsmSale> tsmSales) {
		this.tsmSales = tsmSales;
	}

	public ArrayList<TsmService> getTsmService() {
		return tsmService;
	}

	public void setTsmService(ArrayList<TsmService> tsmService) {
		this.tsmService = tsmService;
	}

	public ArrayList<AsmSale> getAsmSales() {
		return asmSales;
	}

	public void setAsmSales(ArrayList<AsmSale> asmSales) {
		this.asmSales = asmSales;
	}

	public ArrayList<AsmService> getAsmService() {
		return asmService;
	}

	public void setAsmService(ArrayList<AsmService> asmService) {
		this.asmService = asmService;
	}

	public ArrayList<DivDetail> getDivDetails() {
		return divDetails;
	}

	public void setDivDetails(ArrayList<DivDetail> divDetails) {
		this.divDetails = divDetails;
	}

	public ArrayList<RmTct> getRmTct() {
		return rmTct;
	}

	public void setRmTct(ArrayList<RmTct> rmTct) {
		this.rmTct = rmTct;
	}

	public Object getBrandName() {
		return brandName;
	}

	public void setBrandName(Object brandName) {
		this.brandName = brandName;
	}

}
