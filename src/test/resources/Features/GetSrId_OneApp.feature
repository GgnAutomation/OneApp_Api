Feature: OneApp Enterprise : API Login Testing

  @ValidCustomerIdentifier
  Scenario: Validate response with valid data for GetSrId
    Given the login API is available and add headers for GetSrId
    When user add requestBody with customerIdentifier "e9c55a6c-f137-4782-93d8-7b97dac5f41f" and srId "11780-03-RSRB-1019-13073" for GetSrId
    And the user sends a request with "POST" for GetSrId
    Then the response status for GetSrId should be 200 ,message "srId fetched successfully." and srId "1-1L3JXOK"

  @InValidCustomerIdentifier
  Scenario: Validate the response if customerIdentifier field is incorrect for GetSrId
    Given the login API is available and add headers for GetSrId
    When user add requestBody with customerIdentifier "e9c55a6c-f137-4782-93d8" and srId "11780-03-RSRB-1019-13073" for GetSrId
    And the user sends a request with "POST" for GetSrId
    Then the response status for GetSrId should be 401 ,message "User is not authorized" and errorCode 401

  @BlankCustomerIdentifier
  Scenario: Validate the response if customerIdentifier field is blank for GetSrId
    Given the login API is available and add headers for GetSrId
    When user add requestBody with customerIdentifier "" and srId "11780-03-RSRB-1019-13073" for GetSrId
    And the user sends a request with "POST" for GetSrId
    Then the response status for GetSrId should be 200 ,message "Invalid Customer Identifier." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @SpecialCharCustomerIdentifier
  Scenario: Validate the response if the customerIdentifier field is contains spcl char for GetSrId
    Given the login API is available and add headers for GetSrId
    When user add requestBody with customerIdentifier "@#$%^&*" and srId "11780-03-RSRB-1019-13073" for GetSrId
    And the user sends a request with "POST" for GetSrId
    Then the response status for GetSrId should be 200 ,message "Invalid Customer Identifier." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @InvalidSrId
  Scenario: Validate the response if the SrId field is invalid for GetSrId
    Given the login API is available and add headers for GetSrId
    When user add requestBody with customerIdentifier "e9c55a6c-f137-4782-93d8-7b97dac5f41f" and srId "95009-03-1223-81" for GetSrId
    And the user sends a request with "POST" for GetSrId
    Then the response status for GetSrId should be 200 ,message "SR not associated with the registered user" ,errorCode 1040 and errorDescription "Unable to process Your Request"

  @SpecialCharSrId
  Scenario: Validate the response if the SrId field is contains spcl char for GetSrId
    Given the login API is available and add headers for GetSrId
    When user add requestBody with customerIdentifier "e9c55a6c-f137-4782-93d8-7b97dac5f41f" and srId "@#$%^&" for GetSrId
    And the user sends a request with "POST" for GetSrId
    Then the response status for GetSrId should be 200 ,message "SR not associated with the registered user" ,errorCode 1040 and errorDescription "Unable to process Your Request"

  @BlankSrId
  Scenario: Validate the response if the SrId field is blank for GetSrId
    Given the login API is available and add headers for GetSrId
    When user add requestBody with customerIdentifier "e9c55a6c-f137-4782-93d8-7b97dac5f41f" and srId "" for GetSrId
    And the user sends a request with "POST" for GetSrId
    Then the response status for GetSrId should be 200 ,message "srNo Field Blank Or Not In Format." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @InvalidUrl
  Scenario: Validate response if user enters invalid Url in GetSrId
    Given the login API is available and add headers for GetSrId
    When user add requestBody with customerIdentifier "e9c55a6c-f137-4782-93d8-7b97dac5f41f" and srId "11780-03-RSRB-1019-13073" for GetSrId
    And the user sends a request with "POST" for GetSrId with invalid url "https://dev-apim.heromotocorp.com/api/getSrId"
    Then the response status for GetSrId should be 404 ,message "Resource not found" and errorCode "404"

  @EmptyBody
  Scenario: Validate response if user enters blank request body in GetSrId
    Given the login API is available and add headers for GetSrId
    And the user sends a request with "POST" for GetSrId
    Then the response status in GetSrId for empty request body should be 500
