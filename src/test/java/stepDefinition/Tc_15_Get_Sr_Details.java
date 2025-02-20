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
import pojo_Get_Sr_Details.Get_Sr_Details_Root_Output;

public class Tc_15_Get_Sr_Details extends BaseClass {

	PayloadManager payloadManager = new PayloadManager();

	@Given("the login API is available and add headers for GetSrDetails")
	public void the_login_api_is_available_and_add_headers_for_get_sr_details()
			throws FileNotFoundException, IOException {
		RestAssured.registerParser("text/plain", Parser.JSON);
		List<Header> list_headers = new ArrayList<>();
		Header h1 = new Header("appid", "External");
		Header h2 = new Header("specificAppId", "OneApp");
		Header h3 = new Header("ocp-apim-subscription-key", "2b6bbec34ce14a32b968411d7956e24c");
		Header h4 = new Header("Authorization", "Bearer " + getPropertyFileValue("getsrDetailsToken"));
		list_headers.add(h1);
		list_headers.add(h2);
		list_headers.add(h3);
		list_headers.add(h4);
		Headers headers = new Headers(list_headers);
		addHeaders(headers);
	}

	@When("user add requestBody with customerIdentifier {string} ,vinNo {string} and srNo {string}  for GetSrDetails")
	public void user_add_request_body_with_customer_identifier_vin_no_and_sr_no_for_get_sr_details(
			String CustIdentifier, String vinNo, String srNo) throws FileNotFoundException, IOException {
		addReqBody(payloadManager.get_Sr_Details_Payload().addDetails(CustIdentifier, vinNo, srNo));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"GetSrDetails URL is: " + getPropertyFileValue("GetSrDetails"));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"Request_payload: customer identifier=" + CustIdentifier + ",vinNo=" + vinNo + ",srNo=" + srNo);
	}

	@When("the user sends a request with {string} for GetSrDetails")
	public void the_user_sends_a_request_with_for_get_sr_details(String post)
			throws FileNotFoundException, IOException {

		addReqType(post, getPropertyFileValue("GetSrDetails"));
	}

	@Then("the response status for GetSrDetails should be {int} ,message {string} ,serviceType {string} ,estimatedTime {string} ,odometerReading {string} ,dealerName {string} ,jobCardOpenDate {string} ,dealerCode {string} ,divisionName {string} ,jobCardCompletedDate {string} ,serviceBookingNumber {string} ,serviceBookingDate {string} and jobCardNumber {string}")
	public void the_response_status_for_get_sr_details_should_be_message_service_type_estimated_time_odometer_reading_dealer_name_job_card_open_date_dealer_code_division_name_job_card_completed_date_service_booking_number_service_booking_date_and_job_card_number(
			int expResponseCode, String expMessage, String expServiceType, String expEstimatedTime,
			String expOdometerReading, String expDealerName, String expJbCardOpenDate, String expDealerCode,
			String expDivisionName, String expJobCardCompletedDate, String expServiceBookingNumber,
			String expServiceBookingDate, String expJobCardNumber) {

		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		Get_Sr_Details_Root_Output root_Output = getbody().as(Get_Sr_Details_Root_Output.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, root_Output.message, "verify message");
		assertEquals(expServiceType, root_Output.data.serviceType, "verify ServiceType");
		assertEquals(expEstimatedTime, root_Output.data.estimatedTime, "verify EstimatedTime");
		assertEquals(expOdometerReading, root_Output.data.odometerReading, "verify OdometerReading");
		assertEquals(expDealerName, root_Output.data.dealerName, "verify DealerName");
		assertEquals(expJbCardOpenDate, root_Output.data.jobCardOpenDate, "verify JbCardOpenDate");
		assertEquals(expDealerCode, root_Output.data.dealerCode, "verify DealerCode");
		assertEquals(expDivisionName, root_Output.data.divisionName, "verify DivisionName");
		assertEquals(expJobCardCompletedDate, root_Output.data.jobCardCompletedDate, "verify JobCardCompletedDate");
		assertEquals(expServiceBookingNumber, root_Output.data.serviceBookingNumber, "verify ServiceBookingNumber");
		assertEquals(expServiceBookingDate, root_Output.data.serviceBookingDate, "verify ServiceBookingDate");
		assertEquals(expJobCardCompletedDate, root_Output.data.jobCardCompletedDate, "verify JobCardCompletedDate");
		assertEquals(expJobCardNumber, root_Output.data.jobCardNumber, "verify JobCardNumber");
	}
	// <--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

	@When("the user sends request {string} for GetSrDetails with invalid url {string}")
	public void the_user_sends_request_for_get_sr_details_with_invalid_url(String post, String url)
			throws FileNotFoundException, IOException {
		addReqType(post, url);
	}

	@Then("the response status for GetSrDetails should be {int} ,message {string} and errorCode {string}")
	public void the_response_status_for_get_sr_details_should_be_message_and_error_code(Integer expResponseCode,
			String expMessage, String expErrorCode) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		Root_InvalidUrl_Output_Pojo invalid_url_Root_Output = getbody().as(Root_InvalidUrl_Output_Pojo.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, invalid_url_Root_Output.message, "verify message");
		assertEquals(expErrorCode, invalid_url_Root_Output.statusCode, "verify status code");
	}

	// <------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
	@Then("the response status in GetSrDetails for empty request body should be {int}")
	public void the_response_status_in_get_sr_details_for_empty_request_body_should_be(int expResponseCode) {
		System.out.println(getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Request payload: " + "");
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
	}

	// <------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

	@Then("the response status for GetSrDetails should be {int} ,message {string} and errorCode {int}")
	public void the_response_status_for_get_sr_details_should_be_message_and_error_code(int expResponseCode,
			String expMessage, int expStatusCode) {
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

	// <---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
	@Then("the response status for GetSrDetails should be {int} ,message {string} ,errorCode {int} and errorDescription {string}")
	public void the_response_status_for_get_sr_details_should_be_message_error_code_and_error_description(
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
	// <---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

}
