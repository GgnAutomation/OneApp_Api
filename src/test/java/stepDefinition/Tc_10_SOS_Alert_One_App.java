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
import pojoClass_ExternalLogin.Root_ExternalLogin_Output_Pojo;
import pojoClass_ExternalLogin.Root_InvalidUrl_Output_Pojo;
import pojo_External_Login_Otp.Verify_Otp_Tc2_Root_Output_Pojo;
import pojo_Get_External_Cust_Details.In_Valid_Customer_Identifer_Root_Output;
import pojo_Get_External_Cust_Details.Invalid_Customer_Identifier_Root_Output;
import pojo_SOS.SOS_Root_Output;

public class Tc_10_SOS_Alert_One_App extends BaseClass {
	PayloadManager payloadManager = new PayloadManager();

	@Given("the login API is available and user add headers for SOS_Alert")
	public void the_login_api_is_available_and_user_add_headers_for_sos_alert() {
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

	@When("user add requestBody for validLogin loginId {string} ,loginType {string}  and notificationType {string} for SOS_Alert")
	public void user_add_request_body_for_valid_login_login_id_login_type_and_notification_type_for_sos_alert(
			String loginId, String loginType, String notification) throws FileNotFoundException, IOException {
		addReqBody(payloadManager.getExternalLoginPayLoad().addLoginDetails(loginId, loginType, notification));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Login URL is: " + getPropertyFileValue("Login"));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"Request_payload: loginId=" + loginId + ",loginType=" + loginType + ",notification=" + notification);
	}

	@When("the user sends a ExternalLogin request with {string} for SOS_Alert")
	public void the_user_sends_a_external_login_request_with_for_sos_alert(String post)
			throws FileNotFoundException, IOException {
		addReqType(post, getPropertyFileValue("Login"));
	}

	@Then("the response status should be {int} and message {string} and loginId {string} for SOS_Alert")
	public void the_response_status_should_be_and_message_and_login_id_for_sos_alert(int expectedResponseCode,
			String expectedMsg, String expLoginID) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		Root_ExternalLogin_Output_Pojo dataExternalLoginOutput = getbody().as(Root_ExternalLogin_Output_Pojo.class);
		assertEquals(expectedMsg, dataExternalLoginOutput.message, "verify message");
		assertEquals(expectedResponseCode, getResponseCode(), "verify response code");
		assertEquals(dataExternalLoginOutput.data.loginId, expLoginID, "verify LoginId");
	}

	@When("user add request for otpLogin Endpoint along with loginId {string} , isdCode {string} ,deviceType {string} ,osVersion {string} ,appVersion {string} and deviceModel {string} for SOS_Alert")
	public void user_add_request_for_otp_login_endpoint_along_with_login_id_isd_code_device_type_os_version_app_version_and_device_model_for_sos_alert(
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

	@When("the user sends a valid Login Otp request with {string} for SOS_Alert")
	public void the_user_sends_a_valid_login_otp_request_with_for_sos_alert(String post)
			throws FileNotFoundException, IOException {
		addReqType(post, getPropertyFileValue("LoginOtp"));
	}

	@Then("Validate the OTP Generated having the response code as {int} and verify message {string} , loginId {string} , firstName {string} , lastName {string} , appName {string} and primaryUser {string} for SOS_Alert")
	public void validate_the_otp_generated_having_the_response_code_as_and_verify_message_login_id_first_name_last_name_app_name_and_primary_user_for_sos_alert(
			int expResponseCode, String expectedMessage, String expectedLoginId, String expectedFirstName,
			String expectedLastName, String expectedAppName, String expectedPrimaryUser) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		Verify_Otp_Tc2_Root_Output_Pojo verifyOtpTc2RootOutputPojo = getbody()
				.as(Verify_Otp_Tc2_Root_Output_Pojo.class);
		assertEquals(expResponseCode, getResponseCode(), "verify ResponseCode");
		assertEquals(verifyOtpTc2RootOutputPojo.message, expectedMessage, "verify Msg");
		assertEquals(verifyOtpTc2RootOutputPojo.data.loginId, expectedLoginId, "verify loginId");
		assertEquals(verifyOtpTc2RootOutputPojo.data.firstName, expectedFirstName, "verify FirstName");
		assertEquals(verifyOtpTc2RootOutputPojo.data.lastName, expectedLastName, "verify LastName");
		assertEquals(verifyOtpTc2RootOutputPojo.data.appName, expectedAppName, "verify AppName");
		assertEquals(verifyOtpTc2RootOutputPojo.data.primaryUser, expectedPrimaryUser, "verify getPrimaryUser");

	}

	@Given("the login API is available and add headers for SOS_Alert")
	public void the_login_api_is_available_and_add_headers_for_sos_alert() throws FileNotFoundException, IOException {
		RestAssured.registerParser("text/plain", Parser.JSON);
		List<Header> list_headers = new ArrayList<>();
		Header h1 = new Header("appid", "External");
		Header h2 = new Header("specificAppId", "OneApp");
		Header h3 = new Header("ocp-apim-subscription-key", "2b6bbec34ce14a32b968411d7956e24c");
		Header h4 = new Header("Authorization", "Bearer " + getPropertyFileValue("GetExternalCustToken"));
		list_headers.add(h1);
		list_headers.add(h2);
		list_headers.add(h3);
		list_headers.add(h4);
		Headers headers = new Headers(list_headers);
		addHeaders(headers);
	}

	@When("user add requestBody with customerIdentifier {string} and userLocation {string} for SOS_Alert")
	public void user_add_request_body_with_customer_identifier_and_user_location_for_sos_alert(
			String customerIdentifier, String userLocation) throws FileNotFoundException, IOException {
		addReqBody(payloadManager.getSos_Payload().addDetails(customerIdentifier, userLocation));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"sendSOSAlert  URL is: " + getPropertyFileValue("SendSOSAlert"));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"Request_payload: customer identifier=" + customerIdentifier + ",userLocation=" + userLocation);
	}

	@When("the user sends a request with {string} for SOS_Alert")
	public void the_user_sends_a_request_with_for_sos_alert(String post) throws FileNotFoundException, IOException {
		addReqType(post, getPropertyFileValue("SendSOSAlert"));
	}

	@Then("the response status for SOS_Alert should be {int} ,message {string} and mobileNo {string}")
	public void the_response_status_for_sos_alert_should_be_message_and_mobile_no(int expResponseCode,
			String expMessage, String expMobNo) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		SOS_Root_Output root_Ouput = getbody().as(SOS_Root_Output.class);

		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, root_Ouput.message, "verify message");
		assertEquals(expMobNo, root_Ouput.data.mobileNo, "verify mobileNo");
	}

//<----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
	@Then("the response status in SOS_Alert for Invalid Customer Identifier should be {int} and message {string}")
	public void the_response_status_in_sos_alert_for_invalid_customer_identifier_should_be_and_message(
			int expResponseCode, String expMessage) {

		System.out.println(getbody().asPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		Invalid_Customer_Identifier_Root_Output root_Output = getbody()
				.as(Invalid_Customer_Identifier_Root_Output.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, root_Output.message, "verify message");
		assertEquals(expResponseCode, root_Output.errorCode, "verify error code");
		assertFalse(root_Output.success);
	}

	// <------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------>
	
	@Then("the response status in SOS_Alert should be {int} message {string} ,errorCode {int} and errorDescription {string}")
	public void the_response_status_in_sos_alert_should_be_message_error_code_and_error_description(
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
		assertFalse(root_Output.success);
	}

	// <--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
	@When("the user sends a request with {string} and invalid url {string} for SOS_Alert")
	public void the_user_sends_a_request_with_and_invalid_url_for_sos_alert(String post, String url) {
		addReqType(post, url);
	}

	@Then("the response status for SOS_Alert should be {int} ,message {string} and errorCode {string}")
	public void the_response_status_for_sos_alert_should_be_message_and_error_code(int expResponseCode,
			String expMessage,String expErrorCode) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		Root_InvalidUrl_Output_Pojo invalid_url_Root_Output = getbody().as(Root_InvalidUrl_Output_Pojo.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, invalid_url_Root_Output.message, "verify message");
		assertEquals(expErrorCode, invalid_url_Root_Output.statusCode, "verify status code");
	}
	
	// <--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
	@Then("the response status in SOS_Alert for empty request body should be {int}")
	public void the_response_status_in_sos_alert_for_empty_request_body_should_be(Integer expResponseCode) {
		System.out.println(getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + "");
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
	}
	// <------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
}
