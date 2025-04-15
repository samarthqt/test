Feature: Multiple Payment Methods
""
As a user, I want to be able to use multiple payment methods during checkout, so that I can choose my preferred method of payment.
""
Background:
Given the user is on the checkout page
""
Scenario: Pay with a credit card
"    When the user selects ""Credit Card"" as the payment method"
And the user enters valid credit card details
And the user submits the payment
Then the payment should be processed successfully
And the user should see a confirmation message
""
Scenario: Pay with a debit card
"    When the user selects ""Debit Card"" as the payment method"
And the user enters valid debit card details
And the user submits the payment
Then the payment should be processed successfully
And the user should see a confirmation message
""
Scenario: Pay with PayPal
"    When the user selects ""PayPal"" as the payment method"
And the user is redirected to the PayPal login page
And the user logs in with valid PayPal credentials
And the user confirms the payment
Then the payment should be processed successfully
And the user should be redirected back to the confirmation page
""
Scenario: Invalid credit card details
"    When the user selects ""Credit Card"" as the payment method"
And the user enters invalid credit card details
And the user submits the payment
Then the payment should be declined
And the user should see an error message indicating invalid card details
""
Scenario: Invalid debit card details
"    When the user selects ""Debit Card"" as the payment method"
And the user enters invalid debit card details
And the user submits the payment
Then the payment should be declined
And the user should see an error message indicating invalid card details
""
Scenario: Cancel PayPal payment
"    When the user selects ""PayPal"" as the payment method"
And the user is redirected to the PayPal login page
And the user cancels the payment
Then the user should be redirected back to the checkout page
And the payment should not be processed
```
```gherkin
TCID:21