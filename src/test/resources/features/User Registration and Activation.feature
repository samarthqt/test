Feature: User Registration and Activation

  @TC-24
  Scenario: User registration with valid data
    Given user navigates to the registration page
    When user enters a valid email "validuser@example.com"
    And user enters a valid password "ValidPassword123"
    And user completes the CAPTCHA verification
    And user selects the 'Register' button
    Then user is registered successfully and a confirmation email is sent
    When user checks the email inbox for the confirmation email
    Then confirmation email is received
    When user selects the activation link in the confirmation email
    Then user account is activated
    When user attempts to log in with the registered email and password
    Then user is able to log in successfully