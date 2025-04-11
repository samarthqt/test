Feature: Payment Options in Checkout
""
Scenario Outline: User selects a payment method during checkout
Given the user is on the checkout page
"    When the user selects ""<PaymentMethod>"" as the payment method"
And the user enters valid payment details
Then the payment should be processed successfully
And the user should see a confirmation message
""
Examples:
| PaymentMethod |
| Credit Card   |
| PayPal        |
""
Scenario: User attempts to pay with an invalid credit card
Given the user is on the checkout page
"    When the user selects ""Credit Card"" as the payment method"
And the user enters invalid credit card details
Then the payment should not be processed
And the user should see an error message indicating invalid payment details
""
Scenario: User attempts to pay with an invalid PayPal account
Given the user is on the checkout page
"    When the user selects ""PayPal"" as the payment method"
And the user enters invalid PayPal account details
Then the payment should not be processed
And the user should see an error message indicating invalid payment details
""
Scenario: User cancels the payment process
Given the user is on the checkout page
When the user selects a payment method
And the user decides to cancel the payment
Then the payment should not be processed
And the user should be redirected back to the checkout page
""
Scenario: User successfully completes a transaction with a credit card
Given the user is on the checkout page
"    When the user selects ""Credit Card"" as the payment method"
And the user enters valid credit card details
And the user confirms the payment
Then the payment should be processed successfully
And the user should receive a confirmation email
""
Scenario: User successfully completes a transaction with PayPal
Given the user is on the checkout page
"    When the user selects ""PayPal"" as the payment method"
And the user logs into their PayPal account
And the user confirms the payment
Then the payment should be processed successfully
And the user should receive a confirmation email
```