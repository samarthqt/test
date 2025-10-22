Feature: Registration with Duplicate Email

  @TC-25
  Scenario Outline: User attempts to register with an email that is already registered
    Given the user navigates to the registration page
    When the user enters the email "<email>"
    And the user enters a valid password "<password>"
    And the user completes the CAPTCHA verification
    Then the user attempts to register
    And an error message is displayed indicating the email is already registered

    Examples:
      | email                   | password         |
      | duplicate@example.com   | NewPassword123   |