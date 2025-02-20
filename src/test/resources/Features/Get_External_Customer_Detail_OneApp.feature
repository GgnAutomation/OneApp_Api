Feature: One APP Enterprise : API Login Testing

  @InvalidshortCustomerIdentifier
  Scenario: Validate response if user enters customerIdentifier short length
    Given the login API is available and add headers and access token for get external customer detail
    When user add requestBody with customer Identifier with short for get external customer detail
    And the user sends a request with "POST" for get external customer detail
    Then the response status for Invalid customer identifier for get external customer detail should be 401 and message "User is not authorized" and errorCode 401

  @InvalidLongCustomerIdentifier
  Scenario: Validate response if user enters customerIdentifier long length
    Given the login API is available and add headers and access token for get external customer detail
    When user add requestBody with customer Identifier with long for get external customer detail
    And the user sends a request with "POST" for get external customer detail
    Then the response status for Invalid customer identifier for get external customer detail should be 200 and message "Invalid Customer Identifier." , errorCode 1002 and errorDescription "Unable to process Your Request"

  @validCustomerIdentifier
  Scenario: Validate response if user enters Valid customerIdentifier
    Given the login API is available and add headers and access token for get external customer detail
    When user add requestBody with valid customerIdentifier for get external customer detail
    And the user sends a request with "POST" for get external customer detail
    Then the response status for valid customer identifier for get external customer detail should be 200 ,message "Customer Profile",lastName "K",firstName "S K",email "skr@gmail.com",birthDate "1998-07-21",mobileNo "9123253221",id "27761",name "Aatish Shankar" ,relation "Friend" and mobile "7004813003",

  @InvalidCustomerIdentifier
  Scenario: Validate response if user enters Invalid customerIdentifier
    Given the login API is available and add headers and access token for get external customer detail
    When user add requestBody with Invalid customer Identifier for get external customer detail
    And the user sends a request with "POST" for get external customer detail
    Then the response status for Invalid customer identifier for get external customer detail should be 401 and message "User is not authorized" and errorCode 401

  @BlankIdentifier
  Scenario: Validate response if user enters BlankIdentifier
    Given the login API is available and add headers and access token for get external customer detail
    When user add requestBody with BlankIdentifier for get external customer detail
    And the user sends a request with "POST" for get external customer detail
    Then the response status for Invalid customer identifier for get external customer detail should be 200 and message "Invalid Customer Identifier." , errorCode 1002 and errorDescription "Unable to process Your Request"

  @validToken
  Scenario: Validate response if user enters Valid Token
    Given the login API is available and add headers and access token for get external customer detail
    When user add requestBody with valid customerIdentifier for get external customer detail
    And the user sends a request with "POST" for get external customer detail
    Then the response status for valid customer identifier for get external customer detail should be 200 ,message "Customer Profile",lastName "K",firstName "S K",email "skr@gmail.com",birthDate "1998-07-21",mobileNo "9123253221",id "27761",name "Aatish Shankar" ,relation "Friend" and mobile "7004813003",

  @Invalidtoken
  Scenario: Validate response if user enters Invalid Authorisation token
    Given the login API is available and add headers and Invalid access token for get external customer detail
    When user add requestBody with valid customerIdentifier for get external customer detail
    And the user sends a request with "POST" for get external customer detail
    Then the response status for Invalid customer identifier for get external customer detail should be 401 and message "User is not authorized" and errorCode 401

  @Blanktoken
  Scenario: Validate response if user enters Blank Authorisation token
    Given the login API is available and add headers and Blank access token for get external customer detail
    When user add requestBody with valid customerIdentifier for get external customer detail
    And the user sends a request with "POST" for get external customer detail
    Then the response status for blank token for get external customer detail should be 200 ,message "Invalid or null Token." , errorCode 1002 and errorDescription "Unable to process Your Request"

  @InvalidUrl
  Scenario: Validate response if user enters invalid Url
    Given the login API is available and add headers and access token for get external customer detail
    When user add requestBody with valid customerIdentifier for get external customer detail
    And the user sends a request with "POST" and invalid url "https://dev-apim.heromotocorp.com/api/getExternalCustomerDetails" for get external customer detail
    Then the response status for get external customer detail should be 404 and message "Resource not found"

  @BlankRequestBody
  Scenario: Validate response if request body is blank
    Given the login API is available and add headers and access token for get external customer detail
    And the user sends a request with "POST" for get external customer detail
    Then the response status for get external customer detail for empty request body should be "500"
