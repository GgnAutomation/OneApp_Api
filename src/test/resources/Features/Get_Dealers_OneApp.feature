Feature: OneApp Enterprise : API Login Testing

  @validdata
  Scenario: Validate response with valid request body for all parameters
    Given the login API is available and add headers for GetDealers
    When user add requestBody with customerIdentifier "b278d705-f791-4d35-8f6e-bc771bd2210c" ,city "Chennai" ,state "Tamil nadu" for GetDealers
    And the user sends a request with "POST" for GetDealers
    Then the response status for GetDealers should be 200 ,message "successfully fetched Dealers Details" ,dealerCode "10776" ,dealerName "ADYAR MOTORS PVT LTD." ,areaOffice "Area Office - Chennai" ,zonalOffice "Zonal Office - South" ,dealerMobileNo "044-42115588" ,city "CHENNAI" ,state "TAMIL NADU" ,district "Chennai" ,pincode "600020" and brandName "HERO_HARLEY"

  @InvalidCity
  Scenario: Validate response if user enters invalid city in GetDealers
    Given the login API is available and add headers for GetDealers
    When user add requestBody with customerIdentifier "b278d705-f791-4d35-8f6e-bc771bd2210c" ,city "Chennai123" ,state "Tamil nadu" for GetDealers
    And the user sends a request with "POST" for GetDealers
    Then the response status for GetDealers should be 200 ,message "record not found" ,errorCode 1001 and errorDescription "Unable to process Your Request"

  @BlankCity
  Scenario: Validate response with blank city in GetDealers
    Given the login API is available and add headers for GetDealers
    When user add requestBody with customerIdentifier "b278d705-f791-4d35-8f6e-bc771bd2210c" ,city "" ,state "Tamil nadu" for GetDealers
    And the user sends a request with "POST" for GetDealers
    Then the response status for GetDealers should be 200 ,message "Invalid city." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @SpclCharCity
  Scenario: Validate response with special characters in city in GetDealers
    Given the login API is available and add headers for GetDealers
    When user add requestBody with customerIdentifier "b278d705-f791-4d35-8f6e-bc771bd2210c" ,city "ch@#$%^i" ,state "Tamil nadu" for GetDealers
    And the user sends a request with "POST" for GetDealers
    Then the response status for GetDealers should be 200 ,message "Invalid city." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @InvalidState
  Scenario: Validate response if user enters invalid state in GetDealers
    Given the login API is available and add headers for GetDealers
    When user add requestBody with customerIdentifier "b278d705-f791-4d35-8f6e-bc771bd2210c" ,city "Chennai" ,state "Italy" for GetDealers
    And the user sends a request with "POST" for GetDealers
    Then the response status for GetDealers should be 200 ,message "record not found" ,errorCode 1001 and errorDescription "Unable to process Your Request"

  @BlankState
  Scenario: Validate response if user enters Blank state in GetDealers
    Given the login API is available and add headers for GetDealers
    When user add requestBody with customerIdentifier "b278d705-f791-4d35-8f6e-bc771bd2210c" ,city "Chennai" ,state "" for GetDealers
    And the user sends a request with "POST" for GetDealers
    Then the response status for GetDealers should be 200 ,message "Invalid state." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @SpclCharState
  Scenario: Validate response with special characters in state in GetDealers
    Given the login API is available and add headers for GetDealers
    When user add requestBody with customerIdentifier "b278d705-f791-4d35-8f6e-bc771bd2210c" ,city "Chennai" ,state "@#$%^" for GetDealers
    And the user sends a request with "POST" for GetDealers
    Then the response status for GetDealers should be 200 ,message "Invalid state." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @InvalidCustomerIdentifier
  Scenario: Validate response with valid request body for GetDealers
    Given the login API is available and add headers for GetDealers
    When user add requestBody with customerIdentifier "b278d705-f791-4d35" ,city "Chennai" ,state "Tamil nadu" for GetDealers
    And the user sends a request with "POST" for GetDealers
    Then the response status for GetDealers should be 200 ,message "User is not authorized" ,errorCode 1001 and errorDescription "Unable to process Your Request"

  @BlankCustomerIdentifier
  Scenario: Validate response with blank customer identifier for GetDealers
    Given the login API is available and add headers for GetDealers
    When user add requestBody with customerIdentifier "" ,city "Chennai" ,state "Tamil nadu" for GetDealers
    And the user sends a request with "POST" for GetDealers
    Then the response status for GetDealers should be 200 ,message "Invalid Customer Identifier." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @SpclCharCustomerIdentifier
  Scenario: Validate response with special character customer identifier for GetDealers
    Given the login API is available and add headers for GetDealers
    When user add requestBody with customerIdentifier "" ,city "Chennai" ,state "Tamil nadu" for GetDealers
    And the user sends a request with "POST" for GetDealers
    Then the response status for GetDealers should be 200 ,message "Invalid Customer Identifier." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @InvalidUrl
  Scenario: Validate response if user enters invalid Url in GetDealers
    Given the login API is available and add headers for GetDealers
    When user add requestBody with customerIdentifier "b278d705-f791-4d35-8f6e-bc771bd2210c" ,city "Chennai" ,state "Tamil nadu" for GetDealers
    And the user sends a request with "POST" and invalid url "https://dev-apim.heromotocorp.com/api/GetDealers" for GetDealers
    Then the response status for GetDealers should be 404 ,message "Resource not found" and errorCode "404"

  @EmptyBody
  Scenario: Validate response if user enters blank request body in GetDealers
    Given the login API is available and add headers for GetDealers
    And the user sends a request with "POST" for GetDealers
    Then the response status in GetDealers should be 200 message "Cannot invoke \"com.hero.enterprise.application.dto.ServiceSupportDetailsDto.setAppId(String)\" because \"serviceSupportDetailsDto\" is null" ,errorCode 1001 and errorDescription "Unable to process Your Request"
