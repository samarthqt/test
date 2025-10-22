Feature: User Registration with Email Validation

  @TC-26 @TC-3
  Scenario Outline: Registration with various email formats
    Given the user navigates to the registration page
    When the user enters an email "<email>"
    And the user enters a valid password "ValidPassword123"
    And the user completes the CAPTCHA verification
    And the user attempts to register
    Then the system should "<result>"

    Examples:
      | email                  | result                                       |
      | invalid-email-format   | show an error message for invalid email format and prevent registration |
      | valid@example.com      | allow registration                           |

  @TC-3
  Scenario: User Registration - Invalid Email Format
    Given the user navigates to the registration page
    When the user enters an invalid email address format "invalidemail@"
    And the user enters a valid password "ValidPass123!"
    And the user re-enters the same valid password for confirmation "ValidPass123!"
    And the user checks the 'I accept the Privacy Policy and Terms & Conditions' checkbox
    And the user submits the registration form
    Then an error message is displayed indicating invalid email format