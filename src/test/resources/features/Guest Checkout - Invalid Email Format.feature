Feature: Guest Checkout - Invalid Email Format

  @TC-34
  Scenario Outline: Validate error message for invalid email formats during guest checkout
    Given the user navigates to the shopping cart page
    And the shopping cart page is displayed with the selected product
    When the user selects 'Proceed to Checkout' as a guest user
    And the guest checkout page is displayed
    And the user enters "<email>" in the email field
    Then the email is not accepted due to invalid format
    And an error message is displayed indicating invalid email format

    Examples:
      | email         |
      | johndoe@com   |
      | johndoe@.com  |
      | @example.com  |
      | johndoe@com.  |
      | johndoe@.com. |