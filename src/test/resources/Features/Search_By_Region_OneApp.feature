Feature: OneApp Enterprise : API Login Testing

  @validdata
  Scenario: Validate response with valid request body and access token
    Given the login API is available and add headers for SearchByRegion
    When user add requestBody with customerIdentifier "99a40525-e5cf-4df9-a914-945e88e72761" ,searchBy "city" ,value "Chennai" for SearchByRegion
    And the user sends a request with "POST" for SearchByRegion
    Then the response status for SearchByRegion should be 200 ,message "successfully fetched ServiceSupportDetails" ,city "CHENNAI" ,state "TAMIL NADU" and displayName "CHENNAI (TAMIL NADU)"

  @InvalidCustomerIdentifier
  Scenario: Validate response with invalid customer identifier for searchByRegion
    Given the login API is available and add headers for SearchByRegion
    When user add requestBody with customerIdentifier "99a40525-e5cf-4df9" ,searchBy "city" ,value "Chennai" for SearchByRegion
    And the user sends a request with "POST" for SearchByRegion
    Then the response status in searchByRegion should be 200 message "User is not authorized" ,errorCode 1001 ,errorDescription "Unable to process Your Request"

  @BlankCustomerIdentifier
  Scenario: Validate response with Blank customer identifier for searchByRegion
    Given the login API is available and add headers for SearchByRegion
    When user add requestBody with customerIdentifier "" ,searchBy "city" ,value "Chennai" for SearchByRegion
    And the user sends a request with "POST" for SearchByRegion
    Then the response status in searchByRegion should be 200 message "Invalid Customer Identifier." ,errorCode 1002 ,errorDescription "Unable to process Your Request"

  @SpclCharCustomerIdentifier
  Scenario: Validate response with special characters in customer identifier  for searchByRegion
    Given the login API is available and add headers for SearchByRegion
    When user add requestBody with customerIdentifier "@#$%^&*" ,searchBy "city" ,value "Chennai" for SearchByRegion
    And the user sends a request with "POST" for SearchByRegion
    Then the response status in searchByRegion should be 200 message "Invalid Customer Identifier." ,errorCode 1002 ,errorDescription "Unable to process Your Request"

  @InvalidCity
  Scenario: Validate response with invalid searchBy field(other than city) for searchByRegion
    Given the login API is available and add headers for SearchByRegion
    When user add requestBody with customerIdentifier "99a40525-e5cf-4df9-a914-945e88e72761" ,searchBy "District" ,value "Chennai" for SearchByRegion
    And the user sends a request with "POST" for SearchByRegion
    Then the response status in searchByRegion should be 200 message "Invalid searchBy." ,errorCode 1002 ,errorDescription "Unable to process Your Request"

  @AlphaNumCity
  Scenario: Validate response with alphanumeric characters in search by for searchByRegion
    Given the login API is available and add headers for SearchByRegion
    When user add requestBody with customerIdentifier "99a40525-e5cf-4df9-a914-945e88e72761" ,searchBy "chennai2345" ,value "Chennai" for SearchByRegion
    And the user sends a request with "POST" for SearchByRegion
    Then the response status in searchByRegion should be 200 message "Invalid searchBy." ,errorCode 1002 ,errorDescription "Unable to process Your Request"

  @BlankCity
  Scenario: Validate response with blank search by for searchByRegion
    Given the login API is available and add headers for SearchByRegion
    When user add requestBody with customerIdentifier "99a40525-e5cf-4df9-a914-945e88e72761" ,searchBy "" ,value "Chennai" for SearchByRegion
    And the user sends a request with "POST" for SearchByRegion
    Then the response status in searchByRegion should be 200 message "Invalid searchBy." ,errorCode 1002 ,errorDescription "Unable to process Your Request"

  @SpclCharCity
  Scenario: Validate response with special characters in search by for searchByRegion
    Given the login API is available and add headers for SearchByRegion
    When user add requestBody with customerIdentifier "99a40525-e5cf-4df9-a914-945e88e72761" ,searchBy "@#$%^" ,value "Chennai" for SearchByRegion
    And the user sends a request with "POST" for SearchByRegion
    Then the response status in searchByRegion should be 200 message "Invalid searchBy." ,errorCode 1002 ,errorDescription "Unable to process Your Request"

  @InvalidValue
  Scenario: Validate reponse with invalid Value for searchByRegion
    Given the login API is available and add headers for SearchByRegion
    When user add requestBody with customerIdentifier "99a40525-e5cf-4df9-a914-945e88e72761" ,searchBy "city" ,value "Rome" for SearchByRegion
    And the user sends a request with "POST" for SearchByRegion
    Then the response status in searchByRegion should be 200 message "record not found" ,errorCode 1001 ,errorDescription "Unable to process Your Request"

  @BlankValue
  Scenario: Validate response with blank value for searchByRegion
    Given the login API is available and add headers for SearchByRegion
    When user add requestBody with customerIdentifier "99a40525-e5cf-4df9-a914-945e88e72761" ,searchBy "city" ,value "" for SearchByRegion
    And the user sends a request with "POST" for SearchByRegion
    Then the response status for SearchByRegion should be 200 ,message "successfully fetched ServiceSupportDetails" ,city1 "DELHI" ,state1 "DELHI" ,displayName1 "DELHI (DELHI)" ,city2 "DEORIA" ,state2 "UTTAR PRADESH" ,displayName2 "DEORIA (UTTAR PRADESH)" ,city3 "JABALPUR" ,state3 "MADHYA PRADESH" ,displayName3 "JABALPUR (MADHYA PRADESH)" ,city4 "PRATAPGARH" ,state4 "RAJASTHAN", displayName4 "PRATAPGARH (RAJASTHAN)" ,city5 "RAJKOT" ,state5 "GUJARAT" and displayName5 "RAJKOT (GUJARAT)"

  @SpclCharValue
  Scenario: Validate response with special characters in value for searchByRegion
    Given the login API is available and add headers for SearchByRegion
    When user add requestBody with customerIdentifier "99a40525-e5cf-4df9-a914-945e88e72761" ,searchBy "city" ,value "@#$%^" for SearchByRegion
    And the user sends a request with "POST" for SearchByRegion
    Then the response status in searchByRegion should be 200 message "Invalid value." ,errorCode 1002 ,errorDescription "Unable to process Your Request"

  @AlphaNumValue
  Scenario: Validate response with alphanumeric characters in value for searchByRegion
    Given the login API is available and add headers for SearchByRegion
    When user add requestBody with customerIdentifier "99a40525-e5cf-4df9-a914-945e88e72761" ,searchBy "city" ,value "chennai12345" for SearchByRegion
    And the user sends a request with "POST" for SearchByRegion
    Then the response status in searchByRegion should be 200 message "record not found" ,errorCode 1001 ,errorDescription "Unable to process Your Request"

  @InvalidUrl
  Scenario: Validate response if user enters invalid Url in searchByRegion
    Given the login API is available and add headers for SearchByRegion
    When user add requestBody with customerIdentifier "99a40525-e5cf-4df9-a914-945e88e72761" ,searchBy "city" ,value "Chennai" for SearchByRegion
    And the user sends a request with "POST" and ivalid url "https://dev-apim.heromotocorp.com/api/SearchByRegion" for SearchByRegion
    Then the response status for SearchByRegion should be 404 ,message "Resource not found" and errorCode "404"

  @EmptyBody
  Scenario: Validate response if user enters blank request body in SearchByRegion
    Given the login API is available and add headers for SearchByRegion
    And the user sends a request with "POST" for SearchByRegion
    Then the response status in SearchByRegion should be 200 message "Cannot invoke \"com.hero.enterprise.application.dto.DealerCityWiseDetailsDto.getCustomerIdentifier()\" because \"dealerCityWiseDetailsDto\" is null" ,errorCode 1001 ,errorDescription "Unable to process Your Request"
