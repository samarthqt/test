Feature: Registration with Password Strength Validation

  @TC-27
  Scenario Outline: User attempts registration with various password strengths
    Given the user navigates to the registration page
    When the user enters a valid email "<email>"
    And the user enters a password "<password>"
    And the user completes the CAPTCHA verification
    Then the system should show "<message>"

    Examples:
      | email                      | password | message                                              |
      | stronguser@example.com     | weak     | System shows an error message indicating the password is too weak. |

  @TC-27
  Scenario: User completes CAPTCHA successfully
    Given the user navigates to the registration page
    When the user enters a valid email "stronguser@example.com"
    And the user enters a password "weak"
    And the user completes the CAPTCHA verification
    Then CAPTCHA is verified successfully

  @TC-27
  Scenario: System prevents registration due to weak password
    Given the user navigates to the registration page
    When the user enters a valid email "stronguser@example.com"
    And the user enters a password "weak"
    And the user completes the CAPTCHA verification
    And the user attempts to register
    Then the system prevents registration and highlights the weak password field