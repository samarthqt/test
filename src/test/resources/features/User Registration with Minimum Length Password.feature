Feature: User Registration with Minimum Length Password

  @TC-31
  Scenario Outline: Successful registration with a minimum length password
    Given the user navigates to the registration page
    When the user enters a valid email "<email>"
    And the user enters a minimum length password "<password>"
    And the user completes the CAPTCHA verification
    Then the user is registered successfully and a confirmation email is sent

    Examples:
      | email                    | password |
      | minpassword@example.com  | A1b2c3   |