Feature: Guest Checkout - Duplicate Order Prevention

  @TC-33
  Scenario: Prevent duplicate orders using the same guest email
    Given the user navigates to the shopping cart page
    And the shopping cart page is displayed with the selected product
    When the user chooses to proceed to checkout as a guest user
    Then the guest checkout page is displayed
    When the user enters "johndoe@example.com" in the email field
    Then the email is accepted
    When the user completes the checkout process with the same email
    Then the system checks for duplicate orders
    And the system prevents the duplicate order and displays a relevant message