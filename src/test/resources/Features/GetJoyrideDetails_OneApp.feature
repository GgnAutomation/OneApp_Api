Feature: OneApp Enterprise : API Login Testing

  @validdata
  Scenario: Validate response with valid request body for all parameters
    Given the login API is available and add headers for GetJoyRideDetails
    When user add requestBody with VinNo "MBLJFW202MGL01787" for GetJoyRideDetails
    And the user sends a request with "POST" for GetJoyRideDetails
    Then the response status for GetJoyRideDetails should be 200 ,message "Joyride details fetched successfully. " ,amcBalance "3.4444" ,amcExpiryDate "2024-07-31 00:00:00" ,joyridePackageId "6874684" ,joyrideCardNumber "2269322720000958" ,joyrideIssueDate "2022-10-22 00:00:00" and connectedSimStatus "hello"

  @InvalidVinId
  Scenario: Verify response with invalid vinNo for GetJoyRideDetails
    Given the login API is available and add headers for GetJoyRideDetails
    When user add requestBody with VinNo "MBLJA06ES9GC11000" for GetJoyRideDetails
    And the user sends a request with "POST" for GetJoyRideDetails
    Then the response status in GetJoyRideDetails should be 200 message "No Vehicle found for given data!" ,errorCode 1001 and errorDescription "Unable to process Your Request"

  @BlankVinId
  Scenario: Verify response with Blank vinNo for GetJoyRideDetails
    Given the login API is available and add headers for GetJoyRideDetails
    When user add requestBody with VinNo "" for GetJoyRideDetails
    And the user sends a request with "POST" for GetJoyRideDetails
    Then the response status in GetJoyRideDetails should be 200 message "VIN No Field Blank Or Not In Format." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @SpclCharVinId
  Scenario: Verify response with special characters in vinNo for GetJoyRideDetails
    Given the login API is available and add headers for GetJoyRideDetails
    When user add requestBody with VinNo "@#$%^&*" for GetJoyRideDetails
    And the user sends a request with "POST" for GetJoyRideDetails
    Then the response status in GetJoyRideDetails should be 200 message "VIN No contains special character(s)." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @InvalidUrl
  Scenario: Validate response with invalid url for GetDealerOffDays
    Given the login API is available and add headers for GetJoyRideDetails
    When user add requestBody with VinNo "MBLJA06ES9GC12192" for GetJoyRideDetails
    And the user sends a request with "POST" and invalid url "https://dev-apim.heromotocorp.com/api/GetJoyRideDetails" for GetJoyRideDetails
    Then the response status for GetJoyRideDetails should be 404 ,message "Resource not found" and errorCode "404"

  @EmptyBody
  Scenario: Verify response with blank request body
    Given the login API is available and add headers for GetJoyRideDetails
    And the user sends a request with "POST" for GetJoyRideDetails
    Then the response status in GetJoyRideDetails should be 200 message "JSONObject[\"data\"] not found." ,errorCode 1001 and errorDescription "Unable to process Your Request"

  @SimStatusActive
  Scenario: Verify the below condition as :- WHEN ("simStatus" = 'ACTIVE')  from OneAppCustomerVinDetails table THEN connectedSimStatus = ACTIVE
    Given the login API is available and add headers for GetJoyRideDetails
    When user add requestBody with VinNo "MBLKCU079PHF00032" for GetJoyRideDetails
    And the user sends a request with "POST" for GetJoyRideDetails
    Then the response status for GetJoyRideDetails should be 200 ,message "Joyride details fetched successfully. " and connectedSimStatus "ACTIVE"

  @SimStatusInActive
  Scenario: Verify the below condition as :- WHEN (simStatus = 'ELSE accept ACTIVE')  from OneAppCustomerVinDetails table THEN connectedSimStatus = ACTIVE
    Given the login API is available and add headers for GetJoyRideDetails
    When user add requestBody with VinNo "MBLJAW166L9H03855" for GetJoyRideDetails
    And the user sends a request with "POST" for GetJoyRideDetails
    Then the response status for GetJoyRideDetails should be 200 ,message "Joyride details fetched successfully. " and connectedSimStatus "hello"

  @SimStatusInActive
  Scenario: Verify the below condition as :-WHEN (simStatus = null accept ACTIVE )  from OneAppCustomerVinDetails table THEN connectedSimStatus = hello
    Given the login API is available and add headers for GetJoyRideDetails
    When user add requestBody with VinNo "MBLJAW166L9H03855" for GetJoyRideDetails
    And the user sends a request with "POST" for GetJoyRideDetails
    Then the response status for GetJoyRideDetails should be 200 ,message "Joyride details fetched successfully. " and connectedSimStatus "hello"

  @SpclCharSimStatus
  Scenario: Verify the below condition as : -WHEN (simStatus = Spcl Char accept ACTIVE )  from OneAppCustomerVinDetails table THEN connectedSimStatus = hello"
    Given the login API is available and add headers for GetJoyRideDetails
    When user add requestBody with VinNo "MBLHAW172N4L15333" for GetJoyRideDetails
    And the user sends a request with "POST" for GetJoyRideDetails
    Then the response status for GetJoyRideDetails should be 200 ,message "Joyride details fetched successfully. " and connectedSimStatus "hello"

  @BlankSimStatus
  Scenario: Verify the below condition as :-WHEN (""simStatus"" = Blank accept ACTIVE ) from OneAppCustomerVinDetails table THEN connectedSimStatus = hello"
    Given the login API is available and add headers for GetJoyRideDetails
    When user add requestBody with VinNo "MBLHAW173NHK15654" for GetJoyRideDetails
    And the user sends a request with "POST" for GetJoyRideDetails
    Then the response status for GetJoyRideDetails should be 200 ,message "Joyride details fetched successfully. " and connectedSimStatus "hello"

  @AmcBalanceNull
  Scenario: Verify the response from OneAppCustomerVinDetails table for amcBalance = Null
    Given the login API is available and add headers for GetJoyRideDetails
    When user add requestBody with VinNo "MBLHAW173NHK15654" for GetJoyRideDetails
    And the user sends a request with "POST" for GetJoyRideDetails
    Then the response status for GetJoyRideDetails should be 200 ,message "Joyride details fetched successfully. " and amcBalance is null

  @BlankAmcBalance
  Scenario: Verify the response from OneAppCustomerVinDetails table for amcBalance = Blank
    Given the login API is available and add headers for GetJoyRideDetails
    When user add requestBody with VinNo "MBLHAW125NHA00297" for GetJoyRideDetails
    And the user sends a request with "POST" for GetJoyRideDetails
    Then the response status for GetJoyRideDetails should be 200 ,message "Joyride details fetched successfully. " and amcBalance ""

  @AmcExpiryDateNull
  Scenario: Verify the response from OneAppCustomerVinDetails table for amcExpiryDate = Null
    Given the login API is available and add headers for GetJoyRideDetails
    When user add requestBody with VinNo "MBLHAW177N4L10581" for GetJoyRideDetails
    And the user sends a request with "POST" for GetJoyRideDetails
    Then the response status for GetJoyRideDetails should be 200 ,message "Joyride details fetched successfully. " and amcExpiryDate ""

  @AmcExpiryDateBlank
  Scenario: Verify the response from OneAppCustomerVinDetails table for amcExpiryDate = Blank
    Given the login API is available and add headers for GetJoyRideDetails
    When user add requestBody with VinNo "MBLHAW177N4L10581" for GetJoyRideDetails
    And the user sends a request with "POST" for GetJoyRideDetails
    Then the response status for GetJoyRideDetails should be 200 ,message "Joyride details fetched successfully. " and amcExpiryDate ""

  @JoyrideUpdatedTime
  Scenario: Verify the response from ServiceRequestHistory table for joyridePackageId,joyrideCardNumber and joyrideIssueDate = should be pick lastupdatedatetime
    Given the login API is available and add headers for GetJoyRideDetails
    When user add requestBody with VinNo "MBLJFW202MGL01787" for GetJoyRideDetails
    And the user sends a request with "POST" for GetJoyRideDetails
    Then the response status for GetJoyRideDetails should be 200 ,message "Joyride details fetched successfully. " ,amcBalance "3.4444" ,amcExpiryDate "2024-07-31 00:00:00" ,joyridePackageId "6874684" ,joyrideCardNumber "2269322720000958" ,joyrideIssueDate "2022-10-22 00:00:00" and connectedSimStatus "hello"

  @JoyridePackageIdNull
  Scenario: Verify the response from ServiceRequestHistory table for joyridePackageId = null
    Given the login API is available and add headers for GetJoyRideDetails
    When user add requestBody with VinNo "MBLJAS02XH9M00962" for GetJoyRideDetails
    And the user sends a request with "POST" for GetJoyRideDetails
    Then the response status for GetJoyRideDetails should be 200 ,message "Joyride details fetched successfully. " ,joyridePackageId is null

  @JoyrideCardNumberNull
  Scenario: Verify the response from ServiceRequestHistory table for joyrideCardNumber = null
    Given the login API is available and add headers for GetJoyRideDetails
    When user add requestBody with VinNo "MBLJAS02XH9M00962" for GetJoyRideDetails
    And the user sends a request with "POST" for GetJoyRideDetails
    Then the response status for GetJoyRideDetails should be 200 ,message "Joyride details fetched successfully. " ,joyrideCardNumber is null

  @JoyrideIssueDateNull
  Scenario: Verify the response from ServiceRequestHistory table for joyrideIssueDate = null
    Given the login API is available and add headers for GetJoyRideDetails
    When user add requestBody with VinNo "MBLKCU079PHF00032" for GetJoyRideDetails
    And the user sends a request with "POST" for GetJoyRideDetails
    Then the response status for GetJoyRideDetails should be 200 ,message "Joyride details fetched successfully. " ,joyrideIssueDate is null

  @JoyrideCardNumberBlank
  Scenario: Verify the response from ServiceRequestHistory table for joyrideCardNumber = Blank
    Given the login API is available and add headers for GetJoyRideDetails
    When user add requestBody with VinNo "MBLHAW125NHA00297" for GetJoyRideDetails
    And the user sends a request with "POST" for GetJoyRideDetails
    Then the response status for GetJoyRideDetails should be 200 ,message "Joyride details fetched successfully. " ,joyrideCardNumber is ""

  @JoyrideIssueDateBlank
  Scenario: Verify the response from ServiceRequestHistory table for joyrideIssueDate = Blank
    Given the login API is available and add headers for GetJoyRideDetails
    When user add requestBody with VinNo "MBLHAW125NHA00297" for GetJoyRideDetails
    And the user sends a request with "POST" for GetJoyRideDetails
    Then the response status for GetJoyRideDetails should be 200 ,message "Joyride details fetched successfully. " ,joyrideIssueDate is ""
