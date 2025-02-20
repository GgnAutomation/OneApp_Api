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
import pojo_GetSrId.GetSrId_Root_Output;
import pojo_Get_External_Cust_Details.In_Valid_Customer_Identifer_Root_Output;
import pojo_Get_External_Cust_Details.Invalid_Customer_Identifier_Root_Output;

public class Tc16_Get_SrId extends BaseClass {

	PayloadManager payloadManager = new PayloadManager();

	@Given("the login API is available and add headers for GetSrId")
	public void the_login_api_is_available_and_add_headers_for_get_sr_id() throws FileNotFoundException, IOException {

		RestAssured.registerParser("text/plain", Parser.JSON);
		List<Header> list_headers = new ArrayList<>();
		Header h1 = new Header("appid", "External");
		Header h2 = new Header("specificAppId", "OneApp");
		Header h3 = new Header("ocp-apim-subscription-key", "2b6bbec34ce14a32b968411d7956e24c");
		Header h4 = new Header("Authorization", "Bearer " + getPropertyFileValue("getsrIdToken"));
		list_headers.add(h1);
		list_headers.add(h2);
		list_headers.add(h3);
		list_headers.add(h4);
		Headers headers = new Headers(list_headers);
		addHeaders(headers);
	}

	@When("user add requestBody with customerIdentifier {string} and srId {string} for GetSrId")
	public void user_add_request_body_with_customer_identifier_and_sr_id_for_get_sr_id(String SrId, String SrNo)
			throws FileNotFoundException, IOException {
		addReqBody(payloadManager.getSrId_Payload().addDetails(SrId, SrNo));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "GetSrId url is: " + getPropertyFileValue("GetSrId"));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"Request_payload: customerIdentifier = " + SrId + ",SrNo =" + SrNo);
	}

	@When("the user sends a request with {string} for GetSrId")
	public void the_user_sends_a_request_with_for_get_sr_id(String post) throws FileNotFoundException, IOException {
		addReqType(post, getPropertyFileValue("GetSrId"));
	}

	@Then("the response status for GetSrId should be {int} ,message {string} and srId {string}")
	public void the_response_status_for_get_sr_id_should_be_message_and_sr_id(int expResponseCode, String expMessage,
			String expSrId) {

		System.out.println(getbody().asPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		GetSrId_Root_Output root_Output = getbody().as(GetSrId_Root_Output.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertTrue(root_Output.success);
		assertEquals(expMessage, root_Output.message, "verify message");
		assertEquals(expSrId, root_Output.data.srId, "verify SrId");
	}
	// <---------------------------------------------------------------------------------------------------------------------------------------------------------------->

	@Then("the response status for GetSrId should be {int} ,message {string} and errorCode {int}")
	public void the_response_status_for_get_sr_id_should_be_message_and_error_code(int expResponseCode,
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

	// <------------------------------------------------------------------------------------------------------------------------------------------------------------------>

	@Then("the response status for GetSrId should be {int} ,message {string} ,errorCode {int} and errorDescription {string}")
	public void the_response_status_for_get_sr_id_should_be_message_error_code_and_error_description(
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

//<--------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
	@When("the user sends a request with {string} for GetSrId with invalid url {string}")
	public void the_user_sends_a_request_with_for_get_sr_id_with_invalid_url(String post, String url) {
		addReqType(post, url);
	}

	@Then("the response status for GetSrId should be {int} ,message {string} and errorCode {string}")
	public void the_response_status_for_get_sr_id_should_be_message_and_error_code(int expResponseCode,
			String expMessage, String expStatusCode) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		Root_InvalidUrl_Output_Pojo invalid_url_Root_Output = getbody().as(Root_InvalidUrl_Output_Pojo.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, invalid_url_Root_Output.message, "verify message");
		assertEquals(expStatusCode, invalid_url_Root_Output.statusCode, "verify status code");
	}

//<------------------------------------------------------------------------------------------------------------------------------------------------------------------>
	@Then("the response status in GetSrId for empty request body should be {int}")
	public void the_response_status_in_get_sr_id_for_empty_request_body_should_be(int expResponseCode) {
		System.out.println(getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Request payload: " + "");
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());

	}
//<-------------------------------------------------------------------------------------------------------------------------------------------------------------------->
}
