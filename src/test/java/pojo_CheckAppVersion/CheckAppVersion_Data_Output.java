package pojo_CheckAppVersion;

import java.util.ArrayList;

public class CheckAppVersion_Data_Output {

	public String checkVersion;
	public String serviceToken;
	public String salesToken;
	public String serviceDomain;
	public String salesDomain;
	public String currentAppReleaseVersion;
	public ArrayList<String> whatNew;
	public String isMandatory;

	public CheckAppVersion_Data_Output() {
	}

	public CheckAppVersion_Data_Output(String checkVersion, String serviceToken, String salesToken,
			String serviceDomain, String salesDomain, String currentAppReleaseVersion, ArrayList<String> whatNew,
			String isMandatory) {
		this.checkVersion = checkVersion;
		this.serviceToken = serviceToken;
		this.salesToken = salesToken;
		this.serviceDomain = serviceDomain;
		this.salesDomain = salesDomain;
		this.currentAppReleaseVersion = currentAppReleaseVersion;
		this.whatNew = whatNew;
		this.isMandatory = isMandatory;
	}

	public String getCheckVersion() {
		return checkVersion;
	}

	public void setCheckVersion(String checkVersion) {
		this.checkVersion = checkVersion;
	}

	public String getServiceToken() {
		return serviceToken;
	}

	public void setServiceToken(String serviceToken) {
		this.serviceToken = serviceToken;
	}

	public String getSalesToken() {
		return salesToken;
	}

	public void setSalesToken(String salesToken) {
		this.salesToken = salesToken;
	}

	public String getServiceDomain() {
		return serviceDomain;
	}

	public void setServiceDomain(String serviceDomain) {
		this.serviceDomain = serviceDomain;
	}

	public String getSalesDomain() {
		return salesDomain;
	}

	public void setSalesDomain(String salesDomain) {
		this.salesDomain = salesDomain;
	}

	public String getCurrentAppReleaseVersion() {
		return currentAppReleaseVersion;
	}

	public void setCurrentAppReleaseVersion(String currentAppReleaseVersion) {
		this.currentAppReleaseVersion = currentAppReleaseVersion;
	}

	public ArrayList<String> getWhatNew() {
		return whatNew;
	}

	public void setWhatNew(ArrayList<String> whatNew) {
		this.whatNew = whatNew;
	}

	public String getIsMandatory() {
		return isMandatory;
	}

	public void setIsMandatory(String isMandatory) {
		this.isMandatory = isMandatory;
	}

}
