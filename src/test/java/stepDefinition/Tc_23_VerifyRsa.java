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
import pojo_VerifyRSA.VerifyRSA_Root_Output;

public class Tc_23_VerifyRsa extends BaseClass {

	PayloadManager payloadManager = new PayloadManager();

	@Given("the login API is available and add headers for VerifyRsa")
	public void the_login_api_is_available_and_add_headers_for_verify_rsa() {

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

	@When("user add requestBody with mobileNo {string} ,vinNo {string} for VerifyRsa")
	public void user_add_request_body_with_mobile_no_vin_no_for_verify_rsa(String mobileNo, String vinNo)
			throws FileNotFoundException, IOException {

		addReqBody(payloadManager.getVerifyRsa_Payloads().addDetails(mobileNo, vinNo));

		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"VerifyRsa URL is: " + getPropertyFileValue("VerifyRsa"));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"Request_payload: mobileNo=" + mobileNo + ",vinNo=" + vinNo);

	}

	@When("the user sends a request with {string} for VerifyRsa")
	public void the_user_sends_a_request_with_for_verify_rsa(String post) throws FileNotFoundException, IOException {

		addReqType(post, getPropertyFileValue("VerifyRsa"));
	}

	@Then("the response status for VerifyRsa should be {int} ,message {string} ,isRsaMember {string} ,isGaMember {string} ,rsaMembershipStatus {string} ,membershipStartDate {string} ,membershipEndDate {string} ,rsaPolicyNumber {string} and rsaVendorName {string}")
	public void the_response_status_for_verify_rsa_should_be_message_is_rsa_member_is_ga_member_rsa_membership_status_membership_start_date_membership_end_date_rsa_policy_number_and_rsa_vendor_name(
			int expResponseCode, String expMessage, String expIsRsaMember, String expIsGaMember,
			String expRsaMembershipStatus, String expMembershipStartDate, String expMembershipEndDate,
			String expRsaPolicyNumber, String expRsaVendorName) {

		System.out.print(getbody().asPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		VerifyRSA_Root_Output root_Output = getbody().as(VerifyRSA_Root_Output.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, root_Output.message, "verify message");
		assertEquals(expIsRsaMember, root_Output.data.isRsaMember, "verify isRsaMember");
		assertEquals(expIsGaMember, root_Output.data.isGaMember, "verify isGaMember");
		assertEquals(expRsaMembershipStatus, root_Output.data.rsaMembershipStatus, "verify rsaMembershipStatus");
		assertEquals(expMembershipStartDate, root_Output.data.membershipStartDate, "verify membershipStartDate");
		assertEquals(expMembershipEndDate, root_Output.data.membershipEndDate, "verify membershipEndDate");
		assertEquals(expRsaPolicyNumber, root_Output.data.rsaPolicyNumber, "verify rsaPolicyNumber");
		assertEquals(expRsaVendorName, root_Output.data.rsaVendorName, "verify rsaVendorName");
	}
	// <-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

	@Then("the response status in VerifyRsa should be {int} message {string} ,errorCode {int} and errorDescription {string}")
	public void the_response_status_in_verify_rsa_should_be_message_error_code_and_error_description(
			int expResponseCode, String expMessage, int experrorCode, String expErrorDescription) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());

		In_Valid_Customer_Identifer_Root_Output Root_Output = getbody()
				.as(In_Valid_Customer_Identifer_Root_Output.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, Root_Output.message, "verify message");
		assertEquals(experrorCode, Root_Output.errorCode, "verify Error code");
		assertEquals(expErrorDescription, Root_Output.errorDescription, "verify Error Decsription");
	}
	// <--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

	@When("the user sends a request with {string} and invalid url {string} for VerifyRsa")
	public void the_user_sends_a_request_with_and_invalid_url_for_verify_rsa(String post, String url) {
		addReqType(post, url);

	}

	@Then("the response status for VerifyRsa should be {int} ,message {string} and errorCode {string}")
	public void the_response_status_for_verify_rsa_should_be_message_and_error_code(int expResponseCode,
			String expMessage, String expErrorCode) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		Root_InvalidUrl_Output_Pojo invalid_url_Root_Output = getbody().as(Root_InvalidUrl_Output_Pojo.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, invalid_url_Root_Output.message, "verify message");
		assertEquals(expErrorCode, invalid_url_Root_Output.statusCode, "verify status code");
	}
	// <------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

	@Then("the response status for VerifyRsa should be {int} ,message {string} ,isRsaMember {string}")
	public void the_response_status_for_verify_rsa_should_be_message_is_rsa_member(int expResponseCode, String expMessage, String expIsRsaMember) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		VerifyRSA_Root_Output root_Output = getbody().as(VerifyRSA_Root_Output.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, root_Output.message, "verify message");
		assertEquals(expIsRsaMember, root_Output.data.isRsaMember, "verify isRsaMember");
	}
	//<----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
	@Then("the response status for VerifyRsa should be {int} ,message {string} and rsaMembershipStatus {string}")
	public void the_response_status_for_verify_rsa_should_be_message_and_rsa_membership_status(int expResponseCode, String expMessage, String expRsaMembershipStatus) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		VerifyRSA_Root_Output root_Output = getbody().as(VerifyRSA_Root_Output.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, root_Output.message, "verify message");
		assertEquals(expRsaMembershipStatus, root_Output.data.rsaMembershipStatus, "verify rsaMembershipStatus");
	}
	//<------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------>
	@Then("the response status for VerifyRsa should be {int} ,message {string} and rsaVendorName {string}")
	public void the_response_status_for_verify_rsa_should_be_message_and_rsa_vendor_name(int expResponseCode, String expMessage, String expRsaVendorName) {
	 
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		VerifyRSA_Root_Output root_Output = getbody().as(VerifyRSA_Root_Output.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, root_Output.message, "verify message");
		assertEquals(expRsaVendorName, root_Output.data.rsaVendorName, "verify rsaVendorName");
	}
	//<---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
	
	@Then("the response status for VerifyRsa should be {int} ,message {string} ,isRsaMember {string} and rsaVendorName {string}")
	public void the_response_status_for_verify_rsa_should_be_message_is_rsa_member_and_rsa_vendor_name(int expResponseCode, String expMessage,String expIsRsaMember, String expRsaVendorName) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		VerifyRSA_Root_Output root_Output = getbody().as(VerifyRSA_Root_Output.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, root_Output.message, "verify message");
		assertEquals(expIsRsaMember, root_Output.data.isRsaMember, "verify isRsaMember");
		assertEquals(expRsaVendorName, root_Output.data.rsaVendorName, "verify rsaVendorName");
	}
	//<--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
}
