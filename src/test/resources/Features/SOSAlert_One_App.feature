Feature: OneApp Enterprise : API Login Testing

  @validdata
  Scenario: Verify the response if Request body is correct for SOS_Alert
    Given the login API is available and user add headers for SOS_Alert
    When user add requestBody for validLogin loginId "9123253221" ,loginType "mobile"  and notificationType "sms" for SOS_Alert
    And the user sends a ExternalLogin request with "POST" for SOS_Alert
    Then the response status should be 200 and message "OTP Generated Successfully" and loginId "9123253221" for SOS_Alert
    Given the login API is available and user add headers for SOS_Alert
    When user add request for otpLogin Endpoint along with loginId "9123253221" , isdCode "+91" ,deviceType "IOS" ,osVersion "15.1" ,appVersion "10" and deviceModel "x86_64" for SOS_Alert
    And the user sends a valid Login Otp request with "POST" for SOS_Alert
    Then Validate the OTP Generated having the response code as 200 and verify message "OTP Verified Successfully" , loginId "9123253221" , firstName "Aatish" , lastName "Jha" , appName "oneapp" and primaryUser "Y" for SOS_Alert
    Given the login API is available and add headers for SOS_Alert
    When user add requestBody with customerIdentifier "e9c55a6c-f137-4782-93d8-7b97dac5f41f" and userLocation "https://www.mappls.com/@28.4136263,77.0426564" for SOS_Alert
    And the user sends a request with "POST" for SOS_Alert
    Then the response status for SOS_Alert should be 200 ,message "We have sent alert SMS successfully" and mobileNo "9123253221"

  @InvalidCustomerIdentifier
  Scenario: Validate response with invalid Customer Identifier for SOS_Alert
    Given the login API is available and user add headers for SOS_Alert
    When user add requestBody for validLogin loginId "9123253221" ,loginType "mobile"  and notificationType "sms" for SOS_Alert
    And the user sends a ExternalLogin request with "POST" for SOS_Alert
    Then the response status should be 200 and message "OTP Generated Successfully" and loginId "9123253221" for SOS_Alert
    Given the login API is available and user add headers for SOS_Alert
    When user add request for otpLogin Endpoint along with loginId "9123253221" , isdCode "+91" ,deviceType "IOS" ,osVersion "15.1" ,appVersion "10" and deviceModel "x86_64" for SOS_Alert
    And the user sends a valid Login Otp request with "POST" for SOS_Alert
    Then Validate the OTP Generated having the response code as 200 and verify message "OTP Verified Successfully" , loginId "9123253221" , firstName "Aatish" , lastName "Jha" , appName "oneapp" and primaryUser "Y" for SOS_Alert
    Given the login API is available and add headers for SOS_Alert
    When user add requestBody with customerIdentifier "87e598f1-4546-4750-8b6" and userLocation "https://www.mappls.com/@28.4136263,77.0426564" for SOS_Alert
    And the user sends a request with "POST" for SOS_Alert
    Then the response status in SOS_Alert for Invalid Customer Identifier should be 401 and message "User is not authorized"

  @BlankCustomerIdentifier
  Scenario: Validate response with Blank Customer Identifier for SOS_Alert
    Given the login API is available and add headers for SOS_Alert
    When user add requestBody with customerIdentifier "" and userLocation "https://www.mappls.com/@28.4136263,77.0426564" for SOS_Alert
    And the user sends a request with "POST" for SOS_Alert
    Then the response status in SOS_Alert should be 200 message "Invalid Customer Identifier." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @SpclCharCustomerIdentifier
  Scenario: Validate response with special character Customer Identifier for SOS_Alert
    Given the login API is available and add headers for SOS_Alert
    When user add requestBody with customerIdentifier "@#$^" and userLocation "https://www.mappls.com/@28.4136263,77.0426564" for SOS_Alert
    And the user sends a request with "POST" for SOS_Alert
    Then the response status in SOS_Alert should be 200 message "Invalid Customer Identifier." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @locationChange
  Scenario: validate response if user changed locationfor SOS_Alert
     Given the login API is available and user add headers for SOS_Alert
    When user add requestBody for validLogin loginId "9123253221" ,loginType "mobile"  and notificationType "sms" for SOS_Alert
    And the user sends a ExternalLogin request with "POST" for SOS_Alert
    Then the response status should be 200 and message "OTP Generated Successfully" and loginId "9123253221" for SOS_Alert
    Given the login API is available and user add headers for SOS_Alert
    When user add request for otpLogin Endpoint along with loginId "9123253221" , isdCode "+91" ,deviceType "IOS" ,osVersion "15.1" ,appVersion "10" and deviceModel "x86_64" for SOS_Alert
    And the user sends a valid Login Otp request with "POST" for SOS_Alert
    Then Validate the OTP Generated having the response code as 200 and verify message "OTP Verified Successfully" , loginId "9123253221" , firstName "Aatish" , lastName "Jha" , appName "oneapp" and primaryUser "Y" for SOS_Alert
    Given the login API is available and add headers for SOS_Alert
    When user add requestBody with customerIdentifier "e9c55a6c-f137-4782-93d8-7b97dac5f41f" and userLocation "https://www.mappls.com/@28.4136263,77.0426" for SOS_Alert
    And the user sends a request with "POST" for SOS_Alert
    Then the response status for SOS_Alert should be 200 ,message "We have sent alert SMS successfully" and mobileNo "9123253221"

  @Blanklocation
  Scenario: Validate response if user location is blank for SOS_Alert
   Given the login API is available and add headers for SOS_Alert
     When user add requestBody with customerIdentifier "e9c55a6c-f137-4782-93d8-7b97dac5f41f" and userLocation "" for SOS_Alert
    And the user sends a request with "POST" for SOS_Alert
    Then the response status in SOS_Alert should be 200 message "Invalid userLocation." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @SpclCharlocation
  Scenario: Validate response if user location has special characters for SOS_Alert
    Given the login API is available and add headers for SOS_Alert
    When user add requestBody with customerIdentifier "e9c55a6c-f137-4782-93d8-7b97dac5f41f" and userLocation "@#$%^@#$" for SOS_Alert
    And the user sends a request with "POST" for SOS_Alert
    Then the response status in SOS_Alert should be 200 message "Invalid userLocation." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @InvalidUrl
  Scenario: Validate response if user enters invalid Url in SOS_Alert
    Given the login API is available and add headers for SOS_Alert
    When user add requestBody with customerIdentifier "e9c55a6c-f137-4782-93d8-7b97dac5f41f" and userLocation "https://www.mappls.com/@28.4136263,77.0426564" for SOS_Alert
    And the user sends a request with "POST" and invalid url "https://dev-apim.heromotocorp.com/api/sendSosAlert" for SOS_Alert
    Then the response status for SOS_Alert should be 404 ,message "Resource not found" and errorCode "404"

  @EmptyBody
  Scenario: Validate response if user enters blank request body in SOS_Alert
    Given the login API is available and add headers for SOS_Alert
    And the user sends a request with "POST" for SOS_Alert
    Then the response status in SOS_Alert for empty request body should be 500
