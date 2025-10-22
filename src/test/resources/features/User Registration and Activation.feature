Feature: User Registration and Activation

  @TC-1 @TC-24 @TC-5
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

  @TC-1 @TC-5
  Scenario: User Registration - Valid Registration
    Given user is on the homepage or login page
    When user navigates to the registration page from the homepage
    Then registration page is displayed
    When user enters a valid email address "validuser@example.com"
    Then email address is accepted
    When user enters a valid password "ValidPass123!"
    Then password is accepted
    When user re-enters the same valid password "ValidPass123!" for confirmation
    Then password confirmation matches
    When user checks the 'I accept the Privacy Policy and Terms & Conditions' checkbox
    Then checkbox is checked
    When user submits the registration form
    Then form submits successfully
    When user checks the email inbox for a confirmation email
    Then confirmation email is received
    When user clicks the activation link in the email
    Then account is activated
    When user attempts to log in with the new credentials
    Then user logs in successfully

  @TC-5
  Scenario: User Registration - Mismatched Password Confirmation
    Given user is on the registration page
    When user enters a valid email address "newuser@example.com"
    Then email is accepted
    When user enters a valid password "ValidPass123!"
    Then password is entered
    When user enters a different password for confirmation "DifferentPass123!"
    Then password confirmation does not match
    When user checks the 'I accept the Privacy Policy and Terms & Conditions' checkbox
    Then checkbox is checked
    When user submits the registration form
    Then error message is displayed indicating password mismatch