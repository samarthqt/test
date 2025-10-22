Feature: User Registration with CAPTCHA Verification

  @TC-28
  Scenario Outline: Registration attempt with missing CAPTCHA
    Given the user navigates to the registration page
    When the user enters a valid email "<email>"
    And the user enters a valid password "<password>"
    And the user leaves the CAPTCHA field incomplete
    And the user attempts to register
    Then the system should prevent registration and prompt to complete CAPTCHA

    Examples:
      | email                  | password          |
      | testuser@example.com   | ValidPassword123  |