package payloadManager;

import payLoads.Cart_Count_integration_Payload;
import payLoads.CheckAppVersion_Payloads;
import payLoads.Check_Complaint_Payload;
import payLoads.External_Login_PayLoad;
import payLoads.GetDealerOffDays_Payload;
import payLoads.GetHsrpStatus_Payloads;
import payLoads.GetJoyrideDetails_Payload;
import payLoads.GetRsaGiftDetails_Payload;
import payLoads.GetServiceDetail_Payload;
import payLoads.GetServiceSupportDetails_Payload;
import payLoads.GetVinDetailsRsa_Payload;
import payLoads.Get_Dealers_Payloads;
import payLoads.Get_External_Cust_Details_Payload;
import payLoads.Get_Relation_Payload;
import payLoads.Get_Sr_Details_Payload;
import payLoads.Get_Vehicle_Detail_List_Payload;
import payLoads.Get_srId_Payload;
import payLoads.Is_Warranty_Payload;
import payLoads.LoginOtpPayload;
import payLoads.Nickname_Update;
import payLoads.SOS_Payload;
import payLoads.ScratchCardService_Payload;
import payLoads.SearchAllCity_Payloads;
import payLoads.SearchByRegion_Payload;
import payLoads.Search_Vehicle_Details_List_Payload;
import payLoads.ServiceHistory_Payload;
import payLoads.UpdateRsaStatus_Payloads;
import payLoads.UpdateVehicleDetails_Payload;
import payLoads.Update_Customer_Details_Payload;
import payLoads.Update_Emergency_Contact;
import payLoads.Update_Primary_Vehicle;
import payLoads.Upload_Profile_Pic_Payload;
import payLoads.VerifyRsa_Payloads;

public class PayloadManager {

	public External_Login_PayLoad externalLoginPayLoad;
	public LoginOtpPayload loginOtpPayload;
	public Get_External_Cust_Details_Payload get_External_Cust_Details_Payload;
	public Update_Customer_Details_Payload updatecustomer_Details;
	public Upload_Profile_Pic_Payload profile_Pic_Payload;
	public Get_Relation_Payload get_Relation_Payload;
	public Update_Emergency_Contact update_Emergency_Contact;
	public SOS_Payload sos_Payload;
	public Get_Vehicle_Detail_List_Payload vehicle_Detail_List_Payload;
	public Search_Vehicle_Details_List_Payload vehicle_Details_List_Payload;
	public Update_Primary_Vehicle update_Primary_Vehicle;
	public Nickname_Update nickname_Update;
	public Is_Warranty_Payload warranty_Payload;
	public Check_Complaint_Payload check_Complaint_Payload;
	public Get_Sr_Details_Payload sr_Details_Payload;
	public Get_srId_Payload get_srId_Payload;
	public ServiceHistory_Payload ServiceHistory_Payload;
	public GetServiceSupportDetails_Payload serviceSupportDetails_Payload;
	public GetServiceDetail_Payload getServiceDetail_Payload;
	public Get_Dealers_Payloads get_Dealers_Payloads;
	public SearchByRegion_Payload searchByRegion_Payload;
	public Cart_Count_integration_Payload count_integration_Payload;
	public GetRsaGiftDetails_Payload getRsaGiftDetails_Payload;
	public GetDealerOffDays_Payload getDealerOffDays_Payload;
	public GetJoyrideDetails_Payload getJoyrideDetails_Payload;
	public CheckAppVersion_Payloads checkAppVersion_Payloads;
	public VerifyRsa_Payloads verifyRsa_Payloads;
	public UpdateRsaStatus_Payloads updateRsaStatus_Payloads;
	public GetHsrpStatus_Payloads getHsrpStatus_Payloads;
	public SearchAllCity_Payloads searchAllCity_Payloads;
	public UpdateVehicleDetails_Payload updateVehicleDetails_Payload;
	public GetVinDetailsRsa_Payload getVinDetailsRsa_Payload;
	public ScratchCardService_Payload scratchCardService_Payload;

	public GetVinDetailsRsa_Payload getVinDetailsRsa_Payload() {
		return (getVinDetailsRsa_Payload == null) ? getVinDetailsRsa_Payload = new GetVinDetailsRsa_Payload()
				: getVinDetailsRsa_Payload;
	}

	public External_Login_PayLoad getExternalLoginPayLoad() {
		return (externalLoginPayLoad == null) ? externalLoginPayLoad = new External_Login_PayLoad()
				: externalLoginPayLoad;
	}

	public LoginOtpPayload getLoginOtpPayload() {
		return (loginOtpPayload == null) ? loginOtpPayload = new LoginOtpPayload() : loginOtpPayload;

	}

	public Get_External_Cust_Details_Payload Get_External_Cust_Details_Payload() {
		return (get_External_Cust_Details_Payload == null)
				? get_External_Cust_Details_Payload = new Get_External_Cust_Details_Payload()
				: get_External_Cust_Details_Payload;

	}

	public Update_Customer_Details_Payload getUpdate_Customer_Details() {
		return (updatecustomer_Details == null) ? updatecustomer_Details = new Update_Customer_Details_Payload()
				: updatecustomer_Details;

	}

	public Upload_Profile_Pic_Payload getProfile_Pic_Payload() {
		return (profile_Pic_Payload == null) ? profile_Pic_Payload = new Upload_Profile_Pic_Payload()
				: profile_Pic_Payload;

	}

	public Get_Relation_Payload getRelation_Payload() {
		return (get_Relation_Payload == null) ? get_Relation_Payload = new Get_Relation_Payload()
				: get_Relation_Payload;

	}

	public Update_Emergency_Contact getUpdate_Emergency_Contact() {
		return (update_Emergency_Contact == null) ? update_Emergency_Contact = new Update_Emergency_Contact()
				: update_Emergency_Contact;
	}

	public SOS_Payload getSos_Payload() {
		return (sos_Payload == null) ? sos_Payload = new SOS_Payload() : sos_Payload;
	}

	public Get_Vehicle_Detail_List_Payload get_Vehicle_Detail_List_Payload() {
		return (vehicle_Detail_List_Payload == null)
				? vehicle_Detail_List_Payload = new Get_Vehicle_Detail_List_Payload()
				: vehicle_Detail_List_Payload;
	}

	public Search_Vehicle_Details_List_Payload getSearch_Vehicle_Details_List_Payload() {
		return (vehicle_Details_List_Payload == null)
				? vehicle_Details_List_Payload = new Search_Vehicle_Details_List_Payload()
				: vehicle_Details_List_Payload;
	}

	public Update_Primary_Vehicle getUpdate_Primary_Vehicle() {
		return (update_Primary_Vehicle == null) ? update_Primary_Vehicle = new Update_Primary_Vehicle()
				: update_Primary_Vehicle;
	}

	public Nickname_Update getNickname_Update() {
		return (nickname_Update == null) ? nickname_Update = new Nickname_Update() : nickname_Update;
	}

	public Is_Warranty_Payload get_Active_Warranty_Payload() {
		return (warranty_Payload == null) ? warranty_Payload = new Is_Warranty_Payload() : warranty_Payload;
	}

	public Check_Complaint_Payload getCheckComplaint_Payload() {
		return (check_Complaint_Payload == null) ? check_Complaint_Payload = new Check_Complaint_Payload()
				: check_Complaint_Payload;
	}

	public Get_Sr_Details_Payload get_Sr_Details_Payload() {
		return (sr_Details_Payload == null) ? sr_Details_Payload = new Get_Sr_Details_Payload() : sr_Details_Payload;
	}

	public Get_srId_Payload getSrId_Payload() {
		return (get_srId_Payload == null) ? get_srId_Payload = new Get_srId_Payload() : get_srId_Payload;
	}

	public ServiceHistory_Payload getServiceHistory_Payload() {
		return (ServiceHistory_Payload == null) ? ServiceHistory_Payload = new ServiceHistory_Payload()
				: ServiceHistory_Payload;
	}

	public GetServiceSupportDetails_Payload getServiceSupportDetails_Payload() {
		return (serviceSupportDetails_Payload == null)
				? serviceSupportDetails_Payload = new GetServiceSupportDetails_Payload()
				: serviceSupportDetails_Payload;
	}

	public GetServiceDetail_Payload getServiceHistoryDetail() {
		return (getServiceDetail_Payload == null) ? getServiceDetail_Payload = new GetServiceDetail_Payload()
				: getServiceDetail_Payload;
	}

	public Get_Dealers_Payloads getDealers_Payloads() {
		return (get_Dealers_Payloads == null) ? get_Dealers_Payloads = new Get_Dealers_Payloads()
				: get_Dealers_Payloads;
	}

	public SearchByRegion_Payload getSearchByRegion_Payload() {
		return (searchByRegion_Payload == null) ? searchByRegion_Payload = new SearchByRegion_Payload()
				: searchByRegion_Payload;
	}

	public Cart_Count_integration_Payload getCardCount_integration_Payload() {
		return (count_integration_Payload == null) ? count_integration_Payload = new Cart_Count_integration_Payload()
				: count_integration_Payload;
	}

	public GetRsaGiftDetails_Payload getRsaGiftDetails_Payload() {
		return (getRsaGiftDetails_Payload == null) ? getRsaGiftDetails_Payload = new GetRsaGiftDetails_Payload()
				: getRsaGiftDetails_Payload;
	}

	public GetDealerOffDays_Payload getDealerOffDays_Payload() {
		return (getDealerOffDays_Payload == null) ? getDealerOffDays_Payload = new GetDealerOffDays_Payload()
				: getDealerOffDays_Payload;
	}

	public GetJoyrideDetails_Payload getJoyrideDetails_Payload() {
		return (getJoyrideDetails_Payload == null) ? getJoyrideDetails_Payload = new GetJoyrideDetails_Payload()
				: getJoyrideDetails_Payload;
	}

	public CheckAppVersion_Payloads getCheckAppVersion_Payloads() {

		return (checkAppVersion_Payloads == null) ? checkAppVersion_Payloads = new CheckAppVersion_Payloads()
				: checkAppVersion_Payloads;
	}

	public VerifyRsa_Payloads getVerifyRsa_Payloads() {

		return (verifyRsa_Payloads == null) ? verifyRsa_Payloads = new VerifyRsa_Payloads() : verifyRsa_Payloads;
	}

	public UpdateRsaStatus_Payloads getUpdateRsaStatus_Payloads() {
		return (updateRsaStatus_Payloads == null) ? updateRsaStatus_Payloads = new UpdateRsaStatus_Payloads()
				: updateRsaStatus_Payloads;
	}

	public GetHsrpStatus_Payloads getHsrpStatus_Payloads() {
		return (getHsrpStatus_Payloads == null) ? getHsrpStatus_Payloads = new GetHsrpStatus_Payloads()
				: getHsrpStatus_Payloads;
	}

	public SearchAllCity_Payloads getSearchAllCity_Payloads() {
		return (searchAllCity_Payloads == null) ? searchAllCity_Payloads = new SearchAllCity_Payloads()
				: searchAllCity_Payloads;
	}

	public UpdateVehicleDetails_Payload getUpdateVehicleDetails_Payload() {
		return (updateVehicleDetails_Payload == null)
				? updateVehicleDetails_Payload = new UpdateVehicleDetails_Payload()
				: updateVehicleDetails_Payload;
	}

	public ScratchCardService_Payload getScratchCardService_Payload() {
		return (scratchCardService_Payload == null) ? scratchCardService_Payload = new ScratchCardService_Payload()
				: scratchCardService_Payload;
	}

}