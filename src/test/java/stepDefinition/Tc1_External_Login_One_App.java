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
import pojoClass_ExternalLogin.Data_InvalidLogin_Output;
import pojoClass_ExternalLogin.Root_ExternalLogin_Output_Pojo;
import pojoClass_ExternalLogin.Root_InvalidUrl_Output_Pojo;

public class Tc1_External_Login_One_App extends BaseClass {

	PayloadManager payloadManager = new PayloadManager();

	@Given("the login API is available and user add headers")
	public void the_login_api_is_available_and_user_add_headers() {
		RestAssured.registerParser("text/plain", Parser.JSON);
		List<Header> list_headers = new ArrayList<>();
		Header h1 = new Header("appid", "External");
		Header h2 = new Header("specificAppId", "OneApp");
		Header h3 = new Header("ocp-apim-subscription-key", "2b6bbec34ce14a32b968411d7956e24c");
		list_headers.add(h1);
		list_headers.add(h2);
		list_headers.add(h3);
		Headers headers = new Headers(list_headers);
		addHeaders(headers);
	}

	@When("user add requestBody for validLogin {string} ,{string} and {string}")
	public void user_add_request_body_for_valid_login_and(String loginId, String loginType, String notification)
			throws FileNotFoundException, IOException {
		addReqBody(payloadManager.getExternalLoginPayLoad().addLoginDetails(loginId, loginType, notification));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Login URL is: " + getPropertyFileValue("Login"));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"Request_payload: loginId=" + loginId + ",loginType=" + loginType + ",notification=" + notification);
	}

	@When("the user sends a ExternalLogin request with {string}")
	public void the_user_sends_a_external_login_request_with(String post) throws FileNotFoundException, IOException {
		addReqType(post, getPropertyFileValue("Login"));

	}

	@Then("the response status should be {int} and message {string} and loginId {string}")
	public void the_response_status_should_be_and_message_and_login_id(int expectedResponseCode, String expectedMsg,
			String expLoginID) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		Root_ExternalLogin_Output_Pojo dataExternalLoginOutput = getbody().as(Root_ExternalLogin_Output_Pojo.class);
		assertEquals(expectedMsg, dataExternalLoginOutput.message, "verify message");
		assertEquals(expectedResponseCode, getResponseCode(), "verify response code");
		assertEquals(dataExternalLoginOutput.data.loginId, expLoginID, "verify LoginId");
		assertTrue(dataExternalLoginOutput.success);
	}

//<----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
	@Then("the response status should be {int} and message {string} , errorCode {int} and errorDescription {string}")
	public void the_response_status_should_be_and_message_error_code_and_error_description(int expectedResponseCode,
			String expectedMsg, Integer expErrorCode, String expErrorDescription) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		Data_InvalidLogin_Output root_externalLogin_output = getbody().as(Data_InvalidLogin_Output.class);
		assertEquals(expectedMsg, root_externalLogin_output.message, "verify message");
		assertEquals(expectedResponseCode, getResponseCode(), "verify response code");
		assertEquals(expErrorCode, root_externalLogin_output.errorCode, "verify Error code");
		assertEquals(expErrorDescription, root_externalLogin_output.errorDescription, "verify Error Description");
		assertFalse(root_externalLogin_output.success);
	}
	// <-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

	@When("user add requestBody for Empty Request Body")
	public void user_add_request_body_for_empty_request_body() throws FileNotFoundException, IOException {
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Login URL is: " + getPropertyFileValue("Login"));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Request_payload: Empty");
	}

	@Then("Validate response for Empty Request Body status should be {string}")
	public void validate_response_for_empty_request_body_status_should_be(String expectedResponseCode) {
		System.out.println(getResponseCode());
		int responseCode = getResponseCode();
		String actualResponse = Integer.toString(responseCode);
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + responseCode);
		assertEquals(expectedResponseCode, actualResponse, "verify response code");
	}
	// <-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

	@When("the user sends a ExternalLogin request with {string} and url {string}")
	public void the_user_sends_a_external_login_request_with_and_url(String post, String url) {
		addReqType(post, url);
	}

	@Then("the response status should be {int} and message {string}")
	public void the_response_status_should_be_and_message(int expectedResponseCode, String expectedMsg) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());

		Root_InvalidUrl_Output_Pojo output_Pojo = getbody().as(Root_InvalidUrl_Output_Pojo.class);
		assertEquals(expectedMsg, output_Pojo.message, "verify message");
		assertEquals(expectedResponseCode, getResponseCode(), "verify response code");

	}
//<------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------>
}
