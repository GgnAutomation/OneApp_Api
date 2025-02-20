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
import pojo_Get_External_Cust_Details.In_Valid_Customer_Identifer_Root_Output;

public class Tc_32_ScratchCardService extends BaseClass {

	PayloadManager payloadManager = new PayloadManager();

	@Given("the login API is available and add headers and access token for getScratchCard")
	public void the_login_api_is_available_and_add_headers_and_access_token_for_get_scratch_card()
			throws FileNotFoundException, IOException {
		RestAssured.registerParser("text/plain", Parser.JSON);
		List<Header> list_headers = new ArrayList<>();
		Header h1 = new Header("appid", "External");
		Header h2 = new Header("specificAppId", "OneApp");
		Header h3 = new Header("ocp-apim-subscription-key", "2b6bbec34ce14a32b968411d7956e24c");
		Header h4 = new Header("Authorization", "Bearer " + getPropertyFileValue("ScratchCardServiceToken"));
		list_headers.add(h1);
		list_headers.add(h2);
		list_headers.add(h3);
		list_headers.add(h4);
		Headers headers = new Headers(list_headers);
		addHeaders(headers);

	}

	@When("user add requestBody with mobileNo {string} ,vinId {string}, and scratchCardType {string} for getScratchCard")
	public void user_add_request_body_with_mobile_no_vin_id_and_scratch_card_type_for_get_scratch_card(String mobileNo,
			String vinId, String scratchCardType) throws FileNotFoundException, IOException {
		addReqBody(payloadManager.getScratchCardService_Payload().addDetails(mobileNo, vinId, scratchCardType));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"ScratchCardService URL is: " + getPropertyFileValue("ScratchCardService"));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"Request_payload: mobileNo=" + mobileNo + ",vinId =" + vinId + ",scratchCardType =" + scratchCardType);

	}

	@When("the user sends getScratchCard request with {string}")
	public void the_user_sends_get_scratch_card_request_with(String post) throws FileNotFoundException, IOException {
		addReqType(post, getPropertyFileValue("ScratchCardService"));
	}

	@Then("the response status in getScratchCard should be {int} message {string} ,errorCode {int} and errorDescription {string}")
	public void the_response_status_in_get_scratch_card_should_be_message_error_code_and_error_description(
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
	// <------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

}
