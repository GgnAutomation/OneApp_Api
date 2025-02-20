package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(dryRun = false, monochrome = true, plugin = {
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, glue = {
				"stepDefinition" }, features = {
						"src/test/resources/Features/ScratchCardService_OneApp.feature" }, tags = "@ScratchedCard")

public class TestRunnerClass extends AbstractTestNGCucumberTests {

}

//-----------------------------------------------------------------------------------------------------------------------------------------

//<---------------feature------------------------>
//feature for login= {src/test/resources/Features/Login_OneApp.feature}
//feature for loginOtp= {src/test/resources/Features/External_Login_Otp_OneApp.feature}
//feature for Get_External_Customer_Detail_OneApp={src/test/resources/Features/Get_External_Customer_Detail_OneApp.feature}
//feature for Update_External_Details={src/test/resources/Features/Update_External_Cust_Detail_OneApp.feature}
//feature for Upload_Profile_Pic_One_App={"src/test/resources/Features/Upload_Profile_Pic_One_App.feature"}
//feature for Upload_Driving_License_One_App={"src/test/resources/Features/Upload_Driving_License_One_App.feature"}
//feature for get relation ={"src/test/resources/Features/Get_Relation_One_App.feature"}
//feature for Update_Emergency_Contact_One_App={"src/test/resources/Features/Update_Emergency_Contact_One_App.feature"}
//feature for upload emergency profile pic ={"src/test/resources/Features/Upload_Emergency_Profile_Pic_OneApp.feature"}
//feature for GetVehicleDetailList={"src/test/resources/Features/GetVinDetailList_OneApp.feature"}
//feature for Search_Vehicle_list={"src/test/resources/Features/Search_Vehicle_list.feature"}
//feature for Update_Primary_Vehicle_OneApp={"src/test/resources/Features/Update_Primary_Vehicle_OneApp.feature"}
//feature for Update_Vehicle_Nickname_OneApp={"src/test/resources/Features/Update_Vehicle_Nickname_OneApp.feature"}
//feature for Check_Complaint_OneApp={"src/test/resources/Features/Check_Complaint_OneApp.feature"}
//feature for GetSrId={"src/test/resources/Features/GetSrId_OneApp.feature"}
//feature for ServiceHistory_OneApp={"src/test/resources/Features/ServiceHistory_OneApp.feature"}
//feature for GetServiceSupportDetails_OneApp={"src/test/resources/Features/GetServiceSupportDetails_OneApp.feature"}
//feature for getServiceDetails_OneApp={"src/test/resources/Features/GetServiceDetails_OneApp.feature"}
//feature for getDealers_OneApp={"src/test/resources/Features/Get_Dealers_OneApp.feature"}
//feature for Search_By_Region_OneApp=src/test/resources/Features/Search_By_Region_OneApp.feature
//feature for CardCountIntegration_OneApp={"src/test/resources/Features/CardCountIntegration_OneApp.feature"}
//feature for GetRsaGiftDetails={"src/test/resources/Features/GetRsaGiftDetails_OneApp.feature"}
//feature for GetDealerOffDays_OneApp={"src/test/resources/Features/GetDealerOffDays_OneApp.feature"}
//feature for GetJoyrideDetails_OneApp={"src/test/resources/Features/GetJoyrideDetails_OneApp.feature"}
//feature for VerifyRsa_OneApp={"src/test/resources/Features/VerifyRsa_OneApp.feature"}
//fearure for UpdateRsaDetails={"src/test/resources/Features/UpdateRsaStatus_OneApp.feature"}
//feature for GetHsrpStatus_OneApp={"src/test/resources/Features/GetHsrpStatus_OneApp.feature"}
//feature for GetVinDetailsRsa_OneApp={"src/test/resources/Features/GetVinDetailsRsa_OneApp.feature"}

//<--------------------------------tags------------------>
//tags for external_login_otp={"@Valid_Otp or @InValid_Otp_length or @Invalid_SpecialChar_Otp or @Wrong_Otp or @Blank_Otp or @Space_In_between_Otp or @Reuse_Otp or @Invalid_deviceModel or @Blank_deviceModel or @ISD_code_specialChar or @Alpha_numeric_ISD_Code or @Blank_IsdCode or @DeviceTye_specialChar or @DeviceType_With_Space_AlphaNumeric or @OsVersion_specialChar or @AlphaNumeric_SpecialChar_Token"}
//tags for Get_External_Customer_Detail_OneApp={"@InvalidshortCustomerIdentifier or @InvalidLongCustomerIdentifier or @validCustomerIdentifier or @InvalidCustomerIdentifier or @BlankIdentifier or @validToken or @Invalidtoken or @Blanktoken or @InvalidUrl or @BlankRequestBody"}
//tags for update customer details={"@validDatas or @InvalidDOB or @InvalidFisrtName or @AlphanumericFisrtName or @BlankFisrtName or @SpecialCharFisrtName or @InvalidGender or @InvalidEmail or @BlankEmail or @InvalidBloodGroup or @SpecialCharBloodGroup or @BlankBloodGroup or @MaxAddress or @BlankAddress or @BlankState or @SpecialCharState or @SpecialCharCity or @BlankCity or @InvalidPincode or @BlankPincode or @InvalidUrl or @EmptyBody"} 
//tags for Upload_Profile_Pic_One_App={"@JPG or @PNG or @JPEG or @BlankToken or @InvalidUrl or @EmptyBody"}
//tags for Upload_Driving_License_One_App={"@JPG or @PNG or @JPEG or @BlankToken or @InvalidUrl or @EmptyBody"}
//tags for get relation={"@validCustomerIdentifier or @InvalidCustomerIdentifier or @BlankCustomerIdentifier or @SpecialCharCustomerIdentifier or @BlankToken or @Invalidtoken or @InvalidUrl or @EmptyBody"}
//tags for Update_Emergency_Contact_One_App={"@ValidcustomerIdentifier or @InvalidcustomerIdentifier or @BlankcustomerIdentifier or SpclCharcustomerIdentifier or @InvalidNameField or @BlankNameField or @Maxmobilenumber or @Minmobilenumber or @Alphanumericmobilenumber or @Blankmobilenumber or @InvalidRelation or @BlankRelation or @AddContact or @BlankToken or @InvalidUrl or @EmptyBody or @DeleteContact"}
//tags for ={"@JPG or @PNG or @JPEG or @InvalidCustomerIdentifier or @BlankCustomerIdentifier or @BlankVinId or @InvalidVinId or @InvalidCategory or @BlankCategory or @InvalidSubCategory or @BlankSubCategory or @InvalidEmergecnyId or @BlankEmergecnyId or @InvalidUrl or @EmptyBody"}
//tags for get vehicle details list={"@validCustomerIdentifier or @InvalidCustomerIdentifier or @BlankIdentifier or @Old_Token or @Blank_Token or @Empty_Body or @SingleVinTag or @MultiVinTag or @InvalidUrl"}
//tags for search vehicle details list={"@validdata or @BlankId or @InvalidId or @SpclCharId or @SpclCharSearchType or @BlankSearchType or @SpclCharValue or @BlankValue or @BlankRequest or @InvalidUrl or @Samevalue or @Invalidvalue"}
//tags for update primary vehicle={"@ValidVinId or @InValidVinId or @BlankVinId or @InvalidCustomerIdentifier or @BlankCustomerIdentifier or @SpecialCharCustomerIdentifier or @BlankToken or @InvalidUrl or @BlankRequestBody"}
//tags for update vehicle nick name ={"@ValidVinId or @InValidVinId or @InvalidNickname or @BlankNickname or @AlphaNumericNickname or @SpclCharNickname or @BlankVinId or @SpaceinbtwNickname or @InvalidUrl or @BlankRequestBody"}
//tags for update active warrenty={"@NoActiveWarranty or @ActiveWarranty1 or @ActiveWarranty0 0r @InvalidIsWarranty or @InvalidVin or @BlankvalidVin or @InvalidCustomerIdentifier or @BlankCustomerIdentifier or @InvalidUrl or @BlankRequestBody"}
//tags for check complaint={"@ValidVin or @InValidVin or @SpclCharVin or @BlankVin or @Reopned or @InvalidUrl or @EmptyBody"}
//tags for get sr details={"@validdata or @InvalidUrl or @SROpen or @EmptyBody or @InvalidCustomerIdentifier or @SpecialcharCustomerIdentifier or @BlankCustomerIdentifier or @InvalidvinNo or @SpclcharvinNo or @BlankvinNo or @InvalidSrNo or @SpclcharSrNo"}
//tags for get srId={"@ValidCustomerIdentifier or @InValidCustomerIdentifier or @BlankCustomerIdentifier or @SpecialCharCustomerIdentifier or @InvalidSrId or @SpecialCharSrId or @BlankSrId or @InvalidUrl or @EmptyBody"}
//tags for servicehistory={"@validdata or @InvalidUrl or @EmptyBody or @InvalidCustomerIdentifier or @SpclCharCustomerIdentifier or @BlankCustomerIdentifier or @InvalidVinId or @SpclCharVinId or @BlankVinId or @InvalidRowNo or @RowNo10 or @RowNo5 or @RowNo6 or @SpclCharRowNo or @BlankRowNo"}
//tags for servicesupportdetails={"@validdata or @InvalidUrl or @EmptyBody or @InvalidDealerCode or @SpclCharDealerCode or @EmptyDealerCode or @InvalidCustomerIdentifier or @SpclCharCustomerIdentifier or @BlankCustomerIdentifier"}
//tags for get serviceDetails={"@validdata or @InvalidUrl or @EmptyBody or @InvalidmobNo or @SpclCharmobNo or @BlankmobNo or @InvalidVinNo or @SpclCharVinNo or @BlankVinNo or @InvalidCustomerIdentifier or @SpclCharCustomerIdentifier or @BlankCustomerIdentifier"}
//tags for get dealers={"@validdata or @InvalidCity or @BlankCity or @SpclCharCity or @InvalidState or @BlankState or @SpclCharState or @InvalidCustomerIdentifier or @BlankCustomerIdentifier or @SpclCharCustomerIdentifier or @InvalidUrl or @EmptyBody"}
//tags for searchbyregion={"@validdata or @InvalidCustomerIdentifier or @BlankCustomerIdentifier or @SpclCharCustomerIdentifier or @InvalidCity or @BlankCity or @SpclCharCity or @InvalidValue or @BlankValue or @SpclCharValue or @AlphaNumValue or @InvalidUrl or @EmptyBody"}
//tags for CardCountIntegration_OneApp={"@validdata or @InvalidUrl or @EmptyBody r @SpclCharMobNo or @BlankMobNo or @NonExistMobNo or @Itemcountzero"}
//tags for getRsaGiftDetails={"@validdata or @InvalidLogin or @BlankLogin or @InvalidVinNo or @BlankVinNo or @SpclCharVinNo or @InvalidUrl or @EmptyBody"}
//tags for getDealerOffDays={"@validdata or @InvalidCustomerIdentifier or @BlankCustomerIdentifier or @SpclCharCustomerIdentifier or @InvalidDivision or @BlankDivision or @SpclCharDivision or @InvalidUrl or @EmptyBody or @10375Dealer or @60329Dealer"}
//tags for getjoyridetails={"@validdata or @InvalidVinId or @BlankVinId or @SpclCharVinId or @InvalidUrl or @EmptyBody or @SimStatusActive or @SimStatusInActive or @SpclCharSimStatus or @BlankSimStatus or @AmcBalanceNull or @BlankAmcBalance or @AmcExpiryDateBlank or @JoyrideIssueDateNull or @JoyrideCardNumberBlank or @JoyrideIssueDateBlank"}
//tags for checkAppVersion={"@ValidData or @InvalidUrl or @EmptyBody or @InvalidDeviceType or @SpclCharDeviceType or @NullDeviceType or @InvaliduserAppVersion or @BlankDeviceType or @lowerversion or @Higherversion or @IOSData or @Android_IsmandatoryN or @IOS_IsmandatoryN"} 
//tags for verifyrsa={"@ValidData or @InvalidMobNo or @BlankMobNo or @SpclCharMobNo or @InvalidVinNo or @BlankVinNo or @SpclCharvinNo or @InvalidUrl or @EmptyBody or @IsRsaMemberExpired or @ProgramStatusNull or @ProgramStatusBlank or @ProgramStatusSpclChar or @GLOBALASSURE or @PVTLTD or @InvalidRsaVendorName or @RsaVendorNameNull or @RsaVendorNameBlank or @SpclCharVendorName"}
//tags for updateRsaDetails={"@ValidData or @InvalidLoginId or @BlankLoginId or @InvalidUrl or @SpclCharLoginId or @SpclCharVinNo or @BlankVinNo or @SpclCharprogramStatus or @BlankprogramStatus or @EmptyBody or @BlankGiftCardStatus or @SpclCharGiftCardStatus or @ZerogiftCardStatus or @InvalidgiftCardStatus or @SpclChargiftCardMsg or @BlankgiftCardMsg or @BlankgiftCardImage or @SpclChargiftCardImage"}
//tags for GetHsrpStatus_OneApp={"@ValidData or @InvalidUrl or @EmptyBody or @SpclCharMobNo or @BlankMobNo or @InvalidMobNo or @SpclCharVinNo or @BlankVinNo or @InvalidVinNo or @Already_Fitted or @RC_Number_Allocated or @Order_Generated or @Fitment_Status_Already_Fitted or @Fitment_Status_RC_Number_Allocated or @Fitment_Status_Order_Generated or @Fitment_Status_Ready_For_Fitment or @SpclChar_Fitment_Status or @Blank_Fitment_Status or @DLR_FDATE or @D_STS_DATE or @RC_Num_Allocated"}
//tags for search all city={"@ValidData or @InvalidsearchBy or @AlphaNumsearchBy or @BlanksearchBy or @SpclCharsearchBy or @InvalidValue or @SpclCharValue or @InvalidUrl or @EmptyBody"}
//tags for getvindetailsRsa={"@validData or @InvalidUrl or @CosmosData or @InvalidLoginId or @BlankLoginId or @InvalidsearchType or @BlanksearchType or @SpclCharValue or @Invalidvalue or @Blankvalue or @EmptyBody or @InvalidKey or @InvalidAppId or @InvalidspecificAppId"}
//tags for ScratchCardService_OneApp={"@InvaildMobNo or @BlankMobNo or @SpclCharMobNo or @InvaildVinId or @BlankVinId or @SpclCharVinId or @InvaildscratchCardType or @BlankScratchCardType or @SpclCharScratchCardType or @LessThanOneYear or @ScratchedCard"} 
