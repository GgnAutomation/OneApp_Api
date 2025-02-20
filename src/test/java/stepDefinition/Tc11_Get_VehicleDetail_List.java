package stepDefinition;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

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
import pojoClass_ExternalLogin.Root_ExternalLogin_Output_Pojo;
import pojoClass_ExternalLogin.Root_InvalidUrl_Output_Pojo;
import pojo_Class_GetVehicle_List.Valid_Customer_Identifier_Root_Output;
import pojo_External_Login_Otp.Verify_Otp_Tc2_Root_Output_Pojo;
import pojo_Get_External_Cust_Details.In_Valid_Customer_Identifer_Root_Output;
import pojo_Get_External_Cust_Details.Invalid_Customer_Identifier_Root_Output;

public class Tc11_Get_VehicleDetail_List extends BaseClass {

	PayloadManager payloadManager = new PayloadManager();
	static String identifier;

	@Given("the login API is available and add headers for get vehicle detail list")
	public void the_login_api_is_available_and_add_headers_for_get_vehicle_detail_list()
			throws FileNotFoundException, IOException {

		RestAssured.registerParser("text/plain", Parser.JSON);
		List<Header> list_headers = new ArrayList<>();
		Header h1 = new Header("appid", "External");
		Header h2 = new Header("specificAppId", "OneApp");
		Header h3 = new Header("ocp-apim-subscription-key", "2b6bbec34ce14a32b968411d7956e24c");
		list_headers.add(h1);
		list_headers.add(h2);
		list_headers.add(h3);
		Headers headers = new Headers(list_headers);
		addHeaders(headers);

	}

	@When("user add requestBody for get vin detail list {string} ,{string} and {string}")
	public void user_add_request_body_for_get_vin_detail_list_and(String loginId, String loginType, String notification)
			throws FileNotFoundException, IOException {

		addReqBody(payloadManager.getExternalLoginPayLoad().addLoginDetails(loginId, loginType, notification));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Login URL is: " + getPropertyFileValue("Login"));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"Request_payload: loginId=" + loginId + ",loginType=" + loginType + ",notification=" + notification);
	}

	@When("the user sends a get vin detail list Otp request with {string}")
	public void the_user_sends_a_get_vin_detail_list_Otp_request_with(String post)
			throws FileNotFoundException, IOException {

		addReqType(post, getPropertyFileValue("Login"));
	}

	@Then("the response status for get vin detail list Otp should be {int} and message {string} and loginId {string}")
	public void the_response_status_for_get_vin_detail_list_Otp_should_be_and_message_and_login_id(
			int expectedResponseCode, String expectedMsg, String expLoginID) {
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		Root_ExternalLogin_Output_Pojo dataExternalLoginOutput = getbody().as(Root_ExternalLogin_Output_Pojo.class);
		assertEquals(expectedMsg, dataExternalLoginOutput.message, "verify message");
		assertEquals(expectedResponseCode, getResponseCode(), "verify response code");
		assertEquals(dataExternalLoginOutput.data.loginId, expLoginID, "verify LoginId");

	}

	@When("user add request for get vehicle detail list along with loginId {string} , isdCode {string} ,deviceType {string} ,osVersion {string} ,appVersion {string} and deviceModel {string}")
	public void user_add_request_for_get_vehicle_detail_list_along_with_login_id_isd_code_device_type_os_version_app_version_and_device_model(
			String loginId, String isdCode, String deviceType, String osVersion, String appVersion, String deviceModel)
			throws FileNotFoundException, IOException {

		addReqBody(payloadManager.getLoginOtpPayload().addDetails(loginId, getPropertyFileValue("Otp"), isdCode,
				deviceType, osVersion, appVersion, deviceModel, getPropertyFileValue("firebaseToken")));

		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"Login Otp URL is: " + getPropertyFileValue("LoginOtp"));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"Request_payload: loginId=" + loginId + ",deviceType=" + deviceType + ",osVersion=" + osVersion
						+ ",appVersion=" + appVersion + ",deviceModel" + deviceModel + ", firebaseToken"
						+ getPropertyFileValue("firebaseToken"));

	}

	@When("the user sends a get vehicle detail list request with {string}")
	public void the_user_sends_a_get_vehicle_detail_list_request_with(String post)
			throws FileNotFoundException, IOException {

		addReqType(post, getPropertyFileValue("LoginOtp"));
	}

	@Then("Validate the otp Generated for get vehicle detail list having the response code as {int} and verify message {string}")
	public void validate_the_otp_generated_for_get_vehicle_detail_list_having_the_response_code_as_and_verify_message(
			int expResponseCode, String expectedMessage) {

		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		Verify_Otp_Tc2_Root_Output_Pojo verifyOtpTc2RootOutputPojo = getbody()
				.as(Verify_Otp_Tc2_Root_Output_Pojo.class);

		assertEquals(verifyOtpTc2RootOutputPojo.message, expectedMessage, "verify Msg");
		assertEquals(expResponseCode, getResponseCode(), "verify ResponseCode");
		identifier = verifyOtpTc2RootOutputPojo.data.customerIdentifier;
	}

	@Given("the login API is available and add headers and access token for get vehicle detail list")
	public void the_login_api_is_available_and_add_headers_and_access_token_for_get_vehicle_detail_list()
			throws FileNotFoundException, IOException {

		RestAssured.registerParser("text/plain", Parser.JSON);
		List<Header> list_headers = new ArrayList<>();
		Header h1 = new Header("appid", "External");
		Header h2 = new Header("specificAppId", "OneApp");
		Header h3 = new Header("ocp-apim-subscription-key", "2b6bbec34ce14a32b968411d7956e24c");
		Header h4 = new Header("Authorization", "Bearer " + getPropertyFileValue("GetVehicleListToken"));
		list_headers.add(h1);
		list_headers.add(h2);
		list_headers.add(h3);
		list_headers.add(h4);
		Headers headers = new Headers(list_headers);
		addHeaders(headers);

	}

	@When("user add requestBody with valid customer Identifier for get vehicle detail list")
	public void user_add_request_body_with_valid_customer_identifier_for_get_vehicle_detail_list()
			throws FileNotFoundException, IOException {

		addReqBody(payloadManager.get_Vehicle_Detail_List_Payload().addDetails(identifier));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"GetvinDetailList URL is: " + getPropertyFileValue("getVehicleDetailsList"));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Request_payload: CustomerIdentifier=" + identifier);
	}

	@When("the user sends  get vehicle detail list request with {string}")
	public void the_user_sends_get_vehicle_detail_list_request_with(String post)
			throws FileNotFoundException, IOException {
		addReqType(post, getPropertyFileValue("getVehicleDetailsList"));
	}

	@Then("the response status for get vin detail list should be {int} ,message {string} ,serialNumber {string} and model {string}")
	public void the_response_status_for_get_vin_detail_list_should_be_message_serial_number_and_model(
			int expResponseCode, String expMessage, String expSerialNumber, String expModel) {

		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());

		Valid_Customer_Identifier_Root_Output customer_Identifier_Root_Output = getbody()
				.as(Valid_Customer_Identifier_Root_Output.class);
		assertTrue(customer_Identifier_Root_Output.success);
		assertEquals(customer_Identifier_Root_Output.message, expMessage, "verify message");
		assertEquals(getResponseCode(), expResponseCode, "verify ResponseCode");
		assertEquals(customer_Identifier_Root_Output.data.vehicleDetails.get(0).serialNumber, expSerialNumber,
				"verify serial Number");
		assertEquals(customer_Identifier_Root_Output.data.vehicleDetails.get(0).model, expModel, "verify Model");
	}

	// <----------------------------------------------------------------------------------------------------------------------->

	@When("user add requestBody with Invalid customer Identifier for get vehicle detail list")
	public void user_add_request_body_with_invalid_customer_identifier_for_get_vehicle_detail_list()
			throws FileNotFoundException, IOException {

		addReqBody(payloadManager.get_Vehicle_Detail_List_Payload()
				.addDetails(getPropertyFileValue("InvalidCustomerIdentifier")));

		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"GetvinDetailList URL is: " + getPropertyFileValue("getVehicleDetailsList"));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"Request_payload: CustomerIdentifier=" + getPropertyFileValue("InvalidCustomerIdentifier"));

	}

	@When("the user sends a Invalid customer identifier for get vin detail list otp request with {string}")
	public void the_user_sends_a_invalid_customer_identifier_for_get_vin_detail_list_otp_request_with(String post)
			throws FileNotFoundException, IOException {
		addReqType(post, getPropertyFileValue("getVehicleDetailsList"));
	}

	@Then("the response status for Invalid customer identifier for get vin detail list Otp should be {int} and message {string} and errorCode {int}")
	public void the_response_status_for_invalid_customer_identifier_for_get_vin_detail_list_Otp_should_be_and_message_and_error_code(
			int expResponseCode, String expMessage, int expErrorCode) {

		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());

		Invalid_Customer_Identifier_Root_Output Root_Output = getbody()
				.as(Invalid_Customer_Identifier_Root_Output.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, Root_Output.message, "verify message");
		assertEquals(expErrorCode, Root_Output.errorCode, "verify Error code");
		assertFalse(Root_Output.success);
	}

// <-------------------------------------------------------------------------------------------------------------------------------------->

	@When("user add requestBody with Blank customer Identifier for get vehicle detail list")
	public void user_add_request_body_with_blank_customer_identifier_for_get_vehicle_detail_list()
			throws FileNotFoundException, IOException {

		addReqBody(payloadManager.get_Vehicle_Detail_List_Payload().addDetails(""));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"GetvinDetailList URL is: " + getPropertyFileValue("getVehicleDetailsList"));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Request_payload: CustomerIdentifier=" + "empty");
	}

	@Then("the response status for Blank customer identifier for get vin detail list Otp should be {int} and message {string} and errorCode {int}")
	public void the_response_status_for_blank_customer_identifier_for_get_vin_detail_list_otp_should_be_and_message_and_error_code(
			int expResponseCode, String expMessage, int expErrorCode) {

		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"Response Status code is: " + getbody().asPrettyString());

		assertEquals(getResponseCode(), expResponseCode, "verify Responsecode");

		Invalid_Customer_Identifier_Root_Output Root_Output = getbody()
				.as(Invalid_Customer_Identifier_Root_Output.class);

		assertEquals(Root_Output.message, expMessage, "verify message");
		assertEquals(Root_Output.errorCode, expErrorCode, "verify errorCode");
	}

// <-------------------------------------------------------------------------------------------------------------------------------------->

	@Given("the login API is available and add headers for Old access Token for get vehicle detail list")
	public void the_login_api_is_available_and_add_headers_for_old_access_token_for_get_vehicle_detail_list()
			throws FileNotFoundException, IOException {

		RestAssured.registerParser("text/plain", Parser.JSON);
		List<Header> list_headers = new ArrayList<>();
		Header h1 = new Header("appid", "External");
		Header h2 = new Header("specificAppId", "OneApp");
		Header h3 = new Header("ocp-apim-subscription-key", "2b6bbec34ce14a32b968411d7956e24c");
		Header h4 = new Header("Authorization", getPropertyFileValue("InvalidToken"));
		list_headers.add(h1);
		list_headers.add(h2);
		list_headers.add(h3);
		list_headers.add(h4);
		Headers headers = new Headers(list_headers);
		addHeaders(headers);
	}

	@When("user add requestBody with Old access Token for get vehicle detail list")
	public void user_add_request_body_with_old_access_token_for_get_vehicle_detail_list()
			throws FileNotFoundException, IOException {

		addReqBody(payloadManager.get_Vehicle_Detail_List_Payload()
				.addDetails(getPropertyFileValue("InvalidCustomerIdentifier")));

		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"GetvinDetailList URL is: " + getPropertyFileValue("getVehicleDetailsList"));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"Request_payload: CustomerIdentifier=" + getPropertyFileValue("InvalidCustomerIdentifier"));

	}

	@Then("the response status for Old access Token for get vin detail list Otp should be {int} and message {string} and errorCode {int}")
	public void the_response_status_for_old_access_token_for_get_vin_detail_list_otp_should_be_and_message_and_error_code(
			int expResponseCode, String expMessage, int expErrorCode) {

		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"Response Status code is: " + getbody().asPrettyString());

		assertEquals(getResponseCode(), expResponseCode, "verify Responsecode");

		Invalid_Customer_Identifier_Root_Output Root_Output = getbody()
				.as(Invalid_Customer_Identifier_Root_Output.class);

		assertEquals(Root_Output.message, expMessage, "verify message");
		assertEquals(Root_Output.errorCode, expErrorCode, "verify errorCode");

	}

	// <-------------------------------------------------------------------------------------------------------------------------------------->
	@Given("the login API is available and add headers for blank access Token for get vehicle detail list")
	public void the_login_api_is_available_and_add_headers_for_blank_access_token_for_get_vehicle_detail_list()
			throws FileNotFoundException, IOException {
		RestAssured.registerParser("text/plain", Parser.JSON);
		List<Header> list_headers = new ArrayList<>();
		Header h1 = new Header("appid", "External");
		Header h2 = new Header("specificAppId", "OneApp");
		Header h3 = new Header("ocp-apim-subscription-key", "2b6bbec34ce14a32b968411d7956e24c");
		Header h4 = new Header("Authorization", "");
		list_headers.add(h1);
		list_headers.add(h2);
		list_headers.add(h3);
		list_headers.add(h4);
		Headers headers = new Headers(list_headers);
		addHeaders(headers);
	}

	@When("user add requestBody with blank access Token for get vehicle detail list")
	public void user_add_request_body_with_blank_access_token_for_get_vehicle_detail_list()
			throws FileNotFoundException, IOException {

		addReqBody(payloadManager.get_Vehicle_Detail_List_Payload()
				.addDetails(getPropertyFileValue("InvalidCustomerIdentifier")));

		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"GetvinDetailList URL is: " + getPropertyFileValue("getVehicleDetailsList"));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"Request_payload: CustomerIdentifier=" + getPropertyFileValue("InvalidCustomerIdentifier"));
	}

	@Then("the response status for blank access Token for get vin detail list Otp should be {int} and message {string} , errorCode {int} and errorDescription {string}")
	public void the_response_status_for_blank_access_token_for_get_vin_detail_list_otp_should_be_and_message_error_code_and_error_description(
			int expResponseCode, String expMessage, int expErrorCode, String expErrorDescription) {

		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"Response Status code is: " + getbody().asPrettyString());
		In_Valid_Customer_Identifer_Root_Output Root_Output = getbody()
				.as(In_Valid_Customer_Identifer_Root_Output.class);
		assertFalse(Root_Output.success);
		assertEquals(getResponseCode(), expResponseCode, "verify Responsecode");
		assertEquals(Root_Output.message, expMessage, "verify message");
		assertEquals(Root_Output.errorCode, expErrorCode, "verify errorCode");
		assertEquals(Root_Output.errorDescription, expErrorDescription, "verify errorDescription");
	}

	// <-------------------------------------------------------------------------------------------------------------------------------------->

	@When("user add request Body for valid Empty Request Body for get vehice detail list")
	public void user_add_request_body_for_valid_empty_request_body_for_get_vehice_detail_list()
			throws FileNotFoundException, IOException {

		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Login URL is: " + getPropertyFileValue("Login"));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Request_payload: Empty");
	}

	@Then("Validate response for Empty request Body for get vehice detail list status should be responseCode {int}")
	public void validate_response_for_empty_request_body_for_get_vehice_detail_list_status_should_be_response_code(
			int expectedResponseCode) {
		System.out.println(getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		assertEquals(expectedResponseCode, getResponseCode(), "verify response code");

	}

// <-------------------------------------------------------------------------------------------------------------------------------------->
	@Given("the login API is available and add headers and access token in single vin tag for get vehicle detail list")
	public void the_login_api_is_available_and_add_headers_and_access_token_in_single_vin_tag_for_get_vehicle_detail_list()
			throws FileNotFoundException, IOException {
		RestAssured.registerParser("text/plain", Parser.JSON);
		List<Header> list_headers = new ArrayList<>();
		Header h1 = new Header("appid", "External");
		Header h2 = new Header("specificAppId", "OneApp");
		Header h3 = new Header("ocp-apim-subscription-key", "2b6bbec34ce14a32b968411d7956e24c");
		Header h4 = new Header("Authorization", "Bearer " + getPropertyFileValue("SingleVinToken"));
		list_headers.add(h1);
		list_headers.add(h2);
		list_headers.add(h3);
		list_headers.add(h4);
		Headers headers = new Headers(list_headers);
		addHeaders(headers);
	}

	@When("user add requestBody with valid customer Identifier {string} get vehicle detail list")
	public void user_add_request_body_with_valid_customer_identifier_get_vehicle_detail_list(String customerIdentifier)
			throws FileNotFoundException, IOException {

		addReqBody(payloadManager.get_Vehicle_Detail_List_Payload().addDetails(customerIdentifier));

		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"GetvinDetailList URL is: " + getPropertyFileValue("getVehicleDetailsList"));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"Request_payload: CustomerIdentifier=" + customerIdentifier);
	}

	@Then("the response status for get vin detail list should be {int} and message {string} and assestId1 {string}")
	public void the_response_status_for_get_vin_detail_list_should_be_and_message_and_assest_id1(int expResponseCode,
			String expMessage, String expAssestId) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());

		Valid_Customer_Identifier_Root_Output customer_Identifier_Root_Output = getbody()
				.as(Valid_Customer_Identifier_Root_Output.class);

		assertEquals(customer_Identifier_Root_Output.message, expMessage, "verify message");
		assertEquals(getResponseCode(), expResponseCode, "verify ResponseCode");
		assertEquals(customer_Identifier_Root_Output.data.vehicleDetails.get(0).assetId, expAssestId,
				"verify assestId");
	}

	// <------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

	@Given("the login API is available and add headers and access token for multi vin tag in get vehicle detail list")
	public void the_login_api_is_available_and_add_headers_and_access_token_for_multi_vin_tag_in_get_vehicle_detail_list()
			throws FileNotFoundException, IOException {
		RestAssured.registerParser("text/plain", Parser.JSON);
		List<Header> list_headers = new ArrayList<>();
		Header h1 = new Header("appid", "External");
		Header h2 = new Header("specificAppId", "OneApp");
		Header h3 = new Header("ocp-apim-subscription-key", "2b6bbec34ce14a32b968411d7956e24c");
		Header h4 = new Header("Authorization", "Bearer " + getPropertyFileValue("MultiVinTagToken"));
		list_headers.add(h1);
		list_headers.add(h2);
		list_headers.add(h3);
		list_headers.add(h4);
		Headers headers = new Headers(list_headers);
		addHeaders(headers);
	}

	@Then("the response status for get vin detail should be {int} and message {string} and assestId1 {string} ,assestId2 {string} ,assestId3 {string} ,assestId4 {string} ,assestId5 {string} and assestId6 {string}")
	public void the_response_status_for_get_vin_detail_should_be_and_message_and_assest_id1_assest_id2_assest_id3_assest_id4_assest_id5_and_assest_id6(
			int expResponseCode, String expMessage, String expAssestId1, String expAssestId2, String expAssestId3,
			String expAssestId4, String expAssestId5, String expAssestId6) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());

		Valid_Customer_Identifier_Root_Output customer_Identifier_Root_Output = getbody()
				.as(Valid_Customer_Identifier_Root_Output.class);

		assertEquals(customer_Identifier_Root_Output.message, expMessage, "verify message");
		assertEquals(getResponseCode(), expResponseCode, "verify ResponseCode");
		assertEquals(customer_Identifier_Root_Output.data.vehicleDetails.get(0).assetId, expAssestId1,
				"verify assestId1");
		assertEquals(customer_Identifier_Root_Output.data.vehicleDetails.get(1).assetId, expAssestId2,
				"verify assestId2");

		assertEquals(customer_Identifier_Root_Output.data.vehicleDetails.get(2).assetId, expAssestId3,
				"verify assestId3");
		assertEquals(customer_Identifier_Root_Output.data.vehicleDetails.get(3).assetId, expAssestId4,
				"verify assestId4");
		assertEquals(customer_Identifier_Root_Output.data.vehicleDetails.get(4).assetId, expAssestId5,
				"verify assestId5");

		assertEquals(customer_Identifier_Root_Output.data.vehicleDetails.get(5).assetId, expAssestId6,
				"verify assestId6");
	}

	// <------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
	@When("the user sends a request with {string} and invalid url {string} for get vehicle detail list")
	public void the_user_sends_a_request_with_and_invalid_url_for_get_vehicle_detail_list(String post, String url) {
		addReqType(post, url);
	}

	@Then("the response status for get vehicle detail list should be {int} ,message {string} and errorCode {string}")
	public void the_response_status_for_get_vehicle_detail_list_should_be_message_and_error_code(int expResponseCode,
			String expMessage, String expErrorCode) {

		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		Root_InvalidUrl_Output_Pojo invalid_url_Root_Output = getbody().as(Root_InvalidUrl_Output_Pojo.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, invalid_url_Root_Output.message, "verify message");
		assertEquals(expErrorCode, invalid_url_Root_Output.statusCode, "verify status code");

	}
	// <----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
}
