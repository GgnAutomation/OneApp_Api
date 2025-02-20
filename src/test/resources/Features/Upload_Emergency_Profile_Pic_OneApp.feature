Feature: OneApp Enterprise : API Login Testing

  @JPG
  Scenario: Validate response for uploading JPG format file for Upload_Emergency_Profile_Pic
    Given the login API is available and user add headers for Upload_Emergency_Profile_Pic
    When user add requestBody for validLogin loginId "7004813003" ,loginType "mobile"  and notificationType "sms" for Upload_Emergency_Profile_Pic
    And the user sends a ExternalLogin request with "POST" for Upload_Emergency_Profile_Pic
    Then the response status should be 200 and message "OTP Generated Successfully" and loginId "7004813003" for Upload_Emergency_Profile_Pic
    Given the login API is available and user add headers for Upload_Emergency_Profile_Pic
    When user add request for otpLogin Endpoint along with loginId "7004813003" , isdCode "+91" ,deviceType "IOS" ,osVersion "15.1" ,appVersion "10" and deviceModel "x86_64" for Upload_Emergency_Profile_Pic
    And the user sends a valid Login Otp request with "POST" for Upload_Emergency_Profile_Pic
    Then Validate the OTP Generated having the response code as 200 ,verify message "OTP Verified Successfully" and loginId "7004813003" for Upload_Emergency_Profile_Pic
    Given the login API is available and add headers for Upload_Emergency_Profile_Pic
    When user add requestBody with extension "jpeg",customerID "09fdead0-96f5-4b52-8c0c-9697a8952c68" ,vinID "MBLJA06ES9GC12192" ,documentIdentifier "emergencyContactProfilePic/result1" ,category "emergency profile" ,subCategory "" ,emergencyId "1" for Upload_Emergency_Profile_Pic
    And the user sends a request with "POST" for Upload_Emergency_Profile_Pic
    Then the response status for Upload_Emergency_Profile_Pic should be 200 ,message "Upload Document" ,successMsg "File uploaded successfully" and status "Success"

  @PNG
  Scenario: Validate response for uploading PNG format file for Upload_Emergency_Profile_Pic
    Given the login API is available and user add headers for Upload_Emergency_Profile_Pic
    When user add requestBody for validLogin loginId "7004813003" ,loginType "mobile"  and notificationType "sms" for Upload_Emergency_Profile_Pic
    And the user sends a ExternalLogin request with "POST" for Upload_Emergency_Profile_Pic
    Then the response status should be 200 and message "OTP Generated Successfully" and loginId "7004813003" for Upload_Emergency_Profile_Pic
    Given the login API is available and user add headers for Upload_Emergency_Profile_Pic
    When user add request for otpLogin Endpoint along with loginId "7004813003" , isdCode "+91" ,deviceType "IOS" ,osVersion "15.1" ,appVersion "10" and deviceModel "x86_64" for Upload_Emergency_Profile_Pic
    And the user sends a valid Login Otp request with "POST" for Upload_Emergency_Profile_Pic
    Then Validate the OTP Generated having the response code as 200 ,verify message "OTP Verified Successfully" and loginId "7004813003" for Upload_Emergency_Profile_Pic
    Given the login API is available and add headers for Upload_Emergency_Profile_Pic
    When user add requestBody with PNGextension "png",customerID "09fdead0-96f5-4b52-8c0c-9697a8952c68" ,vinID "MBLJA06ES9GC12192" ,documentIdentifier "emergencyContactProfilePic/result1" ,category "emergency profile" ,subCategory "" ,emergencyId "1" for Upload_Emergency_Profile_Pic
    And the user sends a request with "POST" for Upload_Emergency_Profile_Pic
    Then the response status for Upload_Emergency_Profile_Pic should be 200 ,message "Upload Document" ,successMsg "File uploaded successfully" and status "Success"

  @JPEG
  Scenario: Validate response for uploading JPEG format file for Upload_Emergency_Profile_Pic
    Given the login API is available and user add headers for Upload_Emergency_Profile_Pic
    When user add requestBody for validLogin loginId "7004813003" ,loginType "mobile"  and notificationType "sms" for Upload_Emergency_Profile_Pic
    And the user sends a ExternalLogin request with "POST" for Upload_Emergency_Profile_Pic
    Then the response status should be 200 and message "OTP Generated Successfully" and loginId "7004813003" for Upload_Emergency_Profile_Pic
    Given the login API is available and user add headers for Upload_Emergency_Profile_Pic
    When user add request for otpLogin Endpoint along with loginId "7004813003" , isdCode "+91" ,deviceType "IOS" ,osVersion "15.1" ,appVersion "10" and deviceModel "x86_64" for Upload_Emergency_Profile_Pic
    And the user sends a valid Login Otp request with "POST" for Upload_Emergency_Profile_Pic
    Then Validate the OTP Generated having the response code as 200 ,verify message "OTP Verified Successfully" and loginId "7004813003" for Upload_Emergency_Profile_Pic
    Given the login API is available and add headers for Upload_Emergency_Profile_Pic
    When user add requestBody with JPEGextension "jpeg",customerID "09fdead0-96f5-4b52-8c0c-9697a8952c68" ,vinID "MBLJA06ES9GC12192" ,documentIdentifier "emergencyContactProfilePic/result1" ,category "emergency profile" ,subCategory "" ,emergencyId "1" for Upload_Emergency_Profile_Pic
    And the user sends a request with "POST" for Upload_Emergency_Profile_Pic
    Then the response status for Upload_Emergency_Profile_Pic should be 200 ,message "Upload Document" ,successMsg "File uploaded successfully" and status "Success"

  @InvalidUrl
  Scenario: Validate response if user enters invalid Url in Upload_Emergency_Profile_Pic
    Given the login API is available and adding headers for Upload_Emergency_Profile_Pic
    When user add requestBody with JPEGextension "jpeg",customerID "09fdead0-96f5-4b52-8c0c-9697a8952c68" ,vinID "" ,documentIdentifier "emergencyContactProfilePic/result1" ,category "emergency profile" ,subCategory "" ,emergencyId "1" for Upload_Emergency_Profile_Pic
    And the user sends a request with "POST" and invalid url "https://dev-apim.heromotocorp.com/api/uploadDocument" for Upload_Emergency_Profile_Pic
    Then the response status for Upload_Emergency_Profile_Pic should be 404 ,message "Resource not found" and errorCode "404"

  @EmptyBody
  Scenario: Validate response if user enters blank request body in Upload_Emergency_Profile_Pic
    Given the login API is available and adding headers for Upload_Emergency_Profile_Pic
    And the user sends a request with "POST" for Upload_Emergency_Profile_Pic
    Then the response status in Upload_Emergency_Profile_Pic for empty request body should be 500

  @InvalidCustomerIdentifier
  Scenario: Validate response if user enters invalid cutomer identifier for Upload_Emergency_Profile_Pic
    Given the login API is available and user add headers for Upload_Emergency_Profile_Pic
    When user add requestBody for validLogin loginId "7004813003" ,loginType "mobile"  and notificationType "sms" for Upload_Emergency_Profile_Pic
    And the user sends a ExternalLogin request with "POST" for Upload_Emergency_Profile_Pic
    Then the response status should be 200 and message "OTP Generated Successfully" and loginId "7004813003" for Upload_Emergency_Profile_Pic
    Given the login API is available and user add headers for Upload_Emergency_Profile_Pic
    When user add request for otpLogin Endpoint along with loginId "7004813003" , isdCode "+91" ,deviceType "IOS" ,osVersion "15.1" ,appVersion "10" and deviceModel "x86_64" for Upload_Emergency_Profile_Pic
    And the user sends a valid Login Otp request with "POST" for Upload_Emergency_Profile_Pic
    Then Validate the OTP Generated having the response code as 200 ,verify message "OTP Verified Successfully" and loginId "7004813003" for Upload_Emergency_Profile_Pic
    Given the login API is available and add headers for Upload_Emergency_Profile_Pic
    When user add requestBody with extension "jpeg",customerID "6be610ca-5e78-4a5c-be3b" ,vinID "" ,documentIdentifier "emergencyContactProfilePic/result1" ,category "emergency profile" ,subCategory "" ,emergencyId "1" for Upload_Emergency_Profile_Pic
    And the user sends a request with "POST" for Upload_Emergency_Profile_Pic
    Then the response status for Upload_Emergency_Profile_Pic should be 401 ,message "User is not authorized" and errorCode 401

  @BlankCustomerIdentifier
  Scenario: Validate response if user enters blankdata in customer identifier for Upload_Emergency_Profile_Pic
    Given the login API is available and adding headers for Upload_Emergency_Profile_Pic
    When user add requestBody with JPEGextension "jpeg",customerID "" ,vinID "MBLJA06ES9GC12192" ,documentIdentifier "emergencyContactProfilePic/result1" ,category "emergency profile" ,subCategory "" ,emergencyId "1" for Upload_Emergency_Profile_Pic
    And the user sends a request with "POST" for Upload_Emergency_Profile_Pic
    Then the response status in Upload_Emergency_Profile_Pic should be 200 message "Invalid Customer Identifier." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @InvalidVinId
  Scenario: Validate response if user enters Invalid VinId for Upload_Emergency_Profile_Pic
    Given the login API is available and add headers for Upload_Emergency_Profile_Pic
    When user add requestBody with extension "jpeg",customerID "09fdead0-96f5-4b52-8c0c-9697a8952c68" ,vinID "@#$%^&" ,documentIdentifier "emergencyContactProfilePic/result1" ,category "emergency profile" ,subCategory "" ,emergencyId "1" for Upload_Emergency_Profile_Pic
    And the user sends a request with "POST" for Upload_Emergency_Profile_Pic
    Then the response status in Upload_Emergency_Profile_Pic should be 200 message "Invalid VinId." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @BlankVinId
  Scenario: Validate response if user enters blank VinId for Upload_Emergency_Profile_Pic
    Given the login API is available and add headers for Upload_Emergency_Profile_Pic
    When user add requestBody with extension "jpeg",customerID "09fdead0-96f5-4b52-8c0c-9697a8952c68" ,vinID "" ,documentIdentifier "emergencyContactProfilePic/result1" ,category "emergency profile" ,subCategory "" ,emergencyId "1" for Upload_Emergency_Profile_Pic
    And the user sends a request with "POST" for Upload_Emergency_Profile_Pic
    Then the response status for Upload_Emergency_Profile_Pic should be 200 ,message "Upload Document" ,successMsg "File uploaded successfully" and status "Success"

  @InvalidCategory
  Scenario: Validate response if user enters Invalid Category for Upload_Emergency_Profile_Pic
    Given the login API is available and add headers for Upload_Emergency_Profile_Pic
    When user add requestBody with extension "jpeg",customerID "09fdead0-96f5-4b52-8c0c-9697a8952c68" ,vinID "" ,documentIdentifier "emergencyContactProfilePic/result1" ,category "prof12345@#$%^" ,subCategory "" ,emergencyId "1" for Upload_Emergency_Profile_Pic
    And the user sends a request with "POST" for Upload_Emergency_Profile_Pic
    Then the response status in Upload_Emergency_Profile_Pic should be 200 message "Invalid category." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @BlankCategory
  Scenario: Validate response if user enters blank data in Category for Upload_Emergency_Profile_Pic
    Given the login API is available and add headers for Upload_Emergency_Profile_Pic
    When user add requestBody with extension "jpeg",customerID "09fdead0-96f5-4b52-8c0c-9697a8952c68" ,vinID "" ,documentIdentifier "emergencyContactProfilePic/result1" ,category "" ,subCategory "" ,emergencyId "1" for Upload_Emergency_Profile_Pic
    And the user sends a request with "POST" for Upload_Emergency_Profile_Pic
    Then the response status in Upload_Emergency_Profile_Pic should be 200 message "category field is missing." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @InvalidSubCategory
  Scenario: Validate response if user enters Invalid Sub Category for Upload_Emergency_Profile_Pic
    Given the login API is available and add headers for Upload_Emergency_Profile_Pic
    When user add requestBody with extension "jpeg",customerID "09fdead0-96f5-4b52-8c0c-9697a8952c68" ,vinID "" ,documentIdentifier "emergencyContactProfilePic/result1" ,category "emergency profile" ,subCategory "pro1234@#$%" ,emergencyId "1" for Upload_Emergency_Profile_Pic
    And the user sends a request with "POST" for Upload_Emergency_Profile_Pic
    Then the response status in Upload_Emergency_Profile_Pic should be 200 message "Invalid subCategory." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @BlankSubCategory
  Scenario: Validate response if user enters blank data in Sub Category for Upload_Emergency_Profile_Pic
    Given the login API is available and add headers for Upload_Emergency_Profile_Pic
    When user add requestBody with extension "jpeg",customerID "09fdead0-96f5-4b52-8c0c-9697a8952c68" ,vinID "" ,documentIdentifier "emergencyContactProfilePic/result1" ,category "emergency profile" ,subCategory "" ,emergencyId "1" for Upload_Emergency_Profile_Pic
    And the user sends a request with "POST" for Upload_Emergency_Profile_Pic
    Then the response status for Upload_Emergency_Profile_Pic should be 200 ,message "Upload Document" ,successMsg "File uploaded successfully" and status "Success"

  @InvalidEmergecnyId
  Scenario: Validate response if user enters Invalid data in Emergency Id for Upload_Emergency_Profile_Pic  
     Given the login API is available and add headers for Upload_Emergency_Profile_Pic
    When user add requestBody with extension "jpeg",customerID "09fdead0-96f5-4b52-8c0c-9697a8952c68" ,vinID "MBLJA06ES9GC12192" ,documentIdentifier "emergencyContactProfilePic/result1" ,category "emergency profile" ,subCategory "" ,emergencyId "@#" for Upload_Emergency_Profile_Pic
    And the user sends a request with "POST" for Upload_Emergency_Profile_Pic
    Then the response status for Upload_Emergency_Profile_Pic should be 200 ,message "Upload Document" ,successMsg "File uploaded successfully" and status "Success"
   
   @BlankEmergecnyId
  Scenario: Validate response if user enters Blank data in Emergency Id for Upload_Emergency_Profile_Pic  
     Given the login API is available and add headers for Upload_Emergency_Profile_Pic
    When user add requestBody with extension "jpeg",customerID "09fdead0-96f5-4b52-8c0c-9697a8952c68" ,vinID "MBLJA06ES9GC12192" ,documentIdentifier "emergencyContactProfilePic/result1" ,category "emergency profile" ,subCategory "" ,emergencyId "" for Upload_Emergency_Profile_Pic
    And the user sends a request with "POST" for Upload_Emergency_Profile_Pic
    Then the response status for Upload_Emergency_Profile_Pic should be 200 ,message "Upload Document" ,successMsg "File uploaded successfully" and status "Success"
   
    
    
    
    