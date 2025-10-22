Feature: User Registration with Email Validation

  @TC-26
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