Feature: Verify digital receipt generation after successful payment
@TC-178
Scenario: Successful payment generates and sends a digital receipt to the user's registered email
Given the user is logged into the application with valid credentials
When the user navigates to the checkout page
And enters payment details and confirms the payment
Then the payment is processed successfully
And a digital receipt is generated and sent to user@example.com
And an email notification is received with the digital receipt
And the transaction details are updated in the order history
And the user logs out from the application
@TC-178
Scenario: Repeat payment process using a different payment method
Given the user is logged into the application with valid credentials
When the user navigates to the checkout page
And enters payment details using a different payment method and confirms the payment
Then the payment is processed successfully
And a digital receipt is generated successfully for the different payment method
@TC-178
Scenario: Attempt payment with incorrect payment details
Given the user is logged into the application with valid credentials
When the user navigates to the checkout page
And enters incorrect payment details and attempts payment
Then the system displays an error message for invalid payment details
@TC-178
Scenario: Attempt payment without entering payment details
Given the user is logged into the application with valid credentials
When the user navigates to the checkout page
And attempts payment without entering payment details
Then the system displays an error message for missing payment details
@TC-178
Scenario: Verify application behavior when payment is declined
Given the user is logged into the application with valid credentials
When the user navigates to the checkout page
And enters payment details and the payment is declined
Then the system displays an error message for declined payment
@TC-178
Scenario: Verify application behavior when payment gateway is unavailable
Given the user is logged into the application with valid credentials
When the user navigates to the checkout page
And attempts payment when the payment gateway is unavailable
Then the system displays an error message for unavailable payment gateway
@TC-178
Scenario: Verify application behavior when network connection is lost during payment
Given the user is logged into the application with valid credentials
When the user navigates to the checkout page
And attempts payment when the network connection is lost
Then the system displays an error message for network connection issues
@TC-178
Scenario: Attempt payment with expired payment method
Given the user is logged into the application with valid credentials
When the user navigates to the checkout page
And enters expired payment method details and attempts payment
Then the system displays an error message for expired payment method
@TC-178
Scenario: Verify application behavior when digital receipt is not generated despite successful payment
Given the user is logged into the application with valid credentials
When the user navigates to the checkout page
And enters payment details and confirms the payment
Then the payment is processed successfully
And the system displays an error message for receipt generation failure despite successful payment