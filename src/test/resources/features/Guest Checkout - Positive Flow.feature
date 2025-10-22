Feature: Guest Checkout - Positive Flow

  @TC-32
  Scenario: Non-logged-in users can complete the checkout process using valid details
    Given the user navigates to the shopping cart page
    And the shopping cart page is displayed with the selected product
    When the user chooses to proceed to checkout as a guest user
    Then the guest checkout page is displayed
    When the user enters "John Doe" in the name field
    Then the name is accepted
    When the user enters "johndoe@example.com" in the email field
    Then the email is accepted
    When the user enters "1234567890" in the phone field
    Then the phone number is accepted
    When the user enters "123 Main Street, Anytown, USA" in the shipping address field
    Then the shipping address is accepted
    When the user selects a payment method from the available options
    Then the payment method is selected
    When the user completes the payment process
    Then the payment is processed successfully
    And the order confirmation page is displayed with order details
    And the user checks the email inbox for a confirmation email
    Then the order confirmation email is received in the inbox
    When the user attempts to access account-only features
    Then access is denied with a prompt to register or log in
    And the guest information is stored securely for order processing only
    And guest information is not accessible beyond order processing