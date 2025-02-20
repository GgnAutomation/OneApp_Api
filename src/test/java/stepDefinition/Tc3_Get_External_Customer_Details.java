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
import pojo_Get_External_Cust_Details.Get_External_Customer_Detail_Root_Ouput;
import pojo_Get_External_Cust_Details.In_Valid_Customer_Identifer_Root_Output;
import pojo_Get_External_Cust_Details.Invalid_Customer_Identifier_Root_Output;

public class Tc3_Get_External_Customer_Details extends BaseClass {

	PayloadManager payloadManager = new PayloadManager();

	@Given("the login API is available and add headers and access token for get external customer detail")
	public void the_login_api_is_available_and_add_headers_and_access_token_for_get_external_customer_detail()
			throws FileNotFoundException, IOException {
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

	@When("user add requestBody with customer Identifier with short for get external customer detail")
	public void user_add_request_body_with_customer_identifier_with_short_for_get_external_customer_detail()
			throws FileNotFoundException, IOException {

		addReqBody(payloadManager.Get_External_Cust_Details_Payload()
				.addDetails(getPropertyFileValue("shortCustomerIdentifier")));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"GetCustomer Detail list URL is: " + getPropertyFileValue("GetExternalCustomerDetails"));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"Request_payload: CustomerIdentifier=" + getPropertyFileValue("shortCustomerIdentifier"));
	}

	@When("the user sends a request with {string} for get external customer detail")
	public void the_user_sends_a_request_with_for_get_external_customer_detail(String post)
			throws FileNotFoundException, IOException {
		addReqType(post, getPropertyFileValue("GetExternalCustomerDetails"));
	}

	@Then("the response status for Invalid customer identifier for get external customer detail should be {int} and message {string} and errorCode {int}")
	public void the_response_status_for_invalid_customer_identifier_for_get_external_customer_detail_should_be_and_message_and_error_code(
			int expResponseCode, String expMessage, int expStatusCode) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());

		Invalid_Customer_Identifier_Root_Output Root_Output = getbody()
				.as(Invalid_Customer_Identifier_Root_Output.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, Root_Output.message, "verify message");
		assertEquals(expStatusCode, Root_Output.errorCode, "verify Status code");
		assertFalse(Root_Output.success);
	}

	// <------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
	@When("user add requestBody with customer Identifier with long for get external customer detail")
	public void user_add_request_body_with_customer_identifier_with_long_for_get_external_customer_detail()
			throws FileNotFoundException, IOException {
		addReqBody(payloadManager.Get_External_Cust_Details_Payload()
				.addDetails(getPropertyFileValue("LongCustomerIdentifier")));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"GetCustomer Detail list URL is: " + getPropertyFileValue("GetExternalCustomerDetails"));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"Request_payload: CustomerIdentifier=" + getPropertyFileValue("LongCustomerIdentifier"));
	}

	@Then("the response status for Invalid customer identifier for get external customer detail should be {int} and message {string} , errorCode {int} and errorDescription {string}")
	public void the_response_status_for_invalid_customer_identifier_for_get_external_customer_detail_should_be_and_message_error_code_and_error_description(
			int expResponseCode, String expMessage, int expErrorCode, String expErrorDescription) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());

		In_Valid_Customer_Identifer_Root_Output Root_Output = getbody()
				.as(In_Valid_Customer_Identifer_Root_Output.class);
		assertFalse(Root_Output.success);
		assertEquals(getResponseCode(), expResponseCode, "verify Responsecode");
		assertEquals(Root_Output.message, expMessage, "verify message");
		assertEquals(Root_Output.errorCode, expErrorCode, "verify errorCode");
		assertEquals(Root_Output.errorDescription, expErrorDescription, "verify errorDescription");

	}
//<------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------>

	@When("user add requestBody with valid customerIdentifier for get external customer detail")
	public void user_add_request_body_with_valid_customer_identifier_for_get_external_customer_detail()
			throws FileNotFoundException, IOException {
		addReqBody(payloadManager.Get_External_Cust_Details_Payload()
				.addDetails(getPropertyFileValue("GetExternalCustIdentifier")));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"GetCustomer Detail list URL is: " + getPropertyFileValue("GetExternalCustomerDetails"));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"Request_payload: CustomerIdentifier=" + getPropertyFileValue("GetExternalCustIdentifier"));
	}

	@Then("the response status for valid customer identifier for get external customer detail should be {int} ,message {string},lastName {string},firstName {string},email {string},birthDate {string},mobileNo {string},id {string},name {string} ,relation {string} and mobile {string},")
	public void the_response_status_for_valid_customer_identifier_for_get_external_customer_detail_should_be_message_last_name_first_name_email_birth_date_mobile_no_id_name_relation_and_mobile(
			int expResponseCode, String expMessage, String expLastName, String expFirstName, String expEmail,
			String expBirthDate, String expMobileNo, String expId, String expName, String expRelation,
			String expRelationNo) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"Response Status code is: " + getbody().asPrettyString());

		Get_External_Customer_Detail_Root_Ouput output = getbody().as(Get_External_Customer_Detail_Root_Ouput.class);

		assertEquals(getResponseCode(), expResponseCode, "verify response code");
		assertEquals(expMessage, output.message, "verify message");
		assertEquals(expLastName, output.data.profile.lastName, "verify last name");
		assertEquals(expFirstName, output.data.profile.firstName, "verify first name");
		assertEquals(expEmail, output.data.profile.email, "verify email");
		assertEquals(expBirthDate, output.data.profile.birthDate, "verify birthDate");
		assertEquals(expMobileNo, output.data.profile.mobileNo, "verify message");
		assertEquals(expId, output.data.emergency.get(0).id, "verify Id");
		assertEquals(expName, output.data.emergency.get(0).name, "verify relation name");
		assertEquals(expRelation, output.data.emergency.get(0).relation, "verify relation type");
		assertEquals(expRelationNo, output.data.emergency.get(0).mobile, "verify relation number");
	}
	// <--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

	@When("user add requestBody with Invalid customer Identifier for get external customer detail")
	public void user_add_request_body_with_invalid_customer_identifier_for_get_external_customer_detail()
			throws FileNotFoundException, IOException {
		addReqBody(payloadManager.Get_External_Cust_Details_Payload()
				.addDetails(getPropertyFileValue("InvalidCustomerIdentifier")));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"GetCustomer Detail list URL is: " + getPropertyFileValue("GetExternalCustomerDetails"));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"Request_payload: CustomerIdentifier=" + getPropertyFileValue("InvalidCustomerIdentifier"));
	}
	// <----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

	@When("user add requestBody with BlankIdentifier for get external customer detail")
	public void user_add_request_body_with_blank_identifier_for_get_external_customer_detail()
			throws FileNotFoundException, IOException {
		addReqBody(payloadManager.Get_External_Cust_Details_Payload().addDetails(""));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"GetCustomer Detail list URL is: " + getPropertyFileValue("GetExternalCustomerDetails"));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Request_payload: CustomerIdentifier=" + "Empty");
	}

	// <------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------>
	@Given("the login API is available and add headers and Invalid access token for get external customer detail")
	public void the_login_api_is_available_and_add_headers_and_invalid_access_token_for_get_external_customer_detail()
			throws FileNotFoundException, IOException {
		RestAssured.registerParser("text/plain", Parser.JSON);
		List<Header> list_headers = new ArrayList<>();
		Header h1 = new Header("appid", "External");
		Header h2 = new Header("specificAppId", "OneApp");
		Header h3 = new Header("ocp-apim-subscription-key", "2b6bbec34ce14a32b968411d7956e24c");
		Header h4 = new Header("Authorization", "Bearer " + getPropertyFileValue("InvalidToken"));
		list_headers.add(h1);
		list_headers.add(h2);
		list_headers.add(h3);
		list_headers.add(h4);
		Headers headers = new Headers(list_headers);
		addHeaders(headers);
	}

	// <------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
	@Given("the login API is available and add headers and Blank access token for get external customer detail")
	public void the_login_api_is_available_and_add_headers_and_blank_access_token_for_get_external_customer_detail() {
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

	@Then("the response status for blank token for get external customer detail should be {int} ,message {string} , errorCode {int} and errorDescription {string}")
	public void the_response_status_for_blank_token_for_get_external_customer_detail_should_be_message_error_code_and_error_description(
			int expResponseCode, String expMessage, int expErrorCode, String expErrorDescription) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());

		In_Valid_Customer_Identifer_Root_Output Root_Output = getbody()
				.as(In_Valid_Customer_Identifer_Root_Output.class);
		assertFalse(Root_Output.success);
		assertEquals(getResponseCode(), expResponseCode, "verify Responsecode");
		assertEquals(Root_Output.message, expMessage, "verify message");
		assertEquals(Root_Output.errorCode, expErrorCode, "verify errorCode");
		assertEquals(Root_Output.errorDescription, expErrorDescription, "verify errorDescription");
	}

	// <----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
	@When("the user sends a request with {string} and invalid url {string} for get external customer detail")
	public void the_user_sends_a_request_with_and_invalid_url_for_get_external_customer_detail(String post,
			String url) {
		addReqType(post, url);
	}

	@Then("the response status for get external customer detail should be {int} and message {string}")
	public void the_response_status_for_get_external_customer_detail_should_be_and_message(int expResponsecode,
			String expMessage) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());

		Root_InvalidUrl_Output_Pojo output_Pojo = getbody().as(Root_InvalidUrl_Output_Pojo.class);
		assertEquals(expMessage, output_Pojo.message, "verify message");
		assertEquals(expResponsecode, getResponseCode(), "verify response code");
	}

	// <----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
	@Then("the response status for get external customer detail for empty request body should be {string}")
	public void the_response_status_for_get_external_customer_detail_for_empty_request_body_should_be(
			String expResponseCode) {
		System.out.println(getResponseCode());
		int responseCode = getResponseCode();
		String actualResponse = Integer.toString(responseCode);
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		assertEquals(actualResponse, expResponseCode, "verify ResponseCode");
	}
//<---------------------------------------------------------------------------------------------------------------------->

}
