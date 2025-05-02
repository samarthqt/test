Feature: Multiple Payment Methods
In order to provide user convenience
As a user of the retail platform
I want to be able to use multiple payment methods such as credit card, debit card, and PayPal
Scenario: User pays with a credit card
Given the user is on the checkout page
When the user selects credit card as the payment method
And enters valid credit card details
Then the payment should be processed successfully
And the user should receive a payment confirmation
Scenario: User pays with a debit card
Given the user is on the checkout page
When the user selects debit card as the payment method
And enters valid debit card details
Then the payment should be processed successfully
And the user should receive a payment confirmation
Scenario: User pays with PayPal
Given the user is on the checkout page
When the user selects PayPal as the payment method
And logs into their PayPal account
Then the payment should be processed successfully
And the user should receive a payment confirmation
Scenario: User enters invalid credit card details
Given the user is on the checkout page
When the user selects credit card as the payment method
And enters invalid credit card details
Then the payment should be declined
And the user should receive an error message
Scenario: User enters invalid debit card details
Given the user is on the checkout page
When the user selects debit card as the payment method
And enters invalid debit card details
Then the payment should be declined
And the user should receive an error message
Scenario: User fails to log into PayPal
Given the user is on the checkout page
When the user selects PayPal as the payment method
And fails to log into their PayPal account
Then the payment should not be processed
And the user should receive an error message