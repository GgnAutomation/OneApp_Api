Feature: OneApp Enterprise : API Login Testing

  @InvaildMobNo
  Scenario: Validate response with invaild mobileNo in getScratchCard Api
    Given the login API is available and add headers and access token for getScratchCard
    When user add requestBody with mobileNo "8218160023" ,vinId "MBLHA10EYA9G03076", and scratchCardType "SERVICE" for getScratchCard
    And the user sends getScratchCard request with "POST"
    Then the response status in getScratchCard should be 200 message "No Vehicle found for given data!" ,errorCode 1001 and errorDescription "Unable to process Your Request"

  @BlankMobNo
  Scenario: Validate response with Blank mobileNo in getScratchCard Api
    Given the login API is available and add headers and access token for getScratchCard
    When user add requestBody with mobileNo "" ,vinId "MBLHA10EYA9G03076", and scratchCardType "SERVICE" for getScratchCard
    And the user sends getScratchCard request with "POST"
    Then the response status in getScratchCard should be 200 message "Mobile Field Blank Or Not In Format." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @SpclCharMobNo
  Scenario: Validate response with SpclChar mobileNo in getScratchCard Api
    Given the login API is available and add headers and access token for getScratchCard
    When user add requestBody with mobileNo "@#$%^&*" ,vinId "MBLHA10EYA9G03076", and scratchCardType "SERVICE" for getScratchCard
    And the user sends getScratchCard request with "POST"
    Then the response status in getScratchCard should be 200 message "Mobile number is not numeric." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @InvaildVinId
  Scenario: Validate response with invaild VinId in getScratchCard Api
    Given the login API is available and add headers and access token for getScratchCard
    When user add requestBody with mobileNo "7004813003" ,vinId "MBLHA10EYA9G01234", and scratchCardType "SERVICE" for getScratchCard
    And the user sends getScratchCard request with "POST"
    Then the response status in getScratchCard should be 200 message "No Vehicle found for given data!" ,errorCode 1001 and errorDescription "Unable to process Your Request"

  @BlankVinId
  Scenario: Validate response with Blank VinId in getScratchCard Api
    Given the login API is available and add headers and access token for getScratchCard
    When user add requestBody with mobileNo "7004813003" ,vinId "", and scratchCardType "SERVICE" for getScratchCard
    And the user sends getScratchCard request with "POST"
    Then the response status in getScratchCard should be 200 message "Invalid VIN No." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @SpclCharVinId
  Scenario: Validate response with SpclChar VinId in getScratchCard Api
    Given the login API is available and add headers and access token for getScratchCard
    When user add requestBody with mobileNo "7004813003" ,vinId "@#$%^&", and scratchCardType "SERVICE" for getScratchCard
    And the user sends getScratchCard request with "POST"
    Then the response status in getScratchCard should be 200 message "vinId contains special character(s)." ,errorCode 1002 and errorDescription "Unable to process Your Request"

  @InvaildscratchCardType
  Scenario: Validate response with invaild scratchCardType in getScratchCard Api
    Given the login API is available and add headers and access token for getScratchCard
    When user add requestBody with mobileNo "8218160023" ,vinId "MBLHA10EYA9G03076", and scratchCardType "SERVICER" for getScratchCard
    And the user sends getScratchCard request with "POST"
    Then the response status in getScratchCard should be 200 message "No Vehicle found for given data!" ,errorCode 1001 and errorDescription "Unable to process Your Request"

  @BlankScratchCardType
  Scenario: Validate response with Blank scratchCardType in getScratchCard Api
    Given the login API is available and add headers and access token for getScratchCard
    When user add requestBody with mobileNo "8218160023" ,vinId "MBLHA10EYA9G03076", and scratchCardType "" for getScratchCard
    And the user sends getScratchCard request with "POST"
    Then the response status in getScratchCard should be 200 message "No Vehicle found for given data!" ,errorCode 1001 and errorDescription "Unable to process Your Request"

  @SpclCharScratchCardType
  Scenario: Validate response with  SpclChar scratchCardType in getScratchCard Api
    Given the login API is available and add headers and access token for getScratchCard
    When user add requestBody with mobileNo "8218160023" ,vinId "MBLHA10EYA9G03076", and scratchCardType "@#$%^" for getScratchCard
    And the user sends getScratchCard request with "POST"
    Then the response status in getScratchCard should be 200 message "No Vehicle found for given data!" ,errorCode 1001 and errorDescription "Unable to process Your Request"

  @LessThanOneYear
  Scenario: Validate scratch card for user having first sale date Date of Sale > Today - 490  (less than 1 Yr Old Vehicle)
    Given the login API is available and add headers and access token for getScratchCard
    When user add requestBody with mobileNo "8409520578" ,vinId "MBLYGL006P4H00014", and scratchCardType "SERVICE" for getScratchCard
    And the user sends getScratchCard request with "POST"
    Then the response status in getScratchCard should be 200 message "Scratch Card is invalid or expired!" ,errorCode 1001 and errorDescription "Unable to process Your Request"

    @ScratchedCard
  Scenario: Validate the response with You have already scratched the card.message
   Given the login API is available and add headers and access token for getScratchCard
    When user add requestBody with mobileNo "7004813003" ,vinId "MBLJAU026RGB00959", and scratchCardType "SERVICE" for getScratchCard
    And the user sends getScratchCard request with "POST"
    Then the response status in getScratchCard should be 200 message "You have already scratched the card. Please check reward details in Reward section" ,errorCode 1001 and errorDescription "Unable to process Your Request"
    
    
    
    