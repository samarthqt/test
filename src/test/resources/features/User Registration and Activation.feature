Feature: User Registration and Activation

  @TC-24 @11
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

  @11
  Scenario: Registration page accessibility
    Given user is on the homepage
    When user navigates to the registration page
    Then the registration page is displayed prominently

  @11
  Scenario: Registration with existing email
    Given user navigates to the registration page
    When user enters an existing email "existinguser@example.com"
    And user enters a valid password "ValidPassword123"
    And user completes the CAPTCHA verification
    And user selects the 'Register' button
    Then an error message is displayed indicating duplicate registration is not allowed

  @11
  Scenario: Registration with weak password
    Given user navigates to the registration page
    When user enters a valid email "newuser@example.com"
    And user enters a weak password "123"
    And user completes the CAPTCHA verification
    And user selects the 'Register' button
    Then an error message is displayed indicating the password is too weak

  @11
  Scenario: Registration without accepting terms and conditions
    Given user navigates to the registration page
    When user enters a valid email "newuser@example.com"
    And user enters a valid password "ValidPassword123"
    And user does not accept the terms and conditions
    And user completes the CAPTCHA verification
    And user selects the 'Register' button
    Then an error message is displayed indicating terms and conditions must be accepted

  @11
  Scenario: Attempt to log in without activation
    Given user navigates to the login page
    When user enters a registered email "newuser@example.com"
    And user enters the correct password "ValidPassword123"
    And user selects the 'Login' button
    Then a prompt is displayed to complete account activation via the confirmation link

  @11
  Scenario: Registration form validation
    Given user navigates to the registration page
    When user enters an invalid email "invalid-email"
    And user enters a valid password "ValidPassword123"
    And user completes the CAPTCHA verification
    And user selects the 'Register' button
    Then an error message is displayed indicating the email format is invalid