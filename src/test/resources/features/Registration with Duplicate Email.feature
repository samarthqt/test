Feature: Registration with Duplicate Email

  @TC-2 @TC-25
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

  @TC-2
  Scenario: User Registration - Duplicate Email
    Given the user navigates to the registration page
    When the user enters the existing email "existinguser@example.com"
    And the user enters a valid password "ValidPass123!"
    And the user re-enters the same valid password "ValidPass123!" for confirmation
    And the user checks the 'I accept the Privacy Policy and Terms & Conditions' checkbox
    Then the user submits the registration form
    And an error message is displayed indicating the email is already registered