Feature: Payment Options
Scenario: User pays via credit card
Given the user is on the payment page
When the user selects credit card as the payment method
And enters valid credit card details
Then the payment should be processed successfully
And the user should receive a confirmation message
Scenario: User pays via PayPal
Given the user is on the payment page
When the user selects PayPal as the payment method
And logs into their PayPal account
Then the payment should be processed successfully
And the user should receive a confirmation message
Scenario: User enters invalid credit card details
Given the user is on the payment page
When the user selects credit card as the payment method
And enters invalid credit card details
Then the payment should not be processed
And the user should receive an error message indicating invalid payment details
Scenario: User fails to log into PayPal
Given the user is on the payment page
When the user selects PayPal as the payment method
And fails to log into their PayPal account
Then the payment should not be processed
And the user should receive an error message indicating login failure