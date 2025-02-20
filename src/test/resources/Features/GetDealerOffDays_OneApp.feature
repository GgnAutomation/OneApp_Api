Feature: OneApp Enterprise : API Login Testing

  @validdata
  Scenario: Validate response with valid request body for all parameters with storage table(DealerWeekOff) container for GetDealerOffDays
    Given the login API is available and add headers for GetDealerOffDays
    When user add requestBody with customerIdentifier "09fdead0-96f5-4b52-8c0c-9697a8952c68" and divisionName "10375 - Main W/S" for GetDealerOffDays
    And the user sends a request with "POST" for GetDealerOffDays
    Then the response status for GetDealerOffDays should be 200 ,message "Dealer week off days" ,divisionName "10375 - Main W/S" ,weekOff "No Weekly Off" and additionalOffDays "25-12-2024"

  @InvalidCustomerIdentifier
  Scenario: Validate response with invalid customerIdentifier
    Given the login API is available and add headers for GetDealerOffDays
    When user add requestBody with customerIdentifier "09fdead0-96f5-4b5" and divisionName "10375 - Main W/S" for GetDealerOffDays
    And the user sends a request with "POST" for GetDealerOffDays
    Then the response status for GetDealerOffDays should be 401 ,message "User is not authorized" and errorCode 401

  @BlankCustomerIdentifier
  Scenario: Validate response with blank customerIdentifier
    Given the login API is available and add headers for GetDealerOffDays
    When user add requestBody with customerIdentifier "" and divisionName "10375 - Main W/S" for GetDealerOffDays
    And the user sends a request with "POST" for GetDealerOffDays
    Then the response status in GetDealerOffDays should be 200 message "Invalid Customer Identifier." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @SpclCharCustomerIdentifier
  Scenario: Validate response with special characters in customerIdentifier
    Given the login API is available and add headers for GetDealerOffDays
    When user add requestBody with customerIdentifier "@#$%^&" and divisionName "10375 - Main W/S" for GetDealerOffDays
    And the user sends a request with "POST" for GetDealerOffDays
    Then the response status in GetDealerOffDays should be 200 message "Invalid Customer Identifier." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @InvalidDivision
  Scenario: Validate response with invalid divisionName container for GetDealerOffDays
    Given the login API is available and add headers for GetDealerOffDays
    When user add requestBody with customerIdentifier "09fdead0-96f5-4b52-8c0c-9697a8952c68" and divisionName "10375 - Main " for GetDealerOffDays
    And the user sends a request with "POST" for GetDealerOffDays
    Then the response status in GetDealerOffDays should be 200 message "This division name does not exist" ,errorCode 1054 and errorDescription "Unable to process Your Request"

  @BlankDivision
  Scenario: Validate response with Blank divisionName container for GetDealerOffDays
    Given the login API is available and add headers for GetDealerOffDays
    When user add requestBody with customerIdentifier "09fdead0-96f5-4b52-8c0c-9697a8952c68" and divisionName "" for GetDealerOffDays
    And the user sends a request with "POST" for GetDealerOffDays
    Then the response status in GetDealerOffDays should be 200 message "Invalid division name." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @SpclCharDivision
  Scenario: Validate response with special characters in divisionName for GetDealerOffDays
    Given the login API is available and add headers for GetDealerOffDays
    When user add requestBody with customerIdentifier "09fdead0-96f5-4b52-8c0c-9697a8952c68" and divisionName "@#$%^&" for GetDealerOffDays
    And the user sends a request with "POST" for GetDealerOffDays
    Then the response status in GetDealerOffDays should be 200 message "This division name does not exist" ,errorCode 1054 and errorDescription "Unable to process Your Request"

  @InvalidUrl
  Scenario: Validate response with invalid url for GetDealerOffDays
    Given the login API is available and add headers for GetDealerOffDays
    When user add requestBody with customerIdentifier "09fdead0-96f5-4b52-8c0c-9697a8952c68" and divisionName "10375 - Main W/S" for GetDealerOffDays
    And the user sends a request with "POST" and invalid url "https://dev-apim.heromotocorp.com/api/GetRsaGiftDetails" for GetDealerOffDays
    Then the response status for GetDealerOffDays should be 404 ,message "Resource not found" and errorCode "404"

  @EmptyBody
  Scenario: Validate response by passing blank body request for GetDealerOffDays
    Given the login API is available and add headers for GetDealerOffDays
    And the user sends a request with "POST" for GetDealerOffDays
    Then the response status for GetDealerOffDays should be 500

  @10375Dealer
  Scenario: Validate response if additionalOffDays is more then one for 10375 --  Main W/S Dealer container for GetDealerOffDays
    Given the login API is available and add headers for GetDealerOffDays
    When user add requestBody with customerIdentifier "09fdead0-96f5-4b52-8c0c-9697a8952c68" and divisionName "10375 - Main W/S" for GetDealerOffDays
    And the user sends a request with "POST" for GetDealerOffDays
    Then the response status for GetDealerOffDays should be 200 ,message "Dealer week off days" ,divisionName "10375 - Main W/S" ,weekOff "No Weekly Off" and additionalOffDays "25-12-2024"

  @60329Dealer
  Scenario: Validate response if additionalOffDays is more then one for 60329 --  Main W/S Dealer container for GetDealerOffDays
    Given the login API is available and add headers for GetDealerOffDays
    When user add requestBody with customerIdentifier "09fdead0-96f5-4b52-8c0c-9697a8952c68" and divisionName "60329 - Main S/R" for GetDealerOffDays
    And the user sends a request with "POST" for GetDealerOffDays
    Then the response status for GetDealerOffDays should be 200 ,message "Dealer week off days" ,divisionName "60329 - Main S/R" and additionalOffDays "24-12-2024"
