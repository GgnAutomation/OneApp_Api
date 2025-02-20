Feature: One APP Enterprise : API Login Testing

  @validDatas
  Scenario: Validate response with all valid datas in update customer details
    Given the login API is available and add headers and access token for update external customer detail
    When user add requestBody with customerIdentifier,birthDate "1987-01-03",firstName "Aatish",lastName "Jha",gender "male",email "aatish.m@gmail.com",bloodGroup "A+",addressLine1 "Althan",city "Surat",state "Gujarat",pincode "395007" and isExisting 1 for update external customer detail
    And the user sends a request with "POST" for update external customer detail
    Then the response status for update external customer detail should be 200 ,message "Profile Details Updated Successfully" ,birthDate "1987-01-03" ,firstName "Aatish" ,lastName "Jha" ,gender "male" ,email "aatish.m@gmail.com" ,bloodGroup "A+" ,addressLine1 "Althan" ,city "Surat" ,state "Gujarat" ,pincode "395007" and isExisting 1

  @InvalidDOB
  Scenario: Validate response with Invalid DOB format in update customer details
    Given the login API is available and add headers and access token for update external customer detail
    When user add requestBody with customerIdentifier,birthDate "19-01-1993",firstName "Aatish",lastName "Jha",gender "male",email "aatish.m@gmail.com",bloodGroup "A+",addressLine1 "Althan",city "Surat",state "Gujarat",pincode "395007" and isExisting 1 for update external customer detail
    And the user sends a request with "POST" for update external customer detail
    Then the response status for update external customer detail should be 200 ,message "Invalid Birth date." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @InvalidFisrtName
  Scenario: Validate response with Invalid FisrtName in update customer details
    Given the login API is available and add headers and access token for update external customer detail
    When user add requestBody with customerIdentifier,birthDate "1987-01-03",firstName "Aman kumar Aman kumar Aman kumar Aman kumar Aman kumar",lastName "Jha",gender "male",email "aatish.m@gmail.com",bloodGroup "A+",addressLine1 "Althan",city "Surat",state "Gujarat",pincode "395007" and isExisting 1 for update external customer detail
    And the user sends a request with "POST" for update external customer detail
    Then the response status for update external customer detail should be 200 ,message "Invalid FirstName." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @AlphanumericFisrtName
  Scenario: Validate response with alphanumeric characters in first name
    Given the login API is available and add headers and access token for update external customer detail
    When user add requestBody with customerIdentifier,birthDate "1987-01-03",firstName "Aman kumar465858",lastName "Jha",gender "male",email "aatish.m@gmail.com",bloodGroup "A+",addressLine1 "Althan",city "Surat",state "Gujarat",pincode "395007" and isExisting 1 for update external customer detail
    And the user sends a request with "POST" for update external customer detail
    Then the response status for update external customer detail should be 200 ,message "Profile Details Updated Successfully" ,birthDate "1987-01-03" ,firstName "Aman kumar465858" ,lastName "Jha" ,gender "male" ,email "aatish.m@gmail.com" ,bloodGroup "A+" ,addressLine1 "Althan" ,city "Surat" ,state "Gujarat" ,pincode "395007" and isExisting 1

  @BlankFisrtName
  Scenario: Validate response with Blank FisrtName in update customer details
    Given the login API is available and add headers and access token for update external customer detail
    When user add requestBody with customerIdentifier,birthDate "1987-01-03",firstName "  ",lastName "Jha",gender "male",email "aatish.m@gmail.com",bloodGroup "A+",addressLine1 "Althan",city "Surat",state "Gujarat",pincode "395007" and isExisting 1 for update external customer detail
    And the user sends a request with "POST" for update external customer detail
    Then the response status for update external customer detail should be 200 ,message "Invalid FirstName." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @SpecialCharFisrtName
  Scenario: Validate response with special character FisrtName in update customer details
    Given the login API is available and add headers and access token for update external customer detail
    When user add requestBody with customerIdentifier,birthDate "1987-01-03",firstName "@#$%",lastName "Jha",gender "male",email "aatish.m@gmail.com",bloodGroup "A+",addressLine1 "Althan",city "Surat",state "Gujarat",pincode "395007" and isExisting 1 for update external customer detail
    And the user sends a request with "POST" for update external customer detail
    Then the response status for update external customer detail should be 200 ,message "Invalid FirstName." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @InvalidGender
  Scenario: Validate response with Invalid gender in update customer details
    Given the login API is available and add headers and access token for update external customer detail
    When user add requestBody with customerIdentifier,birthDate "1987-01-03",firstName "Aatish",lastName "Jha",gender "trans",email "aatish.m@gmail.com",bloodGroup "A+",addressLine1 "Althan",city "Surat",state "Gujarat",pincode "395007" and isExisting 1 for update external customer detail
    And the user sends a request with "POST" for update external customer detail
    Then the response status for update external customer detail should be 200 ,message "Invalid Gender." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @InvalidEmail
  Scenario: Validate response with Invalid email in update customer details
    Given the login API is available and add headers and access token for update external customer detail
    When user add requestBody with customerIdentifier,birthDate "1987-01-03",firstName "Aatish",lastName "Jha",gender "male",email "aatish.m@@gmail.com",bloodGroup "A+",addressLine1 "Althan",city "Surat",state "Gujarat",pincode "395007" and isExisting 1 for update external customer detail 
    And the user sends a request with "POST" for update external customer detail
    Then the response status for update external customer detail should be 200 ,message "Invalid Email." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @BlankEmail
  Scenario: Validate response with blank email in update customer details
     Given the login API is available and add headers and access token for update external customer detail
    When user add requestBody with customerIdentifier,birthDate "1987-01-03",firstName "Aatish",lastName "Jha",gender "male",email "",bloodGroup "A+",addressLine1 "Althan",city "Surat",state "Gujarat",pincode "395007" and isExisting 1 for update external customer detail
    And the user sends a request with "POST" for update external customer detail
    Then the response status for update external customer detail should be 200 ,message "Profile Details Updated Successfully" ,birthDate "1987-01-03" ,firstName "Aatish" ,lastName "Jha" ,gender "male" ,email "" ,bloodGroup "A+" ,addressLine1 "Althan" ,city "Surat" ,state "Gujarat" ,pincode "395007" and isExisting 1

  @InvalidBloodGroup
  Scenario: Validate response with Invalid blood group format  in update customer details
    Given the login API is available and add headers and access token for update external customer detail
    When user add requestBody with customerIdentifier,birthDate "1987-01-03",firstName "Aatish",lastName "Jha",gender "male",email "aatish.m@gmail.com",bloodGroup "d+",addressLine1 "Althan",city "Surat",state "Gujarat",pincode "395007" and isExisting 1 for update external customer detail
    And the user sends a request with "POST" for update external customer detail
    Then the response status for update external customer detail should be 200 ,message "Invalid bloodGroup." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @SpecialCharBloodGroup
  Scenario: Validate response with special character blood group format in update customer details
    Given the login API is available and add headers and access token for update external customer detail
    When user add requestBody with customerIdentifier,birthDate "1987-01-03",firstName "Aatish",lastName "Jha",gender "male",email "aatish.m@gmail.com",bloodGroup "AB@",addressLine1 "Althan",city "Surat",state "Gujarat",pincode "395007" and isExisting 1 for update external customer detail
    And the user sends a request with "POST" for update external customer detail
    Then the response status for update external customer detail should be 200 ,message "bloodGroup contains special character(s)." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @BlankBloodGroup
  Scenario: Validate response with blank blood group format in update customer details
     Given the login API is available and add headers and access token for update external customer detail
    When user add requestBody with customerIdentifier,birthDate "1987-01-03",firstName "Aatish",lastName "Jha",gender "male",email "aatish.m@gmail.com",bloodGroup "",addressLine1 "Althan",city "Surat",state "Gujarat",pincode "395007" and isExisting 1 for update external customer detail
    And the user sends a request with "POST" for update external customer detail
    Then the response status for update external customer detail should be 200 ,message "Profile Details Updated Successfully" ,birthDate "1987-01-03" ,firstName "Aatish" ,lastName "Jha" ,gender "male" ,email "aatish.m@gmail.com" ,bloodGroup "A+" ,addressLine1 "Althan" ,city "Surat" ,state "Gujarat" ,pincode "395007" and isExisting 1

  @MaxAddress
  Scenario: Validate response with max characters in address line 1 in update customer details
     Given the login API is available and add headers and access token for update external customer detail
    When user add requestBody with customerIdentifier,birthDate "1987-01-03",firstName "Aatish",lastName "Jha",gender "male",email "aatish.m@gmail.com",bloodGroup "",addressLine1 "KAVI NATWARLAL SNEHI MARG,MAHIDPUR ARJANGARH HIMALAYA BADABAZAR KAVI NATWARLAL SNEHI MARG,MAHIDPUR ARJANGARH HIMALAYA BADABAZAR KAVI NATWARLAL SNEHI MARG,MAHIDPUR ARJANGARH HIMALAYA BADABAZAR KAVI NATWARLAL SNEHI MARG,MAHIDPUR ARJANGARH HIMALAYA BADABAZAR JH",city "Surat",state "Gujarat",pincode "395007" and isExisting 1 for update external customer detail 
    And the user sends a request with "POST" for update external customer detail
    Then the response status for update external customer detail should be 200 ,message "Invalid addressLine1." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @BlankAddress
  Scenario: Validate response with blank address line 1 in update customer details
      Given the login API is available and add headers and access token for update external customer detail
    When user add requestBody with customerIdentifier,birthDate "1987-01-03",firstName "Aatish",lastName "Jha",gender "male",email "aatish.m@gmail.com",bloodGroup "A+",addressLine1 "",city "Surat",state "Gujarat",pincode "395007" and isExisting 1 for update external customer detail
    And the user sends a request with "POST" for update external customer detail
    Then the response status for update external customer detail should be 200 ,message "Profile Details Updated Successfully" ,birthDate "1987-01-03" ,firstName "Aatish" ,lastName "Jha" ,gender "male" ,email "aatish.m@gmail.com" ,bloodGroup "A+" ,addressLine1 "" ,city "Surat" ,state "Gujarat" ,pincode "395007" and isExisting 1

  @BlankState
  Scenario: validate response with blank state field in update customer details
     Given the login API is available and add headers and access token for update external customer detail
    When user add requestBody with customerIdentifier,birthDate "1987-01-03",firstName "Aatish",lastName "Jha",gender "male",email "aatish.m@gmail.com",bloodGroup "A+",addressLine1 "Althan",city "Surat",state "",pincode "395007" and isExisting 1 for update external customer detail
    And the user sends a request with "POST" for update external customer detail
    Then the response status for update external customer detail should be 200 ,message "Profile Details Updated Successfully" ,birthDate "1987-01-03" ,firstName "Aatish" ,lastName "Jha" ,gender "male" ,email "aatish.m@gmail.com" ,bloodGroup "A+" ,addressLine1 "Althan" ,city "Surat" ,state "" ,pincode "395007" and isExisting 1

  @SpecialCharState
  Scenario: validate response with special character in state field for update customer details
    Given the login API is available and add headers and access token for update external customer detail
    When user add requestBody with customerIdentifier,birthDate "1987-01-03",firstName "Aatish",lastName "Jha",gender "male",email "aatish.m@gmail.com",bloodGroup "A+",addressLine1 "Althan",city "Surat",state "Punjab@#$%",pincode "395007" and isExisting 1 for update external customer detail
    And the user sends a request with "POST" for update external customer detail
    Then the response status for update external customer detail should be 200 ,message "Invalid State." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @SpecialCharCity
  Scenario: validate response with special character in city field for update customer details
   Given the login API is available and add headers and access token for update external customer detail
    When user add requestBody with customerIdentifier,birthDate "1987-01-03",firstName "Aatish",lastName "Jha",gender "male",email "aatish.m@gmail.com",bloodGroup "A+",addressLine1 "Althan",city "Surat@#$%",state "Gujarat",pincode "395007" and isExisting 1 for update external customer detail
    And the user sends a request with "POST" for update external customer detail
    Then the response status for update external customer detail should be 200 ,message "Invalid City." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @BlankCity
  Scenario: validate response with blank city field in update customer details
     Given the login API is available and add headers and access token for update external customer detail
    When user add requestBody with customerIdentifier,birthDate "1987-01-03",firstName "Aatish",lastName "Jha",gender "male",email "aatish.m@gmail.com",bloodGroup "A+",addressLine1 "Althan",city "",state "Gujarat",pincode "395007" and isExisting 1 for update external customer detail
    And the user sends a request with "POST" for update external customer detail
    Then the response status for update external customer detail should be 200 ,message "Profile Details Updated Successfully" ,birthDate "1987-01-03" ,firstName "Aatish" ,lastName "Jha" ,gender "male" ,email "aatish.m@gmail.com" ,bloodGroup "A+" ,addressLine1 "Althan" ,city "" ,state "Gujarat" ,pincode "395007" and isExisting 1

  @InvalidPincode
  Scenario: validate response with Invalid Pincode in update customer details
      Given the login API is available and add headers and access token for update external customer detail
    When user add requestBody with customerIdentifier,birthDate "1987-01-03",firstName "Aatish",lastName "Jha",gender "male",email "aatish.m@gmail.com",bloodGroup "A+",addressLine1 "Althan",city "Surat",state "Gujarat",pincode "3950@#$" and isExisting 1 for update external customer detail
    And the user sends a request with "POST" for update external customer detail
   Then the response status for update external customer detail should be 200 ,message "Invalid PinCode." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @BlankPincode
  Scenario: validate response with blank Pincode in update customer details
    Given the login API is available and add headers and access token for update external customer detail
    When user add requestBody with customerIdentifier,birthDate "1987-01-03",firstName "Aatish",lastName "Jha",gender "male",email "aatish.m@gmail.com",bloodGroup "A+",addressLine1 "Althan",city "Surat",state "Gujarat",pincode "" and isExisting 1 for update external customer detail
    And the user sends a request with "POST" for update external customer detail
    Then the response status for update external customer detail should be 200 ,message "Profile Details Updated Successfully" ,birthDate "1987-01-03" ,firstName "Aatish" ,lastName "Jha" ,gender "male" ,email "aatish.m@gmail.com" ,bloodGroup "A+" ,addressLine1 "Althan" ,city "Surat" ,state "Gujarat" ,pincode "" and isExisting 1

  @InvalidUrl
  Scenario: Validate response if user enters invalid Url in update customer details
    Given the login API is available and add headers and access token for update external customer detail
    When user add requestBody with customerIdentifier,birthDate "1987-01-03",firstName "Aatish",lastName "Jha",gender "male",email "aatish.m@gmail.com",bloodGroup "A+",addressLine1 "Althan",city "Surat",state "Gujarat",pincode "395007" and isExisting 1 for update external customer detail
    And the user sends request "POST" for update customer details with invalid url "https://dev-apim.heromotocorp.com/api/updateExternalCustomerProfile"
    Then the response status for update customer details should be 404 and message "Resource not found"

  @EmptyBody
  Scenario: Validate response if user enters blank request body in update customer details
    Given the login API is available and add headers and access token for update external customer detail
    And the user sends a request with "POST" for update external customer detail
    Then the response status in update external customer details for empty request body should be "500"
