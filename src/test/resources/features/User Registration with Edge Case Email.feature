Feature: User Registration with Edge Case Email

  @TC-29
  Scenario Outline: User registers with an edge case email format
    Given the user navigates to the registration page
    When the user enters the email "<email>"
    And the user enters a valid password "<password>"
    And the user completes the CAPTCHA verification
    Then the user is registered successfully and a confirmation email is sent

    Examples:
      | email                          | password         |
      | edge.case+test@example.com     | ValidPassword123 |