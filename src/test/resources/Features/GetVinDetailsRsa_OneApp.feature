Feature: OneApp Enterprise : API Login Testing

  @InvalidUrl
  Scenario: Validate response if user enters invalid Url in get vehicle details list Rsa
    Given the login API is available and add headers and access token for get vehicle details for Rsa
    When user add requestBody with loginId "7004813003" ,searchType "mobile" and value "7004813003" get vehicle details for Rsa
    And the user sends a request with "POST" and invalid url "https://dev-apim.heromotocorp.com/api/GetVehicleDetailsList" for get vehicle details for Rsa
    Then the response status for get vehicle details for Rsa should be 404 ,message "Resource not found" and errorCode "404"

  @validData
  Scenario: Successful login with valid data for get vehicle details for Rsa
    Given the login API is available and add headers and access token for get vehicle details for Rsa
    When user add requestBody with loginId "7004813003" ,searchType "mobile" and value "7004813003" get vehicle details for Rsa
    And the user sends get vehicle details for Rsa request with "POST"
    Then the response status for get vehicle details for Rsa should be 200 ,message "successfully fetched Vehicle details" ,regNo "DL5SDD8088" ,vin "MBLJAU026RGB00959" and model "XTREME 125R"

  @CosmosData
  Scenario: Data not present in COSMOS but in DMS
    Given the login API is available and add headers and access token for get vehicle details for Rsa
    When user add requestBody with loginId "7004813003" ,searchType "mobile" and value "1151810216" get vehicle details for Rsa
    And the user sends get vehicle details for Rsa request with "POST"
    Then the response status for get vehicle details for Rsa should be 200 ,message "successfully fetched Vehicle details" ,regNo "DL5SDB1392" ,vin "MBLHA10EN9GC09949" and model "PASSION PRO"

  @InvalidLoginId
  Scenario: Verify response if LoginId is invalid for get vehicle details for Rsa
    Given the login API is available and add headers and access token for get vehicle details for Rsa
    When user add requestBody with loginId "7004813113" ,searchType "mobile" and value "1151810216" get vehicle details for Rsa
    And the user sends get vehicle details for Rsa request with "POST"
    Then the response status for get vehicle details for Rsa should be 200 ,message "successfully fetched Vehicle details" ,regNo "DL5SDB1392" ,vin "MBLHA10EN9GC09949" and model "PASSION PRO"

  @BlankLoginId
  Scenario: Verify response if LoginId is blank for get vehicle details for Rsa
    Given the login API is available and add headers and access token for get vehicle details for Rsa
    When user add requestBody with loginId "" ,searchType "mobile" and value "1151810216" get vehicle details for Rsa
    And the user sends get vehicle details for Rsa request with "POST"
    Then the response status for get vehicle details for Rsa should be 200 ,message "successfully fetched Vehicle details" ,regNo "DL5SDB1392" ,vin "MBLHA10EN9GC09949" and model "PASSION PRO"

  @InvalidsearchType
  Scenario: Verify response if searchType is invalid for get vehicle details for Rsa
    Given the login API is available and add headers and access token for get vehicle details for Rsa
    When user add requestBody with loginId "7004813003" ,searchType "mobileApp" and value "1151810216" get vehicle details for Rsa
    And the user sends get vehicle details for Rsa request with "POST"
    Then the response status in get vehicle details for Rsa should be 200 message "Invalid searchType." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @BlanksearchType
  Scenario: Verify response if searchType is blank for get vehicle details for Rsa
    Given the login API is available and add headers and access token for get vehicle details for Rsa
    When user add requestBody with loginId "7004813003" ,searchType "" and value "1151810216" get vehicle details for Rsa
    And the user sends get vehicle details for Rsa request with "POST"
    Then the response status in get vehicle details for Rsa should be 200 message "Invalid searchType." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @SpclCharValue
  Scenario: Verify response if value contains special characters for get vehicle details for Rsa
    Given the login API is available and add headers and access token for get vehicle details for Rsa
    When user add requestBody with loginId "7004813003" ,searchType "mobile" and value "@#$%^&" get vehicle details for Rsa
    And the user sends get vehicle details for Rsa request with "POST"
    Then the response status in get vehicle details for Rsa should be 200 message "Invalid or Blank Value.." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @Invalidvalue
  Scenario: Verify response if value is invalid for get vehicle details for Rsa
    Given the login API is available and add headers and access token for get vehicle details for Rsa
    When user add requestBody with loginId "7004813003" ,searchType "mobile" and value "7004813113" get vehicle details for Rsa
    And the user sends get vehicle details for Rsa request with "POST"
    Then the response status in get vehicle details for Rsa should be 200 message "This vehicle does not exist in the system. Please check the mobile number again." ,errorCode 1001 and errorDescription "Unable to process Your Request"

  @Blankvalue
  Scenario: Verify response if value is blank for get vehicle details for Rsa
    Given the login API is available and add headers and access token for get vehicle details for Rsa
    When user add requestBody with loginId "7004813003" ,searchType "mobile" and value "" get vehicle details for Rsa
    And the user sends get vehicle details for Rsa request with "POST"
    Then the response status in get vehicle details for Rsa should be 200 message "Invalid or Blank Value.." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @EmptyBody
  Scenario: Successful login with valid data for get vehicle details for Rsa
    Given the login API is available and add headers and access token for get vehicle details for Rsa
    And the user sends get vehicle details for Rsa request with "POST"
    Then the response status for get vehicle details for Rsa should be 400 and message "Invalid request body for vehicleSearch"

  @InvalidKey
  Scenario: Verify response if subscription key is invalid for get vehicle details for Rsa
    Given the login API is available and adding headers with invalid key and access token for get vehicle details for Rsa
    When user add requestBody with loginId "7004813003" ,searchType "mobile" and value "7004813003" get vehicle details for Rsa
    And the user sends get vehicle details for Rsa request with "POST" 
    Then the response status in get vehicle details for Rsa should be statusCode 401 and message "Access denied due to invalid subscription key. Make sure to provide a valid key for an active subscription."

    @InvalidAppId
  Scenario: Verify response if AppId is invalid for get vehicle details for Rsa
    Given the login API is available and adding headers with invalid AppId and access token for get vehicle details for Rsa
    When user add requestBody with loginId "7004813003" ,searchType "mobile" and value "7004813003" get vehicle details for Rsa
    And the user sends get vehicle details for Rsa request with "POST" 
    Then the response status in get vehicle details for Rsa should be 200 message "Invalid or Blank AppId." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @InvalidspecificAppId
  Scenario: Verify response if specificAppId is invalid for get vehicle details for Rsa
    Given the login API is available and adding headers with invalid specific AppId and access token for get vehicle details for Rsa
    When user add requestBody with loginId "7004813003" ,searchType "mobile" and value "7004813003" get vehicle details for Rsa
    And the user sends get vehicle details for Rsa request with "POST" 
    Then the response status in get vehicle details for Rsa should be 200 message "Invalid or Blank SpecificAppId." ,errorCode 1002 and errorDescription "Unable to process Your Request"

    
    