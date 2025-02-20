Feature: One APP Enterprise : API Login Testing

  @ValidData
  Scenario: Verify response with valid request body
    Given the login API is available and add headers for UpdateRsaStatus
    When user add requestBody with loginId "7792889533" ,vinNo "MBLHAW121M4D07827" ,programStatus "active" ,giftCardStatus "1" ,giftCardMessage "You have received a gift card from Freind!" ,giftCardImage "https://firebasestorage.googleapis.com/v0/b/temp-oneapp.appspot.com/o/Card%201.png?alt=media&token=2b2c9ba4-9a73-4087-abaa-75ab432590d5" for UpdateRsaStatus
    And the user sends a request with "POST" for UpdateRsaStatus
    Then the response status for UpdateRsaStatus should be 200 ,message "Rsa Status Successfully Updated" and vinNo "MBLHAW121M4D07827"

  @InvalidLoginId
  Scenario: Validate response with invalid Login Id for UpdateRsaStatus
    Given the login API is available and add headers for UpdateRsaStatus
    When user add requestBody with loginId "7792889123" ,vinNo "MBLHAW121M4D07827" ,programStatus "active" ,giftCardStatus "1" ,giftCardMessage "You have received a gift card from Freind!" ,giftCardImage "https://firebasestorage.googleapis.com/v0/b/temp-oneapp.appspot.com/o/Card%201.png?alt=media&token=2b2c9ba4-9a73-4087-abaa-75ab432590d5" for UpdateRsaStatus
    And the user sends a request with "POST" for UpdateRsaStatus
    Then the response status in UpdateRsaStatus should be 200 message "User is not authorized" ,errorCode 1001 and errorDescription "Unable to process Your Request"

  @BlankLoginId
  Scenario: Validate response with Blank Login Id for UpdateRsaStatus
    Given the login API is available and add headers for UpdateRsaStatus
    When user add requestBody with loginId "" ,vinNo "MBLHAW121M4D07827" ,programStatus "active" ,giftCardStatus "1" ,giftCardMessage "You have received a gift card from Freind!" ,giftCardImage "https://firebasestorage.googleapis.com/v0/b/temp-oneapp.appspot.com/o/Card%201.png?alt=media&token=2b2c9ba4-9a73-4087-abaa-75ab432590d5" for UpdateRsaStatus
    And the user sends a request with "POST" for UpdateRsaStatus
    Then the response status in UpdateRsaStatus should be 200 message "Invalid or Blank Login Id.." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @InvalidUrl
  Scenario: Verify the response if Url is wrong
    Given the login API is available and add headers for UpdateRsaStatus
    When user add requestBody with loginId "" ,vinNo "MBLHAW121M4D07827" ,programStatus "active" ,giftCardStatus "1" ,giftCardMessage "You have received a gift card from Freind!" ,giftCardImage "https://firebasestorage.googleapis.com/v0/b/temp-oneapp.appspot.com/o/Card%201.png?alt=media&token=2b2c9ba4-9a73-4087-abaa-75ab432590d5" for UpdateRsaStatus
    And the user sends a request with "POST" and invalid url "https://dev-apim.heromotocorp.com/api/UpdateRsaStatus" for UpdateRsaStatus
    Then the response status for UpdateRsaStatus should be 404 ,message "Resource not found" and errorCode "404"

  @SpclCharLoginId
  Scenario: Validate response by passing spcl chr in loginId field for UpdateRsaStatus
    Given the login API is available and add headers for UpdateRsaStatus
    When user add requestBody with loginId "@#$%^&" ,vinNo "MBLHAW121M4D07827" ,programStatus "active" ,giftCardStatus "1" ,giftCardMessage "You have received a gift card from Freind!" ,giftCardImage "https://firebasestorage.googleapis.com/v0/b/temp-oneapp.appspot.com/o/Card%201.png?alt=media&token=2b2c9ba4-9a73-4087-abaa-75ab432590d5" for UpdateRsaStatus
    And the user sends a request with "POST" for UpdateRsaStatus
    Then the response status in UpdateRsaStatus should be 200 message "Invalid or Blank Login Id.." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @SpclCharVinNo
  Scenario: Validate response by passing spcl chr in vinNo field for UpdateRsaStatus
    Given the login API is available and add headers for UpdateRsaStatus
    When user add requestBody with loginId "7792889533" ,vinNo "MBLH@#$%^M4D07827" ,programStatus "active" ,giftCardStatus "1" ,giftCardMessage "You have received a gift card from Freind!" ,giftCardImage "https://firebasestorage.googleapis.com/v0/b/temp-oneapp.appspot.com/o/Card%201.png?alt=media&token=2b2c9ba4-9a73-4087-abaa-75ab432590d5" for UpdateRsaStatus
    And the user sends a request with "POST" for UpdateRsaStatus
    Then the response status in UpdateRsaStatus should be 200 message "Invalid or Blank Vin." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @BlankVinNo
  Scenario: Validate response by passing blank in vinNo field for UpdateRsaStatus
    Given the login API is available and add headers for UpdateRsaStatus
    When user add requestBody with loginId "7792889533" ,vinNo "" ,programStatus "active" ,giftCardStatus "1" ,giftCardMessage "You have received a gift card from Freind!" ,giftCardImage "https://firebasestorage.googleapis.com/v0/b/temp-oneapp.appspot.com/o/Card%201.png?alt=media&token=2b2c9ba4-9a73-4087-abaa-75ab432590d5" for UpdateRsaStatus
    And the user sends a request with "POST" for UpdateRsaStatus
    Then the response status in UpdateRsaStatus should be 200 message "Invalid or Blank Vin." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @SpclCharprogramStatus
  Scenario: Validate response by passing spcl chr in programStatus field
    Given the login API is available and add headers for UpdateRsaStatus
    When user add requestBody with loginId "7792889533" ,vinNo "MBLHAW121M4D07827" ,programStatus "@#$%" ,giftCardStatus "1" ,giftCardMessage "You have received a gift card from Freind!" ,giftCardImage "https://firebasestorage.googleapis.com/v0/b/temp-oneapp.appspot.com/o/Card%201.png?alt=media&token=2b2c9ba4-9a73-4087-abaa-75ab432590d5" for UpdateRsaStatus
    And the user sends a request with "POST" for UpdateRsaStatus
    Then the response status in UpdateRsaStatus should be 200 message "Invalid ProgramStatus. Only 'active' is allowed.." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @BlankprogramStatus
  Scenario: Validate response by passing blank data in programStatus field
    Given the login API is available and add headers for UpdateRsaStatus
    When user add requestBody with loginId "7792889533" ,vinNo "MBLHAW121M4D07827" ,programStatus "" ,giftCardStatus "1" ,giftCardMessage "You have received a gift card from Freind!" ,giftCardImage "https://firebasestorage.googleapis.com/v0/b/temp-oneapp.appspot.com/o/Card%201.png?alt=media&token=2b2c9ba4-9a73-4087-abaa-75ab432590d5" for UpdateRsaStatus
    And the user sends a request with "POST" for UpdateRsaStatus
    Then the response status in UpdateRsaStatus should be 200 message "Invalid ProgramStatus. Only 'active' is allowed.." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @EmptyBody
  Scenario: Validate response by passing blank data in programStatus field
    Given the login API is available and add headers for UpdateRsaStatus
    And the user sends a request with "POST" for UpdateRsaStatus
    Then the response status in UpdateRsaStatus should be 500

  @SpclCharGiftCardStatus
  Scenario: Validate response by passing spcl chr in giftCardStatus field in giftCardStatus field
    Given the login API is available and add headers for UpdateRsaStatus
    When user add requestBody with loginId "7792889533" ,vinNo "MBLHAW121M4D07827" ,programStatus "active" ,giftCardStatus "@#$%" ,giftCardMessage "You have received a gift card from Freind!" ,giftCardImage "https://firebasestorage.googleapis.com/v0/b/temp-oneapp.appspot.com/o/Card%201.png?alt=media&token=2b2c9ba4-9a73-4087-abaa-75ab432590d5" for UpdateRsaStatus
    And the user sends a request with "POST" for UpdateRsaStatus
    Then the response status in UpdateRsaStatus should be 200 message "Invalid gift card status. It must be either 0 or 1.." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @BlankGiftCardStatus
  Scenario: Validate response by passing blank in giftCardStatus field
    Given the login API is available and add headers for UpdateRsaStatus
    When user add requestBody with loginId "7792889533" ,vinNo "MBLHAW121M4D07827" ,programStatus "active" ,giftCardStatus "" ,giftCardMessage "You have received a gift card from Freind!" ,giftCardImage "https://firebasestorage.googleapis.com/v0/b/temp-oneapp.appspot.com/o/Card%201.png?alt=media&token=2b2c9ba4-9a73-4087-abaa-75ab432590d5" for UpdateRsaStatus
    And the user sends a request with "POST" for UpdateRsaStatus
    Then the response status in UpdateRsaStatus should be 200 message "Invalid gift card status. It must be either 0 or 1.." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @ZerogiftCardStatus
  Scenario: Validate response by passing zero digit number in giftCardStatus field
    Given the login API is available and add headers for UpdateRsaStatus
    When user add requestBody with loginId "7792889533" ,vinNo "MBLHAW121M4D07827" ,programStatus "active" ,giftCardStatus "0" ,giftCardMessage "You have received a gift card from Freind!" ,giftCardImage "https://firebasestorage.googleapis.com/v0/b/temp-oneapp.appspot.com/o/Card%201.png?alt=media&token=2b2c9ba4-9a73-4087-abaa-75ab432590d5" for UpdateRsaStatus
    And the user sends a request with "POST" for UpdateRsaStatus
    Then the response status for UpdateRsaStatus should be 200 ,message "Rsa Status Successfully Updated" and vinNo "MBLHAW121M4D07827"

  @InvalidgiftCardStatus
  Scenario: Validate response by passing  invalid number digit number in giftCardStatus field
    Given the login API is available and add headers for UpdateRsaStatus
    When user add requestBody with loginId "7792889533" ,vinNo "MBLHAW121M4D07827" ,programStatus "active" ,giftCardStatus "9" ,giftCardMessage "You have received a gift card from Freind!" ,giftCardImage "https://firebasestorage.googleapis.com/v0/b/temp-oneapp.appspot.com/o/Card%201.png?alt=media&token=2b2c9ba4-9a73-4087-abaa-75ab432590d5" for UpdateRsaStatus
    And the user sends a request with "POST" for UpdateRsaStatus
    Then the response status in UpdateRsaStatus should be 200 message "Invalid gift card status. It must be either 0 or 1.." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @SpclChargiftCardMsg
  Scenario: Validate response by passing spcl chr in giftCardImage field
    Given the login API is available and add headers for UpdateRsaStatus
    When user add requestBody with loginId "7792889533" ,vinNo "MBLHAW121M4D07827" ,programStatus "active" ,giftCardStatus "1" ,giftCardMessage "@#%^*(*&^" ,giftCardImage "https://firebasestorage.googleapis.com/v0/b/temp-oneapp.appspot.com/o/Card%201.png?alt=media&token=2b2c9ba4-9a73-4087-abaa-75ab432590d5" for UpdateRsaStatus
    And the user sends a request with "POST" for UpdateRsaStatus
    Then the response status for UpdateRsaStatus should be 200 ,message "Rsa Status Successfully Updated" and vinNo "MBLHAW121M4D07827"

  @BlankgiftCardMsg
  Scenario: Validate response by passing blank in giftCardMsg field
    Given the login API is available and add headers for UpdateRsaStatus
    When user add requestBody with loginId "7792889533" ,vinNo "MBLHAW121M4D07827" ,programStatus "active" ,giftCardStatus "1" ,giftCardMessage "" ,giftCardImage "https://firebasestorage.googleapis.com/v0/b/temp-oneapp.appspot.com/o/Card%201.png?alt=media&token=2b2c9ba4-9a73-4087-abaa-75ab432590d5" for UpdateRsaStatus
    And the user sends a request with "POST" for UpdateRsaStatus
    Then the response status for UpdateRsaStatus should be 200 ,message "Rsa Status Successfully Updated" and vinNo "MBLHAW121M4D07827"

  @BlankgiftCardImage
  Scenario: Validate response by passing blank in giftCardImage field
    Given the login API is available and add headers for UpdateRsaStatus
    When user add requestBody with loginId "7792889533" ,vinNo "MBLHAW121M4D07827" ,programStatus "active" ,giftCardStatus "1" ,giftCardMessage "You have received a gift card from Freind!" ,giftCardImage "" for UpdateRsaStatus
    And the user sends a request with "POST" for UpdateRsaStatus
    Then the response status in UpdateRsaStatus should be 200 message "Blank GiftCardImage." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @SpclChargiftCardImage
  Scenario: Validate response by passing special  character in giftCardImage field
    Given the login API is available and add headers for UpdateRsaStatus
    When user add requestBody with loginId "7792889533" ,vinNo "MBLHAW121M4D07827" ,programStatus "active" ,giftCardStatus "1" ,giftCardMessage "You have received a gift card from Freind!" ,giftCardImage "@#$%^&" for UpdateRsaStatus
    And the user sends a request with "POST" for UpdateRsaStatus
    Then the response status for UpdateRsaStatus should be 200 ,message "Rsa Status Successfully Updated" and vinNo "MBLHAW121M4D07827"
