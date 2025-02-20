Feature: OneApp Enterprise : API Testing

  Background: 
    Given the login API is available and add headers and access token for update emergency contact

  @ValidcustomerIdentifier
  Scenario: Validate response with valid customer identifier for update emergency contact
    When user add requestBody with valid customer Identifier ,id "2" ,name "Manojkumar" ,mobile "9894678401" ,relation "5" and action "ADD" for update emergency contact
    And the user sends update emergency contact request with "POST"
    Then the response status for update emergency contact should be 200 and message "Emergency Contact Details Added Successfully" , id "2" ,name "Manojkumar" ,mobile "9894678401" ,relation "5" and action "ADD"

  @InvalidcustomerIdentifier
  Scenario: Validate response with Invalid customer identifier for update emergency contact
    When user add requestBody with Invalid customer Identifier ,id "2" ,name "Manojkumar" ,mobile "9894678401" ,relation "5" and action "EDIT" for update emergency contact
    And the user sends update emergency contact request with "POST"
    Then the response status for Invalid customer identifier for update emergency contact should be 401 and message "User is not authorized" and errorCode 401

  @BlankcustomerIdentifier
  Scenario: Validate response with blank customer identifier for update emergency contact
    When user add requestBody with Blank customer Identifier ,id "2" ,name "Manojkumar" ,mobile "9894678401" ,relation "5" and action "EDIT" for update emergency contact
    And the user sends update emergency contact request with "POST"
    Then the response status for blank customer identifier for update emergency contact should be 200 ,message "Invalid Customer Identifier." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @SpclCharcustomerIdentifier
  Scenario: Validate response with Special customer identifier for update emergency contact
    When user add requestBody with Special customer Identifier ,id "2" ,name "Manojkumar" ,mobile "9894678401" ,relation "5" and action "EDIT" for update emergency contact
    And the user sends update emergency contact request with "POST"
    Then the response status for Special customer identifier for update emergency contact should be 200 ,message "Invalid Customer Identifier." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @InvalidNameField
  Scenario: Validate response with max characters in name field for update emergency contact
    When user add requestBody with valid customer Identifier ,id "2" ,name "ManojkumarManojkumarManojkumar@#$%^Manoj" ,mobile "9894678401" ,relation "5" and action "EDIT" for update emergency contact
    And the user sends update emergency contact request with "POST"
    Then the response status for update emergency contact should be 200 ,message "Name Field Blank Or Not In Format." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @BlankNameField
  Scenario: Validate response with Blank name field for update emergency contact
    When user add requestBody with valid customer Identifier ,id "2" ,name "" ,mobile "9894678401" ,relation "5" and action "EDIT" for update emergency contact
    And the user sends update emergency contact request with "POST"
    Then the response status for update emergency contact should be 200 ,message "Name Field Blank Or Not In Format." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @Maxmobilenumber
  Scenario: Validate response with max digit in mobile number field for update emergency contact
    When user add requestBody with valid customer Identifier ,id "2" ,name "Manojkumar" ,mobile "98946784012345" ,relation "5" and action "EDIT" for update emergency contact
    And the user sends update emergency contact request with "POST"
    Then the response status for update emergency contact should be 200 ,message "Mobile Field Blank Or Not In Format." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @Minmobilenumber
  Scenario: Validate response with minimum digit in mobile number field for update emergency contact
    When user add requestBody with valid customer Identifier ,id "2" ,name "Manojkumar" ,mobile "98946" ,relation "5" and action "EDIT" for update emergency contact
    And the user sends update emergency contact request with "POST"
    Then the response status for update emergency contact should be 200 ,message "Mobile Field Blank Or Not In Format." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @Alphanumericmobilenumber
  Scenario: Validate response with alpha numeric in mobile number field for update emergency contact
    When user add requestBody with valid customer Identifier ,id "2" ,name "Manojkumar" ,mobile "9894678401ABC" ,relation "5" and action "EDIT" for update emergency contact
    And the user sends update emergency contact request with "POST"
    Then the response status for update emergency contact should be 200 ,message "Mobile number is not numeric." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @Blankmobilenumber
  Scenario: Validate response with blank in mobile number field for update emergency contact
    When user add requestBody with valid customer Identifier ,id "2" ,name "Manojkumar" ,mobile "" ,relation "5" and action "EDIT" for update emergency contact
    And the user sends update emergency contact request with "POST"
    Then the response status for update emergency contact should be 200 ,message "Mobile Field Blank Or Not In Format." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @InvalidRelation
  Scenario: Validate response with relation field range more than 7 for update emergency contact
    When user add requestBody with valid customer Identifier ,id "2" ,name "Manojkumar" ,mobile "9894678401" ,relation "9" and action "EDIT" for update emergency contact
    And the user sends update emergency contact request with "POST"
    Then the response status for update emergency contact should be 200 ,message "Relation Field Blank Or Not In Format." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @BlankRelation
  Scenario: Validate response with blank relation field for update emergency contact
    When user add requestBody with valid customer Identifier ,id "2" ,name "Manojkumar" ,mobile "9894678401" ,relation "" and action "EDIT" for update emergency contact
    And the user sends update emergency contact request with "POST"
    Then the response status for update emergency contact should be 200 ,message "Relation Field Blank Or Not In Format." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @AddContact
  Scenario: Validate response trying to add more than two contacts for update emergency contact
    When user add requestBody with valid customer Identifier ,id "2" ,name "Manojkumar" ,mobile "9894678401" ,relation "5" and action "ADD" for update emergency contact
    And the user sends update emergency contact request with "POST"
    Then the response status for adding more numbers in update emergency contact should be 200 ,message "Cannot add more than 2 Emergency Contacts." ,errorCode 1018 and errorDescription "Unable to process Your Request"

  @BlankToken
  Scenario: Validate response if user enters Blank Authorisation token for update emergency contact
    Given the login API is available and add headers for blank access Token for update emergency contact
    When user add requestBody with valid customer Identifier ,id "2" ,name "Manojkumar" ,mobile "9894678401" ,relation "5" and action "EDIT" for update emergency contact
    And the user sends update emergency contact request with "POST"
    Then the response status for update emergency contact should be 200 ,message "Invalid or null Token." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @InvalidUrl
  Scenario: Validate response if user enters invalid Url for update emergency contact
    Given the login API is available and add headers for blank access Token for update emergency contact
     When user add requestBody with valid customer Identifier ,id "2" ,name "Manojkumar" ,mobile "9894678401" ,relation "5" and action "EDIT" for update emergency contact
   And the user sends request "POST" for update emergency contact with invalid url "https://dev-apim.heromotocorp.com/api/updateEmergencyContact"
    Then the response status for update emergency contact should be 404 ,message "Resource not found" and errorCode "404"

  @EmptyBody
  Scenario: Validate response if send empty response in update emergency contact
    And the user sends update emergency contact request with "POST"
    Then the response status in update emergency contact for empty request body should be 500

  @DeleteContact
  Scenario: Validate response delete contacts for update emergency contact
     When user add requestBody with valid customer Identifier ,id "2" ,name "Manojkumar" ,mobile "9894678401" ,relation "5" and action "DELETE" for update emergency contact
   And the user sends update emergency contact request with "POST"
    Then the response status for delete contact in update emergency contact should be 200 and message "Emergency Contact Details Deleted Successfully" , id "2" ,name "Manojkumar" ,mobile "9894678401" ,relation "5" and action "DELETE"
