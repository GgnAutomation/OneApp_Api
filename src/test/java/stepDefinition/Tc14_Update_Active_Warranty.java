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
import pojo_Get_External_Cust_Details.In_Valid_Customer_Identifer_Root_Output;
import pojo_Get_External_Cust_Details.Invalid_Customer_Identifier_Root_Output;
import pojo_Update_Active_Warranty.Update_Active_Warranty_Root_Ouput;

public class Tc14_Update_Active_Warranty extends BaseClass {
	PayloadManager payloadManager = new PayloadManager();

	@Given("the login API is available and add headers and access token for update Active Warranty")
	public void the_login_api_is_available_and_add_headers_and_access_token_for_update_active_warranty()
			throws FileNotFoundException, IOException {
		RestAssured.registerParser("text/plain", Parser.JSON);
		List<Header> list_headers = new ArrayList<>();
		Header h1 = new Header("appid", "External");
		Header h2 = new Header("specificAppId", "OneApp");
		Header h3 = new Header("ocp-apim-subscription-key", "2b6bbec34ce14a32b968411d7956e24c");
		Header h4 = new Header("Authorization", "Bearer " + getPropertyFileValue("updateActiveWarrentyToken"));
		list_headers.add(h1);
		list_headers.add(h2);
		list_headers.add(h3);
		list_headers.add(h4);
		Headers headers = new Headers(list_headers);
		addHeaders(headers);

	}

	@When("user add requestBody with valid customer Identifier {string} ,Vin Id {string} and Is warranty as {string} for update Active Warranty")
	public void user_add_request_body_with_valid_customer_identifier_vin_id_and_is_warranty_as_for_update_active_warranty(
			String updateActiveWarrentyId, String VinId, String isWarranty) throws FileNotFoundException, IOException {
		addReqBody(payloadManager.get_Active_Warranty_Payload().addDetails(VinId, updateActiveWarrentyId, isWarranty));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"update Active Warranty is: " + getPropertyFileValue("updateActiveWarrenty"));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Request_payload: VinId=" + VinId
				+ ",Customer Identifier=" + updateActiveWarrentyId + ",IsWarranty=" + isWarranty);
	}

	@When("the user sends update Active Warranty request with {string}")
	public void the_user_sends_update_active_warranty_request_with(String post)
			throws FileNotFoundException, IOException {

		addReqType(post, getPropertyFileValue("updateActiveWarrenty"));
	}

	@Then("the response status for update Active Warranty should be {int} and message {string} , vin Id {string} , updated message {string} and is warranty {string}")
	public void the_response_status_for_update_active_warranty_should_be_and_message_vin_id_updated_message_and_is_warranty(
			int expResponseCode, String expMessage, String expVinid, String expUpdatedMsg, String expIsWarranty) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		Update_Active_Warranty_Root_Ouput output = getbody().as(Update_Active_Warranty_Root_Ouput.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, output.message, "verify message");
		assertEquals(expUpdatedMsg, output.data.message, "verify updated message");
		assertEquals(expVinid, output.data.vinId, "verify vin Id");
		assertEquals(expIsWarranty, output.data.isWarrantyActive, "verify isWarranty value");
	}
	// <---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

	@Then("the response status for update Active Warranty should be {int} and message {string} ,errorCode {int} and errorDescription {string}")
	public void the_response_status_for_update_active_warranty_should_be_and_message_error_code_and_error_description(
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
//<-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

	@Then("the response status for update Active Warranty should be {int} and message {string} , errorCode {int}")
	public void the_response_status_for_update_active_warranty_should_be_and_message_error_code(int expResponseCode,
			String expMessage, int expStatusCode) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		Invalid_Customer_Identifier_Root_Output root_Output = getbody()
				.as(Invalid_Customer_Identifier_Root_Output.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, root_Output.message, "verify message");
		assertEquals(expStatusCode, root_Output.errorCode, "verify Status code");
		assertFalse(root_Output.success);
	}

	// <----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
	@When("the user sends update vehicle Active Warranty request with {string} and url {string}")
	public void the_user_sends_update_vehicle_active_warranty_request_with_and_url(String post, String url) {
		addReqType(post, url);
	}

	@Then("the response status for update Active Warranty should be {int} ,message {string} and errorCode {string}")
	public void the_response_status_for_update_active_warranty_should_be_message_and_error_code(int expResponseCode,
			String expMessage, String expErrorCode) {

		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		Root_InvalidUrl_Output_Pojo invalid_url_Root_Output = getbody().as(Root_InvalidUrl_Output_Pojo.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, invalid_url_Root_Output.message, "verify message");
		assertEquals(expErrorCode, invalid_url_Root_Output.statusCode, "verify status code");
	}
	// <--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

	@Then("the response status for update Active Warranty for empty request body should be {int}")
	public void the_response_status_for_update_active_warranty_for_empty_request_body_should_be(int expResponseCode) {

		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());

	}
	//<------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------>
}
