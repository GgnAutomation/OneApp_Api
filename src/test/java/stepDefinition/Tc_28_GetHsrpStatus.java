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
import pojoClass_ExternalLogin.Root_InvalidUrl_Output_Pojo;
import pojo_GetHsrpStatus.GetHsrpStatus_Root_Output;
import pojo_Get_External_Cust_Details.In_Valid_Customer_Identifer_Root_Output;
import pojo_UpdateVehicleDetails.UpdateVehicleDetails_Root_Output;

public class Tc_28_GetHsrpStatus extends BaseClass {

	PayloadManager payloadManager = new PayloadManager();

	@Given("the login API is available and add headers for GetHsrpStatus")
	public void the_login_api_is_available_and_add_headers_for_get_hsrp_status()
			throws FileNotFoundException, IOException {
		RestAssured.registerParser("text/plain", Parser.JSON);
		List<Header> list_headers = new ArrayList<>();
		Header h1 = new Header("appid", "External");
		Header h2 = new Header("specificAppId", "OneApp");
		Header h3 = new Header("ocp-apim-subscription-key", "2b6bbec34ce14a32b968411d7956e24c");
		Header h4 = new Header("Authorization", "Bearer " + getPropertyFileValue("GetHsrpStatusToken"));
		list_headers.add(h1);
		list_headers.add(h2);
		list_headers.add(h3);
		list_headers.add(h4);
		Headers headers = new Headers(list_headers);
		addHeaders(headers);
	}

	@When("user add requestBody with mobileNo {string} ,vinNo {string} for GetHsrpStatus")
	public void user_add_request_body_with_mobile_no_vin_no_for_get_hsrp_status(String mobileNo, String vinNo)
			throws FileNotFoundException, IOException {

		addReqBody(payloadManager.getHsrpStatus_Payloads().addDetails(mobileNo, vinNo));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"GetHsrpStatus URL is: " + getPropertyFileValue("GetHsrpStatus"));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"Request_payload: mobileNo=" + mobileNo + ",vinNo =" + vinNo);

	}

	@When("the user sends a request with {string} for GetHsrpStatus")
	public void the_user_sends_a_request_with_for_get_hsrp_status(String post)
			throws FileNotFoundException, IOException {

		addReqType(post, getPropertyFileValue("GetHsrpStatus"));
	}

	@Then("the response status for GetHsrpStatus should be {int} ,message {string} ,licenceNumber {string} and fitmentStatus {string}")
	public void the_response_status_for_get_hsrp_status_should_be_message_licence_number_and_fitment_status(
			int expResponseCode, String expMessage, String expLicenceNumber, String expFitmentStatus) {

		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());

		GetHsrpStatus_Root_Output root_Output = getbody().as(GetHsrpStatus_Root_Output.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, root_Output.message, "verify message");
		assertEquals(expLicenceNumber, root_Output.data.licenceNumber, "verify licenceNumber");
		assertEquals(expFitmentStatus, root_Output.data.fitmentStatus, "verify fitmentStatus ");
		assertTrue(root_Output.success);
	}
	// <------------------------------------------------------------------------------------------------------------------------------------------------------------->

	@When("the user sends a request with {string} and invalid url {string} for GetHsrpStatus")
	public void the_user_sends_a_request_with_and_invalid_url_for_get_hsrp_status(String post, String url) {
		addReqType(post, url);

	}

	@Then("the response status for GetHsrpStatus should be {int} ,message {string} and errorCode {string}")
	public void the_response_status_for_get_hsrp_status_should_be_message_and_error_code(int expResponseCode,
			String expMessage, String expErrorCode) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		Root_InvalidUrl_Output_Pojo invalid_url_Root_Output = getbody().as(Root_InvalidUrl_Output_Pojo.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, invalid_url_Root_Output.message, "verify message");
		assertEquals(expErrorCode, invalid_url_Root_Output.statusCode, "verify status code");
	}
	// <------------------------------------------------------------------------------------------------------------------------------------------------------------------->

	@Then("the response status in GetHsrpStatus should be {int} ,message {string} ,errorCode {int} and errorDescription {string}")
	public void the_response_status_in_get_hsrp_status_should_be_message_error_code_and_error_description(
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
	// <--------------------------------------------------------------------------------------------------------------------------------------------------------------------->

	@Given("the login API is available and add headers for updateVehicleDetails")
	public void the_login_api_is_available_and_add_headers_for_update_vehicle_details()
			throws FileNotFoundException, IOException {
		RestAssured.registerParser("text/plain", Parser.JSON);
		List<Header> list_headers = new ArrayList<>();
		Header h1 = new Header("appid", "External");
		Header h2 = new Header("specificAppId", "OneApp");
		Header h3 = new Header("ocp-apim-subscription-key", "2b6bbec34ce14a32b968411d7956e24c");
		Header h4 = new Header("Authorization", "Bearer " + getPropertyFileValue("updateVehicleDetailsToken"));
		list_headers.add(h1);
		list_headers.add(h2);
		list_headers.add(h3);
		list_headers.add(h4);
		Headers headers = new Headers(list_headers);
		addHeaders(headers);

	}

	@When("user add requestBody with vinId {string} ,customerIdentifier {string} and fitmentStatus {string} for updateVehicleDetails")
	public void user_add_request_body_with_vin_id_customer_identifier_and_fitment_status_for_update_vehicle_details(
			String vinId, String customerIdentifier, String fitmentStatus) throws FileNotFoundException, IOException {

		addReqBody(
				payloadManager.getUpdateVehicleDetails_Payload().addDetails(vinId, customerIdentifier, fitmentStatus));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"updateVehicleDetails URL is: " + getPropertyFileValue("updateVehicleDetails"));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Request_payload: vinId=" + vinId
				+ ",customerIdentifier =" + customerIdentifier + ",fitmentStatus =" + fitmentStatus);

	}

	@When("the user sends a request with {string} for updateVehicleDetails")
	public void the_user_sends_a_request_with_for_update_vehicle_details(String post)
			throws FileNotFoundException, IOException {

		addReqType(post, getPropertyFileValue("updateVehicleDetails"));
	}

	@Then("the response status for updateVehicleDetails should be {int} ,message {string} ,vinId {string} ,customerIdentifier {string} ,Fitmentmessage {string}, and fitmentStatus {string}")
	public void the_response_status_for_update_vehicle_details_should_be_message_vin_id_customer_identifier_fitmentmessage_and_fitment_status(
			int expResponseCode, String expMessage, String expVinId, String expCustomerIdentifier, String expFitmentmessage, String expFitmentStatus) {

		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());

		UpdateVehicleDetails_Root_Output root_Output = getbody().as(UpdateVehicleDetails_Root_Output.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, root_Output.message, "verify message");
		assertEquals(expVinId, root_Output.data.vinId,"verify vinId");
		assertEquals(expCustomerIdentifier, root_Output.data.customerIdentifier,"verify CustomerIdentifier");
		assertEquals(expFitmentmessage, root_Output.data.message,"verify Fitmentmessage");
		assertEquals(expFitmentStatus, root_Output.data.fitmentStatus,"verify FitmentStatus");
		
	}
	//<-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

}
