Feature: OneApp Enterprise : API Login Testing

  @ValidVinId
  Scenario: Validate response with valid VIN number for update primary vehicle
    Given the login API is available and add headers and access token for update primary vehicle
    When user add requestBody with customer Identifier "855e7d16-4c5f-4bf7-8869-2d0a1f715c43" and Vin Id "MBLHA10ADBHL06438" for update primary vehicle
    And the user sends update primary vehicle request with "POST"
    Then the response status for update primary vehicle should be 200 and message "Vehicle Details Updated Successfully" ,isPrimaryVehicle is "1" and updatedmessage "Vehicle Updated As Primary"

  @InValidVinId
  Scenario: Validate response with Invalid VIN number for update primary vehicle
    Given the login API is available and add headers and access token for update primary vehicle
    When user add requestBody with customer Identifier "855e7d16-4c5f-4bf7-8869-2d0a1f715c43" and Vin Id "MBLHA10ADBHL01234" for update primary vehicle
    And the user sends update primary vehicle request with "POST"
    Then the response status for update primary vehicle should be 200 and message "Vehicle Could Not Be Set Primary" , errorCode 1024 and errorDescription "Unable to process Your Request"

  @BlankVinId
  Scenario: Validate response with Blank VIN number for update primary vehicle
    Given the login API is available and add headers and access token for update primary vehicle
    When user add requestBody with customer Identifier "855e7d16-4c5f-4bf7-8869-2d0a1f715c43" and Vin Id "" for update primary vehicle
    And the user sends update primary vehicle request with "POST"
    Then the response status for update primary vehicle should be 200 and message "Invalid VIN No." , errorCode 1002 and errorDescription "Unable to process Your Request"

  @InvalidCustomerIdentifier
  Scenario: Validate response with invalid customer identifier for update primary vehicle
    Given the login API is available and add headers and access token for update primary vehicle
    When user add requestBody with customer Identifier "855e7d16-4c5f-4bf7-8869" and Vin Id "MBLHA10ADBHL06438" for update primary vehicle
    And the user sends update primary vehicle request with "POST"
    Then the response status for update primary vehicle should be 401 and message "User is not authorized" , errorCode 401

  @BlankCustomerIdentifier
  Scenario: Validate response with Blank customer identifier for update primary vehicle
    Given the login API is available and add headers and access token for update primary vehicle
   When user add requestBody with customer Identifier "" and Vin Id "MBLHA10ADBHL06438" for update primary vehicle
     And the user sends update primary vehicle request with "POST"
    Then the response status for update primary vehicle should be 200 and message "Invalid Customer Identifier." , errorCode 1002 and errorDescription "Unable to process Your Request"

  @SpecialCharCustomerIdentifier
  Scenario: Validate response with Blank customer identifier for update primary vehicle
    Given the login API is available and add headers and access token for update primary vehicle
   When user add requestBody with customer Identifier "@#$%^" and Vin Id "MBLHA10ADBHL06438" for update primary vehicle
    And the user sends update primary vehicle request with "POST"
    Then the response status for update primary vehicle should be 200 and message "customerIdentifier contains special character(s)." , errorCode 1002 and errorDescription "Unable to process Your Request"

  
  @BlankToken
  Scenario: Validate response with Blank token for update primary vehicle
    Given the login API is available and add headers and Blank access token for update primary vehicle
    When user add requestBody with customer Identifier "855e7d16-4c5f-4bf7-8869-2d0a1f715c43" and Vin Id "MBLHA10ADBHL06438" for update primary vehicle
    And the user sends update primary vehicle request with "POST"
    Then the response status for update primary vehicle should be 200 and message "Invalid or null Token." , errorCode 1002 and errorDescription "Unable to process Your Request"

  @InvalidUrl
  Scenario: Validate response if user enters invalid Url for update primary vehicle
    Given the login API is available and add headers and access token for update primary vehicle
   When user add requestBody with customer Identifier "855e7d16-4c5f-4bf7-8869-2d0a1f715c43" and Vin Id "MBLHA10ADBHL06438" for update primary vehicle
     And the user sends update primary vehicle  for invalid url request with "POST" and url "https://dev-apim.heromotocorp.com/api/updatePrimaryVehicle"
    Then the response status for update primary vehicle should be 404 ,message "Resource not found" and errorCode "404"

  @BlankRequestBody
  Scenario: Validate response if request body is blank for update primary vehicle
    Given the login API is available and add headers and access token for update primary vehicle
    When the user sends update primary vehicle request with "POST"
    Then the response status for update primary vehicle for empty request body should be 500
