Feature: OneApp Enterprise : API Login Testing

  @validdata
  Scenario: Verify the response if Request body is correct for GetServiceDetails
    Given the login API is available and add headers for GetServiceDetails
    When user add requestBody with mobileNo "9650602619" ,customerIdentifier "99a40525-e5cf-4df9-a914-945e88e72761" and vinNo "MBLHAW114NHA68940" for GetServiceDetails
    And the user sends a request with "POST" for GetServiceDetails
    Then the response status for GetServiceDetails should be 200 ,message "Service Details Fetched successfully" ,isServiceOpen "Yes" ,dealerName "HIMGIRI AUTOMOBILES (P) LTD." and dealerCd "10375"

  @InvalidUrl
  Scenario: Validate response if user enters invalid Url in GetServiceDetails
    Given the login API is available and add headers for GetServiceDetails
    When user add requestBody with mobileNo "9650602619" ,customerIdentifier "99a40525-e5cf-4df9-a914-945e88e72761" and vinNo "MBLHAW114NHA68940" for GetServiceDetails
    And the user sends a request with "POST" and invalid url "https://dev-apim.heromotocorp.com/api/GetServiceDetails" for GetServiceDetails
    Then the response status for GetServiceDetails should be 404 ,message "Resource not found" and errorCode "404"

  @EmptyBody
  Scenario: Validate response if user enters blank request body in GetServiceDetails
    Given the login API is available and add headers for GetServiceDetails
    And the user sends a request with "POST" for GetServiceDetails
    Then the response status in GetServiceDetails should be 200 message "Cannot invoke \"com.hero.enterprise.application.dto.RequestServiceDetailDto.setAppId(String)\" because \"requestServiceDetailDto\" is null" ,errorCode 1001 and errorDescription "Unable to process Your Request"

  @InvalidmobNo
  Scenario: Verify the response if mobileNo field is incorrect for GetServiceDetails
    Given the login API is available and add headers for GetServiceDetails
    When user add requestBody with mobileNo "9891803084" ,customerIdentifier "99a40525-e5cf-4df9-a914-945e88e72761" and vinNo "MBLHAW114NHA68940" for GetServiceDetails
    And the user sends a request with "POST" for GetServiceDetails
    Then the response status in GetServiceDetails should be 200 message "vin number is not associated with mobile number" ,errorCode 1001 and errorDescription "Unable to process Your Request"

  @SpclCharmobNo
  Scenario: Verify the response if mobileNo field contains SpclChar for GetServiceDetails
    Given the login API is available and add headers for GetServiceDetails
    When user add requestBody with mobileNo "700481@#$%" ,customerIdentifier "99a40525-e5cf-4df9-a914-945e88e72761" and vinNo "MBLHAW114NHA68940" for GetServiceDetails
    And the user sends a request with "POST" for GetServiceDetails
    Then the response status in GetServiceDetails should be 200 message "Mobile number is not numeric." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @BlankmobNo
  Scenario: Verify the response if mobileNo field is blank for GetServiceDetails
    Given the login API is available and add headers for GetServiceDetails
    When user add requestBody with mobileNo "" ,customerIdentifier "99a40525-e5cf-4df9-a914-945e88e72761" and vinNo "MBLHAW114NHA68940" for GetServiceDetails
    And the user sends a request with "POST" for GetServiceDetails
    Then the response status in GetServiceDetails should be 200 message "Mobile Field Blank Or Not In Format." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @InvalidVinNo
  Scenario: Verify the response if VinNo field is incorrect for GetServiceDetails
    Given the login API is available and add headers for GetServiceDetails
    When user add requestBody with mobileNo "9650602619" ,customerIdentifier "99a40525-e5cf-4df9-a914-945e88e72761" and vinNo "MBLHAW114NHA12345" for GetServiceDetails
    And the user sends a request with "POST" for GetServiceDetails
    Then the response status in GetServiceDetails should be 200 message "vin number is not associated with mobile number" ,errorCode 1001 and errorDescription "Unable to process Your Request"

  @SpclCharVinNo
  Scenario: Verify the response if VinNo field contains SpclChar for GetServiceDetails
    Given the login API is available and add headers for GetServiceDetails
    When user add requestBody with mobileNo "9650602619" ,customerIdentifier "99a40525-e5cf-4df9-a914-945e88e72761" and vinNo "MBL@#$%^NHA68940" for GetServiceDetails
    And the user sends a request with "POST" for GetServiceDetails
    Then the response status in GetServiceDetails should be 200 message "Invalid VIN No." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @BlankVinNo
  Scenario: Verify the response if VinNo field is blank for GetServiceDetails
    Given the login API is available and add headers for GetServiceDetails
    When user add requestBody with mobileNo "9650602619" ,customerIdentifier "99a40525-e5cf-4df9-a914-945e88e72761" and vinNo "" for GetServiceDetails
    And the user sends a request with "POST" for GetServiceDetails
    Then the response status in GetServiceDetails should be 200 message "Invalid VIN No." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @InvalidCustomerIdentifier
  Scenario: Verify the response if the customerIdentifier field is incorrect for GetServiceDetails
    Given the login API is available and add headers for GetServiceDetails
    When user add requestBody with mobileNo "9650602619" ,customerIdentifier "99a40525-e5cf" and vinNo "MBLHAW114NHA68940" for GetServiceDetails
    And the user sends a request with "POST" for GetServiceDetails
    Then the response status in GetServiceDetails should be 200 message "User is not authorized" ,errorCode 1001 and errorDescription "Unable to process Your Request"

  @SpclCharCustomerIdentifier
  Scenario: Verify the response if the customerIdentifier field contains SpclChar for GetServiceDetails
    Given the login API is available and add headers for GetServiceDetails
    When user add requestBody with mobileNo "9650602619" ,customerIdentifier "99a40525-e5cf-4df@$%^&" and vinNo "MBLHAW114NHA68940" for GetServiceDetails
    And the user sends a request with "POST" for GetServiceDetails
    Then the response status in GetServiceDetails should be 200 message "Invalid Customer Identifier." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @BlankCustomerIdentifier
  Scenario: Verify the response if the customerIdentifier field is blank for GetServiceDetails
    Given the login API is available and add headers for GetServiceDetails
    When user add requestBody with mobileNo "9650602619" ,customerIdentifier "" and vinNo "MBLHAW114NHA68940" for GetServiceDetails
    And the user sends a request with "POST" for GetServiceDetails
    Then the response status in GetServiceDetails should be 200 message "Invalid Customer Identifier." ,errorCode 1002 and errorDescription "Unable to process Your Request"
