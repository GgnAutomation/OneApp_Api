package stepDefinition;

import static org.testng.Assert.assertEquals;
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
import pojo_CheckAppVersion.CheckAppVersion_Root_Output;
import pojo_Get_External_Cust_Details.In_Valid_Customer_Identifer_Root_Output;

public class Tc_29_CheckAppVersion extends BaseClass {

	PayloadManager payloadManager = new PayloadManager();

	@Given("the login API is available and add headers for CheckAppVersion")
	public void the_login_api_is_available_and_add_headers_for_check_app_version() {
		RestAssured.registerParser("text/plain", Parser.JSON);
		List<Header> list_headers = new ArrayList<>();
		Header h1 = new Header("appid", "External");
		Header h2 = new Header("specificAppId", "OneApp");
		Header h3 = new Header("ocp-apim-subscription-key", "31110036a520491dacc8a96ee18aaa61");
		list_headers.add(h1);
		list_headers.add(h2);
		list_headers.add(h3);
		Headers headers = new Headers(list_headers);
		addHeaders(headers);

	}

	@When("user add requestBody with deviceType {string} and userAppVersion {string} for CheckAppVersion")
	public void user_add_request_body_with_device_type_and_user_app_version_for_check_app_version(String deviceType,
			String userAppVersion) throws FileNotFoundException, IOException {
		addReqBody(payloadManager.getCheckAppVersion_Payloads().addDetails(deviceType, userAppVersion));

		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"CheckAppVersion URL is: " + getPropertyFileValue("CheckAppVersion"));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
				"Request_payload: deviceType=" + deviceType + ",userAppVersion=" + userAppVersion);

	}

	@When("the user sends a request with {string} for CheckAppVersion")
	public void the_user_sends_a_request_with_for_check_app_version(String post)
			throws FileNotFoundException, IOException {

		addReqType(post, getPropertyFileValue("CheckAppVersion"));
	}

	@Then("the response status for CheckAppVersion should be {int} ,message {string} ,checkVersion {string} ,serviceToken {string} ,salesToken {string} ,serviceDomain {string} ,salesDomain {string} ,currentAppReleaseVersion {string} ,whatNew {string} and isMandatory {string}")
	public void the_response_status_for_check_app_version_should_be_message_check_version_service_token_sales_token_service_domain_sales_domain_current_app_release_version_what_new_and_is_mandatory(
			int expResponseCode, String expMessage, String expCheckVersion, String expServiceToken,
			String expSalesToken, String expServiceDomain, String expSalesDomain, String expCurrentAppReleaseVersion,
			String expWhatNew, String expIsMandatory) {

		System.out.print(getbody().asPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		CheckAppVersion_Root_Output root_Output = getbody().as(CheckAppVersion_Root_Output.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, root_Output.message, "verify message");
		assertEquals(expCheckVersion, root_Output.data.checkVersion, "verify check version");
		assertEquals(expServiceToken, root_Output.data.serviceToken, "verify serviceToken");
		assertEquals(expSalesToken, root_Output.data.salesToken, "verify serviceToken");
		assertEquals(expServiceDomain, root_Output.data.serviceDomain, "verify serviceToken");
		assertEquals(expSalesDomain, root_Output.data.salesDomain, "verify serviceToken");
		assertEquals(expCurrentAppReleaseVersion, root_Output.data.currentAppReleaseVersion, "verify serviceToken");
		assertTrue(root_Output.data.whatNew.get(0).contains(expWhatNew), "verify WhatNew");
		assertEquals(expIsMandatory, root_Output.data.isMandatory, "verify isMandatory");
	}

	// <---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
	@When("the user sends a request with {string} and invalid url {string} for CheckAppVersion")
	public void the_user_sends_a_request_with_and_invalid_url_for_check_app_version(String post, String url) {
		addReqType(post, url);

	}

	@Then("the response status for CheckAppVersion should be {int} ,message {string} and errorCode {string}")
	public void the_response_status_for_check_app_version_should_be_message_and_error_code(int expResponseCode,
			String expMessage, String expErrorCode) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Generated is: " + getbody().asPrettyString());
		Root_InvalidUrl_Output_Pojo invalid_url_Root_Output = getbody().as(Root_InvalidUrl_Output_Pojo.class);
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
		assertEquals(expMessage, invalid_url_Root_Output.message, "verify message");
		assertEquals(expErrorCode, invalid_url_Root_Output.statusCode, "verify status code");
	}
//<------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------>

	@Then("the response status for CheckAppVersion should be {int}")
	public void the_response_status_for_check_app_version_should_be(int expResponseCode) {
		System.out.println(getResBodyAsPrettyString());
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Response Status code is: " + getResponseCode());
		assertEquals(expResponseCode, getResponseCode(), "verify response code");
	}

//<---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
	@Then("the response status in CheckAppVersion should be {int} message {string} ,errorCode {int} and errorDescription {string}")
	public void the_response_status_in_check_app_version_should_be_message_error_code_and_error_description(
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
//<------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------>
}
