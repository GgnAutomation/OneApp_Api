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
import pojo_Get_Dealers.Get_Dealers_Root_Output;
import pojo_Get_External_Cust_Details.In_Valid_Customer_Identifer_Root_Output;

public class Tc_20_Get_Dealers extends BaseClass {
	PayloadManager payloadManager = new PayloadManager();

	@Given("the login API is available and add headers for GetDealers")
	public void the_login_api_is_available_and_add_headers_for_get_dealers() throws FileNotFoundException, IOException {
		RestAssured.registerParser("text/plain", Parser.JSON);
		List<Header> list_headers = new ArrayList<>();
		Header h1 = new Header("appid", "External");
		Header h2 = new Header("specificAppId", "OneApp");
		Header h3 = new Header("ocp-apim-subscription-key", "2b6bbec34ce14a32b968411d7956e24c");
		Header h4 = new Header("Authorization", "Bearer " + getPropertyFileValue("GetDealersToken"));
		list_headers.add(h1);
		list_headers.add(h2);
		list_headers.add(h3);
		list_headers.add(h4);
		Headers headers = new Headers(list_headers);
		addHeaders(headers);

	}

	@When("user add requestBody with customerIdentifier {string} ,city {string} ,state {string} for GetDealers")
	public void user_add_request_body_with_customer_identifier_city_state_for_get_dealers(String customerIdentifier,
			String city, String state) throws FileNotFoundException, IOException {
		addReqBody(payloadManager.getDealers_Payloads().addDetails(customerIdentifier, city, state));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"GetDealer  URL is: " + getPropertyFileValue("GetDealer"));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"Request_payload: customer identifier=" + customerIdentifier + ",city=" + city + ",state=" + state);

	}

	@When("the user sends a request with {string} for GetDealers")
	public void the_user_sends_a_request_with_for_get_dealers(String post) throws FileNotFoundException, IOException {
		addReqType(post, getPropertyFileValue("GetDealer"));
	}

	@Then("the response status for GetDealers should be {int} ,message {string} ,dealerCode {string} ,dealerName {string} ,areaOffice {string} ,zonalOffice {string} ,dealerMobileNo {string} ,city {string} ,state {string} ,district {string} ,pincode {string} and brandName {string}")
	public void the_response_status_for_get_dealers_should_be_message_dealer_code_dealer_name_area_office_zonal_office_dealer_mobile_no_city_state_district_pincode_and_brand_name(
			int expResponseCode, String expMessage, String expDealerCode, String expDealerName, String expAreaOffice,
			String expZonalOffice, String expDealerMobileNo, String expCity, String expState, String expDistrict,
			String expPincode, String expBrandName) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());

		Get_Dealers_Root_Output root_Output = getbody().as(Get_Dealers_Root_Output.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, root_Output.message, "verify message");
		assertEquals(expDealerCode, root_Output.data.dealerDetails.get(0).dealerCode, "verify dealerCode");
		assertEquals(expDealerName, root_Output.data.dealerDetails.get(0).dealerName, "verify dealerName");
		assertEquals(expAreaOffice, root_Output.data.dealerDetails.get(0).areaOffice, "verify areaOffice");
		assertEquals(expZonalOffice, root_Output.data.dealerDetails.get(0).zonalOffice, "verify zonalOffice");
		assertEquals(expDealerMobileNo, root_Output.data.dealerDetails.get(0).dealerMobileNo, "verify dealerMobileNo");
		assertEquals(expCity, root_Output.data.dealerDetails.get(0).city, "verify city");
		assertEquals(expState, root_Output.data.dealerDetails.get(0).state, "verify state");
		assertEquals(expDistrict, root_Output.data.dealerDetails.get(0).district, "verify district");
		assertEquals(expPincode, root_Output.data.dealerDetails.get(0).pincode, "verify pincode");
		assertEquals(expBrandName, root_Output.data.dealerDetails.get(0).brandName, "verify brandName");
	}
	// <-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

	@Then("the response status for GetDealers should be {int} ,message {string} ,errorCode {int} and errorDescription {string}")
	public void the_response_status_for_get_dealers_should_be_message_error_code_and_error_description(
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
	// <---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

	@When("the user sends a request with {string} and invalid url {string} for GetDealers")
	public void the_user_sends_a_request_with_and_invalid_url_for_get_dealers(String post, String url) {
		addReqType(post, url);
	}

	@Then("the response status for GetDealers should be {int} ,message {string} and errorCode {string}")
	public void the_response_status_for_get_dealers_should_be_message_and_error_code(int expResponseCode,
			String expMessage, String expStatusCode) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		Root_InvalidUrl_Output_Pojo invalid_url_Root_Output = getbody().as(Root_InvalidUrl_Output_Pojo.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, invalid_url_Root_Output.message, "verify message");
		assertEquals(expStatusCode, invalid_url_Root_Output.statusCode, "verify status code");
	}
	// <---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

	@Then("the response status in GetDealers should be {int} message {string} ,errorCode {int} and errorDescription {string}")
	public void the_response_status_in_get_dealers_should_be_message_error_code_and_error_description(
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
//<----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
}
