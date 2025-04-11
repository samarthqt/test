Feature: Payment Gateway Integration
""
As a user, I want to integrate with popular payment gateways such as Stripe and PayPal
so that I can securely process payments during the checkout process.
""
Background:
Given the e-commerce platform is set up
And the user is on the checkout page
""
Scenario: Successful payment using Stripe
Given the user selects Stripe as the payment method
When the user enters valid payment details
And the user confirms the payment
Then the payment should be processed successfully
And the user should receive a payment confirmation
"    And the order status should be updated to ""Paid"""
""
Scenario: Successful payment using PayPal
Given the user selects PayPal as the payment method
When the user is redirected to the PayPal login page
And the user logs in with valid PayPal credentials
And the user confirms the payment
Then the payment should be processed successfully
And the user should receive a payment confirmation
"    And the order status should be updated to ""Paid"""
""
Scenario: Payment failure due to invalid card details on Stripe
Given the user selects Stripe as the payment method
When the user enters invalid payment details
And the user attempts to confirm the payment
Then the payment should not be processed
And the user should receive an error message indicating invalid card details
""
Scenario: Payment failure due to insufficient balance on PayPal
Given the user selects PayPal as the payment method
When the user is redirected to the PayPal login page
And the user logs in with valid PayPal credentials
And the user attempts to confirm the payment
And the user's PayPal account has insufficient balance
Then the payment should not be processed
And the user should receive an error message indicating insufficient balance
""
Scenario: Canceling a payment on PayPal
Given the user selects PayPal as the payment method
When the user is redirected to the PayPal login page
And the user decides to cancel the payment
Then the user should be redirected back to the checkout page
"    And the order status should remain ""Pending"""
""
Scenario: Payment session timeout
Given the user selects a payment method
When the user takes too long to confirm the payment
Then the payment session should timeout
And the user should be prompted to restart the payment process
```
```gherkin
TCID:47