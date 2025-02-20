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
import pojo_GetRsaGiftDetails.GetRsaGiftDetails_Root_Output;
import pojo_Get_External_Cust_Details.In_Valid_Customer_Identifer_Root_Output;

public class Tc26_GetRsaGiftDetails extends BaseClass {
	PayloadManager payloadManager = new PayloadManager();

	@Given("the login API is available and add headers for getRsaGiftDetails")
	public void the_login_api_is_available_and_add_headers_for_get_rsa_gift_details()
			throws FileNotFoundException, IOException {

		RestAssured.registerParser("text/plain", Parser.JSON);
		List<Header> list_headers = new ArrayList<>();
		Header h1 = new Header("appid", "External");
		Header h2 = new Header("specificAppId", "OneApp");
		Header h3 = new Header("ocp-apim-subscription-key", "2b6bbec34ce14a32b968411d7956e24c");
		Header h4 = new Header("Authorization", "Bearer " + getPropertyFileValue("GetRsaGiftDeatilsToken"));
		list_headers.add(h1);
		list_headers.add(h2);
		list_headers.add(h3);
		list_headers.add(h4);
		Headers headers = new Headers(list_headers);
		addHeaders(headers);

	}

	@When("user add requestBody with loginId {string} and VinNo {string} for getRsaGiftDetails")
	public void user_add_request_body_with_login_id_and_vin_no_for_get_rsa_gift_details(String loginId, String vinNo)
			throws FileNotFoundException, IOException {

		addReqBody(payloadManager.getRsaGiftDetails_Payload().addDetails(loginId, vinNo));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"GetRsaGiftDetails URL is: " + getPropertyFileValue("GetRsaGiftDetails"));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"Request_payload: loginId=" + loginId + ", vinNo= " + vinNo);
	}

	@When("the user sends a request with {string} for getRsaGiftDetails")
	public void the_user_sends_a_request_with_for_get_rsa_gift_details(String post)
			throws FileNotFoundException, IOException {
		addReqType(post, getPropertyFileValue("GetRsaGiftDetails"));
	}

	@Then("the response status for getRsaGiftDetails should be {int} ,message {string} ,vinNo {string} ,giftCardStatus {string} ,giftCardMessage {string} and giftCardImage {string}")
	public void the_response_status_for_get_rsa_gift_details_should_be_message_vin_no_gift_card_status_gift_card_message_and_gift_card_image(
			int expResponseCode, String expMessage, String expVinNo, String expGiftCardStatus,
			String expGiftCardMessage, String expGiftCardImage) {

		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());

		GetRsaGiftDetails_Root_Output output = getbody().as(GetRsaGiftDetails_Root_Output.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, output.message, "verify message");
		assertEquals(expVinNo, output.data.vinNo, "verify vinNo");
		assertEquals(expGiftCardStatus, output.data.giftCardStatus, "verify giftCardStatus");
		assertEquals(expGiftCardMessage, output.data.giftCardMessage, "verify giftCardStatus");
		assertEquals(expGiftCardImage, output.data.giftCardImage, "verify giftCardImage");
	}
	// <-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

	@Then("the response status in getRsaGiftDetails should be {int} message {string} ,errorCode {int} and errorDescription {string}")
	public void the_response_status_in_get_rsa_gift_details_should_be_message_error_code_and_error_description(
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
	// <------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

	@When("the user sends a request with {string} and invalid url {string} for getRsaGiftDetails")
	public void the_user_sends_a_request_with_and_invalid_url_for_get_rsa_gift_details(String post, String url) {
		addReqType(post, url);
	}

	@Then("the response status for getRsaGiftDetails should be {int} ,message {string} and errorCode {string}")
	public void the_response_status_for_get_rsa_gift_details_should_be_message_and_error_code(int expResponseCode,
			String expMessage, String expErrorCode) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		Root_InvalidUrl_Output_Pojo invalid_url_Root_Output = getbody().as(Root_InvalidUrl_Output_Pojo.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, invalid_url_Root_Output.message, "verify message");
		assertEquals(expErrorCode, invalid_url_Root_Output.statusCode, "verify status code");

	}
	// <------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

	@Then("the response status for getRsaGiftDetails should be {int}")
	public void the_response_status_for_get_rsa_gift_details_should_be(int expResponseCode) {
		System.out.println(getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		assertEquals(expResponseCode, getResponseCode(), "verify status code");
	}
  //<------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
}
