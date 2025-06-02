Feature: Verify transaction details included in receipt
@TC-179
Scenario: Verify successful receipt generation with transaction details
Given the user is logged into the application with valid credentials
When the user navigates to the checkout page
And the user enters payment details and confirms the payment
Then the payment is processed successfully
And a receipt is generated with transaction details
And an email notification is received with the receipt including transaction details
And the transaction details are updated in the order history
And the user logs out from the application
@TC-179
Scenario: Verify receipt generation with a different payment method
Given the user is logged into the application with valid credentials
When the user navigates to the checkout page
And the user repeats the payment process using a different payment method
Then a receipt with transaction details is generated successfully for the different payment method
@TC-179
Scenario: Verify error message for incorrect payment details
Given the user is logged into the application with valid credentials
When the user navigates to the checkout page
And the user attempts payment with incorrect payment details
Then the system displays an error message for invalid payment details
@TC-179
Scenario: Verify error message for missing payment details
Given the user is logged into the application with valid credentials
When the user navigates to the checkout page
And the user attempts payment without entering payment details
Then the system displays an error message for missing payment details
@TC-179
Scenario: Verify error message for declined payment
Given the user is logged into the application with valid credentials
When the user navigates to the checkout page
And the user attempts a payment that is declined
Then the system displays an error message for declined payment
@TC-179
Scenario: Verify error message for unavailable payment gateway
Given the user is logged into the application with valid credentials
When the user navigates to the checkout page
And the payment gateway is unavailable
Then the system displays an error message for unavailable payment gateway
@TC-179
Scenario: Verify error message for network connection issues
Given the user is logged into the application with valid credentials
When the user navigates to the checkout page
And the network connection is lost during payment
Then the system displays an error message for network connection issues
@TC-179
Scenario: Verify error message for expired payment method
Given the user is logged into the application with valid credentials
When the user navigates to the checkout page
And the user attempts payment with an expired payment method
Then the system displays an error message for expired payment method
@TC-179
Scenario: Verify error message for missing transaction details in receipt
Given the user is logged into the application with valid credentials
When the user completes a payment successfully
And the receipt does not include transaction details
Then the system displays an error message for missing transaction details in receipt