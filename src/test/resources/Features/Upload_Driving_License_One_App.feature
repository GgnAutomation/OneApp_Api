Feature: OneApp Enterprise : API Login Testing

  @JPG
  Scenario: Validate response for uploading JPG format file for Upload_Driving_License
    Given the login API is available and user add headers for Upload_Driving_License
    When user add requestBody for validLogin loginId "9123253221" ,loginType "mobile"  and notificationType "sms" for Upload_Driving_License
    And the user sends a ExternalLogin request with "POST" for Upload_Driving_License
    Then the response status should be 200 and message "OTP Generated Successfully" and loginId "9123253221" for Upload_Driving_License
    Given the login API is available and user add headers for Upload_Driving_License
    When user add request for otpLogin Endpoint along with loginId "9123253221" , isdCode "+91" ,deviceType "IOS" ,osVersion "15.1" ,appVersion "10" and deviceModel "x86_64" for Upload_Driving_License
    And the user sends a valid Login Otp request with "POST" for Upload_Driving_License
    Then Validate the OTP Generated having the response code as 200 and verify message "OTP Verified Successfully" , loginId "9517390011" , firstName "Aatish" , lastName "Jha" , appName "oneapp" and primaryUser "Y" for Upload_Driving_License
    Given the login API is available and add headers for Upload_Driving_License
    When user add requestBody with extension "jpg",customerID "e9c55a6c-f137-4782-93d8-7b97dac5f41f" ,vinID "MBLJAW010K9G04274" ,documentIdentifier "vehicleDocuments/9123253221" ,category "driving license" ,subCategory "" ,emergencyId "" for Upload_Driving_License
    And the user sends a request with "POST" for Upload_Driving_License
    Then the response status for Upload_Driving_License should be 200 ,message "Upload Document" ,successMsg "File uploaded successfully" and status "Success"

  @PNG
  Scenario: Validate response for uploading PNG format file for Upload_Driving_License
    Given the login API is available and user add headers for Upload_Driving_License
    When user add requestBody for validLogin loginId "9123253221" ,loginType "mobile"  and notificationType "sms" for Upload_Driving_License
    And the user sends a ExternalLogin request with "POST" for Upload_Driving_License
    Then the response status should be 200 and message "OTP Generated Successfully" and loginId "9123253221" for Upload_Driving_License
    Given the login API is available and user add headers for Upload_Driving_License
    When user add request for otpLogin Endpoint along with loginId "9123253221" , isdCode "+91" ,deviceType "IOS" ,osVersion "15.1" ,appVersion "10" and deviceModel "x86_64" for Upload_Driving_License
    And the user sends a valid Login Otp request with "POST" for Upload_Driving_License
    Then Validate the OTP Generated having the response code as 200 and verify message "OTP Verified Successfully" , loginId "9517390011" , firstName "Aatish" , lastName "Jha" , appName "oneapp" and primaryUser "Y" for Upload_Driving_License
    Given the login API is available and add headers for Upload_Driving_License
    When user add requestBody with PNGextension "png",customerID "ad38e285-fb2e-4320-a16d-307489ef822d" ,vinID "MBLYGU015P4M00671" ,documentIdentifier "vehicleDocuments/9517390011" ,category "driving license" ,subCategory "" ,emergencyId "" for Upload_Driving_License
    And the user sends a request with "POST" for Upload_Driving_License
    Then the response status for Upload_Driving_License should be 200 ,message "Upload Document" ,successMsg "File uploaded successfully" and status "Success"

  @JPEG
  Scenario: Validate response for uploading JPEG format file for Upload_Driving_License
    Given the login API is available and user add headers for Upload_Driving_License
    When user add requestBody for validLogin loginId "9123253221" ,loginType "mobile"  and notificationType "sms" for Upload_Driving_License
    And the user sends a ExternalLogin request with "POST" for Upload_Driving_License
    Then the response status should be 200 and message "OTP Generated Successfully" and loginId "9123253221" for Upload_Driving_License
    Given the login API is available and user add headers for Upload_Driving_License
    When user add request for otpLogin Endpoint along with loginId "9123253221" , isdCode "+91" ,deviceType "IOS" ,osVersion "15.1" ,appVersion "10" and deviceModel "x86_64" for Upload_Driving_License
    And the user sends a valid Login Otp request with "POST" for Upload_Driving_License
    Then Validate the OTP Generated having the response code as 200 and verify message "OTP Verified Successfully" , loginId "9517390011" , firstName "Aatish" , lastName "Jha" , appName "oneapp" and primaryUser "Y" for Upload_Driving_License
    Given the login API is available and add headers for Upload_Driving_License
    When user add requestBody with JPEGextension "jpeg",customerID "ad38e285-fb2e-4320-a16d-307489ef822d" ,vinID "MBLYGU015P4M00671" ,documentIdentifier "vehicleDocuments/9517390011" ,category "driving license" ,subCategory "" ,emergencyId "" for Upload_Driving_License
    And the user sends a request with "POST" for Upload_Driving_License
    Then the response status for Upload_Driving_License should be 200 ,message "Upload Document" ,successMsg "File uploaded successfully" and status "Success"

  @BlankToken
  Scenario: Validate response if user enters blank Authorisation token for Upload_Driving_License
    Given the login API is available and user add headers for Upload_Driving_License
    When user add requestBody for validLogin loginId "9123253221" ,loginType "mobile"  and notificationType "sms" for Upload_Driving_License
    And the user sends a ExternalLogin request with "POST" for Upload_Driving_License
    Then the response status should be 200 and message "OTP Generated Successfully" and loginId "9123253221" for Upload_Driving_License
    Given the login API is available and user add headers for Upload_Driving_License
    When user add request for otpLogin Endpoint along with loginId "9123253221" , isdCode "+91" ,deviceType "IOS" ,osVersion "15.1" ,appVersion "10" and deviceModel "x86_64" for Upload_Driving_License
    And the user sends a valid Login Otp request with "POST" for Upload_Driving_License
    Then Validate the OTP Generated having the response code as 200 and verify message "OTP Verified Successfully" , loginId "9517390011" , firstName "Aatish" , lastName "Jha" , appName "oneapp" and primaryUser "Y" for Upload_Driving_License
    Given the login API is available and add headers with blank token for Upload_Profile_Pic
    When user add requestBody with extension "jpg",customerID "e9c55a6c-f137-4782-93d8-7b97dac5f41f" ,vinID "MBLJAW010K9G04274" ,documentIdentifier "vehicleDocuments/9123253221" ,category "driving license" ,subCategory "" ,emergencyId "" for Upload_Driving_License
    And the user sends a request with "POST" for Upload_Driving_License
    Then the response status for Upload_Profile_Pic should be 200 ,message "Invalid or null Token." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @InvalidUrl
  Scenario: Validate response if user enters invalid Url in Upload_Driving_License
    Given the login API is available and adding headers for Upload_Driving_License
    When user add requestBody with extension "png",customerID "ad38e285-fb2e-4320-a16d-307489ef822d" ,vinID "MBLYGU015P4M00671" ,documentIdentifier "vehicleDocuments/9517390011" ,category "driving license" ,subCategory "" ,emergencyId "" for Upload_Driving_License
    And the user sends a request with "POST" and invalid url "https://dev-apim.heromotocorp.com/api/uploadDocument" for Upload_Driving_License
    Then the response status for Upload_Driving_License should be 404 ,message "Resource not found" and errorCode "404"

  @EmptyBody
  Scenario: Validate response if user enters blank request body in Upload_Driving_License
    Given the login API is available and adding headers for Upload_Driving_License
    And the user sends a request with "POST" for Upload_Driving_License
    Then the response status in Upload_Driving_License for empty request body should be 500
