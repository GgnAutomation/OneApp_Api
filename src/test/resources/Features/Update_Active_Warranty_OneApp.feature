Feature: OneApp Enterprise : API Login Testing

  Background: 
    Given the login API is available and add headers and access token for update Active Warranty

  @NoActiveWarranty
  Scenario: Validate response if VIN entered has no active warranty and IsWarrantyActive is one
    When user add requestBody with valid customer Identifier "e2582814-55ec-45a6-ad12-59a1f0269507" ,Vin Id "MBLYGL006P4H00014" and Is warranty as "1" for update Active Warranty
    And the user sends update Active Warranty request with "POST"
    Then the response status for update Active Warranty should be 200 and message "Vehicle Details Updated Successfully" , vin Id "MBLYGL006P4H00014" , updated message "Vehicle Details Updated Successfully" and is warranty "1"

  @ActiveWarranty1
  Scenario: Validate response if VIN entered has already active warranty and IsWarrantyActive is 1
    When user add requestBody with valid customer Identifier "e2582814-55ec-45a6-ad12-59a1f0269507" ,Vin Id "MBLYGL006P4H00014" and Is warranty as "1" for update Active Warranty
    And the user sends update Active Warranty request with "POST"
    Then the response status for update Active Warranty should be 200 and message "Vehicle Details Updated Successfully" , vin Id "MBLYGL006P4H00014" , updated message "Vehicle Details Updated Successfully" and is warranty "1"

  @ActiveWarranty0
  Scenario: Validate response if VIN entered has already active warranty and IsWarrantyActive is 1
    When user add requestBody with valid customer Identifier "e2582814-55ec-45a6-ad12-59a1f0269507" ,Vin Id "MBLYGL006P4H00014" and Is warranty as "0" for update Active Warranty
    And the user sends update Active Warranty request with "POST"
    Then the response status for update Active Warranty should be 200 and message "Vehicle Details Updated Successfully" , vin Id "MBLYGL006P4H00014" , updated message "Vehicle Details Updated Successfully" and is warranty "0"

  @InvalidIsWarranty
  Scenario: Validate response if Invalid isWarranty count for update Active Warranty
    When user add requestBody with valid customer Identifier "e2582814-55ec-45a6-ad12-59a1f0269507" ,Vin Id "MBLYGL006P4H00014" and Is warranty as "1000" for update Active Warranty
    And the user sends update Active Warranty request with "POST"
    Then the response status for update Active Warranty should be 200 and message "Invalid isWarrantyActive value." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @InvalidVin
  Scenario: Validate response if Entered Invalid VIN for update Active Warranty
    When user add requestBody with valid customer Identifier "e2582814-55ec-45a6-ad12-59a1f0269507" ,Vin Id "MBLYGL006P4H12345" and Is warranty as "1" for update Active Warranty
    And the user sends update Active Warranty request with "POST"
    Then the response status for update Active Warranty should be 200 and message "Vehicle Details Could Not Be Updated" ,errorCode 1023 and errorDescription "Unable to process Your Request"

  @BlankVin
  Scenario: Validate response if Entered Blank VIN for update Active Warranty
    When user add requestBody with valid customer Identifier "e2582814-55ec-45a6-ad12-59a1f0269507" ,Vin Id "" and Is warranty as "1" for update Active Warranty
    And the user sends update Active Warranty request with "POST"
    Then the response status for update Active Warranty should be 200 and message "Invalid VIN No." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @InvalidCustomerIdentifier
  Scenario: Validate response if Entered Invalid Customer Identifier for update Active Warranty
    When user add requestBody with valid customer Identifier "e2582814-55ec-45a6" ,Vin Id "MBLYGL006P4H12345" and Is warranty as "1" for update Active Warranty
    And the user sends update Active Warranty request with "POST"
    Then the response status for update Active Warranty should be 401 and message "User is not authorized" , errorCode 401

  @BlankCustomerIdentifier
  Scenario: Validate response if Entered Blank Customer Identifier for update Active Warranty
    When user add requestBody with valid customer Identifier "" ,Vin Id "MBLYGL006P4H12345" and Is warranty as "1" for update Active Warranty
    And the user sends update Active Warranty request with "POST"
    Then the response status for update Active Warranty should be 200 and message "Invalid Customer Identifier." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @InvalidUrl
  Scenario: Validate response if user enters invalid Url for update Active Warranty
    When user add requestBody with valid customer Identifier "e2582814-55ec-45a6-ad12-59a1f0269507" ,Vin Id "MBLYGL006P4H00014" and Is warranty as "1" for update Active Warranty
    And the user sends update vehicle Active Warranty request with "POST" and url "https://dev-apim.heromotocorp.com/api/updateVehicleDetails"
    Then the response status for update Active Warranty should be 404 ,message "Resource not found" and errorCode "404"

  @BlankRequestBody
  Scenario: Validate response if request body is blank for update Active Warranty
    And the user sends update Active Warranty request with "POST"
    Then the response status for update Active Warranty for empty request body should be 500
