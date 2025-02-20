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
import pojo_Search_Vehicle_Details_List.Search_Vehicle_Details_List_Root_Output;

public class Tc25_Search_Vehicle_Details_List extends BaseClass {

	PayloadManager payloadManager = new PayloadManager();

	@Given("the login API is available and add headers for search vehicle details list")
	public void the_login_api_is_available_and_add_headers_for_search_vehicle_details_list()
			throws FileNotFoundException, IOException {
		RestAssured.registerParser("text/plain", Parser.JSON);
		List<Header> list_headers = new ArrayList<>();
		Header h1 = new Header("appid", "External");
		Header h2 = new Header("specificAppId", "OneApp");
		Header h3 = new Header("ocp-apim-subscription-key", "2b6bbec34ce14a32b968411d7956e24c");
		Header h4 = new Header("Authorization", "Bearer " + getPropertyFileValue("SearchVehicleDetailListToken"));
		list_headers.add(h1);
		list_headers.add(h2);
		list_headers.add(h3);
		list_headers.add(h4);
		Headers headers = new Headers(list_headers);
		addHeaders(headers);
	}

	@When("user add requestBody with loginId {string} ,searchType {string} ,value {string} for search vehicle details list")
	public void user_add_request_body_with_login_id_search_type_value_for_search_vehicle_details_list(String loginId,
			String searchType, String value) throws FileNotFoundException, IOException {
		addReqBody(payloadManager.getSearch_Vehicle_Details_List_Payload().addDetails(loginId, searchType, value));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"searchVehicleDetails  URL is: " + getPropertyFileValue("searchVehicleDetails"));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"Request_payload: loginId =" + loginId + ",searchType=" + searchType + ",value=" + value);
	}

	@When("the user sends a request with {string} for search vehicle details list")
	public void the_user_sends_a_request_with_for_search_vehicle_details_list(String post)
			throws FileNotFoundException, IOException {
		addReqType(post, getPropertyFileValue("searchVehicleDetails"));
	}

	@Then("the response status for search vehicle details list should be {int} ,message {string} ,regNo {string} ,vin {string} ,model {string} ,mobile {string} ,customerIdentifier {string} and engineNo {string}")
	public void the_response_status_for_search_vehicle_details_list_should_be_message_reg_no_vin_model_mobile_customer_identifier_and_engine_no(
			int expResponseCode, String expMessage, String expRegNo, String expVin, String expModel, String expMobile,
			String expCustomerIdentifier, String expEngineNo) {

		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());

		Search_Vehicle_Details_List_Root_Output root_Ouput = getbody()
				.as(Search_Vehicle_Details_List_Root_Output.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, root_Ouput.message, "verify message");
		assertEquals(expRegNo, root_Ouput.data.vehicleSearchList.get(0).regNo, "verify regNo");
		assertEquals(expVin, root_Ouput.data.vehicleSearchList.get(0).vin, "verify vin");
		assertEquals(expModel, root_Ouput.data.vehicleSearchList.get(0).model, "verify model");
		assertEquals(expMobile, root_Ouput.data.vehicleSearchList.get(0).mobile, "verify Mobile");
		assertEquals(expCustomerIdentifier, root_Ouput.data.vehicleSearchList.get(0).customerIdentifier,
				"verify customerIdentifier");
		assertEquals(expEngineNo, root_Ouput.data.vehicleSearchList.get(0).engineNo, "verify engineNo");

	}
//<--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

	@Then("the response status for search vehicle details list should be {int} ,message {string} ,errorCode {int} and errorDescription {string}")
	public void the_response_status_for_search_vehicle_details_list_should_be_message_error_code_and_error_description(
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
	// <--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

	@Then("the response status for search vehicle details list should be {int} and message {string}")
	public void the_response_status_for_search_vehicle_details_list_should_be_and_message(int expResponseCode,
			String expMessage) {
		System.out.println(getResponseCode());
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getResBodyAsString());
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, getResBodyAsString(), "verify response code");
	}

//<------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
	@When("the user sends a request with {string} and invalid url {string} for search vehicle detail list")
	public void the_user_sends_a_request_with_and_invalid_url_for_search_vehicle_detail_list(String post, String url) {
		addReqType(post, url);
	}

	@Then("the response status for search vehicle detail list should be {int} ,message {string} and errorCode {string}")
	public void the_response_status_for_search_vehicle_detail_list_should_be_message_and_error_code(int expResponseCode,
			String expMessage, String expErrorCode) {

		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		Root_InvalidUrl_Output_Pojo invalid_url_Root_Output = getbody().as(Root_InvalidUrl_Output_Pojo.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, invalid_url_Root_Output.message, "verify message");
		assertEquals(expErrorCode, invalid_url_Root_Output.statusCode, "verify status code");

	}
//<--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
}
