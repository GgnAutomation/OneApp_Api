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
import pojoClass_ExternalLogin.Root_InvalidUrl_Output_Pojo;
import pojo_GetDealerOffDays.GetDealerOffDays_Root_Output;
import pojo_Get_External_Cust_Details.In_Valid_Customer_Identifer_Root_Output;
import pojo_Get_External_Cust_Details.Invalid_Customer_Identifier_Root_Output;

public class Tc_31_GetDealerOffDays extends BaseClass {

	PayloadManager payloadManager = new PayloadManager();

	@Given("the login API is available and add headers for GetDealerOffDays")
	public void the_login_api_is_available_and_add_headers_for_get_dealer_off_days()
			throws FileNotFoundException, IOException {

		RestAssured.registerParser("text/plain", Parser.JSON);
		List<Header> list_headers = new ArrayList<>();
		Header h1 = new Header("appid", "External");
		Header h2 = new Header("specificAppId", "OneApp");
		Header h3 = new Header("ocp-apim-subscription-key", "2b6bbec34ce14a32b968411d7956e24c");
		Header h4 = new Header("Authorization", "Bearer " + getPropertyFileValue("GetDealerOffDaysToken"));
		list_headers.add(h1);
		list_headers.add(h2);
		list_headers.add(h3);
		list_headers.add(h4);
		Headers headers = new Headers(list_headers);
		addHeaders(headers);
	}

	@When("user add requestBody with customerIdentifier {string} and divisionName {string} for GetDealerOffDays")
	public void user_add_request_body_with_customer_identifier_and_division_name_for_get_dealer_off_days(
			String customerIdentifier, String divisionName) throws FileNotFoundException, IOException {

		addReqBody(payloadManager.getDealerOffDays_Payload().addDetails(customerIdentifier, divisionName));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"GetDealerOffDays URL is: " + getPropertyFileValue("GetDealerOffDays"));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"Request_payload: customerIdentifier=" + customerIdentifier + ", divisionName= " + divisionName);

	}

	@When("the user sends a request with {string} for GetDealerOffDays")
	public void the_user_sends_a_request_with_for_get_dealer_off_days(String post)
			throws FileNotFoundException, IOException {
		addReqType(post, getPropertyFileValue("GetDealerOffDays"));
	}

	@Then("the response status for GetDealerOffDays should be {int} ,message {string} ,divisionName {string} ,weekOff {string} and additionalOffDays {string}")
	public void the_response_status_for_get_dealer_off_days_should_be_message_division_name_week_off_and_additional_off_days(
			int expResponseCode, String expMessage, String expDivisionName, String expweekOff,
			String additionalOffDays) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());

		GetDealerOffDays_Root_Output output = getbody().as(GetDealerOffDays_Root_Output.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, output.message, "verify message");
		assertEquals(expDivisionName, output.data.divisionName, "verify divisionName");
		assertTrue(output.data.weekOff.contains(expweekOff), "verify weekOff");
		assertTrue(output.data.additionalOffDays.contains(additionalOffDays), "verify additionalOffDays");

	}
	// <--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

	@Then("the response status for GetDealerOffDays should be {int} ,message {string} and errorCode {int}")
	public void the_response_status_for_get_dealer_off_days_should_be_message_and_error_code(int expResponseCode,
			String expMessage, int expErrorCode) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());

		Invalid_Customer_Identifier_Root_Output root_Output = getbody()
				.as(Invalid_Customer_Identifier_Root_Output.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, root_Output.message, "verify message");
		assertEquals(expErrorCode, root_Output.errorCode, "verify error code");
		assertFalse(root_Output.success);
	}
	// <------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------>

	@Then("the response status in GetDealerOffDays should be {int} message {string} ,errorCode {int} and errorDescription {string}")
	public void the_response_status_in_get_dealer_off_days_should_be_message_error_code_and_error_description(
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
	// <------------------------------------------------------------------------------------------------------------------------------------------------------------------->

	@When("the user sends a request with {string} and invalid url {string} for GetDealerOffDays")
	public void the_user_sends_a_request_with_and_invalid_url_for_get_dealer_off_days(String post, String url) {
		addReqType(post, url);
	}

	@Then("the response status for GetDealerOffDays should be {int} ,message {string} and errorCode {string}")
	public void the_response_status_for_get_dealer_off_days_should_be_message_and_error_code(int expResponseCode,
			String expMessage, String expErrorCode) {

		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		Root_InvalidUrl_Output_Pojo invalid_url_Root_Output = getbody().as(Root_InvalidUrl_Output_Pojo.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, invalid_url_Root_Output.message, "verify message");
		assertEquals(expErrorCode, invalid_url_Root_Output.statusCode, "verify status code");
	}
	// <-------------------------------------------------------------------------------------------------------------------------------------------------------------->

	@Then("the response status for GetDealerOffDays should be {int}")
	public void the_response_status_for_get_dealer_off_days_should_be(int expResponseCode) {

		System.out.println(getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		assertEquals(expResponseCode, getResponseCode(), "verify status code");
	}
	// <------------------------------------------------------------------------------------------------------------------------------------------------------------------>

	@Then("the response status for GetDealerOffDays should be {int} ,message {string} ,divisionName {string} and additionalOffDays {string}")
	public void the_response_status_for_get_dealer_off_days_should_be_message_division_name_and_additional_off_days(
			int expResponseCode, String expMessage, String expDivisionName, String additionalOffDays) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());

		GetDealerOffDays_Root_Output output = getbody().as(GetDealerOffDays_Root_Output.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, output.message, "verify message");
		assertEquals(expDivisionName, output.data.divisionName, "verify divisionName");
		assertTrue(output.data.additionalOffDays.contains(additionalOffDays), "verify additionalOffDays");
	}
	//<---------------------------------------------------------------------------------------------------------------------------------------------------------------------->
}
