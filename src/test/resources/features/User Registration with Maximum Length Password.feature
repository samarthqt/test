Feature: User Registration with Maximum Length Password

  @TC-30
  Scenario Outline: User registers with a password at the maximum allowed length
    Given the user navigates to the registration page
    When the user enters a valid email "<email>"
    And the user enters a maximum length password "<password>"
    And the user completes the CAPTCHA verification
    Then the user is registered successfully and a confirmation email is sent

    Examples:
      | email                     | password                                                          |
      | maxpassword@example.com   | A123456789012345678901234567890123456789012345678901234567890123  |