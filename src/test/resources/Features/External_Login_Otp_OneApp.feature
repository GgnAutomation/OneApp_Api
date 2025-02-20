Feature: OneApp Enterprise : API Login Testing

  Background: 
    Given the login API is available and add headers for External Login Otp

  @Valid_Otp
  Scenario Outline: Successful login with valid mobile number for valid otp
    When user add requestBody for valid Login otp "<loginId>" ,"<loginType>" and "<notificationType>"
    And the user sends a valid Login otp request with "POST"
    Then the response status for valid login otp should be 200 and message "OTP Generated Successfully" and loginId "8409520578"
    When user add request for otpLogin along with loginId "8409520578" ,otp "123456" ,isdCode "<isdCode>" ,deviceType "<deviceType>" ,osVersion "<osVersion>" ,appVersion "<apVersion>" and deviceModel "<deviceModel>"
    And the user sends a valid Login Otp request with "POST"
    Then Validate the OTP Generated having the response code as 200 and verify message "<message>" , loginId "<loginId>" , firstName "<firstName>" , lastName "<lastName>" , appName "<appName>" and primaryUser "<primaryUser>"

    Examples: 
      | loginId    | loginType | notificationType | isdCode | deviceType | osVersion | apVersion | deviceModel | message                   | loginId    | firstName | lastName | appName | primaryUser |
      | 8409520578 | mobile    | sms              | +91     | IOS        |      15.1 |        10 | x86_64      | OTP Verified Successfully | 8409520578 | SP SINGH  | SURAJ    | oneapp  | Y           |

  @InValid_Otp_length
  Scenario Outline: Validate response for invalid otp length in OTP
    When user add requestBody for valid Login otp "<loginId>" ,"<loginType>" and "<notificationType>"
    And the user sends a valid Login otp request with "POST"
    Then the response status for valid login otp should be 200 and message "OTP Generated Successfully" and loginId "8409520578"
    When user add request for otpLogin along with loginId "8409520578" ,otp "1234567" ,isdCode "<isdCode>" ,deviceType "<deviceType>" ,osVersion "<osVersion>" ,appVersion "<apVersion>" and deviceModel "<deviceModel>"
    And the user sends a valid Login Otp request with "POST"
    Then Validate the Generated response code as 200 and verify message "<message>" , errorCode 1002 and errorDescription "<errorDescription>"

    Examples: 
      | loginId    | loginType | notificationType | isdCode | deviceType | osVersion | apVersion | deviceModel | message             | errorDescription               |
      | 8409520578 | mobile    | sms              | +91     | IOS        |      15.1 |        10 | x86_64      | Invalid OTP length. | Unable to process Your Request |

  @Invalid_SpecialChar_Otp
  Scenario Outline: Validate response for special charecters in OTP
    When user add requestBody for valid Login otp "<loginId>" ,"<loginType>" and "<notificationType>"
    And the user sends a valid Login otp request with "POST"
    Then the response status for valid login otp should be 200 and message "OTP Generated Successfully" and loginId "8409520578"
    When user add request for otpLogin along with loginId "8409520578" ,otp "@#$%^&" ,isdCode "<isdCode>" ,deviceType "<deviceType>" ,osVersion "<osVersion>" ,appVersion "<apVersion>" and deviceModel "<deviceModel>"
    And the user sends a valid Login Otp request with "POST"
    Then Validate the Generated response code as 200 and verify message "<message>" , errorCode 1002 and errorDescription "<errorDescription>"

    Examples: 
      | loginId    | loginType | notificationType | isdCode | deviceType | osVersion | apVersion | deviceModel | message                            | errorDescription               |
      | 8409520578 | mobile    | sms              | +91     | IOS        |      15.1 |        10 | x86_64      | OTP contains special character(s). | Unable to process Your Request |

  @Wrong_Otp
  Scenario Outline: Validate response if user enteres invalid OTP
    When user add requestBody for valid Login otp "<loginId>" ,"<loginType>" and "<notificationType>"
    And the user sends a valid Login otp request with "POST"
    Then the response status for valid login otp should be 200 and message "OTP Generated Successfully" and loginId "9123253221"
    When user add request for otpLogin along with loginId "9123253221" ,otp "345678" ,isdCode "<isdCode>" ,deviceType "<deviceType>" ,osVersion "<osVersion>" ,appVersion "<apVersion>" and deviceModel "<deviceModel>"
    And the user sends a valid Login Otp request with "POST"
    Then Validate the Generated response code as 200 and verify message "<message>" , errorCode 1005 and errorDescription "<errorDescription>"

    Examples: 
      | loginId    | loginType | notificationType | isdCode | deviceType | osVersion | apVersion | deviceModel | message                      | errorDescription               |
      | 9123253221 | mobile    | sms              | +91     | IOS        |      15.1 |        10 | x86_64      | Invalid OTP 4 attempts left. | Unable to process Your Request |

  @Blank_Otp
  Scenario Outline: Validate response if user keeps OTP as blank
    When user add requestBody for valid Login otp "<loginId>" ,"<loginType>" and "<notificationType>"
    And the user sends a valid Login otp request with "POST"
    Then the response status for valid login otp should be 200 and message "OTP Generated Successfully" and loginId "9123253221"
    When user add request for otpLogin along with loginId "9123253221" ,otp "" ,isdCode "<isdCode>" ,deviceType "<deviceType>" ,osVersion "<osVersion>" ,appVersion "<apVersion>" and deviceModel "<deviceModel>"
    And the user sends a valid Login Otp request with "POST"
    Then Validate the Generated response code as 200 and verify message "<message>" , errorCode 1002 and errorDescription "<errorDescription>"

    Examples: 
      | loginId    | loginType | notificationType | isdCode | deviceType | osVersion | apVersion | deviceModel | message                        | errorDescription               |
      | 9123253221 | mobile    | sms              | +91     | IOS        |      15.1 |        10 | x86_64      | OTP must not be Empty or Null. | Unable to process Your Request |

  @Space_In_between_Otp
  Scenario Outline: Validate response if user gives space between digits
    When user add requestBody for valid Login otp "<loginId>" ,"<loginType>" and "<notificationType>"
    And the user sends a valid Login otp request with "POST"
    Then the response status for valid login otp should be 200 and message "OTP Generated Successfully" and loginId "9123253221"
    When user add request for otpLogin along with loginId "9123253221" ,otp "12 456" ,isdCode "<isdCode>" ,deviceType "<deviceType>" ,osVersion "<osVersion>" ,appVersion "<apVersion>" and deviceModel "<deviceModel>"
    And the user sends a valid Login Otp request with "POST"
    Then Validate the Generated response code as 200 and verify message "<message>" , errorCode 1002 and errorDescription "<errorDescription>"

    Examples: 
      | loginId    | loginType | notificationType | isdCode | deviceType | osVersion | apVersion | deviceModel | message      | errorDescription               |
      | 9123253221 | mobile    | sms              | +91     | IOS        |      15.1 |        10 | x86_64      | Invalid OTP. | Unable to process Your Request |

  @Reuse_Otp
  Scenario Outline: Successful login with reusing the OTP
    When user add request for otpLogin along with loginId "6264413799" ,otp "123456" ,isdCode "<isdCode>" ,deviceType "<deviceType>" ,osVersion "<osVersion>" ,appVersion "<apVersion>" and deviceModel "<deviceModel>"
    And the user sends a valid Login Otp request with "POST"
    Then Validate the Generated response code as 200 and verify message "<message>" , errorCode 1004 and errorDescription "<errorDescription>"

    Examples: 
      | isdCode | deviceType | osVersion | apVersion | deviceModel | message                                | errorDescription               |
      | +91     | IOS        |      15.1 |        10 | x86_64      | Your OTP has expired, Please try again | Unable to process Your Request |

  @Invalid_deviceModel
  Scenario Outline: Successful login with Invalid device Model OTP verification
    When user add requestBody for valid Login otp "<loginId>" ,"<loginType>" and "<notificationType>"
    And the user sends a valid Login otp request with "POST"
    Then the response status for valid login otp should be 200 and message "OTP Generated Successfully" and loginId "8278650631"
    When user add request for otpLogin along with loginId "8278650631" ,otp "123456" ,isdCode "<isdCode>" ,deviceType "<deviceType>" ,osVersion "<osVersion>" ,appVersion "<apVersion>" and deviceModel "<deviceModel>"
    And the user sends a valid Login Otp request with "POST"
    Then Validate the OTP Generated having the response code as 200 and verify message "<message>" , loginId "<loginId>" , firstName "<firstName>" , lastName "<lastName>" , appName "<appName>" and primaryUser "<primaryUser>"

    Examples: 
      | loginId    | loginType | notificationType | isdCode | deviceType | osVersion | apVersion | deviceModel   | message                   | loginId    | firstName | lastName | appName | primaryUser |
      | 8278650631 | mobile    | sms              | +91     | IOS        |      15.1 |        10 | SkG x86_64$#$ | OTP Verified Successfully | 8278650631 | BALWINDER       | KOUR        | oneapp  | Y           |

  @Blank_deviceModel
  Scenario Outline: Validate response if modelName name field is blank.
    When user add requestBody for valid Login otp "<loginId>" ,"<loginType>" and "<notificationType>"
    And the user sends a valid Login otp request with "POST"
    Then the response status for valid login otp should be 200 and message "OTP Generated Successfully" and loginId "8278650631"
    When user add request for otpLogin along with loginId "8278650631" ,otp "123456" ,isdCode "<isdCode>" ,deviceType "<deviceType>" ,osVersion "<osVersion>" ,appVersion "<apVersion>" and deviceModel "<deviceModel>"
    And the user sends a valid Login Otp request with "POST"
    Then Validate the OTP Generated having the response code as 200 and verify message "<message>" , loginId "<loginId>" , firstName "<firstName>" , lastName "<lastName>" , appName "<appName>" and primaryUser "<primaryUser>"

    Examples: 
      | loginId    | loginType | notificationType | isdCode | deviceType | osVersion | apVersion | deviceModel | message                   | loginId    | firstName | lastName | appName | primaryUser |
      | 8278650631 | mobile    | sms              | +91     | IOS        |      15.1 |        10 |             | OTP Verified Successfully | 8278650631 | BALWINDER       | KOUR        | oneapp  | Y           |

  @ISD_code_specialChar
  Scenario Outline: Validate response if user enters ISD code with special char
    When user add requestBody for valid Login otp "<loginId>" ,"<loginType>" and "<notificationType>"
    And the user sends a valid Login otp request with "POST"
    Then the response status for valid login otp should be 200 and message "OTP Generated Successfully" and loginId "7004813003"
    When user add request for otpLogin along with loginId "7004813003" ,otp "123456" ,isdCode "<isdCode>" ,deviceType "<deviceType>" ,osVersion "<osVersion>" ,appVersion "<apVersion>" and deviceModel "<deviceModel>"
    And the user sends a valid Login Otp request with "POST"
    Then Validate the Generated response code as 200 and verify message "<message>" , errorCode 1002 and errorDescription "<errorDescription>"

    Examples: 
      | loginId    | loginType | notificationType | isdCode | deviceType | osVersion | apVersion | deviceModel | message                                | errorDescription               |
      | 7004813003 | mobile    | sms              | +91#$%  | IOS        |      15.1 |        10 | x86_64      | IsdCode contains special character(s). | Unable to process Your Request |

  @Alpha_numeric_ISD_Code
  Scenario Outline: Validate response if user enters ISD code with alphanumeric char
    When user add requestBody for valid Login otp "<loginId>" ,"<loginType>" and "<notificationType>"
    And the user sends a valid Login otp request with "POST"
    Then the response status for valid login otp should be 200 and message "OTP Generated Successfully" and loginId "7004813003"
    When user add request for otpLogin along with loginId "7004813003" ,otp "123456" ,isdCode "<isdCode>" ,deviceType "<deviceType>" ,osVersion "<osVersion>" ,appVersion "<apVersion>" and deviceModel "<deviceModel>"
    And the user sends a valid Login Otp request with "POST"
    Then Validate the OTP Generated having the response code as 200 and verify message "<message>" , loginId "<loginId>" , firstName "<firstName>" , lastName "<lastName>" , appName "<appName>" and primaryUser "<primaryUser>"

    Examples: 
      | loginId    | loginType | notificationType | isdCode | deviceType | osVersion | apVersion | deviceModel | message                   | loginId    | firstName | lastName | appName | primaryUser |
      | 7004813003 | mobile    | sms              | 93 IN   | IOS        |      15.1 |        10 | x86_64      | OTP Verified Successfully | 7004813003 | AATIsh    | SHANKAr  | oneapp  | Y           |

  @Blank_IsdCode
  Scenario Outline: Successful login with Blank IsdCode in OTP verification
    When user add requestBody for valid Login otp "<loginId>" ,"<loginType>" and "<notificationType>"
    And the user sends a valid Login otp request with "POST"
    Then the response status for valid login otp should be 200 and message "OTP Generated Successfully" and loginId "7004813003"
    When user add request for otpLogin along with loginId "7004813003" ,otp "123456" ,isdCode "<isdCode>" ,deviceType "<deviceType>" ,osVersion "<osVersion>" ,appVersion "<apVersion>" and deviceModel "<deviceModel>"
    And the user sends a valid Login Otp request with "POST"
    Then Validate the OTP Generated having the response code as 200 and verify message "<message>" , loginId "<loginId>" , firstName "<firstName>" , lastName "<lastName>" , appName "<appName>" and primaryUser "<primaryUser>"

    Examples: 
      | loginId    | loginType | notificationType | isdCode | deviceType | osVersion | apVersion | deviceModel | message                   | loginId    | firstName | lastName | appName | primaryUser |
      | 7004813003 | mobile    | sms              |         | IOS        |      15.1 |        10 | x86_64      | OTP Verified Successfully | 7004813003 | AATIsh    | SHANKAr  | oneapp  | Y           |

  @DeviceTye_specialChar
  Scenario Outline: Validate response if user enters Device Type  with special char
    When user add request for otpLogin along with loginId "7004813003" ,otp "123456" ,isdCode "<isdCode>" ,deviceType "<deviceType>" ,osVersion "<osVersion>" ,appVersion "<apVersion>" and deviceModel "<deviceModel>"
    And the user sends a valid Login Otp request with "POST"
    Then Validate the Generated response code as 200 and verify message "<message>" , errorCode 1002 and errorDescription "<errorDescription>"

    Examples: 
      | isdCode | deviceType | osVersion | apVersion | deviceModel | message                                   | errorDescription               |
      | +91     | #$IOS      |      15.1 |        10 | x86_64      | DeviceType contains special character(s). | Unable to process Your Request |

  @DeviceType_With_Space_AlphaNumeric
  Scenario Outline: Successful login with device type with space and alpha numeric in OTP verification
    When user add requestBody for valid Login otp "<loginId>" ,"<loginType>" and "<notificationType>"
    And the user sends a valid Login otp request with "POST"
    Then the response status for valid login otp should be 200 and message "OTP Generated Successfully" and loginId "7004813003"
    When user add request for otpLogin along with loginId "7004813003" ,otp "123456" ,isdCode "<isdCode>" ,deviceType "<deviceType>" ,osVersion "<osVersion>" ,appVersion "<apVersion>" and deviceModel "<deviceModel>"
    And the user sends a valid Login Otp request with "POST"
    Then Validate the OTP Generated having the response code as 200 and verify message "<message>" , loginId "<loginId>" , firstName "<firstName>" , lastName "<lastName>" , appName "<appName>" and primaryUser "<primaryUser>"

    Examples: 
      | loginId    | loginType | notificationType | isdCode | deviceType | osVersion | apVersion | deviceModel | message                   | loginId    | firstName | lastName | appName | primaryUser |
      | 7004813003 | mobile    | sms              |      91 | IOS 153    |      15.1 |        10 | x86_64      | OTP Verified Successfully | 7004813003 | AATIsh    | SHANKAr  | oneapp  | Y           |

  @OsVersion_specialChar
  Scenario Outline: Successful login with Invalid OS version with special char in OTP verification
    When user add requestBody for valid Login otp "<loginId>" ,"<loginType>" and "<notificationType>"
    And the user sends a valid Login otp request with "POST"
    Then the response status for valid login otp should be 200 and message "OTP Generated Successfully" and loginId "7004813003"
    When user add request for otpLogin along with loginId "7004813003" ,otp "123456" ,isdCode "<isdCode>" ,deviceType "<deviceType>" ,osVersion "<osVersion>" ,appVersion "<apVersion>" and deviceModel "<deviceModel>"
    And the user sends a valid Login Otp request with "POST"
    Then Validate the Generated response code as 200 and verify message "<message>" , errorCode 1002 and errorDescription "<errorDescription>"

    Examples: 
      | loginId    | loginType | notificationType | isdCode | deviceType | osVersion | apVersion | deviceModel | message                                  | errorDescription               |
      | 7004813003 | mobile    | sms              | +91     | IOS        | 15.1#$    |        10 | x86_64      | OsVersion contains special character(s). | Unable to process Your Request |

  @AlphaNumeric_SpecialChar_Token
  Scenario Outline: Successful login with alpha numeric special char in firebase token in OTP verification
    When user add requestBody for valid Login otp "<loginId>" ,"<loginType>" and "<notificationType>"
    And the user sends a valid Login otp request with "POST"
    Then the response status for valid login otp should be 200 and message "OTP Generated Successfully" and loginId "6264413799"
    When user add request for otpLogin along with loginId "6264413799" ,otp "123456" ,isdCode "<isdCode>" ,deviceType "<deviceType>" ,osVersion "<osVersion>" ,appVersion "<apVersion>" ,deviceModel "<deviceModel>" and specialfirebsetoken
    And the user sends a valid Login Otp request with "POST"
    Then Validate the OTP Generated having the response code as 200 and verify message "<message>" , loginId "<loginId>" , firstName "<firstName>" , lastName "<lastName>" , appName "<appName>" and primaryUser "<primaryUser>"

    Examples: 
      | loginId    | loginType | notificationType | isdCode | deviceType | osVersion | apVersion | deviceModel | message                   | loginId    | firstName | lastName | appName | primaryUser |
      | 6264413799 | mobile    | sms              | +91     | IOS        |      15.1 |        10 | x86_64      | OTP Verified Successfully | 6264413799 | NARESH    | VAKHLA   | oneapp  | Y           |

  @Blank_Token
  Scenario Outline: Successful login with blank token in firebase token in OTP verification
    When user add requestBody for valid Login otp "<loginId>" ,"<loginType>" and "<notificationType>"
    And the user sends a valid Login otp request with "POST"
    Then the response status for valid login otp should be 200 and message "OTP Generated Successfully" and loginId "6264413799"
    When user add request for otpLogin along with loginId "6264413799" ,otp "123456" ,isdCode "<isdCode>" ,deviceType "<deviceType>" ,osVersion "<osVersion>" ,appVersion "<apVersion>" ,deviceModel "<deviceModel>" and blankfirebsetoken
    And the user sends a valid Login Otp request with "POST"
    Then Validate the OTP Generated having the response code as 200 and verify message "<message>" , loginId "<loginId>" , firstName "<firstName>" , lastName "<lastName>" , appName "<appName>" and primaryUser "<primaryUser>"

    Examples: 
      | loginId    | loginType | notificationType | isdCode | deviceType | osVersion | apVersion | deviceModel | message                   | loginId    | firstName | lastName | appName | primaryUser |
      | 6264413799 | mobile    | sms              | +91     | IOS        |      15.1 |        10 | x86_64      | OTP Verified Successfully | 6264413799 | NARESH    | VAKHLA   | oneapp  | Y           |

  @Empty_RequestBody
  Scenario Outline: Validate response if request body is blank
    When user add request Body for valid Empty Request Body
    And the user sends a valid Login Otp request with "POST"
    Then Validate response for Empty request Body status should be "<responseCode>"

    Examples: 
      | responseCode |
      |          500 |

  @Invalid_url
  Scenario Outline: Validate response if user enters invalid Url
    When user add requestBody for valid Login otp "<loginId>" ,"<loginType>" and "<notificationType>"
    And the user sends a valid Login otp request with "POST"
    Then the response status for valid login otp should be 200 and message "OTP Generated Successfully" and loginId "6264413799"
    When user add request for otpLogin along with loginId "6264413799" ,otp "123456" ,isdCode "<isdCode>" ,deviceType "<deviceType>" ,osVersion "<osVersion>" ,appVersion "<apVersion>" and deviceModel "<deviceModel>"
    And the user sends a valid Login Otp request with "POST" and Invalid url "https://dev-apim.heromotocorp.com/api/externalLogin"
    Then Validate the response code as 404 and verify message "Resource not found"

     Examples: 
      | loginId    | loginType | notificationType | isdCode | deviceType | osVersion | apVersion | deviceModel |
      | 6264413799 | mobile    | sms              | +91     | IOS        |      15.1 |        10 | x86_64      | 
