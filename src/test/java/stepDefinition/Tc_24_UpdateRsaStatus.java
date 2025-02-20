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
import pojo_Get_External_Cust_Details.In_Valid_Customer_Identifer_Root_Output;
import pojo_UpdateRsaStatus.UpdateRsaStatus_Root_Output;

public class Tc_24_UpdateRsaStatus extends BaseClass {

	PayloadManager payloadManager = new PayloadManager();

	@Given("the login API is available and add headers for UpdateRsaStatus")
	public void the_login_api_is_available_and_add_headers_for_update_rsa_status()
			throws FileNotFoundException, IOException {
		RestAssured.registerParser("text/plain", Parser.JSON);
		List<Header> list_headers = new ArrayList<>();
		Header h1 = new Header("appid", "External");
		Header h2 = new Header("specificAppId", "OneApp");
		Header h3 = new Header("ocp-apim-subscription-key", "2b6bbec34ce14a32b968411d7956e24c");
		Header h4 = new Header("Authorization", "Bearer " + getPropertyFileValue("UpdateRsaStatusToken"));
		list_headers.add(h1);
		list_headers.add(h2);
		list_headers.add(h3);
		list_headers.add(h4);
		Headers headers = new Headers(list_headers);
		addHeaders(headers);
	}

	@When("user add requestBody with loginId {string} ,vinNo {string} ,programStatus {string} ,giftCardStatus {string} ,giftCardMessage {string} ,giftCardImage {string} for UpdateRsaStatus")
	public void user_add_request_body_with_login_id_vin_no_program_status_gift_card_status_gift_card_message_gift_card_image_for_update_rsa_status(
			String loginId, String vinNo, String programStatus, String giftCardStatus, String giftCardMessage,
			String giftCardImage) throws FileNotFoundException, IOException {
		addReqBody(payloadManager.getUpdateRsaStatus_Payloads().addDetails(loginId, vinNo, programStatus,
				giftCardStatus, giftCardMessage, giftCardImage));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"UpdateRsaStatus URL is: " + getPropertyFileValue("UpdateRsaStatus"));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"Request_payload: loginId=" + loginId + ",vinNo =" + vinNo + ",programStatus =" + programStatus
						+ ",giftCardStatus =" + giftCardStatus + ",giftCardMessage = " + giftCardMessage
						+ ",giftCardImage" + giftCardImage);
	}

	@When("the user sends a request with {string} for UpdateRsaStatus")
	public void the_user_sends_a_request_with_for_update_rsa_status(String post)
			throws FileNotFoundException, IOException {
		addReqType(post, getPropertyFileValue("UpdateRsaStatus"));
	}

	@Then("the response status for UpdateRsaStatus should be {int} ,message {string} and vinNo {string}")
	public void the_response_status_for_update_rsa_status_should_be_message_and_vin_no(int expResponseCode,
			String expMessage, String expVinNo) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());

		UpdateRsaStatus_Root_Output output = getbody().as(UpdateRsaStatus_Root_Output.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, output.message, "verify message");
		assertEquals(expVinNo, output.data.vinNo, "verify vinNo");
		assertTrue(output.success);
	}
	// <------------------------------------------------------------------------------------------------------------------------------------------------------->

	@Then("the response status in UpdateRsaStatus should be {int} message {string} ,errorCode {int} and errorDescription {string}")
	public void the_response_status_in_update_rsa_status_should_be_message_error_code_and_error_description(
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
	// <----------------------------------------------------------------------------------------------------------------------------------------------------------------->

	@When("the user sends a request with {string} and invalid url {string} for UpdateRsaStatus")
	public void the_user_sends_a_request_with_and_invalid_url_for_update_rsa_status(String post, String url) {

		addReqType(post, url);
	}

	@Then("the response status for UpdateRsaStatus should be {int} ,message {string} and errorCode {string}")
	public void the_response_status_for_update_rsa_status_should_be_message_and_error_code(int expResponseCode, String expMessage,
			String expErrorCode) {
		
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		Root_InvalidUrl_Output_Pojo invalid_url_Root_Output = getbody().as(Root_InvalidUrl_Output_Pojo.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, invalid_url_Root_Output.message, "verify message");
		assertEquals(expErrorCode, invalid_url_Root_Output.statusCode, "verify status code");
	}
	//<-------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

	@Then("the response status in UpdateRsaStatus should be {int}")
	public void the_response_status_in_update_rsa_status_should_be(int expResponseCode) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		assertEquals(expResponseCode, getResponseCode(), "verify response code");	
	}
	//<------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->


}
