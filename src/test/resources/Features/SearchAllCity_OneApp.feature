Feature: One APP Enterprise : API Login Testing

  @ValidData
  Scenario: Validate response with valid request body and access token
    Given the login API is available and add headers for SearchAllCity
    When user add requestBody with searchBy "city" and value "" for SearchAllCity
    And the user sends a request with "POST" for SearchAllCity
    Then the response status for SearchAllCity should be 200 ,message "successfully fetched ServiceSupportDetails" ,city1 "AMRITSAR" ,state1 "PUNJAB" ,displayName1 "AMRITSAR (PUNJAB)" ,city2 "PATIALA" ,state2 "PUNJAB" ,displayName2 "PATIALA (PUNJAB)" and totaldealerslocation 4732

  @InvalidsearchBy
  Scenario: Validate response with invalid searchBy field(other than city)
    Given the login API is available and add headers for SearchAllCity
    When user add requestBody with searchBy "state" and value "" for SearchAllCity
    And the user sends a request with "POST" for SearchAllCity
    Then the response status in SearchAllCity should be 200 message "Invalid searchBy." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @AlphaNumsearchBy
  Scenario: Validate response with alphanumeric characters in search by
    Given the login API is available and add headers for SearchAllCity
    When user add requestBody with searchBy "city123" and value "" for SearchAllCity
    And the user sends a request with "POST" for SearchAllCity
    Then the response status in SearchAllCity should be 200 message "Invalid searchBy." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @BlanksearchBy
  Scenario: Validate response with blank data in search by
    Given the login API is available and add headers for SearchAllCity
    When user add requestBody with searchBy "" and value "" for SearchAllCity
    And the user sends a request with "POST" for SearchAllCity
    Then the response status in SearchAllCity should be 200 message "Invalid searchBy." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @SpclCharsearchBy
  Scenario: Validate response with special characters in search by
    Given the login API is available and add headers for SearchAllCity
    When user add requestBody with searchBy "@#$%^" and value "" for SearchAllCity
    And the user sends a request with "POST" for SearchAllCity
    Then the response status in SearchAllCity should be 200 message "Invalid searchBy." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @InvalidValue
  Scenario: Validate reponse with invalid Value for SearchAllCity
    Given the login API is available and add headers for SearchAllCity
    When user add requestBody with searchBy "city" and value "loop" for SearchAllCity
    And the user sends a request with "POST" for SearchAllCity
    Then the response status in SearchAllCity should be 200 message "Dealer city not found" ,errorCode 1001 and errorDescription "Unable to process Your Request"

  @SpclCharValue
  Scenario: Validate response with special characters in value for SearchAllCity
    Given the login API is available and add headers for SearchAllCity
    When user add requestBody with searchBy "city" and value "@#$%^" for SearchAllCity
    And the user sends a request with "POST" for SearchAllCity
    Then the response status in SearchAllCity should be 200 message "Invalid value." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @SpclCharValue
  Scenario: Validate response with alphanumeric characters in value for SearchAllCity
    Given the login API is available and add headers for SearchAllCity
    When user add requestBody with searchBy "city" and value "chennai123" for SearchAllCity
    And the user sends a request with "POST" for SearchAllCity
    Then the response status in SearchAllCity should be 200 message "Dealer city not found" ,errorCode 1001 and errorDescription "Unable to process Your Request"

  @InvalidUrl
  Scenario: Validate response if user enters invalid Url for SearchAllCity
    Given the login API is available and add headers for SearchAllCity
    When user add requestBody with searchBy "city" and value "" for SearchAllCity
    And the user sends a request with "POST" and invalid url "https://dev-apim.heromotocorp.com/api/SearchAllCity" for SearchAllCity
    Then the response status for SearchAllCity should be 404 ,message "Resource not found" and errorCode "404"

  @EmptyBody
  Scenario: Validate response if request body is blank
    Given the login API is available and add headers for SearchAllCity
    And the user sends a request with "POST" for SearchAllCity
    Then the response status in SearchAllCity should be 200 message "Cannot invoke \"com.hero.enterprise.application.dto.DealerCityWiseDetailsDto.getCustomerIdentifier()\" because \"dealerCityWiseDetailsDto\" is null" ,errorCode 1001 and errorDescription "Unable to process Your Request"

    
    
    
    