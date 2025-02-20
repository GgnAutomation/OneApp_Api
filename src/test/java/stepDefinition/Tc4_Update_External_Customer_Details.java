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
import pojo_Update_Customer_Details.Update_Customer_Details_Root_Output;

public class Tc4_Update_External_Customer_Details extends BaseClass {

	PayloadManager payloadManager = new PayloadManager();

	@Given("the login API is available and add headers and access token for update external customer detail")
	public void the_login_api_is_available_and_add_headers_and_access_token_for_update_external_customer_detail()
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

	@When("user add requestBody with customerIdentifier,birthDate {string},firstName {string},lastName {string},gender {string},email {string},bloodGroup {string},addressLine1 {string},city {string},state {string},pincode {string} and isExisting {int} for update external customer detail")
	public void user_add_request_body_with_customer_identifier_birth_date_first_name_last_name_gender_email_blood_group_address_line1_city_state_pincode_and_is_existing_for_in_update_external_customer_detail(
			String birthDate, String firstName, String lastName, String gender, String email, String bloodGroup,
			String addressLine1, String city, String state, String pincode, int isExisting)
			throws FileNotFoundException, IOException {
		addReqBody(payloadManager.getUpdate_Customer_Details().addDetails(
				getPropertyFileValue("GetExternalCustIdentifier"), birthDate, firstName, lastName, gender, email,
				bloodGroup, addressLine1, city, state, pincode, isExisting));

		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"UpdateExternalCustomerProfile URL is: " + getPropertyFileValue("UpdateExternalCustomerProfile"));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"Request_payload: CustomerIdentifier=" + getPropertyFileValue("ValidExternalVinIdIdentifier")
						+ ",birthDate =" + birthDate + ",firstname =" + firstName + ",lastname =" + lastName
						+ ",gender =" + gender + ",email =" + email + ",bloodGroup =" + bloodGroup + ",addressLine1 ="
						+ addressLine1 + ",city =" + city + ",state =" + state + ",pincode =" + pincode
						+ ",isExisting =" + isExisting);
	}

	@When("the user sends a request with {string} for update external customer detail")
	public void the_user_sends_a_request_with_for_update_external_customer_detail(String post)
			throws FileNotFoundException, IOException {
		addReqType(post, getPropertyFileValue("UpdateExternalCustomerProfile"));
	}

	@Then("the response status for update external customer detail should be {int} ,message {string} ,birthDate {string} ,firstName {string} ,lastName {string} ,gender {string} ,email {string} ,bloodGroup {string} ,addressLine1 {string} ,city {string} ,state {string} ,pincode {string} and isExisting {int}")
	public void the_response_status_for_update_external_customer_detail_should_be_message_birth_date_first_name_last_name_gender_email_blood_group_address_line1_city_state_pincode_and_is_existing(
			int expResponseCode, String expMessage, String expBirthDate, String expFirstName, String expLastName,
			String expGender, String expEmail, String expBloodGroup, String expAddressLine1, String expCity,
			String expState, String expPincode, int expIsExisting) throws FileNotFoundException, IOException {
		System.out.println(getbody().asPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, " Response code is " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		Update_Customer_Details_Root_Output root_Ouput = getbody().as(Update_Customer_Details_Root_Output.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, root_Ouput.message, "verify message");
		assertEquals(expBirthDate, root_Ouput.data.birthDate, "verify birth date");
		assertEquals(expLastName, root_Ouput.data.lastName, "verify last name");
		assertEquals(expFirstName, root_Ouput.data.firstName, "verify firstname");
		assertEquals(expGender, root_Ouput.data.gender, "verify gender");
		assertEquals(expEmail, root_Ouput.data.email, "verify Email");
		assertEquals(expBloodGroup, root_Ouput.data.bloodGroup, "verify bloog group");
		assertEquals(expAddressLine1, root_Ouput.data.addressLine1, "verify addressLine1 ");
		assertEquals(expCity, root_Ouput.data.city, "verify city");
		assertEquals(expState, root_Ouput.data.state, "verify state");
		assertEquals(expPincode, root_Ouput.data.pincode, "verify pincode");
		assertEquals(Integer.toString(expIsExisting), root_Ouput.data.isExisting, "verify Isexisting");
	}

//<--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
	@Then("the response status for update external customer detail should be {int} ,message {string} ,errorCode {int} and errorDescription {string}")
	public void the_response_status_for_update_external_customer_detail_should_be_message_error_code_and_error_description(
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

	// <----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
	@When("the user sends request {string} for update customer details with invalid url {string}")
	public void the_user_sends_request_for_update_customer_details_with_invalid_url(String post, String url) {
		addReqType(post, url);
	}

	@Then("the response status for update customer details should be {int} and message {string}")
	public void the_response_status_for_update_customer_details_should_be_and_message(int expResponsecode,
			String expMessage) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());

		Root_InvalidUrl_Output_Pojo output_Pojo = getbody().as(Root_InvalidUrl_Output_Pojo.class);
		assertEquals(expMessage, output_Pojo.message, "verify message");
		assertEquals(expResponsecode, getResponseCode(), "verify response code");

	}
	// <---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

	@Then("the response status in update external customer details for empty request body should be {string}")
	public void the_response_status_in_update_external_customer_details_for_empty_request_body_should_be(String expResponseCode) {
		System.out.println(getResponseCode());
		int responseCode = getResponseCode();
		String actualResponse = Integer.toString(responseCode);
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		assertEquals(actualResponse, expResponseCode, "verify ResponseCode");
	}
	//<--------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
}
