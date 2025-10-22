Feature: Credit Card Payment Process

  @TC-40
  Scenario: User completes an order using a credit card
    Given a product is available in the shopping cart
    When the user navigates to the shopping cart page
    Then the shopping cart page is displayed with the selected product
    When the user selects 'Proceed to Checkout'
    Then the checkout page is displayed
    When the user selects 'Credit Card' as the payment method
    Then the credit card payment form is displayed
    When the user enters credit card details with number "4111111111111111", expiration date "12/25", and CVV "123"
    Then the credit card details are accepted
    When the user completes the payment process
    Then the payment is processed successfully
    When the user verifies the order confirmation page is displayed
    Then the order confirmation page is displayed with order details
    When the user checks the email inbox for a confirmation email
    Then the order confirmation email is received in the inbox