Feature: OneApp Enterprise : API Login Testing

  @validdata
  Scenario: Verify the response if Request body is correct for GetServiceSupportDetails
    Given the login API is available and add headers for GetServiceSupportDetails
    When user add requestBody with customerIdentifier "99a40525-e5cf-4df9-a914-945e88e72761" and dealerCode "11030" for GetServiceSupportDetails
    And the user sends a request with "POST" for GetServiceSupportDetails
    Then the response status for GetSrDetails should be 200 ,message "successfully fetched ServiceSupportDetails" ,dealerCode "11030" ,dealerName "TEKRIWAL MOTORS" ,areaOffice "Area Office - Ranchi" ,dealerMobileNo "06422-223948" ,dealerstatus "Active" ,divName "11030 - Main S/R" ,divType "SR" ,mobileNo "8084707504" ,name "SUHIT KUMAR Kumar" ,position "Technical Coordinator and Trainer" ,mobileNo "7061394653" ,name "Ganesh Rakshit" ,position "Relationship Manager"

  @InvalidUrl
  Scenario: Validate response if user enters invalid Url in GetServiceSupportDetails
    Given the login API is available and add headers for GetServiceSupportDetails
    When user add requestBody with customerIdentifier "99a40525-e5cf-4df9-a914-945e88e72761" and dealerCode "11030" for GetServiceSupportDetails
    And the user sends a request with "POST" and ivalid url "https://dev-apim.heromotocorp.com/api/getServiceSupportDetails" for GetServiceSupportDetails
    Then the response status for GetServiceSupportDetails should be 404 ,message "Resource not found" and errorCode "404"

  @EmptyBody
  Scenario: Validate response if user enters blank request body in GetServiceSupportDetails
    Given the login API is available and add headers for GetServiceSupportDetails
    And the user sends a request with "POST" for GetServiceSupportDetails
    Then the response status in GetServiceSupportDetails should be 200 message "Cannot invoke \"com.hero.enterprise.application.dto.ServiceSupportDetailsDto.getDealerCode()\" because \"serviceSupportDetailsDto\" is null" ,errorCode 1001 ,errorDescription "Unable to process Your Request"

  @InvalidDealerCode
  Scenario: Verify the response if dealerCode field is incorrect in GetServiceSupportDetails
    Given the login API is available and add headers for GetServiceSupportDetails
    When user add requestBody with customerIdentifier "99a40525-e5cf-4df9-a914-945e88e72761" and dealerCode "10005678" for GetServiceSupportDetails
    And the user sends a request with "POST" for GetServiceSupportDetails
    Then the response status in GetServiceSupportDetails should be 200 message "Dealer Address Details Not Found" ,errorCode 1039 ,errorDescription "Unable to process Your Request"

  @SpclCharDealerCode
  Scenario: Verify the response if dealerCode field is contains spcl char in GetServiceSupportDetails
    Given the login API is available and add headers for GetServiceSupportDetails
    When user add requestBody with customerIdentifier "99a40525-e5cf-4df9-a914-945e88e72761" and dealerCode "10375@#$$" for GetServiceSupportDetails
    And the user sends a request with "POST" for GetServiceSupportDetails
    Then the response status in GetServiceSupportDetails should be 200 message "Dealer Address Details Not Found" ,errorCode 1039 ,errorDescription "Unable to process Your Request"

  @EmptyDealerCode
  Scenario: Verify the response if dealerCode field is Blank in GetServiceSupportDetails
    Given the login API is available and add headers for GetServiceSupportDetails
    When user add requestBody with customerIdentifier "99a40525-e5cf-4df9-a914-945e88e72761" and dealerCode "" for GetServiceSupportDetails
    And the user sends a request with "POST" for GetServiceSupportDetails
    Then the response status in GetServiceSupportDetails should be 200 message "Invalid dealerCode." ,errorCode 1002 ,errorDescription "Unable to process Your Request"

  @InvalidCustomerIdentifier
  Scenario: Verify the response if the customerIdentifier field is incorrect in GetServiceSupportDetails
    Given the login API is available and add headers for GetServiceSupportDetails
    When user add requestBody with customerIdentifier "99a40525-e5cf-4df9" and dealerCode "11030" for GetServiceSupportDetails
    And the user sends a request with "POST" for GetServiceSupportDetails
    Then the response status in GetServiceSupportDetails should be 401 message "User is not authorized" and errorCode 401

  @SpclCharCustomerIdentifier
  Scenario: Verify the response if customerIdentifier field is contains spcl char in GetServiceSupportDetails
    Given the login API is available and add headers for GetServiceSupportDetails
    When user add requestBody with customerIdentifier "99a40525-e5cf-4df9-@#$%^&d4bdb445cf7d" and dealerCode "11030" for GetServiceSupportDetails
    And the user sends a request with "POST" for GetServiceSupportDetails
    Then the response status in GetServiceSupportDetails should be 200 message "Invalid Customer Identifier." ,errorCode 1002 ,errorDescription "Unable to process Your Request"

  @BlankCustomerIdentifier
  Scenario: Verify the response if customerIdentifier field is blank in GetServiceSupportDetails
    Given the login API is available and add headers for GetServiceSupportDetails
    When user add requestBody with customerIdentifier "" and dealerCode "11030" for GetServiceSupportDetails
    And the user sends a request with "POST" for GetServiceSupportDetails
    Then the response status in GetServiceSupportDetails should be 200 message "Invalid Customer Identifier." ,errorCode 1002 ,errorDescription "Unable to process Your Request"
