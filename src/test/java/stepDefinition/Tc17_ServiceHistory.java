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
import pojo_ServiceHistory.ServiceHistory_Root_Ouput;

public class Tc17_ServiceHistory extends BaseClass {

	PayloadManager payloadManager = new PayloadManager();

	@Given("the login API is available and add headers for ServiceHistory")
	public void the_login_api_is_available_and_add_headers_for_service_history()
			throws FileNotFoundException, IOException {
		RestAssured.registerParser("text/plain", Parser.JSON);
		List<Header> list_headers = new ArrayList<>();
		Header h1 = new Header("appid", "External");
		Header h2 = new Header("specificAppId", "OneApp");
		Header h3 = new Header("ocp-apim-subscription-key", "2b6bbec34ce14a32b968411d7956e24c");
		Header h4 = new Header("Authorization", "Bearer " + getPropertyFileValue("ServiceHistoryToken"));
		list_headers.add(h1);
		list_headers.add(h2);
		list_headers.add(h3);
		list_headers.add(h4);
		Headers headers = new Headers(list_headers);
		addHeaders(headers);

	}

	@When("user add requestBody with customerIdentifier {string} ,vin {string} and rowno {string} for ServiceHistory")
	public void user_add_request_body_with_customer_identifier_vin_and_rowno_for_service_history(
			String customerIdentifier, String vinNo, String rowNo) throws FileNotFoundException, IOException {
		addReqBody(payloadManager.getServiceHistory_Payload().addDetails(customerIdentifier, vinNo, rowNo));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"ServiceHistory  URL is: " + getPropertyFileValue("ServiceHistory"));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"Request_payload: customer identifier=" + customerIdentifier + ",vinNo=" + vinNo + ",rowNo=" + rowNo);
	}

	@When("the user sends a request with {string} for ServiceHistory")
	public void the_user_sends_a_request_with_for_service_history(String post)
			throws FileNotFoundException, IOException {

		addReqType(post, getPropertyFileValue("ServiceHistory"));
	}

	@Then("the response status for ServiceHistory should be {int} ,message {string} ,serviceType {string} ,odometerReading {string} ,invoiceNum is {string} ,dealerCode {string} ,estimatedPrice {string} ,serviceBookingNumber {string} ,serviceBookingDate {string} and jobCardNumber is {string}")
	public void the_response_status_for_service_history_should_be_message_service_type_odometer_reading_invoice_num_is_dealer_code_estimated_price_service_booking_number_service_booking_date_and_job_card_number_is(
			int expResponseCode, String expMessage, String serviceType, String odometerReading, String expInvoiceNum,
			String dealerCode, String estimatedPrice, String serviceBookingNumber, String serviceBookingDate,
			String expJobCardNumber) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		ServiceHistory_Root_Ouput root_Ouput = getbody().as(ServiceHistory_Root_Ouput.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, root_Ouput.message, "verify message");
		assertEquals(serviceType, root_Ouput.data.serviceHistory.get(0).serviceType, "verify serviceType");
		assertEquals(odometerReading, root_Ouput.data.serviceHistory.get(0).odometerReading, "verify odometerReading");
		assertEquals(expInvoiceNum, root_Ouput.data.serviceHistory.get(0).invoiceNum);
		assertEquals(dealerCode, root_Ouput.data.serviceHistory.get(0).dealerCode, "verify dealerCode");
		assertEquals(estimatedPrice, root_Ouput.data.serviceHistory.get(0).estimatedPrice, "verify estimatedPrice");
		assertEquals(serviceBookingNumber, root_Ouput.data.serviceHistory.get(0).serviceBookingNumber,
				"verify serviceBookingNumber");
		assertEquals(serviceBookingDate, root_Ouput.data.serviceHistory.get(0).serviceBookingDate,
				"verify serviceBookingDate");
		assertEquals(expJobCardNumber, root_Ouput.data.serviceHistory.get(0).jobCardNumber);

	}

	// <-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
	@When("the user sends a request with {string} and invalid url {string} for ServiceHistory")
	public void the_user_sends_a_request_with_and_invalid_url_for_service_history(String post, String url) {
		addReqType(post, url);
	}

	@Then("the response status for ServiceHistory should be {int} ,message {string} and errorCode {string}")
	public void the_response_status_for_service_history_should_be_message_and_error_code(int expResponseCode,
			String expMessage, String expStatusCode) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		Root_InvalidUrl_Output_Pojo invalid_url_Root_Output = getbody().as(Root_InvalidUrl_Output_Pojo.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, invalid_url_Root_Output.message, "verify message");
		assertEquals(expStatusCode, invalid_url_Root_Output.statusCode, "verify status code");
	}

//<----------------------------------------------------------------------------------------------------------------------------------------------------------->
	@Then("the response status in ServiceHistory should be {int} message {string} ,errorCode {int} and errorDescription {string}")
	public void the_response_status_in_service_history_should_be_message_error_code_and_error_description(
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

//<---------------------------------------------------------------------------------------------------------------------------------------------------------------->
	@Then("the response status for ServiceHistory should be {int} ,message {string}")
	public void the_response_status_for_service_history_should_be_message(int expResponseCode, String expMessage) {

		System.out.println(getbody().asPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		Invalid_Customer_Identifier_Root_Output root_Output = getbody()
				.as(Invalid_Customer_Identifier_Root_Output.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, root_Output.message, "verify message");
		assertEquals(expResponseCode, root_Output.errorCode, "verify error code");
		assertFalse(root_Output.success);
	}

//<---------------------------------------------------------------------------------------------------------------------------------------------------------->

	@Given("the login API is available and adding headers for ServiceHistory")
	public void the_login_api_is_available_and_adding_headers_for_service_history()
			throws FileNotFoundException, IOException {
		RestAssured.registerParser("text/plain", Parser.JSON);
		List<Header> list_headers = new ArrayList<>();
		Header h1 = new Header("appid", "External");
		Header h2 = new Header("specificAppId", "OneApp");
		Header h3 = new Header("ocp-apim-subscription-key", "2b6bbec34ce14a32b968411d7956e24c");
		Header h4 = new Header("Authorization", "Bearer " + getPropertyFileValue("ServiceHistoryToken1"));
		list_headers.add(h1);
		list_headers.add(h2);
		list_headers.add(h3);
		list_headers.add(h4);
		Headers headers = new Headers(list_headers);
		addHeaders(headers);

	}

	@Then("the response status for ServiceHistory should be {int} ,message {string} ,serviceType {string} ,odometerReading {string} ,dealerName {string} ,jobCardOpenDate {string} and dealerCode {string}")
	public void the_response_status_for_service_history_should_be_message_service_type_odometer_reading_dealer_name_job_card_open_date_and_dealer_code(
			int expResponseCode, String expMessage, String expServiceType, String expOdometerReading,
			String expDealerName, String expJobCardOpenDate, String expDealerCode) {

		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		ServiceHistory_Root_Ouput root_Ouput = getbody().as(ServiceHistory_Root_Ouput.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, root_Ouput.message, "verify message");
		assertEquals(expServiceType, root_Ouput.data.serviceHistory.get(4).serviceType, "verify serviceType");
		assertEquals(expOdometerReading, root_Ouput.data.serviceHistory.get(4).odometerReading,
				"verify odometerReading");
		assertEquals(expDealerName, root_Ouput.data.serviceHistory.get(4).dealerName, "verify dealerName");
		assertEquals(expJobCardOpenDate, root_Ouput.data.serviceHistory.get(4).jobCardOpenDate,
				"verify jobCardOpenDate");
		assertEquals(expDealerCode, root_Ouput.data.serviceHistory.get(4).dealerCode, "verify dealerCode");

		assertEquals(5, root_Ouput.data.serviceHistory.size(), "verify size");
	}

	// <------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------>
	@Then("the response status for ServiceHistory for rows ten should be {int} ,message {string} ,serviceType {string} ,odometerReading {string} ,city {string} ,dealerName {string} ,jobCardOpenDate {string} and dealerCode {string}")
	public void the_response_status_for_service_history_for_rows_ten_should_be_message_service_type_odometer_reading_city_dealer_name_job_card_open_date_and_dealer_code(
			int expResponseCode, String expMessage, String expServiceType, String expOdometerReading, String expCity,
			String expDealerName, String expJobCardOpenDate, String expDealerCode) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		ServiceHistory_Root_Ouput root_Ouput = getbody().as(ServiceHistory_Root_Ouput.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, root_Ouput.message, "verify message");
		assertEquals(expServiceType, root_Ouput.data.serviceHistory.get(9).serviceType, "verify serviceType");
		assertEquals(expOdometerReading, root_Ouput.data.serviceHistory.get(9).odometerReading,
				"verify odometerReading");
		assertEquals(expCity, root_Ouput.data.serviceHistory.get(9).city, "verify city");
		assertEquals(expDealerName, root_Ouput.data.serviceHistory.get(9).dealerName, "verify dealerName");
		assertEquals(expJobCardOpenDate, root_Ouput.data.serviceHistory.get(9).jobCardOpenDate,
				"verify jobCardOpenDate");
		assertEquals(expDealerCode, root_Ouput.data.serviceHistory.get(9).dealerCode, "verify dealerCode");

		assertEquals(10, root_Ouput.data.serviceHistory.size(), "verify size");

	}
	// <------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
}
