Feature: OneApp Enterprise : API Login Testing

  Background: 
    Given the login API is available and user add headers

  Scenario Outline: Successful login with valid mobile number
    When user add requestBody for validLogin "<loginId>" ,"<loginType>" and "<notificationType>"
    And the user sends a ExternalLogin request with "POST"
    Then the response status should be 200 and message "OTP Generated Successfully" and loginId "8409520578"

    Examples: 
      | loginId    | loginType | notificationType |
      | 8409520578 | mobile    | sms              |

  Scenario Outline: UnSuccessful login with Invalid mobile number
    When user add requestBody for validLogin "<loginId>" ,"<loginType>" and "<notificationType>"
    And the user sends a ExternalLogin request with "POST"
    Then the response status should be 200 and message "User is not registered" , errorCode 1001 and errorDescription "Unable to process Your Request"

    Examples: 
      | loginId    | loginType | notificationType |
      | 7004813883 | mobile    | sms              |

  Scenario Outline: Validate response if user enters special characters in LoginId
    When user add requestBody for validLogin "<loginId>" ,"<loginType>" and "<notificationType>"
    And the user sends a ExternalLogin request with "POST"
    Then the response status should be 200 and message "Mobile number is not numeric." , errorCode 1002 and errorDescription "Unable to process Your Request"

    Examples: 
      | loginId    | loginType | notificationType |
      | 7004813&%3 | mobile    | sms              |

  Scenario Outline: UnSuccessful login with more than 10 digits in LoginId mobile number
    When user add requestBody for validLogin "<loginId>" ,"<loginType>" and "<notificationType>"
    And the user sends a ExternalLogin request with "POST"
    Then the response status should be 200 and message "Mobile Field Blank Or Not In Format." , errorCode 1002 and errorDescription "Unable to process Your Request"

    Examples: 
      | loginId      | loginType | notificationType |
      | 700481300003 | mobile    | sms              |

  Scenario Outline: Unsuccessful login with special character in Invalid login Type
    When user add requestBody for validLogin "<loginId>" ,"<loginType>" and "<notificationType>"
    And the user sends a ExternalLogin request with "POST"
    Then the response status should be 200 and message "Invalid loginType, Please try again." , errorCode 1002 and errorDescription "Unable to process Your Request"

    Examples: 
      | loginId    | loginType   | notificationType |
      | 8409520578 | $##$%#$%dwd | sms              |

  Scenario Outline: UnSuccessful login with Blank mobile type
    When user add requestBody for validLogin "<loginId>" ,"<loginType>" and "<notificationType>"
    And the user sends a ExternalLogin request with "POST"
    Then the response status should be 200 and message "Invalid loginType, Please try again." , errorCode 1002 and errorDescription "Unable to process Your Request"

    Examples: 
      | loginId    | loginType | notificationType |
      | 8409520578 |           | sms              |

  Scenario Outline: Unsuccessful login with More character in login Type
    When user add requestBody for validLogin "<loginId>" ,"<loginType>" and "<notificationType>"
    And the user sends a ExternalLogin request with "POST"
    Then the response status should be 200 and message "Invalid loginType, Please try again." , errorCode 1002 and errorDescription "Unable to process Your Request"

    Examples: 
      | loginId    | loginType   | notificationType |
      | 8409520578 | mobile sk@# | sms              |

  Scenario Outline: Successful login with valid new mobile number
    When user add requestBody for validLogin "<loginId>" ,"<loginType>" and "<notificationType>"
    And the user sends a ExternalLogin request with "POST"
    Then the response status should be 200 and message "OTP Generated Successfully" and loginId "9123253221"

    Examples: 
      | loginId    | loginType | notificationType |
      | 9123253221 | mobile    | sms              |

  Scenario Outline: UnSuccessful login with Empty Request Body
    When user add requestBody for Empty Request Body
    And the user sends a ExternalLogin request with "POST"
    Then Validate response for Empty Request Body status should be "<responseCode>"

    Examples: 
      | responseCode |
      |          500 |

  Scenario Outline: Validate response if user enters invalid Url
    When user add requestBody for validLogin "<loginId>" ,"<loginType>" and "<notificationType>"
    And the user sends a ExternalLogin request with "POST" and url "https://dev-apim.heromotocorp.com/api/externalLogin"
    Then the response status should be 404 and message "Resource not found" 

    Examples: 
      | loginId    | loginType | notificationType |
      | 9123253221 | mobile    | sms              |
