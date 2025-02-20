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
import pojo_Get_Relation.Get_Relation_Root_Output;

public class Tc7_Get_Relation_One_App extends BaseClass {

	PayloadManager payloadManager = new PayloadManager();

	@Given("the login API is available and add headers,customer identifier and access token for get relation")
	public void the_login_api_is_available_and_add_headers_customer_identifier_and_access_token_for_get_relation()
			throws FileNotFoundException, IOException {
		RestAssured.registerParser("text/plain", Parser.JSON);
		List<Header> list_headers = new ArrayList<>();
		Header h1 = new Header("appid", "External");
		Header h2 = new Header("specificAppId", "OneApp");
		Header h3 = new Header("ocp-apim-subscription-key", "2b6bbec34ce14a32b968411d7956e24c");
		Header h4 = new Header("Authorization", "Bearer " + getPropertyFileValue("GetExternalCustToken"));
		list_headers.add(h1);
		list_headers.add(h2);
		list_headers.add(h3);
		list_headers.add(h4);
		Headers headers = new Headers(list_headers);
		addHeaders(headers);

	}

	@When("user add requestBody with valid customer Identifier for get relation")
	public void user_add_request_body_with_valid_customer_identifier_for_get_relation()
			throws FileNotFoundException, IOException {
		addReqBody(payloadManager.getRelation_Payload().addDetails(getPropertyFileValue("GetExternalCustIdentifier")));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"Get Relation URL is: " + getPropertyFileValue("GetRelations"));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"Request_payload: CustomerIdentifier=" + getPropertyFileValue("GetExternalCustIdentifier"));
	}

	@When("the user sends request for get relation with {string}")
	public void the_user_sends_request_for_get_relation_with(String post) throws FileNotFoundException, IOException {
		addReqType(post, getPropertyFileValue("GetRelations"));
	}

	@Then("the response status for valid customer identifier for get relation should be {int} ,message {string} ,key1 {string} ,value1 {string} ,key2 {string} ,value2 {string} ,key3 {string} ,value3 {string} ,key4 {string} ,value4 {string} ,key5 {string} ,value5 {string} ,key6 {string} ,value6 {string} ,key7 {string} ,value7 {string} , key8 {string} and value8 {string}")
	public void the_response_status_for_valid_customer_identifier_for_get_relation_should_be_message_key1_value1_key2_value2_key3_value3_key4_value4_key5_value5_key6_value6_key7_value7_key8_and_value8(
			int expResponseCode, String expMessage, String expKey1, String expValue1, String expKey2, String expValue2,
			String expKey3, String expValue3, String expKey4, String expValue4, String expKey5, String expValue5,
			String expKey6, String expValue6, String expKey7, String expValue7, String expKey8, String expValue8) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		Get_Relation_Root_Output root_Output = getbody().as(Get_Relation_Root_Output.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, root_Output.message, "verify message");
		assertEquals(expKey1, root_Output.data.dataList.get(0).key, "verify key1");
		assertEquals(expValue1, root_Output.data.dataList.get(0).value, "verify value1");
		assertEquals(expKey2, root_Output.data.dataList.get(1).key, "verify key2");
		assertEquals(expValue2, root_Output.data.dataList.get(1).value, "verify value2");
		assertEquals(expKey3, root_Output.data.dataList.get(2).key, "verify key3");
		assertEquals(expValue3, root_Output.data.dataList.get(2).value, "verify value3");
		assertEquals(expKey4, root_Output.data.dataList.get(3).key, "verify key4");
		assertEquals(expValue4, root_Output.data.dataList.get(3).value, "verify value4");
		assertEquals(expKey5, root_Output.data.dataList.get(4).key, "verify key5");
		assertEquals(expValue5, root_Output.data.dataList.get(4).value, "verify value5");
		assertEquals(expKey6, root_Output.data.dataList.get(5).key, "verify key6");
		assertEquals(expValue6, root_Output.data.dataList.get(5).value, "verify value6");
		assertEquals(expKey7, root_Output.data.dataList.get(6).key, "verify key7");
		assertEquals(expValue7, root_Output.data.dataList.get(6).value, "verify value7");
		assertEquals(expKey8, root_Output.data.dataList.get(7).key, "verify key8");
		assertEquals(expValue8, root_Output.data.dataList.get(7).value, "verify value8");
	}

//<---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
	@When("user add requestBody with Invalid customer Identifier for get relation")
	public void user_add_request_body_with_invalid_customer_identifier_for_get_relation()
			throws FileNotFoundException, IOException {
		addReqBody(payloadManager.getRelation_Payload().addDetails(getPropertyFileValue("InvalidCustomerIdentifier")));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"Get Relation URL is: " + getPropertyFileValue("GetRelations"));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"Request_payload: CustomerIdentifier=" + getPropertyFileValue("InvalidCustomerIdentifier"));
	}

	@Then("the response status for Invalid customer identifier for get relation should be {int} and message {string} and errorCode {int}")
	public void the_response_status_for_invalid_customer_identifier_for_get_relation_should_be_and_message_and_error_code(
			int expResponseCode, String expMessage, int expStatusCode) {
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
	// <--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

	@When("user add requestBody with blank customer Identifier for get relation")
	public void user_add_request_body_with_blank_customer_identifier_for_get_relation()
			throws FileNotFoundException, IOException {
		addReqBody(payloadManager.getRelation_Payload().addDetails(""));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"Get Relation URL is: " + getPropertyFileValue("GetRelations"));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Request_payload: CustomerIdentifier=" + "");
	}

	@Then("the response status for blank customer identifier for get relation should be {int} ,message {string} ,errorCode {int} and errorDescription {string}")
	public void the_response_status_for_blank_customer_identifier_for_get_relation_should_be_message_error_code_and_error_description(
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

//<-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->	
	@When("user add requestBody with special character in customer Identifier for get relation")
	public void user_add_request_body_with_special_character_in_customer_identifier_for_get_relation()
			throws FileNotFoundException, IOException {
		addReqBody(
				payloadManager.getRelation_Payload().addDetails(getPropertyFileValue("specialcharcustomerIdentifier")));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"Get Relation URL is: " + getPropertyFileValue("GetRelations"));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"Request_payload: CustomerIdentifier=" + getPropertyFileValue("specialcharcustomerIdentifier"));
	}

	@Then("the response status for special character in customer identifier for get relation should be {int} ,message {string} ,errorCode {int} and errorDescription {string}")
	public void the_response_status_for_special_character_in_customer_identifier_for_get_relation_should_be_message_error_code_and_error_description(
			int expResponseCode, String expMessage, int experrorCode, String expErrorDescription) {

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

	// <------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
	@Given("the login API is available and add headers,customer identifier and Invalid access token for get relation")
	public void the_login_api_is_available_and_add_headers_customer_identifier_and_invalid_access_token_for_get_relation()
			throws FileNotFoundException, IOException {
		RestAssured.registerParser("text/plain", Parser.JSON);
		List<Header> list_headers = new ArrayList<>();
		Header h1 = new Header("appid", "External");
		Header h2 = new Header("specificAppId", "OneApp");
		Header h3 = new Header("ocp-apim-subscription-key", "2b6bbec34ce14a32b968411d7956e24c");
		Header h4 = new Header("Authorization", getPropertyFileValue("InvalidToken"));
		list_headers.add(h1);
		list_headers.add(h2);
		list_headers.add(h3);
		list_headers.add(h4);
		Headers headers = new Headers(list_headers);
		addHeaders(headers);

	}

	@Then("the response status for Invalid access token for get relation should be {int} and message {string} and errorCode {int}")
	public void the_response_status_for_invalid_access_token_for_get_relation_should_be_and_message_and_error_code(
			int expResponseCode, String expMessage, int expStatusCode) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		In_Valid_Customer_Identifer_Root_Output root_Output = getbody()
				.as(In_Valid_Customer_Identifer_Root_Output.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, root_Output.message, "verify message");
		assertEquals(expStatusCode, root_Output.errorCode, "verify Status code");
		assertFalse(root_Output.success);
	}

//<--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
	@Given("the login API is available and add headers for blank access Token for get relation")
	public void the_login_api_is_available_and_add_headers_for_blank_access_token_for_get_relation() {
		RestAssured.registerParser("text/plain", Parser.JSON);
		List<Header> list_headers = new ArrayList<>();
		Header h1 = new Header("appid", "External");
		Header h2 = new Header("specificAppId", "Harley");
		Header h3 = new Header("ocp-apim-subscription-key", "2b6bbec34ce14a32b968411d7956e24c");
		Header h4 = new Header("Authorization", "");
		list_headers.add(h1);
		list_headers.add(h2);
		list_headers.add(h3);
		list_headers.add(h4);
		Headers headers = new Headers(list_headers);
		addHeaders(headers);
	}

	@Then("the response status for blank access Token for get relation should be {int} and message {string} , errorCode {int} and errorDescription {string}")
	public void the_response_status_for_blank_access_token_for_get_relation_should_be_and_message_error_code_and_error_description(
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

	// <--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
	@When("the user sends request {string} for get relation with invalid url {string}")
	public void the_user_sends_request_for_get_relation_with_invalid_url(String post, String url) {
		addReqType(post, url);
	}
	@Then("the response status for get relation should be {int} ,message {string} and errorCode {string}")
	public void the_response_status_for_get_relation_should_be_message_and_error_code(int expResponseCode,
			String expMessage,String expErrorCode) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		Root_InvalidUrl_Output_Pojo invalid_url_Root_Output = getbody().as(Root_InvalidUrl_Output_Pojo.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, invalid_url_Root_Output.message, "verify message");
		assertEquals(expErrorCode, invalid_url_Root_Output.statusCode, "verify status code");
	}
	

	// <-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
	@Then("the response status in get relation for empty request body should be {int}")
	public void the_response_status_in_get_relation_for_empty_request_body_should_be(int expResponseCode) {

		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
	}
}
