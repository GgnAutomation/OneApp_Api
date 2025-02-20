Feature: OneApp Enterprise : API Login Testing

  @validCustomerIdentifier
  Scenario: Successful login with valid CustomerIdentifier
    Given the login API is available and add headers for get vehicle detail list
    When user add requestBody for get vin detail list "7004813003" ,"mobile" and "sms"
    And the user sends a get vin detail list Otp request with "POST"
    Then the response status for get vin detail list Otp should be 200 and message "OTP Generated Successfully" and loginId "7004813003"
    When user add request for get vehicle detail list along with loginId "7004813003" , isdCode "+91" ,deviceType "IOS" ,osVersion "15.1" ,appVersion "10" and deviceModel "x86_64"
    And the user sends a get vehicle detail list request with "POST"
    Then Validate the otp Generated for get vehicle detail list having the response code as 200 and verify message "OTP Verified Successfully"
    Given the login API is available and add headers and access token for get vehicle detail list
    When user add requestBody with valid customer Identifier for get vehicle detail list
    And the user sends  get vehicle detail list request with "POST"
    Then the response status for get vin detail list should be 200 ,message "Vehicle Details" ,serialNumber "MBLJA06ES9GC12192" and model "GLAMOUR"

  @InvalidCustomerIdentifier
  Scenario: Successful login with valid mobile number for get vehicle detail list with Invalid customer Identifier
    Given the login API is available and add headers and access token for get vehicle detail list
    When user add requestBody with Invalid customer Identifier for get vehicle detail list
    And the user sends a Invalid customer identifier for get vin detail list otp request with "POST"
    Then the response status for Invalid customer identifier for get vin detail list Otp should be 401 and message "User is not authorized" and errorCode 401

  @BlankIdentifier
  Scenario: Successful login with valid mobile number for get vehicle detail list with Blank customer Identifier
    Given the login API is available and add headers and access token for get vehicle detail list
    When user add requestBody with Blank customer Identifier for get vehicle detail list
    And the user sends  get vehicle detail list request with "POST"
    Then the response status for Blank customer identifier for get vin detail list Otp should be 401 and message "User is not authorized" and errorCode 401

  @Old_Token
  Scenario: Successful login with valid mobile number for get vehicle detail list with Old access Token
    Given the login API is available and add headers for Old access Token for get vehicle detail list
    When user add requestBody with Old access Token for get vehicle detail list
    And the user sends  get vehicle detail list request with "POST"
    Then the response status for Old access Token for get vin detail list Otp should be 401 and message "User is not authorized" and errorCode 401

  @Blank_Token
  Scenario: Successful login with valid mobile number for get vehicle detail list with Old access Token
    Given the login API is available and add headers for blank access Token for get vehicle detail list
    When user add requestBody with blank access Token for get vehicle detail list
    And the user sends  get vehicle detail list request with "POST"
    Then the response status for blank access Token for get vin detail list Otp should be 200 and message "Invalid or null Token." , errorCode 1002 and errorDescription "Unable to process Your Request"

  @Empty_Body
  Scenario: Successful login with Empty Request Body for get vehice detail list
    Given the login API is available and add headers and access token for get vehicle detail list
    When user add request Body for valid Empty Request Body for get vehice detail list
    And the user sends  get vehicle detail list request with "POST"
    Then Validate response for Empty request Body for get vehice detail list status should be responseCode 500

  @SingleVinTag
  Scenario: Successful login with valid CustomerIdentifier has single VIN tagged with a mobile number
    Given the login API is available and add headers for get vehicle detail list
    When user add requestBody for get vin detail list "8409520578" ,"mobile" and "sms"
    And the user sends a get vin detail list Otp request with "POST"
    Then the response status for get vin detail list Otp should be 200 and message "OTP Generated Successfully" and loginId "8409520578"
    When user add request for get vehicle detail list along with loginId "8409520578" , isdCode "+91" ,deviceType "IOS" ,osVersion "15.1" ,appVersion "10" and deviceModel "x86_64"
    And the user sends a get vehicle detail list request with "POST"
    Then Validate the otp Generated for get vehicle detail list having the response code as 200 and verify message "OTP Verified Successfully"
    Given the login API is available and add headers and access token in single vin tag for get vehicle detail list
    When user add requestBody with valid customer Identifier "e2582814-55ec-45a6-ad12-59a1f0269507" get vehicle detail list
    And the user sends  get vehicle detail list request with "POST"
    Then the response status for get vin detail list should be 200 and message "Vehicle Details" and assestId1 "2-S11Q7LE"

  @MultiVinTag
  Scenario: Successful login with valid CustomerIdentifier has multi VIN tagged with a mobile number
    Given the login API is available and add headers for get vehicle detail list
    When user add requestBody for get vin detail list "7898237339" ,"mobile" and "sms"
    And the user sends a get vin detail list Otp request with "POST"
    Then the response status for get vin detail list Otp should be 200 and message "OTP Generated Successfully" and loginId "7898237339"
    When user add request for get vehicle detail list along with loginId "7898237339" , isdCode "+91" ,deviceType "IOS" ,osVersion "15.1" ,appVersion "10" and deviceModel "x86_64"
    And the user sends a get vehicle detail list request with "POST"
    Then Validate the otp Generated for get vehicle detail list having the response code as 200 and verify message "OTP Verified Successfully"
    Given the login API is available and add headers and access token for multi vin tag in get vehicle detail list
    When user add requestBody with valid customer Identifier for get vehicle detail list
    And the user sends  get vehicle detail list request with "POST"
    Then the response status for get vin detail should be 200 and message "Vehicle Details" and assestId1 "1-1NMCA87" ,assestId2 "1-2EVT15FB" ,assestId3 "1-81EORU3" ,assestId4 "1-818WQPZ" ,assestId5 "1-7Y09VV4" and assestId6 "2-6Q6H1AR"

  @InvalidUrl
  Scenario: Validate response if user enters invalid Url in get vehicle details list
    Given the login API is available and add headers and access token for get vehicle detail list
    When user add requestBody with valid customer Identifier "e2582814-55ec-45a6-ad12-59a1f0269507" get vehicle detail list
    And the user sends a request with "POST" and invalid url "https://dev-apim.heromotocorp.com/api/getVehicleDetailsList" for get vehicle detail list
    Then the response status for get vehicle detail list should be 404 ,message "Resource not found" and errorCode "404"

    
    
    