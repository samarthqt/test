Feature: Multiple Payment Methods - PayPal Payment

  @TC-41
  Scenario: User completes an order using PayPal
    Given a product is available in the shopping cart
    When the user navigates to the shopping cart page
    Then the shopping cart page is displayed with the selected product
    When the user selects 'Proceed to Checkout'
    Then the checkout page is displayed
    When the user selects 'PayPal' as the payment method
    Then the user is redirected to the PayPal login page
    When the user logs into PayPal with valid credentials
    Then the PayPal login is successful
    When the user authorizes the payment
    Then the payment is authorized and processed
    When the user verifies the order confirmation page is displayed
    Then the order confirmation page is displayed with order details
    When the user checks the email inbox for a confirmation email
    Then the order confirmation email is received in the inbox