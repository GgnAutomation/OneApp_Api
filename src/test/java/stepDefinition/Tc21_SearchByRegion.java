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
import pojo_Search_By_Region.Search_By_Region_Root_Output;

public class Tc21_SearchByRegion extends BaseClass {

	PayloadManager payloadManager = new PayloadManager();

	@Given("the login API is available and add headers for SearchByRegion")
	public void the_login_api_is_available_and_add_headers_for_search_by_region()
			throws FileNotFoundException, IOException {
		RestAssured.registerParser("text/plain", Parser.JSON);
		List<Header> list_headers = new ArrayList<>();
		Header h1 = new Header("appid", "External");
		Header h2 = new Header("specificAppId", "OneApp");
		Header h3 = new Header("ocp-apim-subscription-key", "2b6bbec34ce14a32b968411d7956e24c");
		Header h4 = new Header("Authorization", "Bearer " + getPropertyFileValue("SearchByRegionToken"));
		list_headers.add(h1);
		list_headers.add(h2);
		list_headers.add(h3);
		list_headers.add(h4);
		Headers headers = new Headers(list_headers);
		addHeaders(headers);

	}

	@When("user add requestBody with customerIdentifier {string} ,searchBy {string} ,value {string} for SearchByRegion")
	public void user_add_request_body_with_customer_identifier_search_by_value_for_search_by_region(
			String customerIdentifier, String searchBy, String value) throws FileNotFoundException, IOException {

		addReqBody(payloadManager.getSearchByRegion_Payload().addDetails(customerIdentifier, searchBy, value));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"SearchByRegion  URL is: " + getPropertyFileValue("SearchByRegion"));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Request_payload: customer identifier="
				+ customerIdentifier + ",searchBy=" + searchBy + ",value=" + value);

	}

	@When("the user sends a request with {string} for SearchByRegion")
	public void the_user_sends_a_request_with_for_search_by_region(String post)
			throws FileNotFoundException, IOException {
		addReqType(post, getPropertyFileValue("SearchByRegion"));
	}

	@Then("the response status for SearchByRegion should be {int} ,message {string} ,city {string} ,state {string} and displayName {string}")
	public void the_response_status_for_search_by_region_should_be_message_city_state_and_display_name(
			int expResponseCode, String expMessage, String expCity, String expState, String expDisplayName) {

		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());

		Search_By_Region_Root_Output output = getbody().as(Search_By_Region_Root_Output.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, output.message, "verify message");
		assertEquals(expCity, output.data.dealerLocation.get(0).city, "verify expCity");
		assertEquals(expState, output.data.dealerLocation.get(0).state, "verify expState");
		assertEquals(expDisplayName, output.data.dealerLocation.get(0).displayName, "verify expDisplayName");
	}

	// <---------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
	@Then("the response status in searchByRegion should be {int} message {string} ,errorCode {int} ,errorDescription {string}")
	public void the_response_status_in_search_by_region_should_be_message_error_code_error_description(
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
	}

	// <----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
	@Then("the response status for SearchByRegion should be {int} ,message {string} ,city1 {string} ,state1 {string} ,displayName1 {string} ,city2 {string} ,state2 {string} ,displayName2 {string} ,city3 {string} ,state3 {string} ,displayName3 {string} ,city4 {string} ,state4 {string}, displayName4 {string} ,city5 {string} ,state5 {string} and displayName5 {string}")
	public void the_response_status_for_search_by_region_should_be_message_city1_state1_display_name1_city2_state2_display_name2_city3_state3_display_name3_city4_state4_display_name4_city5_state5_and_display_name5(
			int expResponseCode, String expMessage, String expCity1, String expState1, String expDisplayName1,
			String expCity2, String expState2, String expDisplayName2, String expCity3, String expState3,
			String expDisplayName3, String expCity4, String expState4, String expDisplayName4, String expCity5,
			String expState5, String expDisplayName5) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());

		Search_By_Region_Root_Output output = getbody().as(Search_By_Region_Root_Output.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, output.message, "verify message");
		assertEquals(expCity1, output.data.dealerLocation.get(0).city, "verify expCity");
		assertEquals(expState1, output.data.dealerLocation.get(0).state, "verify expState");
		assertEquals(expDisplayName1, output.data.dealerLocation.get(0).displayName, "verify expDisplayName");

		assertEquals(expCity2, output.data.dealerLocation.get(1).city, "verify expCity");
		assertEquals(expState2, output.data.dealerLocation.get(1).state, "verify expState");
		assertEquals(expDisplayName2, output.data.dealerLocation.get(1).displayName, "verify expDisplayName");

		assertEquals(expCity3, output.data.dealerLocation.get(2).city, "verify expCity");
		assertEquals(expState3, output.data.dealerLocation.get(2).state, "verify expState");
		assertEquals(expDisplayName3, output.data.dealerLocation.get(2).displayName, "verify expDisplayName");

		assertEquals(expCity4, output.data.dealerLocation.get(3).city, "verify expCity");
		assertEquals(expState4, output.data.dealerLocation.get(3).state, "verify expState");
		assertEquals(expDisplayName4, output.data.dealerLocation.get(3).displayName, "verify expDisplayName");

		assertEquals(expCity5, output.data.dealerLocation.get(4).city, "verify expCity");
		assertEquals(expState5, output.data.dealerLocation.get(4).state, "verify expState");
		assertEquals(expDisplayName5, output.data.dealerLocation.get(4).displayName, "verify expDisplayName");

	}
//<------------------------------------------------------------------------------------------------------------------------------------------------------------>

	@When("the user sends a request with {string} and ivalid url {string} for SearchByRegion")
	public void the_user_sends_a_request_with_and_ivalid_url_for_search_by_region(String post, String url) {
		addReqType(post, url);
	}

	@Then("the response status for SearchByRegion should be {int} ,message {string} and errorCode {string}")
	public void the_response_status_for_search_by_region_should_be_message_and_error_code(Integer expResponseCode,
			String expMessage, String expStatusCode) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		Root_InvalidUrl_Output_Pojo invalid_url_Root_Output = getbody().as(Root_InvalidUrl_Output_Pojo.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, invalid_url_Root_Output.message, "verify message");
		assertEquals(expStatusCode, invalid_url_Root_Output.statusCode, "verify status code");
	}

	// <-------------------------------------------------------------------------------------------------------------------------------------------------------->
	@Then("the response status in SearchByRegion should be {int} message {string} ,errorCode {int} ,errorDescription {string}")
	public void the_response_status_in_search_by_region_should_be_message_error_code_error_description(int expResponseCode,
			String expMessage, Integer experrorCode, String expErrorDescription) {
		System.out.println(getbody().asPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		In_Valid_Customer_Identifer_Root_Output root_Output = getbody()
				.as(In_Valid_Customer_Identifer_Root_Output.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, root_Output.message, "verify message");
		assertEquals(experrorCode, root_Output.errorCode, "verify is Error code");
		assertEquals(expErrorDescription, root_Output.errorDescription, "verify Error Decsription");
		}
	//<--------------------------------------------------------------------------------------------------------------------------------------------------------------->
}
