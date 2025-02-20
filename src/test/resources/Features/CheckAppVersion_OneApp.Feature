Feature: One APP Enterprise : API Login Testing

  @ValidData
  Scenario: Verify the response if Request body is correct
    Given the login API is available and add headers for CheckAppVersion
    When user add requestBody with deviceType "A" and userAppVersion "9.1.8" for CheckAppVersion
    And the user sends a request with "POST" for CheckAppVersion
    Then the response status for CheckAppVersion should be 200 ,message "Check app version details" ,checkVersion "Y" ,serviceToken "r0vhvWfVbDafwGZSMo24Yw==" ,salesToken "Uj+yp1djcn4i01gOCDnDGxFLCL7viytEoKP/klf8EEM=" ,serviceDomain "RqUsh1WB6X5bTByO/Cg2WXCJs7RsnEwWCZwRtGPkmdk=" ,salesDomain "RqUsh1WB6X5bTByO/Cg2WXCJs7RsnEwWCZwRtGPkmdk=" ,currentAppReleaseVersion "9.2.8" ,whatNew "Exchange journey for non Hero users" and isMandatory "Y"

  @InvalidUrl
  Scenario: Verify the response if Url is wrong
    Given the login API is available and add headers for CheckAppVersion
    When user add requestBody with deviceType "A" and userAppVersion "9.1.8" for CheckAppVersion
    And the user sends a request with "POST" and invalid url "https://dev-apim.heromotocorp.com/api/CheckAppVersion" for CheckAppVersion
    Then the response status for CheckAppVersion should be 404 ,message "Resource not found" and errorCode "404"

  @EmptyBody
  Scenario: Verify the response if Request body is blank
    Given the login API is available and add headers for CheckAppVersion
    And the user sends a request with "POST" for CheckAppVersion
    Then the response status for CheckAppVersion should be 500

  @InvalidDeviceType
  Scenario: Verify the response if deviceType field is incorrect incase
    Given the login API is available and add headers for CheckAppVersion
    When user add requestBody with deviceType "B" and userAppVersion "9.1.8" for CheckAppVersion
    And the user sends a request with "POST" for CheckAppVersion
    Then the response status in CheckAppVersion should be 200 message "Invalid DeviceType." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @SpclCharDeviceType
  Scenario: Verify the response if deviceType is contains spcl char
    Given the login API is available and add headers for CheckAppVersion
    When user add requestBody with deviceType "@#$%B" and userAppVersion "9.1.8" for CheckAppVersion
    And the user sends a request with "POST" for CheckAppVersion
    Then the response status in CheckAppVersion should be 200 message "DeviceType contains special character(s)." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @BlankDeviceType
  Scenario: Verify the response if deviceType is Blank
    Given the login API is available and add headers for CheckAppVersion
    When user add requestBody with deviceType "" and userAppVersion "9.1.8" for CheckAppVersion
    And the user sends a request with "POST" for CheckAppVersion
    Then the response status in CheckAppVersion should be 200 message "Invalid DeviceType." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @NullDeviceType
  Scenario: Verify the response if deviceType is Null
    Given the login API is available and add headers for CheckAppVersion
    When user add requestBody with deviceType "null" and userAppVersion "9.1.8" for CheckAppVersion
    And the user sends a request with "POST" for CheckAppVersion
    Then the response status in CheckAppVersion should be 200 message "Invalid DeviceType." ,errorCode 1002 and errorDescription "Unable to process Your Request"

 @InvalidUserAppVersion
  Scenario: Verify the response if userAppVersion field is incorrect incase
    Given the login API is available and add headers for CheckAppVersion
    When user add requestBody with deviceType "A" and userAppVersion "9-1-8" for CheckAppVersion
    And the user sends a request with "POST" for CheckAppVersion
    Then the response status in CheckAppVersion should be 200 message "Invalid User App Version." ,errorCode 1002 and errorDescription "Unable to process Your Request"
   
    @SpclCharUserAppVersion
  Scenario: Verify the response if userAppVersion is contains spcl char
    Given the login API is available and add headers for CheckAppVersion
    When user add requestBody with deviceType "A" and userAppVersion "9@1%8" for CheckAppVersion
    And the user sends a request with "POST" for CheckAppVersion
    Then the response status in CheckAppVersion should be 200 message "UserAppVersion contains special character(s)." ,errorCode 1002 and errorDescription "Unable to process Your Request"
  
     @BlankDeviceType
  Scenario: Verify the response if userAppVersion field is Blank
    Given the login API is available and add headers for CheckAppVersion
    When user add requestBody with deviceType "A" and userAppVersion "" for CheckAppVersion
    And the user sends a request with "POST" for CheckAppVersion
    Then the response status in CheckAppVersion should be 200 message "Invalid User App Version." ,errorCode 1002 and errorDescription "Unable to process Your Request"
    
    @NullDeviceType
  Scenario: Verify the response if userAppVersion field is null
    Given the login API is available and add headers for CheckAppVersion
    When user add requestBody with deviceType "A" and userAppVersion "" for CheckAppVersion
    And the user sends a request with "POST" for CheckAppVersion
    Then the response status in CheckAppVersion should be 200 message "Invalid User App Version." ,errorCode 1002 and errorDescription "Unable to process Your Request"
    
  @lowerversion
  Scenario: Verify response for checkVersion for lower version
    Given the login API is available and add headers for CheckAppVersion
    When user add requestBody with deviceType "A" and userAppVersion "9.1.8" for CheckAppVersion
    And the user sends a request with "POST" for CheckAppVersion
    Then the response status for CheckAppVersion should be 200 ,message "Check app version details" ,checkVersion "Y" ,serviceToken "r0vhvWfVbDafwGZSMo24Yw==" ,salesToken "Uj+yp1djcn4i01gOCDnDGxFLCL7viytEoKP/klf8EEM=" ,serviceDomain "RqUsh1WB6X5bTByO/Cg2WXCJs7RsnEwWCZwRtGPkmdk=" ,salesDomain "RqUsh1WB6X5bTByO/Cg2WXCJs7RsnEwWCZwRtGPkmdk=" ,currentAppReleaseVersion "9.2.8" ,whatNew "Exchange journey for non Hero users" and isMandatory "Y"
   
   @Higherversion
  Scenario: Verify response for checkVersion for lower version
    Given the login API is available and add headers for CheckAppVersion
    When user add requestBody with deviceType "A" and userAppVersion "9.2.9" for CheckAppVersion
    And the user sends a request with "POST" for CheckAppVersion
    Then the response status for CheckAppVersion should be 200 ,message "Check app version details" ,checkVersion "N" ,serviceToken "r0vhvWfVbDafwGZSMo24Yw==" ,salesToken "Uj+yp1djcn4i01gOCDnDGxFLCL7viytEoKP/klf8EEM=" ,serviceDomain "RqUsh1WB6X5bTByO/Cg2WXCJs7RsnEwWCZwRtGPkmdk=" ,salesDomain "RqUsh1WB6X5bTByO/Cg2WXCJs7RsnEwWCZwRtGPkmdk=" ,currentAppReleaseVersion "9.2.8" ,whatNew "Exchange journey for non Hero users" and isMandatory "N"
  
   @IOSData
  Scenario: Verify the response if Request body is correct
    Given the login API is available and add headers for CheckAppVersion
    When user add requestBody with deviceType "I" and userAppVersion "9.0.0" for CheckAppVersion
    And the user sends a request with "POST" for CheckAppVersion
    Then the response status for CheckAppVersion should be 200 ,message "Check app version details" ,checkVersion "Y" ,serviceToken "r0vhvWfVbDafwGZSMo24Yw==" ,salesToken "Uj+yp1djcn4i01gOCDnDGxFLCL7viytEoKP/klf8EEM=" ,serviceDomain "RqUsh1WB6X5bTByO/Cg2WXCJs7RsnEwWCZwRtGPkmdk=" ,salesDomain "RqUsh1WB6X5bTByO/Cg2WXCJs7RsnEwWCZwRtGPkmdk=" ,currentAppReleaseVersion "9.2.7" ,whatNew "Exchange journey for non Hero users" and isMandatory "Y"
   
   
  
   @Android_IsmandatoryN
  Scenario: Verify response for isMandatory N for Android (user App version other than "9.1.0", "9.1.1","9.1.2", "9.1.3", "9.1.4", "9.1.5", "9.1.6", "9.1.7", "9.1.8", "9.1.9","9.1.10")
    Given the login API is available and add headers for CheckAppVersion
    When user add requestBody with deviceType "A" and userAppVersion "9.0.0" for CheckAppVersion
    And the user sends a request with "POST" for CheckAppVersion
    Then the response status for CheckAppVersion should be 200 ,message "Check app version details" ,checkVersion "Y" ,serviceToken "r0vhvWfVbDafwGZSMo24Yw==" ,salesToken "Uj+yp1djcn4i01gOCDnDGxFLCL7viytEoKP/klf8EEM=" ,serviceDomain "RqUsh1WB6X5bTByO/Cg2WXCJs7RsnEwWCZwRtGPkmdk=" ,salesDomain "RqUsh1WB6X5bTByO/Cg2WXCJs7RsnEwWCZwRtGPkmdk=" ,currentAppReleaseVersion "9.2.8" ,whatNew "Exchange journey for non Hero users" and isMandatory "N"
    
    @IOS_IsmandatoryN
  Scenario: Verify response for isMandatory N for IOS(user App version other than  "9.0.0","9.1.0", "9.1.1","9.1.2", "9.1.3", "9.1.4", "9.1.5", "9.1.6", "9.1.7", "9.1.8", "9.1.9")
    Given the login API is available and add headers for CheckAppVersion
    When user add requestBody with deviceType "I" and userAppVersion "9.1.10" for CheckAppVersion
    And the user sends a request with "POST" for CheckAppVersion
    Then the response status for CheckAppVersion should be 200 ,message "Check app version details" ,checkVersion "Y" ,serviceToken "r0vhvWfVbDafwGZSMo24Yw==" ,salesToken "Uj+yp1djcn4i01gOCDnDGxFLCL7viytEoKP/klf8EEM=" ,serviceDomain "RqUsh1WB6X5bTByO/Cg2WXCJs7RsnEwWCZwRtGPkmdk=" ,salesDomain "RqUsh1WB6X5bTByO/Cg2WXCJs7RsnEwWCZwRtGPkmdk=" ,currentAppReleaseVersion "9.2.7" ,whatNew "Exchange journey for non Hero users" and isMandatory "N"
   
    