Feature: Verify Error Handling for Invalid Payment Details
As a user
I want to ensure the system handles errors gracefully
So that invalid payment details are managed effectively
@TC-15
Scenario: Verify error handling for expired Credit Card details
Given I am logged into my user account
And I navigate to the checkout page
When I select Credit Card as the payment method
And I enter expired Credit Card details
Then the system displays an error message for expired Credit Card
@TC-15
Scenario: Verify error handling for incorrect CVV number
Given I am logged into my user account
And I navigate to the checkout page
When I select Credit Card as the payment method
And I enter an incorrect CVV number
Then the system displays an error message for incorrect CVV
@TC-15
Scenario: Verify error handling for invalid PayPal account details
Given I am logged into my user account
And I navigate to the checkout page
When I attempt a transaction with invalid PayPal account details
Then the system displays an error message for invalid PayPal account
@TC-15
Scenario: Verify error handling for empty payment details
Given I am logged into my user account
And I navigate to the checkout page
When I proceed with empty payment details
Then the system prompts me to enter payment details
@TC-15
Scenario: Verify error handling for unsupported payment method
Given I am logged into my user account
And I navigate to the checkout page
When I select an unsupported payment method
Then the system displays an error message for unsupported payment method
@TC-15
Scenario: Verify error handling for network interruption during payment processing
Given I am logged into my user account
And I navigate to the checkout page
When there is a network interruption during payment processing
Then the system handles the interruption gracefully with an error message
@TC-15
Scenario: Verify error handling for incorrect currency selection
Given I am logged into my user account
And I navigate to the checkout page
When I select an incorrect currency for the transaction
Then the system displays an error message for incorrect currency
@TC-15
Scenario: Verify error handling for exceeding transaction limit
Given I am logged into my user account
And I navigate to the checkout page
When I attempt a transaction with an amount exceeding the limit
Then the system displays an error message for exceeding transaction limit
@TC-15
Scenario: Verify error handling for invalid billing address
Given I am logged into my user account
And I navigate to the checkout page
When I enter an invalid billing address
Then the system displays an error message for invalid billing address
@TC-15
Scenario: Verify error handling for invalid shipping address
Given I am logged into my user account
And I navigate to the checkout page
When I enter an invalid shipping address
Then the system displays an error message for invalid shipping address
@TC-15
Scenario: Verify error handling for expired promotional code
Given I am logged into my user account
And I navigate to the checkout page
When I attempt a transaction with an expired promotional code
Then the system displays an error message for expired promotional code
@TC-15
Scenario: Verify error handling for duplicate payment attempts
Given I am logged into my user account
And I navigate to the checkout page
When I attempt duplicate payment transactions
Then the system displays an error message for duplicate payment attempts
@TC-15
Scenario: Verify error handling for incomplete payment details
Given I am logged into my user account
And I navigate to the checkout page
When I proceed with incomplete payment details
Then the system prompts me to complete payment details