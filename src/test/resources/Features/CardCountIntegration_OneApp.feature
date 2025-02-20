Feature: OneApp Enterprise : API Login Testing

  @validdata
  Scenario: Validate response with valid request body for all parameters
    Given the login API is available and add headers for CardCountIntegration
    When user add requestBody with mobileNumber "9650602619" for CardCountIntegration
    And the user sends a request with "POST" for CardCountIntegration
    Then the response status for CardCountIntegration should be 200 ,message "Eshop data fetched successfully." and data "{\"messages\":[],\"fileBaseUrl\":\"https://shop.heromotocorp.com/s/62ea2c599d1398fa16dbae0a/\",\"data\":[],\"paging\":{\"limit\":30,\"start\":0,\"count\":0,\"total\":0}}"

  @InvalidUrl
  Scenario: Validate response if user enters invalid Url in CardCountIntegration
    Given the login API is available and add headers for CardCountIntegration
    When user add requestBody with mobileNumber "9650602619" for CardCountIntegration
    And the user sends a request with "POST" and invalid url "https://dev-apim.heromotocorp.com/api/CardCountIntegration" for CardCountIntegration
    Then the response status for CardCountIntegration should be 404 ,message "Resource not found" and errorCode "404"

  @EmptyBody
  Scenario: Validate response if user enters blank request body in CardCountIntegration
    Given the login API is available and add headers for CardCountIntegration
    And the user sends a request with "POST" for CardCountIntegration
    Then the response status in CardCountIntegration should be 200 message "JSONObject[\"data\"] not found." ,errorCode 1001 and errorDescription "Unable to process Your Request"

  @SpclCharMobNo
  Scenario: Verify the response if mobileNo is contains spcl char
    Given the login API is available and add headers for CardCountIntegration
    When user add requestBody with mobileNumber "@#$%^" for CardCountIntegration
    And the user sends a request with "POST" for CardCountIntegration
    Then the response status in CardCountIntegration should be 200 message "Mobile number is not numeric." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @BlankMobNo
  Scenario: Verify the response if mobileNo field is Blank/null
    Given the login API is available and add headers for CardCountIntegration
    When user add requestBody with mobileNumber "" for CardCountIntegration
    And the user sends a request with "POST" for CardCountIntegration
    Then the response status in CardCountIntegration should be 200 message "Mobile Field Blank Or Not In Format." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @NonExistMobNo
  Scenario: Verify the response if mobileNo is not exists
    Given the login API is available and add headers for CardCountIntegration
    When user add requestBody with mobileNumber "0000000000" for CardCountIntegration
    And the user sends a request with "POST" for CardCountIntegration
    Then the response status for CardCountIntegration should be 200 ,message "Eshop data fetched successfully." and data "{\"messages\":[],\"fileBaseUrl\":\"https://shop.heromotocorp.com/s/62ea2c599d1398fa16dbae0a/\",\"data\":[],\"paging\":{\"limit\":30,\"start\":0,\"count\":0,\"total\":0}}"

  @Itemcountzero
  Scenario: Verify the item_count where item_count = 0
    Given the login API is available and add headers for CardCountIntegration
    When user add requestBody with mobileNumber "9650602619" for CardCountIntegration
    And the user sends a request with "POST" for CardCountIntegration
    Then the response status for CardCountIntegration should be 200 ,message "Eshop data fetched successfully." and data "{\"messages\":[],\"fileBaseUrl\":\"https://shop.heromotocorp.com/s/62ea2c599d1398fa16dbae0a/\",\"data\":[],\"paging\":{\"limit\":30,\"start\":0,\"count\":0,\"total\":0}}"
