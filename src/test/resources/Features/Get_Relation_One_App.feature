Feature: Harley Enterprise : API Login Testing

  @validCustomerIdentifier
  Scenario: Validate response with valid customer identifier for Get relation
    Given the login API is available and add headers,customer identifier and access token for get relation
    When user add requestBody with valid customer Identifier for get relation
    And the user sends request for get relation with "POST"
    Then the response status for valid customer identifier for get relation should be 200 ,message "Relations fetched successfully." ,key1 "1" ,value1 "Father" ,key2 "2" ,value2 "Mother" ,key3 "3" ,value3 "Sister" ,key4 "4" ,value4 "Brother" ,key5 "5" ,value5 "Local Guardian" ,key6 "6" ,value6 "Spouse" ,key7 "7" ,value7 "Friend" , key8 "8" and value8 "Others"

  @InvalidCustomerIdentifier
  Scenario: Validate response with Invalid customer identifier for Get relation
    Given the login API is available and add headers,customer identifier and access token for get relation
    When user add requestBody with Invalid customer Identifier for get relation
    And the user sends request for get relation with "POST"
    Then the response status for Invalid customer identifier for get relation should be 401 and message "User is not authorized" and errorCode 401

  @BlankCustomerIdentifier
  Scenario: Validate response with blank customer identifier for Get relation
    Given the login API is available and add headers,customer identifier and access token for get relation
    When user add requestBody with blank customer Identifier for get relation
    And the user sends request for get relation with "POST"
    Then the response status for blank customer identifier for get relation should be 200 ,message "Invalid Customer Identifier." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @SpecialCharCustomerIdentifier
  Scenario: Validate response if user enters special characters in customer identifier for Get relation
    Given the login API is available and add headers,customer identifier and access token for get relation
    When user add requestBody with special character in customer Identifier for get relation
    And the user sends request for get relation with "POST"
    Then the response status for special character in customer identifier for get relation should be 200 ,message "Invalid Customer Identifier." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @Invalidtoken
  Scenario: Validate response if user enters invalid Authorisation token for Get relation
    Given the login API is available and add headers,customer identifier and Invalid access token for get relation
    When user add requestBody with valid customer Identifier for get relation
    And the user sends request for get relation with "POST"
    Then the response status for Invalid access token for get relation should be 401 and message "User is not authorized" and errorCode 401

  @BlankToken
  Scenario: Validate response if user enters Blank Authorisation token for Get relation
    Given the login API is available and add headers for blank access Token for get relation
    When user add requestBody with valid customer Identifier for get relation
    And the user sends request for get relation with "POST"
    Then the response status for blank access Token for get relation should be 200 and message "Invalid or null Token." , errorCode 1002 and errorDescription "Unable to process Your Request"

  @InvalidUrl
  Scenario: Validate response if user enters invalid Url in get relation
    Given the login API is available and add headers,customer identifier and access token for get relation
    When user add requestBody with valid customer Identifier for get relation
    And the user sends request "POST" for get relation with invalid url "https://dev-apim.heromotocorp.com/api/getRelations"
    Then the response status for get relation should be 404 ,message "Resource not found" and errorCode "404"

  @EmptyBody
  Scenario: Validate response if send empty response in get relation
    Given the login API is available and add headers,customer identifier and access token for get relation
    And the user sends request for get relation with "POST"
    Then the response status in get relation for empty request body should be 500
