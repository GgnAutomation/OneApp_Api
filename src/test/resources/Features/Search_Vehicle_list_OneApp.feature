Feature: OneApp Enterprise : API Login Testing

  @validdata
  Scenario: Validate response with valid data for search vehicle details list
    Given the login API is available and add headers for search vehicle details list
    When user add requestBody with loginId "8218160023" ,searchType "mobile" ,value "9309123775" for search vehicle details list
    And the user sends a request with "POST" for search vehicle details list
    Then the response status for search vehicle details list should be 200 ,message "successfully fetched Vehicle details" ,regNo "WB96U7304" ,vin "MBLJFW242NGJ09709" ,model "DESTINI 125" ,mobile "9309123775" ,customerIdentifier "5f26bc73-03aa-4914-a045-f774c0994b51" and engineNo "JF17EANGJ07208"

  @BlankId
  Scenario: Validate response with Blank Login Id for search vehicle details list
    Given the login API is available and add headers for search vehicle details list
    When user add requestBody with loginId "" ,searchType "mobile" ,value "9309123775" for search vehicle details list
    And the user sends a request with "POST" for search vehicle details list
    Then the response status for search vehicle details list should be 200 ,message "Invalid LoginId." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @InvalidId
  Scenario: Validate response with Invalid Login Id for search vehicle details list
    Given the login API is available and add headers for search vehicle details list
    When user add requestBody with loginId "8218160123" ,searchType "mobile" ,value "9309123775" for search vehicle details list
    And the user sends a request with "POST" for search vehicle details list
    Then the response status for search vehicle details list should be 200 ,message "User is not authorized" ,errorCode 1001 and errorDescription "Unable to process Your Request"

  @SpclCharId
  Scenario: Validate response by passing spcl chr in loginId field for search vehicle details list
    Given the login API is available and add headers for search vehicle details list
    When user add requestBody with loginId "@#$%^" ,searchType "mobile" ,value "9309123775" for search vehicle details list
    And the user sends a request with "POST" for search vehicle details list
    Then the response status for search vehicle details list should be 200 ,message "Invalid LoginId." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @SpclCharSearchType
  Scenario: Validate response by passing spcl chr in searchtype field for search vehicle details list
    Given the login API is available and add headers for search vehicle details list
    When user add requestBody with loginId "8218160023" ,searchType "@#$%^" ,value "9309123775" for search vehicle details list
    And the user sends a request with "POST" for search vehicle details list
    Then the response status for search vehicle details list should be 200 ,message "Invalid searchType." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @BlankSearchType
  Scenario: Validate response with Blank SearchType for search vehicle details list
    Given the login API is available and add headers for search vehicle details list
    When user add requestBody with loginId "8218160023" ,searchType "" ,value "9309123775" for search vehicle details list
    And the user sends a request with "POST" for search vehicle details list
    Then the response status for search vehicle details list should be 200 ,message "Invalid searchType." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @SpclCharValue
  Scenario: Validate response by passing spcl chr in value field for search vehicle details list
    Given the login API is available and add headers for search vehicle details list
    When user add requestBody with loginId "8218160023" ,searchType "mobile" ,value "@#$%^&" for search vehicle details list
    And the user sends a request with "POST" for search vehicle details list
    Then the response status for search vehicle details list should be 200 ,message "Invalid or Blank Value.." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @BlankValue
  Scenario: Validate response by passing blank in value field for search vehicle details list
    Given the login API is available and add headers for search vehicle details list
    When user add requestBody with loginId "8218160023" ,searchType "mobile" ,value "" for search vehicle details list
    And the user sends a request with "POST" for search vehicle details list
    Then the response status for search vehicle details list should be 200 ,message "Invalid or Blank Value.." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @Invalidvalue
  Scenario: Verify response incase of mobile number is not exist when we pass on Value section for search vehicle details list
    Given the login API is available and add headers for search vehicle details list
    When user add requestBody with loginId "8218160023" ,searchType "mobile" ,value "8218160123" for search vehicle details list
    And the user sends a request with "POST" for search vehicle details list
    Then the response status for search vehicle details list should be 200 ,message "This vehicle does not exist in the system. Please check the mobile number again." ,errorCode 1001 and errorDescription "Unable to process Your Request"

  @BlankRequest
  Scenario: Validate response by passing blank body request for search vehicle details list
    Given the login API is available and add headers for search vehicle details list
    And the user sends a request with "POST" for search vehicle details list
    Then the response status for search vehicle details list should be 400 and message "Invalid request body for vehicleSearch"

  @InvalidUrl
  Scenario: Validate response if user enters invalid Url in search vehicle details list
    Given the login API is available and add headers for search vehicle details list
    When user add requestBody with loginId "8218160023" ,searchType "mobile" ,value "9309123775" for search vehicle details list
    And the user sends a request with "POST" and invalid url "https://dev-apim.heromotocorp.com/api/searchVehicleDetailsList" for search vehicle detail list
    Then the response status for search vehicle detail list should be 404 ,message "Resource not found" and errorCode "404"

  @Samevalue
  Scenario: Verify response incase of same Login data in Value field for search vehicle details list
    Given the login API is available and add headers for search vehicle details list
    When user add requestBody with loginId "8218160023" ,searchType "mobile" ,value "8218160023" for search vehicle details list
    And the user sends a request with "POST" for search vehicle details list
    Then the response status for search vehicle details list should be 200 ,message "successfully fetched Vehicle details" ,regNo "KA02KV3626" ,vin "MBLCEW001P6H00394" ,model "V1 PRO" ,mobile "8218160023" ,customerIdentifier "b63f1fc9-5b6a-470d-826b-f90f5fa89e12" and engineNo "ECD000P6H00245"
