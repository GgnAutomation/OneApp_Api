Feature: OneApp Enterprise : API Login Testing

  Background: 
    Given the login API is available and add headers and access token for update vehicle nickname

  @ValidVinId
  Scenario: Validate response with valid VIN number for update vehicle nickname
    When user add requestBody with customer Identifier "855e7d16-4c5f-4bf7-8869-2d0a1f715c43" ,Vin Id "MBLHA10ADBHL06438" and nickname "manoj" for update vehicle nickname
    And the user sends update vehicle nickname request with "POST"
    Then the response status for update vehicle nickname should be 200 and message "Vehicle Details Updated Successfully" , vehicle nickname "manoj" and updated message "Vehicle Nick Name Updated Successfully"

  @InValidVinId
  Scenario: Validate response with invalid VIN number for update vehicle nickname
    When user add requestBody with customer Identifier "855e7d16-4c5f-4bf7-8869-2d0a1f715c43" ,Vin Id "MBLHA10ADBHL01234" and nickname "manoj" for update vehicle nickname
    And the user sends update vehicle nickname request with "POST"
    Then the response status for update vehicle nickname should be 200 and message "Vehicle Details Could Not Be Updated" , errorCode 1023 and errorDescription "Unable to process Your Request"

  @InvalidNickname
  Scenario: Validate response with valid VIN number and VehicleNickName with max characters for update vehicle nickname
    When user add requestBody with customer Identifier "855e7d16-4c5f-4bf7-8869-2d0a1f715c43" ,Vin Id "MBLHA10ADBHL06438" and nickname "manojkumarmanojkumarmanojkumarmanojkumarmanojkumarmanojkumar" for update vehicle nickname
    And the user sends update vehicle nickname request with "POST"
    Then the response status for update vehicle nickname should be 200 and message "Vehicle Name Could Not Be Updated." , errorCode 1002 and errorDescription "Unable to process Your Request"

  @BlankNickname
  Scenario: Validate response with valid VIN number and Blank VehicleNickName for update vehicle nickname
    When user add requestBody with customer Identifier "855e7d16-4c5f-4bf7-8869-2d0a1f715c43" ,Vin Id "MBLHA10ADBHL06438" and nickname "" for update vehicle nickname
    And the user sends update vehicle nickname request with "POST"
    Then the response status for update vehicle nickname should be 200 and message "Vehicle Details Updated Successfully" , vehicle nickname "manoj" and updated message "Vehicle Details Updated Successfully"

  @AlphaNumericNickname
  Scenario: Validate response with valid VIN number and Alpha numeric VehicleNickName for update vehicle nickname
    When user add requestBody with customer Identifier "855e7d16-4c5f-4bf7-8869-2d0a1f715c43" ,Vin Id "MBLHA10ADBHL06438" and nickname "123MNJ" for update vehicle nickname
    And the user sends update vehicle nickname request with "POST"
    Then the response status for update vehicle nickname should be 200 and message "Vehicle Details Updated Successfully" , vehicle nickname "123MNJ" and updated message "Vehicle Nick Name Updated Successfully"

  @SpclCharNickname
  Scenario: Validate response with valid VIN number and Special char VehicleNickName for update vehicle nickname
    When user add requestBody with customer Identifier "855e7d16-4c5f-4bf7-8869-2d0a1f715c43" ,Vin Id "MBLHA10ADBHL06438" and nickname "@@@123" for update vehicle nickname
    And the user sends update vehicle nickname request with "POST"
    Then the response status for update vehicle nickname should be 200 and message "Vehicle Name Could Not Be Updated." , errorCode 1002 and errorDescription "Unable to process Your Request"

  @SpaceinbtwNickname
  Scenario: Validate response with valid VIN number and VehicleNickName should have white space for update vehicle nickname
    When user add requestBody with customer Identifier "855e7d16-4c5f-4bf7-8869-2d0a1f715c43" ,Vin Id "MBLHA10ADBHL06438" and nickname "   manoj" for update vehicle nickname
    And the user sends update vehicle nickname request with "POST"
    Then the response status for update vehicle nickname should be 200 and message "Vehicle Details Updated Successfully" , vehicle nickname "manoj" and updated message "Vehicle Nick Name Updated Successfully"

  @BlankVinId
  Scenario: Validate response with blank VIN number for update vehicle nickname
    When user add requestBody with customer Identifier "855e7d16-4c5f-4bf7-8869-2d0a1f715c43" ,Vin Id "" and nickname "manoj" for update vehicle nickname
    And the user sends update vehicle nickname request with "POST"
    Then the response status for update vehicle nickname should be 200 and message "Invalid VIN No." , errorCode 1002 and errorDescription "Unable to process Your Request"

  @InvalidUrl
  Scenario: Validate response if user enters invalid Url for update vehicle nickname 
     When user add requestBody with customer Identifier "855e7d16-4c5f-4bf7-8869-2d0a1f715c43" ,Vin Id "MBLHA10ADBHL06438" and nickname "manoj" for update vehicle nickname
     And the user sends update vehicle nickname request with "POST" and url "https://dev-apim.heromotocorp.com/api/updateVehicleDetails"
    Then the response status for update vehicle nickname should be 404 ,message "Resource not found" and errorCode "404"

  @BlankRequestBody
  Scenario: Validate response if request body is blank for update vehicle nick name
    When the user sends update vehicle nickname request with "POST"
    Then the response status for update vehicle nick name for empty request body should be 500
