package stepDefinition;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import baseClass.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.parsing.Parser;
import payloadManager.PayloadManager;
import pojoClass_ExternalLogin.Root_InvalidUrl_Output_Pojo;
import pojo_GetServiceSupportDetails.GetServiceSupportDetails_Root_Output;
import pojo_Get_External_Cust_Details.In_Valid_Customer_Identifer_Root_Output;
import pojo_Get_External_Cust_Details.Invalid_Customer_Identifier_Root_Output;

public class Tc_18_GetServiceSupportDetails extends BaseClass {

	PayloadManager payloadManager = new PayloadManager();

	@Given("the login API is available and add headers for GetServiceSupportDetails")
	public void the_login_api_is_available_and_add_headers_for_get_service_support_details()
			throws FileNotFoundException, IOException {
		RestAssured.registerParser("text/plain", Parser.JSON);
		List<Header> list_headers = new ArrayList<>();
		Header h1 = new Header("appid", "External");
		Header h2 = new Header("specificAppId", "OneApp");
		Header h3 = new Header("ocp-apim-subscription-key", "2b6bbec34ce14a32b968411d7956e24c");
		Header h4 = new Header("Authorization", "Bearer " + getPropertyFileValue("GetServiceSupportToken"));
		list_headers.add(h1);
		list_headers.add(h2);
		list_headers.add(h3);
		list_headers.add(h4);
		Headers headers = new Headers(list_headers);
		addHeaders(headers);
	}

	@When("user add requestBody with customerIdentifier {string} and dealerCode {string} for GetServiceSupportDetails")
	public void user_add_request_body_with_customer_identifier_and_dealer_code_for_get_service_support_details(
			String customerIdentifier, String dealerCode) throws FileNotFoundException, IOException {
		addReqBody(payloadManager.getServiceSupportDetails_Payload().addDetails(dealerCode, customerIdentifier));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"GetServiceSupportDetails URL is: " + getPropertyFileValue("getServiceSupportDetails"));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"Request_payload: customer identifier=" + customerIdentifier + ",dealerCode=" + dealerCode);
	}

	@When("the user sends a request with {string} for GetServiceSupportDetails")
	public void the_user_sends_a_request_with_for_get_service_support_details(String post)
			throws FileNotFoundException, IOException {
		addReqType(post, getPropertyFileValue("getServiceSupportDetails"));
	}

	@Then("the response status for GetSrDetails should be {int} ,message {string} ,dealerCode {string} ,dealerName {string} ,areaOffice {string} ,dealerMobileNo {string} ,dealerstatus {string} ,divName {string} ,divType {string} ,mobileNo {string} ,name {string} ,position {string} ,mobileNo {string} ,name {string} ,position {string}")
	public void the_response_status_for_get_sr_details_should_be_message_dealer_code_dealer_name_area_office_dealer_mobile_no_dealerstatus_div_name_div_type_mobile_no_name_position_mobile_no_name_position(
			int expResponseCode, String expMessage, String expDealerCode, String expDealerName, String expAreaOffice,
			String expDealerMobileNo, String expDealerstatus, String expDivName, String expDivType,
			String expRmTctmobileNo1, String expRmTctname1, String expRmTctposition1, String expRmTctmobileNo2,
			String expRmTctname2, String expRmTctposition2) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());

		GetServiceSupportDetails_Root_Output root_Output = getbody().as(GetServiceSupportDetails_Root_Output.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, root_Output.message, "verify message");
		assertEquals(expDealerCode, root_Output.data.dealerDetails.dealerCode, "verify DealerCode");
		assertEquals(expDealerName, root_Output.data.dealerDetails.dealerName, "verify DealerName");
		assertEquals(expAreaOffice, root_Output.data.dealerDetails.areaOffice, "verify AreaOffice");
		assertEquals(expDealerMobileNo, root_Output.data.dealerDetails.dealerMobileNo, "verify DealerMobileNo");
		assertEquals(expDealerstatus, root_Output.data.dealerDetails.dealerstatus, "verify Dealerstatus");
		assertEquals(expDivName, root_Output.data.dealerDetails.divDetails.get(0).divName,
				"verify DealerDetails DivName");
		assertEquals(expDivType, root_Output.data.dealerDetails.divDetails.get(0).divType,
				"verify DealerDetails DivType");
		assertEquals(expRmTctmobileNo1, root_Output.data.dealerDetails.rmTct.get(0).mobileNo, "verify rmtctMobileNo");
		assertEquals(expRmTctname1, root_Output.data.dealerDetails.rmTct.get(0).name, "verify rmtctName ");
		assertEquals(expRmTctposition1, root_Output.data.dealerDetails.rmTct.get(0).position, "verify rmtctPosition");
		assertEquals(expRmTctmobileNo2, root_Output.data.dealerDetails.rmTct.get(1).mobileNo, "verify rmtctMobileNo");
		assertEquals(expRmTctname2, root_Output.data.dealerDetails.rmTct.get(1).name, "verify rmtctName ");
		assertEquals(expRmTctposition2, root_Output.data.dealerDetails.rmTct.get(1).position, "verify rmtctPosition");
	}

	// <------------------------------------------------------------------------------------------------------------------------------------------------------------->

	@When("the user sends a request with {string} and ivalid url {string} for GetServiceSupportDetails")
	public void the_user_sends_a_request_with_and_ivalid_url_for_get_service_support_details(String post, String url) {
		addReqType(post, url);
	}

	@Then("the response status for GetServiceSupportDetails should be {int} ,message {string} and errorCode {string}")
	public void the_response_status_for_get_service_support_details_should_be_message_and_error_code(
			int expResponseCode, String expMessage, String expStatusCode) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		Root_InvalidUrl_Output_Pojo invalid_url_Root_Output = getbody().as(Root_InvalidUrl_Output_Pojo.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, invalid_url_Root_Output.message, "verify message");
		assertEquals(expStatusCode, invalid_url_Root_Output.statusCode, "verify status code");
	}

	// <-------------------------------------------------------------------------------------------------------------------------------------------------->
	@Then("the response status in GetServiceSupportDetails should be {int} message {string} ,errorCode {int} ,errorDescription {string}")
	public void the_response_status_in_get_service_support_details_should_be_message_error_code_error_description(
			int expResponseCode, String expMessage, int experrorCode, String expErrorDescription) {
		System.out.println(getbody().asPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		In_Valid_Customer_Identifer_Root_Output root_Output = getbody()
				.as(In_Valid_Customer_Identifer_Root_Output.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, root_Output.message, "verify message");
		assertEquals(experrorCode, root_Output.errorCode, "verify is Error code");
		assertEquals(expErrorDescription, root_Output.errorDescription, "verify Error Decsription");
	}

	// <-------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

	@Then("the response status in GetServiceSupportDetails should be {int} message {string} and errorCode {int}")
	public void the_response_status_in_get_service_support_details_should_be_message_and_error_code(int expResponseCode,
			String expMessage, int expErrorCode) {
		System.out.println(getbody().asPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		Invalid_Customer_Identifier_Root_Output root_Output = getbody()
				.as(Invalid_Customer_Identifier_Root_Output.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, root_Output.message, "verify message");
		assertEquals(expErrorCode, root_Output.errorCode, "verify error code");
		assertFalse(root_Output.success);

	}
   //<----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
}
