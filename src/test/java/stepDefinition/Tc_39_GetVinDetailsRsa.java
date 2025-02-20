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
import pojo_GetVinDetailsForRsa.GetVinDetailsForRsa_InvalidKey;
import pojo_GetVinDetailsForRsa.GetVinDetailsForRsa_Root_Output;
import pojo_Get_External_Cust_Details.In_Valid_Customer_Identifer_Root_Output;

public class Tc_39_GetVinDetailsRsa extends BaseClass {

	PayloadManager payloadManager = new PayloadManager();

	@Given("the login API is available and add headers and access token for get vehicle details for Rsa")
	public void the_login_api_is_available_and_add_headers_and_access_token_for_get_vehicle_details_for_rsa()
			throws FileNotFoundException, IOException {

		RestAssured.registerParser("text/plain", Parser.JSON);
		List<Header> list_headers = new ArrayList<>();
		Header h1 = new Header("appid", "External");
		Header h2 = new Header("specificAppId", "OneApp");
		Header h3 = new Header("ocp-apim-subscription-key", "2b6bbec34ce14a32b968411d7956e24c");
		Header h4 = new Header("Authorization", "Bearer " + getPropertyFileValue("GetVinDetailsRsaToken"));
		list_headers.add(h1);
		list_headers.add(h2);
		list_headers.add(h3);
		list_headers.add(h4);
		Headers headers = new Headers(list_headers);
		addHeaders(headers);

	}

	@When("user add requestBody with loginId {string} ,searchType {string} and value {string} get vehicle details for Rsa")
	public void user_add_request_body_with_login_id_search_type_and_value_get_vehicle_details_for_rsa(String loginId,
			String searchType, String value) throws FileNotFoundException, IOException {
		addReqBody(payloadManager.getVinDetailsRsa_Payload().addDetails(loginId, searchType, value));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"GetVinDetailsRsa URL is: " + getPropertyFileValue("GetVinDetailsRsa"));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"Request_payload: loginId=" + loginId + ",searchType =" + searchType + ",value =" + value);

	}

	@When("the user sends get vehicle details for Rsa request with {string}")
	public void the_user_sends_get_vehicle_details_for_rsa_request_with(String post)
			throws FileNotFoundException, IOException {
		addReqType(post, getPropertyFileValue("GetVinDetailsRsa"));
	}

	@Then("the response status for get vehicle details for Rsa should be {int} ,message {string} ,regNo {string} ,vin {string} and model {string}")
	public void the_response_status_for_get_vehicle_details_for_rsa_should_be_message_reg_no_vin_and_model(
			int expResponseCode, String expMessage, String expRegNo, String expVin, String expModel) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());

		GetVinDetailsForRsa_Root_Output output = getbody().as(GetVinDetailsForRsa_Root_Output.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, output.message, "verify message");
		assertTrue(output.success);
		assertEquals(expRegNo, output.data.vehicleSearchList.get(0).regNo, "verify RegNo");
		assertEquals(expVin, output.data.vehicleSearchList.get(0).vin, "verify Vin");
		assertEquals(expModel, output.data.vehicleSearchList.get(0).model, "verify model");
	}

	// <----------------------------------------------------------------------------------------------------------------------------------------------------------------------->
	@When("the user sends a request with {string} and invalid url {string} for get vehicle details for Rsa")
	public void the_user_sends_a_request_with_and_invalid_url_for_get_vehicle_details_for_rsa(String post, String url) {
		addReqType(post, url);
	}

	@Then("the response status for get vehicle details for Rsa should be {int} ,message {string} and errorCode {string}")
	public void the_response_status_for_get_vehicle_details_for_rsa_should_be_message_and_error_code(
			int expResponseCode, String expMessage, String expErrorCode) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		Root_InvalidUrl_Output_Pojo invalid_url_Root_Output = getbody().as(Root_InvalidUrl_Output_Pojo.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, invalid_url_Root_Output.message, "verify message");
		assertEquals(expErrorCode, invalid_url_Root_Output.statusCode, "verify status code");
	}
	// <--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

	@Then("the response status in get vehicle details for Rsa should be {int} message {string} ,errorCode {int} and errorDescription {string}")
	public void the_response_status_in_get_vehicle_details_for_rsa_should_be_message_error_code_and_error_description(
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

	// <------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------>
	@Then("the response status for get vehicle details for Rsa should be {int} and message {string}")
	public void the_response_status_for_get_vehicle_details_for_rsa_should_be_and_message(int expResponseCode,
			String expMessage) {
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, getResBodyAsPrettyString(), "verify message");
	}
	// <----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

	@Given("the login API is available and adding headers with invalid key and access token for get vehicle details for Rsa")
	public void the_login_api_is_available_and_adding_headers_with_invalid_key_and_access_token_for_get_vehicle_details_for_rsa()
			throws FileNotFoundException, IOException {

		RestAssured.registerParser("text/plain", Parser.JSON);
		List<Header> list_headers = new ArrayList<>();
		Header h1 = new Header("appid", "External");
		Header h2 = new Header("specificAppId", "OneApp");
		Header h3 = new Header("ocp-apim-subscription-key", "2b6bbec34ce14a32b96841112345679");
		Header h4 = new Header("Authorization", "Bearer " + getPropertyFileValue("GetVinDetailsRsaToken"));
		list_headers.add(h1);
		list_headers.add(h2);
		list_headers.add(h3);
		list_headers.add(h4);
		Headers headers = new Headers(list_headers);
		addHeaders(headers);

	}

	@Then("the response status in get vehicle details for Rsa should be statusCode {int} and message {string}")
	public void the_response_status_in_get_vehicle_details_for_rsa_should_be_status_code_and_message(
			int expResponseCode, String expMessage) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		GetVinDetailsForRsa_InvalidKey invalidKey = getbody().as(GetVinDetailsForRsa_InvalidKey.class);
		assertEquals(expMessage, invalidKey.message, "verify message");
		assertEquals(expResponseCode, invalidKey.statusCode, "verify statusCode");
	}
	// <-------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

	@Given("the login API is available and adding headers with invalid AppId and access token for get vehicle details for Rsa")
	public void the_login_api_is_available_and_adding_headers_with_invalid_app_id_and_access_token_for_get_vehicle_details_for_rsa()
			throws FileNotFoundException, IOException {

		RestAssured.registerParser("text/plain", Parser.JSON);
		List<Header> list_headers = new ArrayList<>();
		Header h1 = new Header("appid", "Application");
		Header h2 = new Header("specificAppId", "OneApp");
		Header h3 = new Header("ocp-apim-subscription-key", "2b6bbec34ce14a32b968411d7956e24c");
		Header h4 = new Header("Authorization", "Bearer " + getPropertyFileValue("GetVinDetailsRsaToken"));
		list_headers.add(h1);
		list_headers.add(h2);
		list_headers.add(h3);
		list_headers.add(h4);
		Headers headers = new Headers(list_headers);
		addHeaders(headers);
	}
	// <---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

	@Given("the login API is available and adding headers with invalid specific AppId and access token for get vehicle details for Rsa")
	public void the_login_api_is_available_and_adding_headers_with_invalid_specific_app_id_and_access_token_for_get_vehicle_details_for_rsa() throws FileNotFoundException, IOException {
		RestAssured.registerParser("text/plain", Parser.JSON);
		List<Header> list_headers = new ArrayList<>();
		Header h1 = new Header("appid", "External");
		Header h2 = new Header("specificAppId", "One");
		Header h3 = new Header("ocp-apim-subscription-key", "2b6bbec34ce14a32b968411d7956e24c");
		Header h4 = new Header("Authorization", "Bearer " + getPropertyFileValue("GetVinDetailsRsaToken"));
		list_headers.add(h1);
		list_headers.add(h2);
		list_headers.add(h3);
		list_headers.add(h4);
		Headers headers = new Headers(list_headers);
		addHeaders(headers);
	}
	//<-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
}
