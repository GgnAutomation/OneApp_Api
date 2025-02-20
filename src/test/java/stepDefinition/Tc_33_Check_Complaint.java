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
import pojo_Check_Complaints.Check_Complaint_Root_Output;
import pojo_Get_External_Cust_Details.In_Valid_Customer_Identifer_Root_Output;

public class Tc_33_Check_Complaint extends BaseClass {

	PayloadManager payloadManager = new PayloadManager();

	@Given("the login API is available and add headers and access token for Check Complaint")
	public void the_login_api_is_available_and_add_headers_and_access_token_for_check_complaint()
			throws FileNotFoundException, IOException {

		RestAssured.registerParser("text/plain", Parser.JSON);
		List<Header> list_headers = new ArrayList<>();
		Header h1 = new Header("appid", "External");
		Header h2 = new Header("specificAppId", "OneApp");
		Header h3 = new Header("ocp-apim-subscription-key", "2b6bbec34ce14a32b968411d7956e24c");
		Header h4 = new Header("Authorization", "Bearer " + getPropertyFileValue("checkComplaintToken"));
		list_headers.add(h1);
		list_headers.add(h2);
		list_headers.add(h3);
		list_headers.add(h4);
		Headers headers = new Headers(list_headers);
		addHeaders(headers);

	}

	@When("user add requestBody with Vin Id {string} for Check Complaint")
	public void user_add_request_body_with_vin_id_for_check_complaint(String vinId)
			throws FileNotFoundException, IOException {
		addReqBody(payloadManager.getCheckComplaint_Payload().addDetails(vinId));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"checkComplaint url is: " + getPropertyFileValue("checkComplaint"));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Request_payload: VinId=" + vinId);

	}

	@When("the user sends Check Complaint request with {string}")
	public void the_user_sends_check_complaint_request_with(String post) throws FileNotFoundException, IOException {
		addReqType(post, getPropertyFileValue("checkComplaint"));
	}

	@Then("the response status for Check Complaint should be {int} and message {string} and statusCode {string}")
	public void the_response_status_for_check_complaint_should_be_and_message_and_status_code(int expResponseCode,
			String expMessage, String expStatusCode) {

		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		Check_Complaint_Root_Output root_Output = getbody().as(Check_Complaint_Root_Output.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, root_Output.message, "verify message");
		assertEquals(expStatusCode, root_Output.statusCode, "verify statusCode");
	}
	// <-------------------------------------------------------------------------------------------------------------------------------------------->

	@Then("the response status for Check Complaint should be {int} and message {string} ,errorCode {int} and errorDescription {string}")
	public void the_response_status_for_check_complaint_should_be_and_message_error_code_and_error_description(
			Integer expResponseCode, String expMessage, Integer experrorCode, String expErrorDescription) {
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
	// <--------------------------------------------------------------------------------------------------------------------------------------------------->

	@When("the user sends request {string} for check complaint with invalid url {string}")
	public void the_user_sends_request_for_check_complaint_with_invalid_url(String post, String url) {
		addReqType(post, url);
	}

	@Then("the response status for check complaint should be {int} ,message {string} and errorCode {string}")
	public void the_response_status_for_check_complaint_should_be_message_and_error_code(int expResponseCode,
			String expMessage, String expErrorCode) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		Root_InvalidUrl_Output_Pojo invalid_url_Root_Output = getbody().as(Root_InvalidUrl_Output_Pojo.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, invalid_url_Root_Output.message, "verify message");
		assertEquals(expErrorCode, invalid_url_Root_Output.statusCode, "verify status code");
	}

	// <--------------------------------------------------------------------------------------------------------------------------------------------------------->
	@Then("the response status in check complaint for empty request body should be {int}")
	public void the_response_status_in_check_complaint_for_empty_request_body_should_be(int expResponseCode) {
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
	}
	// <---------------------------------------------------------------------------------------------------------------------------------------------------------->

}
