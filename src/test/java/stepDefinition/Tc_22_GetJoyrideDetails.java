package stepDefinition;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNull;
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
import pojoClass_ExternalLogin.Root_InvalidUrl_Output_Pojo;
import pojo_GetJoyRideDetails.GetJoyRideDetails_Root_Output;
import pojo_Get_External_Cust_Details.In_Valid_Customer_Identifer_Root_Output;

public class Tc_22_GetJoyrideDetails extends BaseClass {

	PayloadManager payloadManager = new PayloadManager();

	@Given("the login API is available and add headers for GetJoyRideDetails")
	public void the_login_api_is_available_and_add_headers_for_get_joy_ride_details() {
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

	@When("user add requestBody with VinNo {string} for GetJoyRideDetails")
	public void user_add_request_body_with_vin_no_for_get_joy_ride_details(String vinNo)
			throws FileNotFoundException, IOException {
		addReqBody(payloadManager.getJoyrideDetails_Payload().addDetails(vinNo));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"GetJoyrideDetails URL is: " + getPropertyFileValue("GetJoyrideDetails"));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Request_payload: vinNo=" + vinNo);

	}

	@When("the user sends a request with {string} for GetJoyRideDetails")
	public void the_user_sends_a_request_with_for_get_joy_ride_details(String post)
			throws FileNotFoundException, IOException {
		addReqType(post, getPropertyFileValue("GetJoyrideDetails"));
	}

	@Then("the response status for GetJoyRideDetails should be {int} ,message {string} ,amcBalance {string} ,amcExpiryDate {string} ,joyridePackageId {string} ,joyrideCardNumber {string} ,joyrideIssueDate {string} and connectedSimStatus {string}")
	public void the_response_status_for_get_joy_ride_details_should_be_message_amc_balance_amc_expiry_date_joyride_package_id_joyride_card_number_joyride_issue_date_and_connected_sim_status(
			int expResponseCode, String expMessage, String expAmcBalance, String expAmcExpiryDate,
			String expJoyridePackageId, String expJoyrideCardNumber, String expJoyrideIssueDate,
			String expConnectedSimStatus) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		GetJoyRideDetails_Root_Output output = getbody().as(GetJoyRideDetails_Root_Output.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, output.message, "verify message");
		assertEquals(expJoyridePackageId, output.data.joyridePackageId, "verify joyridePackageId");
		assertEquals(expJoyrideCardNumber, output.data.joyrideCardNumber, "verify joyrideCardNumber");
		assertEquals(expAmcExpiryDate, output.data.amcExpiryDate, "verify amcExpiryDate");
		assertEquals(expAmcBalance, output.data.amcBalance, "verify AmcBalance");
		assertEquals(expJoyrideIssueDate, output.data.joyrideIssueDate, "verify joyrideCardNumber");
		assertEquals(expConnectedSimStatus, output.data.connectedSimStatus, "verify connectedSimStatus");
		assertTrue(output.success);
	}
	// <--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

	@Then("the response status in GetJoyRideDetails should be {int} message {string} ,errorCode {int} and errorDescription {string}")
	public void the_response_status_in_get_joy_ride_details_should_be_message_error_code_and_error_description(
			int expResponseCode, String expMessage, int experrorCode, String expErrorDescription) {
		System.out.println(getResBodyAsPrettyString());
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

	// <------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------>
	@When("the user sends a request with {string} and invalid url {string} for GetJoyRideDetails")
	public void the_user_sends_a_request_with_and_invalid_url_for_get_joy_ride_details(String post, String url) {
		addReqType(post, url);
	}

	@Then("the response status for GetJoyRideDetails should be {int} ,message {string} and errorCode {string}")
	public void the_response_status_for_get_joy_ride_details_should_be_message_and_error_code(int expResponseCode,
			String expMessage, String expErrorCode) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		Root_InvalidUrl_Output_Pojo invalid_url_Root_Output = getbody().as(Root_InvalidUrl_Output_Pojo.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, invalid_url_Root_Output.message, "verify message");
		assertEquals(expErrorCode, invalid_url_Root_Output.statusCode, "verify status code");
	}
	// <-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

	@Then("the response status for GetJoyRideDetails should be {int} ,message {string} and connectedSimStatus {string}")
	public void the_response_status_for_get_joy_ride_details_should_be_message_and_connected_sim_status(
			int expResponseCode, String expMessage, String expConnectedSimStatus) {
		System.out.println(getResBodyAsPrettyString());

		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());

		GetJoyRideDetails_Root_Output output = getbody().as(GetJoyRideDetails_Root_Output.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, output.message, "verify message");
		assertEquals(expConnectedSimStatus, output.data.connectedSimStatus, "verify connectedSimStatus");
		assertTrue(output.success);
	}
	// <------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

	@Then("the response status for GetJoyRideDetails should be {int} ,message {string} and amcBalance is null")
	public void the_response_status_for_get_joy_ride_details_should_be_message_and_amc_balance_is_null(
			int expResponseCode, String expMessage) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		GetJoyRideDetails_Root_Output output = getbody().as(GetJoyRideDetails_Root_Output.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, output.message, "verify message");
		assertNull(output.data.amcBalance);
	}

//<-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
	@Then("the response status for GetJoyRideDetails should be {int} ,message {string} and amcBalance {string}")
	public void the_response_status_for_get_joy_ride_details_should_be_message_and_amc_balance(int expResponseCode,
			String expMessage, String expAmcBalance) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		GetJoyRideDetails_Root_Output output = getbody().as(GetJoyRideDetails_Root_Output.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, output.message, "verify message");
		assertEquals(expAmcBalance, output.data.amcBalance, "verify expAmcBalance");
	}
	// <--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

	@Then("the response status for GetJoyRideDetails should be {int} ,message {string} and amcExpiryDate {string}")
	public void the_response_status_for_get_joy_ride_details_should_be_message_and_amc_expiry_date(int expResponseCode,
			String expMessage, String expAmcExpiryDate) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		GetJoyRideDetails_Root_Output output = getbody().as(GetJoyRideDetails_Root_Output.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, output.message, "verify message");
		assertEquals(expAmcExpiryDate, output.data.amcExpiryDate, "verify AmcExpiryDate");
	}
	// <-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

	@Then("the response status for GetJoyRideDetails should be {int} ,message {string} ,joyridePackageId is null")
	public void the_response_status_for_get_joy_ride_details_should_be_message_joyride_package_id_is_null(
			int expResponseCode, String expMessage) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		GetJoyRideDetails_Root_Output output = getbody().as(GetJoyRideDetails_Root_Output.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, output.message, "verify message");
		assertNull(output.data.joyridePackageId);
	}
	// <---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

	@Then("the response status for GetJoyRideDetails should be {int} ,message {string} ,joyrideCardNumber is null")
	public void the_response_status_for_get_joy_ride_details_should_be_message_joyride_card_number_is_null(
			int expResponseCode, String expMessage) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		GetJoyRideDetails_Root_Output output = getbody().as(GetJoyRideDetails_Root_Output.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, output.message, "verify message");
		assertNull(output.data.joyrideCardNumber);
	}
	// <------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------>

	@Then("the response status for GetJoyRideDetails should be {int} ,message {string} ,joyrideIssueDate is null")
	public void the_response_status_for_get_joy_ride_details_should_be_message_joyride_issue_date_is_null(
			int expResponseCode, String expMessage) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		GetJoyRideDetails_Root_Output output = getbody().as(GetJoyRideDetails_Root_Output.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, output.message, "verify message");
		assertNull(output.data.joyrideIssueDate);
	}
	// <------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

	@Then("the response status for GetJoyRideDetails should be {int} ,message {string} ,joyrideCardNumber is {string}")
	public void the_response_status_for_get_joy_ride_details_should_be_message_joyride_card_number_is(
			int expResponseCode, String expMessage, String expJoyrideCardNumber) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		GetJoyRideDetails_Root_Output output = getbody().as(GetJoyRideDetails_Root_Output.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, output.message, "verify message");
		assertEquals(expJoyrideCardNumber, output.data.joyrideCardNumber, "verify joyrideCardNumber");
	}
	// <--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

	@Then("the response status for GetJoyRideDetails should be {int} ,message {string} ,joyrideIssueDate is {string}")
	public void the_response_status_for_get_joy_ride_details_should_be_message_joyride_issue_date_is(int expResponseCode, String expMessage, String expJoyrideIssueDate) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		GetJoyRideDetails_Root_Output output = getbody().as(GetJoyRideDetails_Root_Output.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, output.message, "verify message");
		assertEquals(expJoyrideIssueDate, output.data.joyrideIssueDate, "verify joyrideIssueDate");
	}
	//<----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
}
