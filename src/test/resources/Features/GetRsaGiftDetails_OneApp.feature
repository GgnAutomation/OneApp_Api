Feature: OneApp Enterprise : API Login Testing

  @validdata
  Scenario: Validate response with valid request body for getRsaGiftDetails
    Given the login API is available and add headers for getRsaGiftDetails
    When user add requestBody with loginId "8945612378" and VinNo "MBLYGL004P4H00013" for getRsaGiftDetails
    And the user sends a request with "POST" for getRsaGiftDetails
    Then the response status for getRsaGiftDetails should be 200 ,message "Successfully Fetched RSA Gift Details" ,vinNo "MBLYGL004P4H00013" ,giftCardStatus "0" ,giftCardMessage "You have received a gift card from" and giftCardImage "DummyGiftCard"

  @InvalidLogin
  Scenario: Validate response with invalid Login Id for getRsaGiftDetails
    Given the login API is available and add headers for getRsaGiftDetails
    When user add requestBody with loginId "89456123788" and VinNo "MBLYGL004P4H00013" for getRsaGiftDetails
    And the user sends a request with "POST" for getRsaGiftDetails
    Then the response status in getRsaGiftDetails should be 200 message "User is not authorized" ,errorCode 1001 and errorDescription "Unable to process Your Request"

  @BlankLogin
  Scenario: Validate response with Blank Login Id for getRsaGiftDetails
    Given the login API is available and add headers for getRsaGiftDetails
    When user add requestBody with loginId "" and VinNo "MBLYGL004P4H00013" for getRsaGiftDetails
    And the user sends a request with "POST" for getRsaGiftDetails
    Then the response status in getRsaGiftDetails should be 200 message "Invalid or Blank Login Id.." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @InvalidVinNo
  Scenario: Validate response with invalid VinNo for getRsaGiftDetails
    Given the login API is available and add headers for getRsaGiftDetails
    When user add requestBody with loginId "8945612378" and VinNo "MBLYGL004P4H000137" for getRsaGiftDetails
    And the user sends a request with "POST" for getRsaGiftDetails
    Then the response status in getRsaGiftDetails should be 200 message "Rsa Gift does not exist in the system. Please check the VIN number again." ,errorCode 1001 and errorDescription "Unable to process Your Request"

  @BlankVinNo
  Scenario: Validate response with Blank VinNo for getRsaGiftDetails
    Given the login API is available and add headers for getRsaGiftDetails
    When user add requestBody with loginId "8945612378" and VinNo "" for getRsaGiftDetails
    And the user sends a request with "POST" for getRsaGiftDetails
    Then the response status in getRsaGiftDetails should be 200 message "Invalid or Blank Vin." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @SpclCharVinNo
  Scenario: Validate response with special char VinNo for getRsaGiftDetails
    Given the login API is available and add headers for getRsaGiftDetails
    When user add requestBody with loginId "8945612378" and VinNo "@#$%^" for getRsaGiftDetails
    And the user sends a request with "POST" for getRsaGiftDetails
    Then the response status in getRsaGiftDetails should be 200 message "Invalid or Blank Vin." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @InvalidUrl
  Scenario: Validate response with invalid url for getRsaGiftDetails
    Given the login API is available and add headers for getRsaGiftDetails
    When user add requestBody with loginId "8945612378" and VinNo "MBLYGL004P4H00013" for getRsaGiftDetails
    And the user sends a request with "POST" and invalid url "https://dev-apim.heromotocorp.com/api/GetRsaGiftDetails" for getRsaGiftDetails
    Then the response status for getRsaGiftDetails should be 404 ,message "Resource not found" and errorCode "404"

  @EmptyBody
  Scenario: Validate response by passing blank body request for getRsaGiftDetails
    Given the login API is available and add headers for getRsaGiftDetails
    And the user sends a request with "POST" for getRsaGiftDetails
    Then the response status for getRsaGiftDetails should be 500
