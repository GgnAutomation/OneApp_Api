Feature: OneApp Enterprise : API Login Testing

  Background: 
    Given the login API is available and add headers and access token for Check Complaint

  @ValidVin
  Scenario: Verify the response if Request body is correct for check complaint
    When user add requestBody with Vin Id "MBLHA10EN9GC09928" for Check Complaint
    And the user sends Check Complaint request with "POST"
    Then the response status for Check Complaint should be 200 and message "Your request is already in process" and statusCode "3"

  @InValidVin
  Scenario: Verify the response for invalid Vin for check complaint
    When user add requestBody with Vin Id "MBLJAR14XJHK01234" for Check Complaint
    And the user sends Check Complaint request with "POST"
    Then the response status for Check Complaint should be 200 and message "Update your mobile number" and statusCode "2"

  @SpclCharVin
  Scenario: Verify the response if Vin contains spcl char for check complaint
    When user add requestBody with Vin Id "@#$%^" for Check Complaint
    And the user sends Check Complaint request with "POST"
    Then the response status for Check Complaint should be 200 and message "Invalid VIN No." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @BlankVin
  Scenario: Verify the response if Vin field is Blank/null for check complaint
    When user add requestBody with Vin Id "" for Check Complaint
    And the user sends Check Complaint request with "POST"
    Then the response status for Check Complaint should be 200 and message "Invalid VIN No." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @Reopned
  Scenario: Verify the response if category=Contact Update and status (Re-Opened) for check complaint
    When user add requestBody with Vin Id "MBLHAC045P9D00629" for Check Complaint
    And the user sends Check Complaint request with "POST"
    Then the response status for Check Complaint should be 200 and message "Your request is already in process" and statusCode "3"

     @InvalidUrl
  Scenario: Validate response if user enters invalid Url in check complaint
    When user add requestBody with Vin Id "MBLHA10EN9GC09928" for Check Complaint
    And the user sends request "POST" for check complaint with invalid url "https://dev-apim.heromotocorp.com/api/getRelations"
    Then the response status for check complaint should be 404 ,message "Resource not found" and errorCode "404"

  @EmptyBody
  Scenario: Validate response if send empty response in check complaint
   And the user sends Check Complaint request with "POST"
     Then the response status in check complaint for empty request body should be 500
    
    