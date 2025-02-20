Feature: Harley Enterprise : API Login Testing

  @validdata
  Scenario: Verify the response if Request body is correct for ServiceHistory
    Given the login API is available and add headers for ServiceHistory
    When user add requestBody with customerIdentifier "e9c55a6c-f137-4782-93d8-7b97dac5f41f" ,vin "MBLJAW010K9G04274" and rowno "1" for ServiceHistory
    And the user sends a request with "POST" for ServiceHistory
    Then the response status for ServiceHistory should be 200 ,message "successfully fetched service history details" ,serviceType "FSC" ,odometerReading "524.0" ,invoiceNum is "11780CJ19V12171" ,dealerCode "11780" ,estimatedPrice "400.0" ,serviceBookingNumber "11780-03-RSRB-1019-13073" ,serviceBookingDate "2019-10-18 20:56:36" and jobCardNumber is "11780-03-RJC-1019-12295"

  @InvalidUrl
  Scenario: Validate response if user enters invalid Url in ServiceHistory
    Given the login API is available and add headers for ServiceHistory
    When user add requestBody with customerIdentifier "e9c55a6c-f137-4782-93d8-7b97dac5f41f" ,vin "MBLJAW010K9G04274" and rowno "1" for ServiceHistory
    And the user sends a request with "POST" and invalid url "https://dev-apim.heromotocorp.com/api/serviceHistory" for ServiceHistory
    Then the response status for ServiceHistory should be 404 ,message "Resource not found" and errorCode "404"

  @EmptyBody
  Scenario: Validate response if user enters blank request body in ServiceHistory
    Given the login API is available and add headers for ServiceHistory
    And the user sends a request with "POST" for ServiceHistory
    Then the response status in ServiceHistory should be 200 message "Cannot invoke \"com.hero.enterprise.application.dto.VehicleServiceDataDto.setAppId(String)\" because \"serviceDataDto\" is null" ,errorCode 1001 and errorDescription "Unable to process Your Request"

  @InvalidCustomerIdentifier
  Scenario: Verify the response if customer identifier field is incorrect for ServiceHistory
    Given the login API is available and add headers for ServiceHistory
    When user add requestBody with customerIdentifier "e9c55a6c-f137-4782" ,vin "MBLJAW010K9G04274" and rowno "1" for ServiceHistory
    And the user sends a request with "POST" for ServiceHistory
    Then the response status for ServiceHistory should be 401 ,message "User is not authorized"

  @SpclCharCustomerIdentifier
  Scenario: Verify the response if customer identifier field is contains spcl char for ServiceHistory
    Given the login API is available and add headers for ServiceHistory
    When user add requestBody with customerIdentifier "e9c55a6c-f137-@#$%^-4782" ,vin "MBLJAW010K9G04274" and rowno "1" for ServiceHistory
    And the user sends a request with "POST" for ServiceHistory
    Then the response status in ServiceHistory should be 200 message "Invalid Customer Identifier." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @BlankCustomerIdentifier
  Scenario: Verify the response if customer identifier field is blank for ServiceHistory
    Given the login API is available and add headers for ServiceHistory
    When user add requestBody with customerIdentifier "" ,vin "MBLJAW010K9G04274" and rowno "1" for ServiceHistory
    And the user sends a request with "POST" for ServiceHistory
    Then the response status in ServiceHistory should be 200 message "Invalid Customer Identifier." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @InvalidVinId
  Scenario: Verify the response if vin field is incorrect for ServiceHistory
    Given the login API is available and add headers for ServiceHistory
    When user add requestBody with customerIdentifier "e9c55a6c-f137-4782-93d8-7b97dac5f41f" ,vin "MBLYGU011P4" and rowno "1" for ServiceHistory
    And the user sends a request with "POST" for ServiceHistory
    Then the response status in ServiceHistory should be 200 message "Customer Identifier and VIN Number is not associated" ,errorCode 1001 and errorDescription "Unable to process Your Request"

  @SpclCharVinId
  Scenario: Verify the response if vin id  field contains special character for ServiceHistory
    Given the login API is available and add headers for ServiceHistory
    When user add requestBody with customerIdentifier "e9c55a6c-f137-4782-93d8-7b97dac5f41f" ,vin "MBLYGU011@#$%" and rowno "1" for ServiceHistory
    And the user sends a request with "POST" for ServiceHistory
    Then the response status in ServiceHistory should be 200 message "Invalid or Blank Vin." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @BlankVinId
  Scenario: Verify the response if vin id  field is blank for ServiceHistory
    Given the login API is available and add headers for ServiceHistory
    When user add requestBody with customerIdentifier "e9c55a6c-f137-4782-93d8-7b97dac5f41f" ,vin "" and rowno "1" for ServiceHistory
    And the user sends a request with "POST" for ServiceHistory
    Then the response status in ServiceHistory should be 200 message "Invalid or Blank Vin." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @InvalidRowNo
  Scenario: Verify the response if the rowNum field is incorrect for ServiceHistory
    Given the login API is available and add headers for ServiceHistory
    When user add requestBody with customerIdentifier "e9c55a6c-f137-4782-93d8-7b97dac5f41f" ,vin "MBLJAW010K9G04274" and rowno "0" for ServiceHistory
    And the user sends a request with "POST" for ServiceHistory
    Then the response status in ServiceHistory should be 200 message "RowNum must be a positive integer greater than 0." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @RowNo10
  Scenario: Verify the response if the rowNum field contains ten for ServiceHistory
     Given the login API is available and adding headers for ServiceHistory
    When user add requestBody with customerIdentifier "855e7d16-4c5f-4bf7-8869-2d0a1f715c43" ,vin "MBLHA10ADBHL06438" and rowno "10" for ServiceHistory
    And the user sends a request with "POST" for ServiceHistory
   Then the response status for ServiceHistory for rows ten should be 200 ,message "successfully fetched service history details" ,serviceType "Paid Service" ,odometerReading "36720.0" ,city "ALUVA" ,dealerName "MEGA MOTORS" ,jobCardOpenDate "2024-04-05 16:07:53" and dealerCode "10089"

  @RowNo5
  Scenario: Verify the response if the rowNum field contains five for ServiceHistory
    Given the login API is available and adding headers for ServiceHistory
    When user add requestBody with customerIdentifier "855e7d16-4c5f-4bf7-8869-2d0a1f715c43" ,vin "MBLHA10ADBHL06438" and rowno "5" for ServiceHistory
    And the user sends a request with "POST" for ServiceHistory
    Then the response status for ServiceHistory should be 200 ,message "successfully fetched service history details" ,serviceType "FSC" ,odometerReading "500.0" ,dealerName "JANKI AUTOMOBILES" ,jobCardOpenDate "2024-03-11 17:54:14" and dealerCode "23501"

  @RowNo6
  Scenario: Verify the response if the rowNum field contains six for ServiceHistory
    Given the login API is available and add headers for ServiceHistory
    When user add requestBody with customerIdentifier "e9c55a6c-f137-4782-93d8-7b97dac5f41f" ,vin "MBLJAW010K9G04274" and rowno "6" for ServiceHistory
    And the user sends a request with "POST" for ServiceHistory
    Then the response status in ServiceHistory should be 200 message "Invalid rowNum value: 6" ,errorCode 1001 and errorDescription "Unable to process Your Request"

  @SpclCharRowNo
  Scenario: Verify the response if rowNum field is contains spcl char for ServiceHistory
   Given the login API is available and add headers for ServiceHistory
    When user add requestBody with customerIdentifier "e9c55a6c-f137-4782-93d8-7b97dac5f41f" ,vin "MBLJAW010K9G04274" and rowno "@" for ServiceHistory
    And the user sends a request with "POST" for ServiceHistory
     Then the response status in ServiceHistory should be 200 message "RowNum must be a positive integer greater than 0." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @BlankRowNo
  Scenario: Verify the response if rowNum field is blank for ServiceHistory
  Given the login API is available and add headers for ServiceHistory
    When user add requestBody with customerIdentifier "e9c55a6c-f137-4782-93d8-7b97dac5f41f" ,vin "MBLJAW010K9G04274" and rowno "" for ServiceHistory
    And the user sends a request with "POST" for ServiceHistory
      Then the response status in ServiceHistory should be 200 message "RowNum cannot be blank." ,errorCode 1002 and errorDescription "Unable to process Your Request"
