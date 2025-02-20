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
import pojo_Update_Emergency_Contact.Update_Emergency_Contact_Root_Output;

public class Tc8_Update_Emergency_Contact_One_App extends BaseClass {
	PayloadManager payloadManager = new PayloadManager();

	@Given("the login API is available and add headers and access token for update emergency contact")
	public void the_login_api_is_available_and_add_headers_and_access_token_for_update_emergency_contact()
			throws FileNotFoundException, IOException {
		RestAssured.registerParser("text/plain", Parser.JSON);
		List<Header> list_headers = new ArrayList<>();
		Header h1 = new Header("appid", "External");
		Header h2 = new Header("specificAppId", "OneApp");
		Header h3 = new Header("ocp-apim-subscription-key", "2b6bbec34ce14a32b968411d7956e24c");
		Header h4 = new Header("Authorization", "Bearer " + getPropertyFileValue("UpdateEmegencyContactToken"));
		list_headers.add(h1);
		list_headers.add(h2);
		list_headers.add(h3);
		list_headers.add(h4);
		Headers headers = new Headers(list_headers);
		addHeaders(headers);
	}

	@When("user add requestBody with valid customer Identifier ,id {string} ,name {string} ,mobile {string} ,relation {string} and action {string} for update emergency contact")
	public void user_add_request_body_with_valid_customer_identifier_id_name_mobile_relation_and_action_for_update_emergency_contact(
			String id, String name, String mobile, String relation, String action)
			throws FileNotFoundException, IOException {

		addReqBody(payloadManager.getUpdate_Emergency_Contact().addDetails(id, name, mobile, relation,
				getPropertyFileValue("UpdateEmegencyContactId"), action));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"update EmergencyContact URL is: " + getPropertyFileValue("updateEmergencyContact"));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"Request_payload: CustomerIdentifier=" + getPropertyFileValue("UpdateEmegencyContactId") + ",id =" + id
						+ ",name =" + name + ",mobile =" + mobile + ",relation =" + relation + ",action =" + action);
	}

	@When("the user sends update emergency contact request with {string}")
	public void the_user_sends_update_emergency_contact_request_with(String post)
			throws FileNotFoundException, IOException {

		addReqType(post, getPropertyFileValue("updateEmergencyContact"));
	}

	@Then("the response status for update emergency contact should be {int} and message {string} , id {string} ,name {string} ,mobile {string} ,relation {string} and action {string}")
	public void the_response_status_for_update_emergency_contact_should_be_and_message_id_name_mobile_relation_and_action(
			int expResponseCode, String expMessage, String expId, String expName, String expMobile, String expRelation,
			String expAction) {
		System.out.println(getbody().asPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		Update_Emergency_Contact_Root_Output root_Output = getbody().as(Update_Emergency_Contact_Root_Output.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, root_Output.message, "verify message");
		assertEquals(expId, root_Output.data.emergency.id, "verify Id");
		assertEquals(expName, root_Output.data.emergency.name, "verify name");
		assertEquals(expMobile, root_Output.data.emergency.mobile, "verify mobile");
		assertEquals(expRelation, root_Output.data.emergency.relation, "verify relation");
		assertEquals(expAction, root_Output.data.action, "verify action");
	}

//<------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
	@When("user add requestBody with Invalid customer Identifier ,id {string} ,name {string} ,mobile {string} ,relation {string} and action {string} for update emergency contact")
	public void user_add_request_body_with_invalid_customer_identifier_id_name_mobile_relation_and_action_for_update_emergency_contact(
			String id, String name, String mobile, String relation, String action)
			throws FileNotFoundException, IOException {
		addReqBody(payloadManager.getUpdate_Emergency_Contact().addDetails(id, name, mobile, relation,
				getPropertyFileValue("InvalidCustomerIdentifier"), action));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"update EmergencyContact URL is: " + getPropertyFileValue("updateEmergencyContact"));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"Request_payload: CustomerIdentifier=" + getPropertyFileValue("InvalidCustomerIdentifier") + ",id ="
						+ id + ",name =" + name + ",mobile =" + mobile + ",relation =" + relation + ",action ="
						+ action);
	}

	@Then("the response status for Invalid customer identifier for update emergency contact should be {int} and message {string} and errorCode {int}")
	public void the_response_status_for_invalid_customer_identifier_for_update_emergency_contact_should_be_and_message_and_error_code(
			int expResponseCode, String expMessage, int expStatusCode) {
		System.out.println(getbody().asPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		Invalid_Customer_Identifier_Root_Output root_Output = getbody()
				.as(Invalid_Customer_Identifier_Root_Output.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, root_Output.message, "verify message");
		assertEquals(expStatusCode, root_Output.errorCode, "verify Status code");
		assertFalse(root_Output.success);
	}

//<------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
	@When("user add requestBody with Blank customer Identifier ,id {string} ,name {string} ,mobile {string} ,relation {string} and action {string} for update emergency contact")
	public void user_add_request_body_with_blank_customer_identifier_id_name_mobile_relation_and_action_for_update_emergency_contact(
			String id, String name, String mobile, String relation, String action)
			throws FileNotFoundException, IOException {
		addReqBody(payloadManager.getUpdate_Emergency_Contact().addDetails(id, name, mobile, relation, "", action));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"update EmergencyContact URL is: " + getPropertyFileValue("updateEmergencyContact"));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Request_payload: CustomerIdentifier=" + "" + ",id ="
				+ id + ",name =" + name + ",mobile =" + mobile + ",relation =" + relation + ",action =" + action);
	}

	@Then("the response status for blank customer identifier for update emergency contact should be {int} ,message {string} ,errorCode {int} and errorDescription {string}")
	public void the_response_status_for_blank_customer_identifier_for_update_emergency_contact_should_be_message_error_code_and_error_description(
			int expResponseCode, String expMessage, int experrorCode, String expErrorDescription) {
		System.out.println(getbody().asPrettyString());
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

//<----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

	@When("user add requestBody with Special customer Identifier ,id {string} ,name {string} ,mobile {string} ,relation {string} and action {string} for update emergency contact")
	public void user_add_request_body_with_special_customer_identifier_id_name_mobile_relation_and_action_for_update_emergency_contact(
			String id, String name, String mobile, String relation, String action)
			throws FileNotFoundException, IOException {
		addReqBody(payloadManager.getUpdate_Emergency_Contact().addDetails(id, name, mobile, relation,
				getPropertyFileValue("specialcharcustomerIdentifier"), action));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"update EmergencyContact URL is: " + getPropertyFileValue("updateEmergencyContact"));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"Request_payload: CustomerIdentifier=" + getPropertyFileValue("specialcharcustomerIdentifier") + ",id ="
						+ id + ",name =" + name + ",mobile =" + mobile + ",relation =" + relation + ",action ="
						+ action);
	}

	@Then("the response status for Special customer identifier for update emergency contact should be {int} ,message {string} ,errorCode {int} and errorDescription {string}")
	public void the_response_status_for_special_customer_identifier_for_update_emergency_contact_should_be_message_error_code_and_error_description(
			int expResponseCode, String expMessage, int experrorCode, String expErrorDescription) {
		System.out.println(getbody().asPrettyString());
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

//<------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------>	

	@Then("the response status for update emergency contact should be {int} ,message {string} ,errorCode {int} and errorDescription {string}")
	public void the_response_status_for_invalid_name_in_update_emergency_contact_should_be_message_error_code_and_error_description(
			int expResponseCode, String expMessage, int experrorCode, String expErrorDescription) {
		System.out.println(getbody().asPrettyString());
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
	// <-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

	@When("user add requestBody with customer Identifier ,id {string} ,name {string} ,mobile number {string} ,relation {string} and action {string} for adding more numbers in update emergency contact")
	public void user_add_request_body_with_customer_identifier_id_name_mobile_number_relation_and_action_for_adding_more_numbers_in_update_emergency_contact(
			String id, String name, String mobile, String relation, String action)
			throws FileNotFoundException, IOException {
		addReqBody(payloadManager.getUpdate_Emergency_Contact().addDetails(id, name, mobile, relation,
				getPropertyFileValue("ValidExternalVinIdIdentifier"), action));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"update EmergencyContact URL is: " + getPropertyFileValue("updateEmergencyContact"));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"Request_payload: CustomerIdentifier=" + getPropertyFileValue("ValidExternalVinIdIdentifier") + ",id ="
						+ id + ",name =" + name + ",mobile =" + mobile + ",relation =" + relation + ",action ="
						+ action);
	}

	@Then("the response status for adding more numbers in update emergency contact should be {int} ,message {string} ,errorCode {int} and errorDescription {string}")
	public void the_response_status_for_adding_more_numbers_in_update_emergency_contact_should_be_message_error_code_and_error_description(
			int expResponseCode, String expMessage, int experrorCode, String expErrorDescription) {
		System.out.println(getbody().asPrettyString());
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

	// <-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
	
	@Then("the response status for delete contact in update emergency contact should be {int} and message {string} , id {string} ,name {string} ,mobile {string} ,relation {string} and action {string}")
	public void the_response_status_for_delete_contact_in_update_emergency_contact_should_be_and_message_id_name_mobile_relation_and_action(
			int expResponseCode, String expMessage, String expId, String expName, String expMobile, String expRelation,
			String expAction) {

		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		Update_Emergency_Contact_Root_Output root_Output = getbody().as(Update_Emergency_Contact_Root_Output.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, root_Output.message, "verify message");
		assertEquals(expId, root_Output.data.emergency.id, "verify Id");
		assertEquals(expName, root_Output.data.emergency.name, "verify name");
		assertEquals(expMobile, root_Output.data.emergency.mobile, "verify mobile");
		assertEquals(expRelation, root_Output.data.emergency.relation, "verify relation");
		assertEquals(expAction, root_Output.data.action, "verify action");
	}

	// <--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
	@Given("the login API is available and add headers for blank access Token for update emergency contact")
	public void the_login_api_is_available_and_add_headers_for_blank_access_token_for_update_emergency_contact() {
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

	// <---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
	@When("the user sends request {string} for update emergency contact with invalid url {string}")
	public void the_user_sends_request_for_update_emergency_contact_with_invalid_url(String post, String url) {
		addReqType(post, url);
	}

	@Then("the response status for update emergency contact should be {int} ,message {string} and errorCode {string}")
	public void the_response_status_for_update_emergency_contact_should_be_message_and_error_code(Integer expResponseCode, String expMessage, String expStatusCode) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		Root_InvalidUrl_Output_Pojo output_Pojo = getbody().as(Root_InvalidUrl_Output_Pojo.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, output_Pojo.message, "verify message");
		assertEquals(expStatusCode, output_Pojo.statusCode, "verify status code");
	}
	// <------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
	@Then("the response status in update emergency contact for empty request body should be {int}")
	public void the_response_status_in_update_emergency_contact_for_empty_request_body_should_be(int expResponseCode) {
		System.out.println(getResponseCode());
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
	}
}
