Feature: One APP Enterprise : API Login Testing

  @ValidData
  Scenario: Verify response with valid request body
    Given the login API is available and add headers for VerifyRsa
    When user add requestBody with mobileNo "7004813003" ,vinNo "MBLJA06ES9GC12192" for VerifyRsa
    And the user sends a request with "POST" for VerifyRsa
    Then the response status for VerifyRsa should be 200 ,message "Rsa details fetched successfully. " ,isRsaMember "Yes" ,isGaMember "Yes" ,rsaMembershipStatus "Active" ,membershipStartDate "2024-09-27 00:00:00" ,membershipEndDate "2025-09-26 00:00:00" ,rsaPolicyNumber "TW2709240000000006" and rsaVendorName "Global Assure"

  @InvalidMobNo
  Scenario: Verify response with invalid mobileNo for VerifyRsa
    Given the login API is available and add headers for VerifyRsa
    When user add requestBody with mobileNo "7004811000" ,vinNo "MBLJA06ES9GC12192" for VerifyRsa
    And the user sends a request with "POST" for VerifyRsa
    Then the response status in VerifyRsa should be 200 message "No Vehicle found for given data!" ,errorCode 1001 and errorDescription "Unable to process Your Request"

  @BlankMobNo
  Scenario: Verify response with blank mobileNo for VerifyRsa
    Given the login API is available and add headers for VerifyRsa
    When user add requestBody with mobileNo "" ,vinNo "MBLJA06ES9GC12192" for VerifyRsa
    And the user sends a request with "POST" for VerifyRsa
    Then the response status in VerifyRsa should be 200 message "Mobile Field Blank Or Not In Format." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @SpclCharMobNo
  Scenario: Verify response with special characters in mobileNo for VerifyRsa
    Given the login API is available and add headers for VerifyRsa
    When user add requestBody with mobileNo "@#$%^&*" ,vinNo "MBLJA06ES9GC12192" for VerifyRsa
    And the user sends a request with "POST" for VerifyRsa
    Then the response status in VerifyRsa should be 200 message "Mobile number is not numeric." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @InvalidVinNo
  Scenario: Verify response with invalid vinNo for VerifyRsa
    Given the login API is available and add headers for VerifyRsa
    When user add requestBody with mobileNo "7004813003" ,vinNo "MBLJA06ES9GC11000" for VerifyRsa
    And the user sends a request with "POST" for VerifyRsa
    Then the response status in VerifyRsa should be 200 message "No Vehicle found for given data!" ,errorCode 1001 and errorDescription "Unable to process Your Request"

  @BlankVinNo
  Scenario: Verify response with blank vinNo for verifyRsa
    Given the login API is available and add headers for VerifyRsa
    When user add requestBody with mobileNo "7004813003" ,vinNo "" for VerifyRsa
    And the user sends a request with "POST" for VerifyRsa
    Then the response status in VerifyRsa should be 200 message "VIN No Field Blank Or Not In Format." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @SpclCharvinNo
  Scenario: Verify response with special characters in vinNo for VerifyRsa
    Given the login API is available and add headers for VerifyRsa
    When user add requestBody with mobileNo "7004813003" ,vinNo "@#$%^&*" for VerifyRsa
    And the user sends a request with "POST" for VerifyRsa
    Then the response status in VerifyRsa should be 200 message "VIN No contains special character(s)." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @InvalidUrl
  Scenario: Verify response with incorrect url for verifyRsa
    Given the login API is available and add headers for VerifyRsa
    When user add requestBody with mobileNo "7004813003" ,vinNo "MBLJA06ES9GC12192" for VerifyRsa
    And the user sends a request with "POST" and invalid url "https://dev-apim.heromotocorp.com/api/VerifyRsa" for VerifyRsa
    Then the response status for VerifyRsa should be 404 ,message "Resource not found" and errorCode "404"

  @EmptyBody
  Scenario: Verify response with valid request body
    Given the login API is available and add headers for VerifyRsa
    And the user sends a request with "POST" for VerifyRsa
    Then the response status in VerifyRsa should be 200 message "JSONObject[\"data\"] not found." ,errorCode 1001 and errorDescription "Unable to process Your Request"

  @IsRsaMemberActive
  Scenario: Verify response WHEN (programStatus = 'Active' THEN 'Yes' ELSE 'No'  for isRsaMember)
    Given the login API is available and add headers for VerifyRsa
    When user add requestBody with mobileNo "7004813003" ,vinNo "MBLJA06ES9GC12192" for VerifyRsa
    And the user sends a request with "POST" for VerifyRsa
    Then the response status for VerifyRsa should be 200 ,message "Rsa details fetched successfully. " ,isRsaMember "Yes" ,isGaMember "Yes" ,rsaMembershipStatus "Active" ,membershipStartDate "2024-09-27 00:00:00" ,membershipEndDate "2025-09-26 00:00:00" ,rsaPolicyNumber "TW2709240000000006" and rsaVendorName "Global Assure"

  @IsRsaMemberExpired
  Scenario: Verify response WHEN (programStatus = 'Active' THEN 'Yes' ELSE 'No'  for isRsaMember)
    Given the login API is available and add headers for VerifyRsa
    When user add requestBody with mobileNo "8223071147" ,vinNo "MBLHAW118LHJ03649" for VerifyRsa
    And the user sends a request with "POST" for VerifyRsa
    Then the response status for VerifyRsa should be 200 ,message "Rsa details fetched successfully. " ,isRsaMember "Yes" ,isGaMember "Yes" ,rsaMembershipStatus "Expired" ,membershipStartDate "2020-12-04 00:00:00" ,membershipEndDate "2021-12-03 00:00:00" ,rsaPolicyNumber "127" and rsaVendorName "GLOBAL ASSURE"

  @ProgramStatusNull
  Scenario: Verify response WHEN programStatus is null  then is shall be NO for isRsaMember
    Given the login API is available and add headers for VerifyRsa
    When user add requestBody with mobileNo "9123253221" ,vinNo "MBLJAW010K9G04274" for VerifyRsa
    And the user sends a request with "POST" for VerifyRsa
    Then the response status for VerifyRsa should be 200 ,message "Rsa details fetched successfully. " ,isRsaMember "No"

  @ProgramStatusBlank
  Scenario: Verify response WHEN programStatus is Blank  then is shall be NO for isRsaMember
    Given the login API is available and add headers for VerifyRsa
    When user add requestBody with mobileNo "8282828281" ,vinNo "MBLHA10AVDHF01338" for VerifyRsa
    And the user sends a request with "POST" for VerifyRsa
    Then the response status for VerifyRsa should be 200 ,message "Rsa details fetched successfully. " ,isRsaMember "No"

  @ProgramStatusSpclChar
  Scenario: Verify response WHEN programStatus is Spcl Char then is shall be NO for isRsaMember
    Given the login API is available and add headers for VerifyRsa
    When user add requestBody with mobileNo "8094935137" ,vinNo "MBLHAW127N4J01880" for VerifyRsa
    And the user sends a request with "POST" for VerifyRsa
    Then the response status for VerifyRsa should be 200 ,message "Rsa details fetched successfully. " and rsaMembershipStatus "@#$%"

  @GLOBALASSURE
  Scenario: Verify response WHEN (upper(vendorName) IN ('GLOBAL ASSURE')) THEN 'Yes' ELSE 'No' for  isGaMember
    Given the login API is available and add headers for VerifyRsa
    When user add requestBody with mobileNo "7004813003" ,vinNo "MBLJA06ES9GC12192" for VerifyRsa
    And the user sends a request with "POST" for VerifyRsa
    Then the response status for VerifyRsa should be 200 ,message "Rsa details fetched successfully. " ,isRsaMember "Yes" ,isGaMember "Yes" ,rsaMembershipStatus "Active" ,membershipStartDate "2024-09-27 00:00:00" ,membershipEndDate "2025-09-26 00:00:00" ,rsaPolicyNumber "TW2709240000000006" and rsaVendorName "Global Assure"

  @PVTLTD
  Scenario: Verify response WHEN (upper(vendorName) IN (PVT LIMITED)) THEN 'Yes' ELSE 'No' for  isGaMember
    Given the login API is available and add headers for VerifyRsa
    When user add requestBody with mobileNo "8926462510" ,vinNo "MBLJC59ADFGC00439" for VerifyRsa
    And the user sends a request with "POST" for VerifyRsa
    Then the response status for VerifyRsa should be 200 ,message "Rsa details fetched successfully. " and rsaVendorName "PVT LTD"

  @InvalidRsaVendorName
  Scenario: Verify response WHEN rsaVendorName is not in format  then is shall be NO for isGaMember
    Given the login API is available and add headers for VerifyRsa
    When user add requestBody with mobileNo "8535820261" ,vinNo "MBLJAR026HGK22987" for VerifyRsa
    And the user sends a request with "POST" for VerifyRsa
    Then the response status for VerifyRsa should be 200 ,message "Rsa details fetched successfully. " ,isRsaMember "No"

  @RsaVendorNameNull
  Scenario: Verify response WHEN rsaVendorName is null  then is shall be NO for isGaMember
    Given the login API is available and add headers for VerifyRsa
    When user add requestBody with mobileNo "9635574988" ,vinNo "MBLJFW011J4F14676" for VerifyRsa
    And the user sends a request with "POST" for VerifyRsa
    Then the response status for VerifyRsa should be 200 ,message "Rsa details fetched successfully. " ,isRsaMember "No"

  @RsaVendorNameBlank
  Scenario: Verify response WHEN rsaVendorName is Blank  then is shall be NO for isGaMember
    Given the login API is available and add headers for VerifyRsa
    When user add requestBody with mobileNo "9571411586" ,vinNo "MBLHAW116NHH89115" for VerifyRsa
    And the user sends a request with "POST" for VerifyRsa
    Then the response status for VerifyRsa should be 200 ,message "Rsa details fetched successfully. " ,isRsaMember "No" and rsaVendorName ""

  @SpclCharVendorName
  Scenario: Verify response WHEN rsaVendorName is Spcl Char then is shall be NO for isGaMember
    Given the login API is available and add headers for VerifyRsa
    When user add requestBody with mobileNo "8223031587" ,vinNo "MBLHAC048M9K06656" for VerifyRsa
    And the user sends a request with "POST" for VerifyRsa
    Then the response status for VerifyRsa should be 200 ,message "Rsa details fetched successfully. " ,isRsaMember "No" and rsaVendorName "@#$%^&*("
