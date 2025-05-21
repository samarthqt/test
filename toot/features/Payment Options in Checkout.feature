Feature: Payment Options in Checkout
""
As a user,
I want to be able to pay for my purchases using either a credit card or PayPal
So that I have flexible payment options during the checkout process.
""
Background:
Given the user is on the checkout page
""
Scenario: Successful payment using a credit card
"    When the user selects ""Credit Card"" as the payment method"
And the user enters valid credit card details
And the user submits the payment
Then the payment should be processed successfully
And the user should see a confirmation message for the successful payment
""
Scenario: Successful payment using PayPal
"    When the user selects ""PayPal"" as the payment method"
And the user is redirected to the PayPal login page
And the user logs in with valid PayPal credentials
And the user confirms the payment on the PayPal platform
Then the payment should be processed successfully
And the user should be redirected back to the checkout page
And the user should see a confirmation message for the successful payment
""
Scenario: Declined payment due to invalid credit card details
"    When the user selects ""Credit Card"" as the payment method"
And the user enters invalid credit card details
And the user submits the payment
Then the payment should be declined
And the user should see an error message indicating the payment was not successful
""
Scenario: Canceled payment on PayPal
"    When the user selects ""PayPal"" as the payment method"
And the user is redirected to the PayPal login page
And the user cancels the payment on the PayPal platform
Then the payment should not be processed
And the user should be redirected back to the checkout page
And the user should see a message indicating the payment was canceled
""
Scenario: Payment option selection is mandatory
When the user tries to proceed without selecting a payment method
Then the user should see an error message indicating that a payment method must be selected
```
```gherkin
TCID:11