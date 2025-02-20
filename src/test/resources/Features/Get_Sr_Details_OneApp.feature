Feature: OneApp Enterprise : API Login Testing

  @validdata
  Scenario: Verify the response if Request body is correct for GetSrDetails
    Given the login API is available and add headers for GetSrDetails
    When user add requestBody with customerIdentifier "e9c55a6c-f137-4782-93d8-7b97dac5f41f" ,vinNo "MBLJAW010K9G04274" and srNo "11780-03-RSRB-1019-13073"  for GetSrDetails
    And the user sends a request with "POST" for GetSrDetails
    Then the response status for GetSrDetails should be 200 ,message "SR details fetched successfully." ,serviceType "FSC" ,estimatedTime "2019-10-18 16:27:27" ,odometerReading "524" ,dealerName "R.K.AUTOMOBILES" ,jobCardOpenDate "2019-10-18 15:28:04" ,dealerCode "11780" ,divisionName "11780 - Main W/S" ,jobCardCompletedDate "2019-10-18 09:58:28" ,serviceBookingNumber "11780-03-RSRB-1019-13073" ,serviceBookingDate "2019-10-18 15:26:36" and jobCardNumber "11780-03-RJC-1019-12295"

  @InvalidUrl
  Scenario: Validate response if user enters invalid Url in GetSrDetails
    Given the login API is available and add headers for GetSrDetails
    When user add requestBody with customerIdentifier "e9c55a6c-f137-4782-93d8-7b97dac5f41f" ,vinNo "MBLJAW010K9G04274" and srNo "11780-03-RSRB-1019-13073"  for GetSrDetails
    And the user sends request "POST" for GetSrDetails with invalid url "https://dev-apim.heromotocorp.com/api/getSrDetails"
    Then the response status for GetSrDetails should be 404 ,message "Resource not found" and errorCode "404"

  @SROpen
  Scenario: Verify the response if Request body is correct & SR is Open for GetSrDetails
    Given the login API is available and add headers for GetSrDetails
    When user add requestBody with customerIdentifier "e9c55a6c-f137-4782-93d8-7b97dac5f41f" ,vinNo "MBLJAW010K9G04274" and srNo "11780-03-RSRB-1019-13073"  for GetSrDetails
    And the user sends a request with "POST" for GetSrDetails
    Then the response status for GetSrDetails should be 200 ,message "SR details fetched successfully." ,serviceType "FSC" ,estimatedTime "2019-10-18 16:27:27" ,odometerReading "524" ,dealerName "R.K.AUTOMOBILES" ,jobCardOpenDate "2019-10-18 15:28:04" ,dealerCode "11780" ,divisionName "11780 - Main W/S" ,jobCardCompletedDate "2019-10-18 09:58:28" ,serviceBookingNumber "11780-03-RSRB-1019-13073" ,serviceBookingDate "2019-10-18 15:26:36" and jobCardNumber "11780-03-RJC-1019-12295"

  @EmptyBody
  Scenario: Validate response if user enters blank request body in GetSrDetails
    Given the login API is available and add headers for GetSrDetails
    And the user sends a request with "POST" for GetSrDetails
    Then the response status in GetSrDetails for empty request body should be 500

  @InvalidCustomerIdentifier
  Scenario: Verify the response if customerIdentifier field is incorrect in GetSrDetails
    Given the login API is available and add headers for GetSrDetails
    When user add requestBody with customerIdentifier "320eaeb8-d86b-4e3f" ,vinNo "MBLJAW010K9G04274" and srNo "11780-03-RSRB-1019-13073"  for GetSrDetails
    And the user sends a request with "POST" for GetSrDetails
    Then the response status for GetSrDetails should be 401 ,message "User is not authorized" and errorCode 401

  @SpecialcharCustomerIdentifier
  Scenario: Validate response with blank customer identifier in GetSrDetails
    Given the login API is available and add headers for GetSrDetails
    When user add requestBody with customerIdentifier "673de449@#$%^&bbe-3905bbbb7" ,vinNo "MBLJAW010K9G04274" and srNo "11780-03-RSRB-1019-13073"  for GetSrDetails
    And the user sends a request with "POST" for GetSrDetails
    Then the response status for GetSrDetails should be 200 ,message "Invalid Customer Identifier." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @BlankCustomerIdentifier
  Scenario: Validate response with blank customer identifier in GetSrDetails
    Given the login API is available and add headers for GetSrDetails
    When user add requestBody with customerIdentifier "" ,vinNo "MBLJAW010K9G04274" and srNo "11780-03-RSRB-1019-13073"  for GetSrDetails
    And the user sends a request with "POST" for GetSrDetails
    Then the response status for GetSrDetails should be 200 ,message "Invalid Customer Identifier." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @InvalidvinNo
  Scenario: Verify the response if vinNo field is incorrect in GetSrDetails
    Given the login API is available and add headers for GetSrDetails
    When user add requestBody with customerIdentifier "e9c55a6c-f137-4782-93d8-7b97dac5f41f" ,vinNo "MBLJAW010K9G01234" and srNo "11780-03-RSRB-1019-13073"  for GetSrDetails
    And the user sends a request with "POST" for GetSrDetails
    Then the response status for GetSrDetails should be 200 ,message "VIN or SR not associated with the registered user" ,errorCode 1041 and errorDescription "Unable to process Your Request"

  @SpclcharvinNo
  Scenario: Verify the response if vinNo field is contains spcl char for GetSrDetails
    Given the login API is available and add headers for GetSrDetails
    When user add requestBody with customerIdentifier "e9c55a6c-f137-4782-93d8-7b97dac5f41f" ,vinNo "MBLJAW010@#$%1234" and srNo "11780-03-RSRB-1019-13073"  for GetSrDetails
    And the user sends a request with "POST" for GetSrDetails
    Then the response status for GetSrDetails should be 200 ,message "Invalid VIN No." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @BlankvinNo
  Scenario: Verify the response if vinNo field is Blank for GetSrDetails
    Given the login API is available and add headers for GetSrDetails
    When user add requestBody with customerIdentifier "e9c55a6c-f137-4782-93d8-7b97dac5f41f" ,vinNo "" and srNo "11780-03-RSRB-1019-13073"  for GetSrDetails
    And the user sends a request with "POST" for GetSrDetails
    Then the response status for GetSrDetails should be 200 ,message "Invalid VIN No." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @InvalidSrNo
  Scenario: Verify the response if srNo field is incorrect for GetSrDetails
    Given the login API is available and add headers for GetSrDetails
    When user add requestBody with customerIdentifier "e9c55a6c-f137-4782-93d8-7b97dac5f41f" ,vinNo "MBLJAW010K9G04274" and srNo "95009-1124-7"  for GetSrDetails
    And the user sends a request with "POST" for GetSrDetails
    Then the response status for GetSrDetails should be 200 ,message "VIN or SR not associated with the registered user" ,errorCode 1041 and errorDescription "Unable to process Your Request"

  @SpclcharSrNo
  Scenario: Verify the response if srNo field is contains spcl char for GetSrDetails
    Given the login API is available and add headers for GetSrDetails
    When user add requestBody with customerIdentifier "e9c55a6c-f137-4782-93d8-7b97dac5f41f" ,vinNo "MBLJAW010K9G04274" and srNo "95009-03-@#$%-1124-7"  for GetSrDetails
    And the user sends a request with "POST" for GetSrDetails
    Then the response status for GetSrDetails should be 200 ,message "VIN or SR not associated with the registered user" ,errorCode 1041 and errorDescription "Unable to process Your Request"

  @BlankSrNo
  Scenario: Verify the response if SrNo field is Blank for GetSrDetails
    Given the login API is available and add headers for GetSrDetails
    When user add requestBody with customerIdentifier "e9c55a6c-f137-4782-93d8-7b97dac5f41f" ,vinNo "MBLJAW010K9G04274" and srNo ""  for GetSrDetails
    And the user sends a request with "POST" for GetSrDetails
    Then the response status for GetSrDetails should be 200 ,message "srNo Field Blank Or Not In Format." ,errorCode 1002 and errorDescription "Unable to process Your Request"
