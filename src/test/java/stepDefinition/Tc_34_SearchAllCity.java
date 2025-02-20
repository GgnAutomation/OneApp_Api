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
import pojo_Search_All_City.Search_All_City_Root_Input;
import pojo_Search_All_City.Search_All_City_Root_Output;

public class Tc_34_SearchAllCity extends BaseClass {

	PayloadManager payloadManager = new PayloadManager();

	@Given("the login API is available and add headers for SearchAllCity")
	public void the_login_api_is_available_and_add_headers_for_search_all_city() {
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

	@When("user add requestBody with searchBy {string} and value {string} for SearchAllCity")
	public void user_add_request_body_with_search_by_and_value_for_search_all_city(String searchBy, String value)
			throws FileNotFoundException, IOException {

		addReqBody(payloadManager.getSearchAllCity_Payloads().addDetails(searchBy, value));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"SearchAllCity url is: " + getPropertyFileValue("SearchAllCity"));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"Request_payload: searchBy=" + searchBy + ",value =" + value);

	}

	@When("the user sends a request with {string} for SearchAllCity")
	public void the_user_sends_a_request_with_for_search_all_city(String post)
			throws FileNotFoundException, IOException {
		addReqType(post, getPropertyFileValue("SearchAllCity"));
	}

	@Then("the response status for SearchAllCity should be {int} ,message {string} ,city1 {string} ,state1 {string} ,displayName1 {string} ,city2 {string} ,state2 {string} ,displayName2 {string} and totaldealerslocation {int}")
	public void the_response_status_for_search_all_city_should_be_message_city1_state1_display_name1_city2_state2_display_name2_and_totaldealerslocation(
			int expResponseCode, String expMessage, String expCity1, String expState1, String expDisplayName1,
			String expCity2, String expState2, String expDisplayName2, int expTotaldealerslocation) {

		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());

		Search_All_City_Root_Output root_Output = getbody().as(Search_All_City_Root_Output.class);
		assertEquals(expTotaldealerslocation, root_Output.data.dealerLocation.size(), "verify total dealers location");

		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, root_Output.message, "verify message");
		assertEquals(expCity1, root_Output.data.dealerLocation.get(0).city, "verify city1");
		assertEquals(expState1, root_Output.data.dealerLocation.get(0).state, "verify state1");
		assertEquals(expDisplayName1, root_Output.data.dealerLocation.get(0).displayName, "verify displayName1");

		assertEquals(expCity2, root_Output.data.dealerLocation.get(1).city, "verify city2");
		assertEquals(expState2, root_Output.data.dealerLocation.get(1).state, "verify state2");
		assertEquals(expDisplayName2, root_Output.data.dealerLocation.get(1).displayName, "verify displayName2");
	}
	// <----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

	@Then("the response status in SearchAllCity should be {int} message {string} ,errorCode {int} and errorDescription {string}")
	public void the_response_status_in_search_all_city_should_be_message_error_code_and_error_description(int expResponseCode, String expMessage, int experrorCode, String expErrorDescription) {
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
	//<------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

	@When("the user sends a request with {string} and invalid url {string} for SearchAllCity")
	public void the_user_sends_a_request_with_and_invalid_url_for_search_all_city(String post, String url) {
		addReqType(post, url);
	}
	@Then("the response status for SearchAllCity should be {int} ,message {string} and errorCode {string}")
	public void the_response_status_for_search_all_city_should_be_message_and_error_code(int expResponseCode, String expMessage, String expErrorCode) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		Root_InvalidUrl_Output_Pojo invalid_url_Root_Output = getbody().as(Root_InvalidUrl_Output_Pojo.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, invalid_url_Root_Output.message, "verify message");
		assertEquals(expErrorCode, invalid_url_Root_Output.statusCode, "verify status code");
	}
	//<-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

}
