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

public class Tc2_External_Login_Otp_One_App extends BaseClass {

	PayloadManager payloadManager = new PayloadManager();

	@Given("the login API is available and add headers for External Login Otp")
	public void the_login_api_is_available_and_add_headers_for_external_login_otp() {

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

	@When("user add requestBody for valid Login otp {string} ,{string} and {string}")
	public void user_add_request_body_for_valid_login_otp_and(String loginId, String loginType, String notification)
			throws IOException {
		addReqBody(payloadManager.getExternalLoginPayLoad().addLoginDetails(loginId, loginType, notification));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Login URL is: " + getPropertyFileValue("Login"));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"Request_payload: loginId=" + loginId + ",loginType=" + loginType + ",notification=" + notification);
	}

	@When("the user sends a valid Login otp request with {string}")
	public void the_user_sends_a_valid_login_otp_request_with(String post) throws IOException {
		addReqType(post, getPropertyFileValue("Login"));
	}

	@Then("the response status for valid login otp should be {int} and message {string} and loginId {string}")
	public void the_response_status_for_valid_login_otp_should_be_and_message_and_login_id(int expectedResponseCode,
			String expectedMsg, String expLoginID) {

		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		Root_ExternalLogin_Output_Pojo dataExternalLoginOutput = getbody().as(Root_ExternalLogin_Output_Pojo.class);
		assertEquals(expectedMsg, dataExternalLoginOutput.message, "verify message");
		assertEquals(expectedResponseCode, getResponseCode(), "verify response code");
		assertEquals(dataExternalLoginOutput.data.loginId, expLoginID, "verify LoginId");
	}

	@When("user add request for otpLogin along with loginId {string} ,otp {string} ,isdCode {string} ,deviceType {string} ,osVersion {string} ,appVersion {string} and deviceModel {string}")
	public void user_add_request_for_otp_login_along_with_login_id_otp_isd_code_device_type_os_version_app_version_and_device_model(
			String loginId, String otp, String isdCode, String deviceType, String osVersion, String appVersion,
			String deviceModel) throws FileNotFoundException, IOException {
		addReqBody(payloadManager.getLoginOtpPayload().addDetails(loginId, otp, isdCode, deviceType, osVersion,
				appVersion, deviceModel, getPropertyFileValue("firebaseToken")));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "LoginOtp URL is: " + getPropertyFileValue("LoginOtp"));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"Request_payload: loginId=" + loginId + ",deviceType=" + deviceType + ",osVersion=" + osVersion
						+ ",appVersion=" + appVersion + ",deviceModel" + deviceModel + ", firebaseToken"
						+ getPropertyFileValue("firebaseToken"));
	}

	@When("the user sends a valid Login Otp request with {string}")
	public void the_user_sends_a_valid_login_Otp_request_with(String post) throws IOException {

		addReqType(post, getPropertyFileValue("LoginOtp"));
	}

	@Then("Validate the OTP Generated having the response code as {int} and verify message {string} , loginId {string} , firstName {string} , lastName {string} , appName {string} and primaryUser {string}")
	public void validate_the_otp_generated_having_the_response_code_as_and_verify_message_login_id_first_name_last_name_app_name_and_primary_user(
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
//<---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

	@Then("Validate the Generated response code as {int} and verify message {string} , errorCode {int} and errorDescription {string}")
	public void validate_the_generated_response_code_as_and_verify_message_error_code_and_error_description(
			int expResponseCode, String expMessage, int expErrorCode, String expErrorDescription) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		pojo_External_Login_Otp.Verify_InvalidOtp_Root_Output_Pojo verifyInvalidOtp = getbody()
				.as(pojo_External_Login_Otp.Verify_InvalidOtp_Root_Output_Pojo.class);
		assertEquals(expResponseCode, getResponseCode(), "verify ResponseCode");
		assertEquals(expMessage, verifyInvalidOtp.message, "verify Msg");
		assertEquals(expErrorCode, verifyInvalidOtp.errorCode, "verify Msg");
		assertEquals(expErrorDescription, verifyInvalidOtp.errorDescription, "verify Msg");
		assertFalse(verifyInvalidOtp.success);
	}

//<------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------>
	@When("user add request for otpLogin along with loginId {string} ,otp {string} ,isdCode {string} ,deviceType {string} ,osVersion {string} ,appVersion {string} ,deviceModel {string} and specialfirebsetoken")
	public void user_add_request_for_otp_login_along_with_login_id_otp_isd_code_device_type_os_version_app_version_device_model_and_specialfirebsetoken(
			String loginId, String otp, String isdCode, String deviceType, String osVersion, String appVersion,
			String deviceModel) throws FileNotFoundException, IOException {
		addReqBody(payloadManager.getLoginOtpPayload().addDetails(loginId, otp, isdCode, deviceType, osVersion,
				appVersion, deviceModel, getPropertyFileValue("specialCharFirebaseToken")));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Login URL is: " + getPropertyFileValue("LoginOtp"));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"Request_payload: loginId=" + loginId + ",deviceType=" + deviceType + ",osVersion=" + osVersion
						+ ",appVersion=" + appVersion + ",deviceModel" + deviceModel + ", firebaseToken"
						+ getPropertyFileValue("specialCharFirebaseToken"));
	}

	// <------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------>
	@When("user add request for otpLogin along with loginId {string} ,otp {string} ,isdCode {string} ,deviceType {string} ,osVersion {string} ,appVersion {string} ,deviceModel {string} and blankfirebsetoken")
	public void user_add_request_for_otp_login_along_with_login_id_otp_isd_code_device_type_os_version_app_version_device_model_and_blankfirebsetoken(
			String loginId, String otp, String isdCode, String deviceType, String osVersion, String appVersion,
			String deviceModel) throws FileNotFoundException, IOException {
		addReqBody(payloadManager.getLoginOtpPayload().addDetails(loginId, otp, isdCode, deviceType, osVersion,
				appVersion, deviceModel, ""));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Login URL is: " + getPropertyFileValue("LoginOtp"));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"Request_payload: loginId=" + loginId + ",deviceType=" + deviceType + ",osVersion=" + osVersion
						+ ",appVersion=" + appVersion + ",deviceModel" + deviceModel + ", firebaseToken" + "");
	}

	// <--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
	@When("user add request Body for valid Empty Request Body")
	public void user_add_request_body_for_valid_empty_request_body() throws FileNotFoundException, IOException {
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Login URL is: " + getPropertyFileValue("LoginOtp"));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Request_payload is : Empty");
	}

	@Then("Validate response for Empty request Body status should be {string}")
	public void validate_response_for_empty_request_body_status_should_be(String expResponseCode) {
		System.out.println(getResponseCode());
		int responseCode = getResponseCode();
		String actualResponse = Integer.toString(responseCode);
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		assertEquals(expResponseCode, actualResponse, "verify ResponseCode");
	}

	// <--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
	@When("the user sends a valid Login Otp request with {string} and Invalid url {string}")
	public void the_user_sends_a_valid_login_otp_request_with_and_invalid_url(String post, String url) {
		addReqType(post, url);
	}

	@Then("Validate the response code as {int} and verify message {string}")
	public void validate_the_response_code_as_and_verify_message(int expResponsecode, String expMessage) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		
		Root_InvalidUrl_Output_Pojo output_Pojo = getbody().as(Root_InvalidUrl_Output_Pojo.class);
		assertEquals(expMessage, output_Pojo.message, "verify message");
		assertEquals(expResponsecode, getResponseCode(), "verify response code");
	
	}
	// <-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
}
