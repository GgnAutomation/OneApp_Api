package pojo_GetServiceDetail;

public class ServiceStatus {
	public String isServiceOpen;
	public String dealerName;
	public String dealerCd;
	public String dealerCity;
	public String divisionName;
	public String dealerAddress;
	public Object nextServiceDate;
	public Object jobCardOpenDate;
	public Object jobCardNumber;
	public String serviceBookingNumber;
	public String serviceBookingDate;
	public String serviceType;
	public String bookingSlot;
	public String supportPersonName;
	public Object supportPersonNumber;
	public String serviceStatus;

	public ServiceStatus() {
	}

	public ServiceStatus(String isServiceOpen, String dealerName, String dealerCd, String dealerCity,
			String divisionName, String dealerAddress, Object nextServiceDate, Object jobCardOpenDate,
			Object jobCardNumber, String serviceBookingNumber, String serviceBookingDate, String serviceType,
			String bookingSlot, String supportPersonName, Object supportPersonNumber, String serviceStatus) {
		this.isServiceOpen = isServiceOpen;
		this.dealerName = dealerName;
		this.dealerCd = dealerCd;
		this.dealerCity = dealerCity;
		this.divisionName = divisionName;
		this.dealerAddress = dealerAddress;
		this.nextServiceDate = nextServiceDate;
		this.jobCardOpenDate = jobCardOpenDate;
		this.jobCardNumber = jobCardNumber;
		this.serviceBookingNumber = serviceBookingNumber;
		this.serviceBookingDate = serviceBookingDate;
		this.serviceType = serviceType;
		this.bookingSlot = bookingSlot;
		this.supportPersonName = supportPersonName;
		this.supportPersonNumber = supportPersonNumber;
		this.serviceStatus = serviceStatus;
	}

	public String getIsServiceOpen() {
		return isServiceOpen;
	}

	public void setIsServiceOpen(String isServiceOpen) {
		this.isServiceOpen = isServiceOpen;
	}

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	public String getDealerCd() {
		return dealerCd;
	}

	public void setDealerCd(String dealerCd) {
		this.dealerCd = dealerCd;
	}

	public String getDealerCity() {
		return dealerCity;
	}

	public void setDealerCity(String dealerCity) {
		this.dealerCity = dealerCity;
	}

	public String getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	public String getDealerAddress() {
		return dealerAddress;
	}

	public void setDealerAddress(String dealerAddress) {
		this.dealerAddress = dealerAddress;
	}

	public Object getNextServiceDate() {
		return nextServiceDate;
	}

	public void setNextServiceDate(Object nextServiceDate) {
		this.nextServiceDate = nextServiceDate;
	}

	public Object getJobCardOpenDate() {
		return jobCardOpenDate;
	}

	public void setJobCardOpenDate(Object jobCardOpenDate) {
		this.jobCardOpenDate = jobCardOpenDate;
	}

	public Object getJobCardNumber() {
		return jobCardNumber;
	}

	public void setJobCardNumber(Object jobCardNumber) {
		this.jobCardNumber = jobCardNumber;
	}

	public String getServiceBookingNumber() {
		return serviceBookingNumber;
	}

	public void setServiceBookingNumber(String serviceBookingNumber) {
		this.serviceBookingNumber = serviceBookingNumber;
	}

	public String getServiceBookingDate() {
		return serviceBookingDate;
	}

	public void setServiceBookingDate(String serviceBookingDate) {
		this.serviceBookingDate = serviceBookingDate;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getBookingSlot() {
		return bookingSlot;
	}

	public void setBookingSlot(String bookingSlot) {
		this.bookingSlot = bookingSlot;
	}

	public String getSupportPersonName() {
		return supportPersonName;
	}

	public void setSupportPersonName(String supportPersonName) {
		this.supportPersonName = supportPersonName;
	}

	public Object getSupportPersonNumber() {
		return supportPersonNumber;
	}

	public void setSupportPersonNumber(Object supportPersonNumber) {
		this.supportPersonNumber = supportPersonNumber;
	}

	public String getServiceStatus() {
		return serviceStatus;
	}

	public void setServiceStatus(String serviceStatus) {
		this.serviceStatus = serviceStatus;
	}

}
