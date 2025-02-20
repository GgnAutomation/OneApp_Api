Feature: One APP Enterprise : API Login Testing

  @ValidData
  Scenario: Verify response with valid request body
    Given the login API is available and add headers for GetHsrpStatus
    When user add requestBody with mobileNo "8278650631" ,vinNo "MBLHAW145N4L02582" for GetHsrpStatus
    And the user sends a request with "POST" for GetHsrpStatus
    Then the response status for GetHsrpStatus should be 200 ,message "HSRP fitment status fetched successfully." ,licenceNumber "RJ07NS7919" and fitmentStatus "Already_Fitted"

  @InvalidUrl
  Scenario: Verify the response if Url is wrong for GetHsrpStatus
    Given the login API is available and add headers for GetHsrpStatus
    When user add requestBody with mobileNo "8278650631" ,vinNo "MBLHAW145N4L02582" for GetHsrpStatus
    And the user sends a request with "POST" and invalid url "https://dev-apim.heromotocorp.com/api/GetHsrpStatus" for GetHsrpStatus
    Then the response status for GetHsrpStatus should be 404 ,message "Resource not found" and errorCode "404"

  @EmptyBody
  Scenario: Verify the response if Request body is blank
    Given the login API is available and add headers for GetHsrpStatus
    And the user sends a request with "POST" for GetHsrpStatus
    Then the response status in GetHsrpStatus should be 200 ,message "JSONObject[\"data\"] not found." ,errorCode 1001 and errorDescription "Unable to process Your Request"

  @SpclCharMobNo
  Scenario: Verify the response if mobileNo is contains spcl char for GetHsrpStatus
    Given the login API is available and add headers for GetHsrpStatus
    When user add requestBody with mobileNo "@#$%^" ,vinNo "MBLHAW145N4L02582" for GetHsrpStatus
    And the user sends a request with "POST" for GetHsrpStatus
    Then the response status in GetHsrpStatus should be 200 ,message "Mobile number is not numeric." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @BlankMobNo
  Scenario: Verify the response if mobileNo field is Blank/null for GetHsrpStatus
    Given the login API is available and add headers for GetHsrpStatus
    When user add requestBody with mobileNo "" ,vinNo "MBLHAW145N4L02582" for GetHsrpStatus
    And the user sends a request with "POST" for GetHsrpStatus
    Then the response status in GetHsrpStatus should be 200 ,message "Mobile Field Blank Or Not In Format." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @InvalidMobNo
  Scenario: Verify the response if mobileNo field is Invalid for GetHsrpStatus
    Given the login API is available and add headers for GetHsrpStatus
    When user add requestBody with mobileNo "8218160023" ,vinNo "MBLHAW145N4L02582" for GetHsrpStatus
    And the user sends a request with "POST" for GetHsrpStatus
    Then the response status in GetHsrpStatus should be 200 ,message "No Vehicle found for given data!" ,errorCode 1001 and errorDescription "Unable to process Your Request"

  @SpclCharVinNo
  Scenario: Verify the response if vinNo is contains spcl char for GetHsrpStatus
    Given the login API is available and add headers for GetHsrpStatus
    When user add requestBody with mobileNo "8278650631" ,vinNo "@#$%^&" for GetHsrpStatus
    And the user sends a request with "POST" for GetHsrpStatus
    Then the response status in GetHsrpStatus should be 200 ,message "VIN No contains special character(s)." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @BlankVinNo
  Scenario: Verify the response if vinNo field is Blank/null for GetHsrpStatus
    Given the login API is available and add headers for GetHsrpStatus
    When user add requestBody with mobileNo "8278650631" ,vinNo "" for GetHsrpStatus
    And the user sends a request with "POST" for GetHsrpStatus
    Then the response status in GetHsrpStatus should be 200 ,message "VIN No Field Blank Or Not In Format." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @InvalidVinNo
  Scenario: Verify the response if VinNo field is Invalid for GetHsrpStatus
    Given the login API is available and add headers for GetHsrpStatus
    When user add requestBody with mobileNo "8218160023" ,vinNo "MBLHAW108N9H00291" for GetHsrpStatus
    And the user sends a request with "POST" for GetHsrpStatus
    Then the response status in GetHsrpStatus should be 200 ,message "No Vehicle found for given data!" ,errorCode 1001 and errorDescription "Unable to process Your Request"

  @Already_Fitted
  Scenario: Validate response for Already_Fitted Status for GetHsrpStatus
    Given the login API is available and add headers for GetHsrpStatus
    When user add requestBody with mobileNo "8278650631" ,vinNo "MBLHAW145N4L02582" for GetHsrpStatus
    And the user sends a request with "POST" for GetHsrpStatus
    Then the response status for GetHsrpStatus should be 200 ,message "HSRP fitment status fetched successfully." ,licenceNumber "RJ07NS7919" and fitmentStatus "Already_Fitted"

  @RC_Number_Allocated
  Scenario: Validate response for RC_Number_Allocated for GetHsrpStatus
    Given the login API is available and add headers for GetHsrpStatus
    When user add requestBody with mobileNo "8658524515" ,vinNo "MBLHA10A3D9M02286" for GetHsrpStatus
    And the user sends a request with "POST" for GetHsrpStatus
    Then the response status for GetHsrpStatus should be 200 ,message "HSRP fitment status fetched successfully." ,licenceNumber "DL5SBU4051" and fitmentStatus "RC_Number_Allocated"

  @Order_Generated
  Scenario: Validate response for Order_Generated for GetHsrpStatus
    Given the login API is available and add headers for GetHsrpStatus
    When user add requestBody with mobileNo "8282828282" ,vinNo "MBLHAC027KHH05002" for GetHsrpStatus
    And the user sends a request with "POST" for GetHsrpStatus
    Then the response status for GetHsrpStatus should be 200 ,message "HSRP fitment status fetched successfully." ,licenceNumber "PB38D6354" and fitmentStatus "Order_Generated"

  @Ready_For_Fitment
  Scenario: Validate response for Ready_For_Fitment for GetHsrpStatus
    Given the login API is available and add headers for GetHsrpStatus
    When user add requestBody with mobileNo "8282828282" ,vinNo "MBLJFW05XKGD04161" for GetHsrpStatus
    And the user sends a request with "POST" for GetHsrpStatus
    Then the response status for GetHsrpStatus should be 200 ,message "HSRP fitment status fetched successfully." ,licenceNumber "PB07BT6147" and fitmentStatus "Ready_For_Fitment"

  @Fitment_Status_Already_Fitted
  Scenario: Validate response for Already_Fitted Status in updateVehicleDetails API
    Given the login API is available and add headers for updateVehicleDetails
    When user add requestBody with vinId "MBLHAW145N4L02582" ,customerIdentifier "bf9a33a0-588d-49ff-9c41-e63dc8419ce0" and fitmentStatus "Already_Fitted" for updateVehicleDetails
    And the user sends a request with "POST" for updateVehicleDetails
    Then the response status for updateVehicleDetails should be 200 ,message "Vehicle Details Updated Successfully" ,vinId "MBLHAW145N4L02582" ,customerIdentifier "bf9a33a0-588d-49ff-9c41-e63dc8419ce0" ,Fitmentmessage "HSRP Fitment Status Updated Successfully", and fitmentStatus "Already_Fitted"

  @Fitment_Status_RC_Number_Allocated
  Scenario: Validate response for RC_Number_Allocated in updateVehicleDetails API
    Given the login API is available and add headers for updateVehicleDetails
    When user add requestBody with vinId "MBLHAW145N4L02582" ,customerIdentifier "bf9a33a0-588d-49ff-9c41-e63dc8419ce0" and fitmentStatus "RC_Number_Allocated" for updateVehicleDetails
    And the user sends a request with "POST" for updateVehicleDetails
    Then the response status in GetHsrpStatus should be 200 ,message "Invalid HSRP fitment status." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @Fitment_Status_Order_Generated
  Scenario: Validate response for Order_Generated in updateVehicleDetails API
    Given the login API is available and add headers for updateVehicleDetails
    When user add requestBody with vinId "MBLHAW145N4L02582" ,customerIdentifier "bf9a33a0-588d-49ff-9c41-e63dc8419ce0" and fitmentStatus "Order_Generated" for updateVehicleDetails
    And the user sends a request with "POST" for updateVehicleDetails
    Then the response status in GetHsrpStatus should be 200 ,message "Invalid HSRP fitment status." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @Fitment_Status_Ready_For_Fitment
  Scenario: Validate response for Ready_For_Fitment in updateVehicleDetails API
    Given the login API is available and add headers for updateVehicleDetails
    When user add requestBody with vinId "MBLHAW145N4L02582" ,customerIdentifier "bf9a33a0-588d-49ff-9c41-e63dc8419ce0" and fitmentStatus "Ready_For_Fitment" for updateVehicleDetails
    And the user sends a request with "POST" for updateVehicleDetails
    Then the response status in GetHsrpStatus should be 200 ,message "Invalid HSRP fitment status." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @SpclChar_Fitment_Status
  Scenario: Verify the response if fitmentStatus field is contains spcl char
    Given the login API is available and add headers for updateVehicleDetails
    When user add requestBody with vinId "MBLHAW145N4L02582" ,customerIdentifier "bf9a33a0-588d-49ff-9c41-e63dc8419ce0" and fitmentStatus "@#$%^&*" for updateVehicleDetails
    And the user sends a request with "POST" for updateVehicleDetails
    Then the response status in GetHsrpStatus should be 200 ,message "Invalid HSRP fitment status." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @Blank_Fitment_Status
  Scenario: Validate response for Already_Fitted Status in updateVehicleDetails API
    Given the login API is available and add headers for updateVehicleDetails
    When user add requestBody with vinId "MBLHAW145N4L02582" ,customerIdentifier "bf9a33a0-588d-49ff-9c41-e63dc8419ce0" and fitmentStatus "Already_Fitted" for updateVehicleDetails
    And the user sends a request with "POST" for updateVehicleDetails
    Then the response status for updateVehicleDetails should be 200 ,message "Vehicle Details Updated Successfully" ,vinId "MBLHAW145N4L02582" ,customerIdentifier "bf9a33a0-588d-49ff-9c41-e63dc8419ce0" ,Fitmentmessage "HSRP Fitment Status Updated Successfully", and fitmentStatus "Already_Fitted"

  @DLR_FDATE
  Scenario: Verify the response with the below condition Already_Fitted: If DLR_FDATE is present.
    Given the login API is available and add headers for GetHsrpStatus
    When user add requestBody with mobileNo "9162597322" ,vinNo "MBLHAW020K9E02414" for GetHsrpStatus
    And the user sends a request with "POST" for GetHsrpStatus
    Then the response status for GetHsrpStatus should be 200 ,message "HSRP fitment status fetched successfully." ,licenceNumber "JH21J4152" and fitmentStatus "Already_Fitted"

  @D_STS_DATE
  Scenario: Verify the response with the below condition Ready_For_Fitment: If D_STS_DATE is present and D_STS equals to “R”
    Given the login API is available and add headers for GetHsrpStatus
    When user add requestBody with mobileNo "9815666565" ,vinNo "MBLHAC020KHD16153" for GetHsrpStatus
    And the user sends a request with "POST" for GetHsrpStatus
    Then the response status for GetHsrpStatus should be 200 ,message "HSRP fitment status fetched successfully." ,licenceNumber "PB08EJ2942" and fitmentStatus "Already_Fitted"

  @RC_Num_Allocated
  Scenario: Verify the response with the below condition RC_Number_Allocated: If the license number is present in the cosmos database.
    Given the login API is available and add headers for GetHsrpStatus
    When user add requestBody with mobileNo "9815666565" ,vinNo "MBLHAC020KHD16153" for GetHsrpStatus
    And the user sends a request with "POST" for GetHsrpStatus
    Then the response status for GetHsrpStatus should be 200 ,message "HSRP fitment status fetched successfully." ,licenceNumber "PB08EJ2942" and fitmentStatus "Already_Fitted"
