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
import pojo_Vin_Nickname.Nickname_Valid_VinID_Root_Ouput;

public class Tc13_Update_Vehicle_Nickname extends BaseClass {

	PayloadManager payloadManager = new PayloadManager();

	@Given("the login API is available and add headers and access token for update vehicle nickname")
	public void the_login_api_is_available_and_add_headers_and_access_token_for_update_vehicle_nickname()
			throws FileNotFoundException, IOException {

		RestAssured.registerParser("text/plain", Parser.JSON);
		List<Header> list_headers = new ArrayList<>();
		Header h1 = new Header("appid", "External");
		Header h2 = new Header("specificAppId", "OneApp");
		Header h3 = new Header("ocp-apim-subscription-key", "2b6bbec34ce14a32b968411d7956e24c");
		Header h4 = new Header("Authorization", "Bearer " + getPropertyFileValue("updateVehicleNicknameToken"));
		list_headers.add(h1);
		list_headers.add(h2);
		list_headers.add(h3);
		list_headers.add(h4);
		Headers headers = new Headers(list_headers);
		addHeaders(headers);
	}

	@When("user add requestBody with customer Identifier {string} ,Vin Id {string} and nickname {string} for update vehicle nickname")
	public void user_add_request_body_with_customer_identifier_vin_id_and_nickname_for_update_vehicle_nickname(
			String VinIdIdentifier, String VinId, String Nickname) throws FileNotFoundException, IOException {
		addReqBody(payloadManager.getNickname_Update().addDetails(VinId, VinIdIdentifier, Nickname));

		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"update vehicle nickname URL is: " + getPropertyFileValue("UpdateVehicleNickname"));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Request_payload: VinId=" + VinIdIdentifier
				+ ",Customer Identifier=" + VinId + ",Nickname=" + Nickname);
	}

	@When("the user sends update vehicle nickname request with {string}")
	public void the_user_sends_update_vehicle_nickname_request_with(String post)
			throws FileNotFoundException, IOException {

		addReqType(post, getPropertyFileValue("UpdateVehicleNickname"));
	}

	@Then("the response status for update vehicle nickname should be {int} and message {string} , vehicle nickname {string} and updated message {string}")
	public void the_response_status_for_update_vehicle_nickname_should_be_and_message_vehicle_nickname_and_updated_message(
			int expResponseCode, String expMessage, String expNickName, String expUpdatedMsg) {
		System.out.println(getbody().asPrettyString());

		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		Nickname_Valid_VinID_Root_Ouput root_Ouput = getbody().as(Nickname_Valid_VinID_Root_Ouput.class);

		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, root_Ouput.message, "verify message");
		assertEquals(expNickName, root_Ouput.data.vehicleNickName, "verify vehicle nickname");
		assertEquals(expUpdatedMsg, root_Ouput.data.message, "verify vehicle nickname updated message");
	}
//<------------------------------------------------------------------------------------------------------------------------------------------------------------------->	

	@Then("the response status for update vehicle nickname should be {int} and message {string} , errorCode {int} and errorDescription {string}")
	public void the_response_status_for_update_vehicle_nickname_should_be_and_message_error_code_and_error_description(
			int expResponseCode, String expMessage, int experrorCode, String expErrorDescription) {
		System.out.println(getResBodyAsString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());

		In_Valid_Customer_Identifer_Root_Output Root_Output = getbody()
				.as(In_Valid_Customer_Identifer_Root_Output.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, Root_Output.message, "verify message");
		assertEquals(experrorCode, Root_Output.errorCode, "verify Error code");
		assertEquals(expErrorDescription, Root_Output.errorDescription, "verify Error Decsription");

	}

//<------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------>	

	@When("user add requestBody with valid customer Identifier, valid nick name and BlankVinId for update vehicle nickname")
	public void user_add_request_body_with_valid_customer_identifier_valid_nick_name_and_blank_vin_id_for_update_vehicle_nickname()
			throws FileNotFoundException, IOException {

		addReqBody(payloadManager.getNickname_Update().addDetails("", getPropertyFileValue("validVinIdIdentifier"),
				getPropertyFileValue("Nickname")));

		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"update vehicle nickname URL is: " + getPropertyFileValue("UpdateVehicleNickname"));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Request_payload: VinId=" + "" + ",Customer Identifier="
				+ getPropertyFileValue("validVinIdIdentifier") + ",Nickname=" + getPropertyFileValue("Nickname"));

	}

	@Then("the response status for update vehicle nickname for blank vinId should be {int} and message {string} , errorCode {int} and errorDescription {string}")
	public void the_response_status_for_update_vehicle_nickname_for_blank_vin_id_should_be_and_message_error_code_and_error_description(
			int expResponseCode, String expMessage, int experrorCode, String expErrorDescription) {

		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());

		In_Valid_Customer_Identifer_Root_Output Root_Output = getbody()
				.as(In_Valid_Customer_Identifer_Root_Output.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, Root_Output.message, "verify message");
		assertEquals(experrorCode, Root_Output.errorCode, "verify Error code");
		assertEquals(expErrorDescription, Root_Output.errorDescription, "verify Error Decsription");

	}
//<---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

	@When("the user sends update vehicle nickname request with {string} and url {string}")
	public void the_user_sends_update_vehicle_nickname_request_with_and_url(String post, String inValidUrl) {
		addReqType(post, inValidUrl);

	}

	@Then("the response status for update vehicle nickname should be {int} ,message {string} and errorCode {string}")
	public void the_response_status_for_update_vehicle_nickname_should_be_message_and_error_code(int expResponseCode,
			String expMessage, String expErrorCode) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		Root_InvalidUrl_Output_Pojo invalid_url_Root_Output = getbody().as(Root_InvalidUrl_Output_Pojo.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, invalid_url_Root_Output.message, "verify message");
		assertEquals(expErrorCode, invalid_url_Root_Output.statusCode, "verify status code");
	}

	// <-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

	@Then("the response status for update vehicle nick name for empty request body should be {int}")
	public void the_response_status_for_update_vehicle_nick_name_for_empty_request_body_should_be(Integer int1) {
		System.out.println(getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
	}

//<-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
}
