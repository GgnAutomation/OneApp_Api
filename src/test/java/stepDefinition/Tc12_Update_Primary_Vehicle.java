package stepDefinition;

import static org.testng.Assert.assertEquals;

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
import pojo_UpdatePrimayVehicle.Valid_Vin_Id_Root_Output;

public class Tc12_Update_Primary_Vehicle extends BaseClass {

	PayloadManager payloadManager = new PayloadManager();

	@Given("the login API is available and add headers and access token for update primary vehicle")
	public void the_login_api_is_available_and_add_headers_and_access_token_for_update_primary_vehicle()
			throws FileNotFoundException, IOException {

		RestAssured.registerParser("text/plain", Parser.JSON);
		List<Header> list_headers = new ArrayList<>();
		Header h1 = new Header("appid", "External");
		Header h2 = new Header("specificAppId", "OneApp");
		Header h3 = new Header("ocp-apim-subscription-key", "2b6bbec34ce14a32b968411d7956e24c");
		Header h4 = new Header("Authorization", "Bearer " + getPropertyFileValue("UpdatePrimaryVehicleToken"));
		list_headers.add(h1);
		list_headers.add(h2);
		list_headers.add(h3);
		list_headers.add(h4);
		Headers headers = new Headers(list_headers);
		addHeaders(headers);
	}

	@When("user add requestBody with customer Identifier {string} and Vin Id {string} for update primary vehicle")
	public void user_add_request_body_with_customer_identifier_and_vin_id_for_update_primary_vehicle(String customerId,
			String VinId) throws FileNotFoundException, IOException {
		addReqBody(payloadManager.getUpdate_Primary_Vehicle().addDetails(VinId, customerId));

		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"update primary vehicle URL is: " + getPropertyFileValue("UpdatePrimaryvehicle"));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"Request_payload: VinId=" + VinId + ",Customer Identifier=" + customerId);
	}

	@When("the user sends update primary vehicle request with {string}")
	public void the_user_sends_update_primary_vehicle_request_with(String post)
			throws FileNotFoundException, IOException {

		addReqType(post, getPropertyFileValue("UpdatePrimaryvehicle"));
	}

	@Then("the response status for update primary vehicle should be {int} and message {string} ,isPrimaryVehicle is {string} and updatedmessage {string}")
	public void the_response_status_for_update_primary_vehicle_should_be_and_message_is_primary_vehicle_is_and_updatedmessage(
			int expResponseCode, String expMessage, String expIsPrimaryVehicle, String expUpdatedMessage) {

		System.out.print(getbody().asPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		Valid_Vin_Id_Root_Output root_Output = getbody().as(Valid_Vin_Id_Root_Output.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, root_Output.message, "verify message");
		assertEquals(expIsPrimaryVehicle, root_Output.data.isPrimaryVehicle, "verify primary value");
		assertEquals(expUpdatedMessage, root_Output.data.message, "verify updated message");

	}

//<------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->	

	@Then("the response status for update primary vehicle should be {int} and message {string} , errorCode {int} and errorDescription {string}")
	public void the_response_status_for_update_primary_vehicle_should_be_and_message_error_code_and_error_description(
			int expResponseCode, String expMessage, int experrorCode, String expErrorDescription) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());

		In_Valid_Customer_Identifer_Root_Output Root_Output = getbody()
				.as(In_Valid_Customer_Identifer_Root_Output.class);
			assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, Root_Output.message, "verify message");
		assertEquals(experrorCode, Root_Output.errorCode, "verify Error code");
		assertEquals(expErrorDescription, Root_Output.errorDescription, "verify Error Decsription");
	}

//<---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->	

	@Then("the response status for update primary vehicle should be {int} and message {string} , errorCode {int}")
	public void the_response_status_for_update_primary_vehicle_should_be_and_message_error_code(int expResponseCode,
			String expMessage, int expErrorCode) {

		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		Invalid_Customer_Identifier_Root_Output Root_Output = getbody()
				.as(Invalid_Customer_Identifier_Root_Output.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, Root_Output.message, "verify message");
		assertEquals(expErrorCode, Root_Output.errorCode, "verify is Error code");
	}

	// <-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

	@Given("the login API is available and add headers and Blank access token for update primary vehicle")
	public void the_login_api_is_available_and_add_headers_and_blank_access_token_for_update_primary_vehicle()
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

	// <---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

	@When("the user sends update primary vehicle  for invalid url request with {string} and url {string}")
	public void the_user_sends_update_primary_vehicle_for_invalid_url_request_with_and_url(String post,
			String invalidUrl) {

		addReqType(post, invalidUrl);
	}

	@Then("the response status for update primary vehicle should be {int} ,message {string} and errorCode {string}")
	public void the_response_status_for_update_primary_vehicle_should_be_message_and_error_code(int expResponseCode,
			String expMessage, String expErrorCode) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		Root_InvalidUrl_Output_Pojo invalid_url_Root_Output = getbody().as(Root_InvalidUrl_Output_Pojo.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, invalid_url_Root_Output.message, "verify message");
		assertEquals(expErrorCode, invalid_url_Root_Output.statusCode, "verify status code");
	}

	// <---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

	@Then("the response status for update primary vehicle for empty request body should be {int}")
	public void the_response_status_for_update_primary_vehicle_for_empty_request_body_should_be(int expResponseCode) {

		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());

		assertEquals(expResponseCode, getResponseCode(), "verify response code");

	}
	// <---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

}
