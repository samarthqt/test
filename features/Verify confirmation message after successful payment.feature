Feature: Verify confirmation message after successful payment
@TC-177
Scenario: Successfully display confirmation message after successful payment
Given the user logs in to the application with valid credentials
And navigates to the checkout page
When the user enters payment details and confirms the payment
Then the payment is processed successfully
And a confirmation message is displayed immediately
@TC-177
Scenario: Receive email notification for payment confirmation
Given the payment is processed successfully
When the user checks the email notification
Then the email notification is received with payment confirmation
@TC-177
Scenario: Verify transaction details in the order history
Given the payment is processed successfully
When the user verifies the transaction details in the order history
Then the transaction details are updated in the order history
@TC-177
Scenario: Log out from the application
Given the user is logged in
When the user logs out from the application
Then the user is logged out successfully
@TC-177
Scenario: Repeat payment process using a different payment method
Given the user is logged in
And navigates to the checkout page
When the user repeats the payment process using a different payment method
Then the payment is processed successfully
And a confirmation message is displayed successfully for the different payment method
@TC-177
Scenario: Attempt payment with incorrect payment details
Given the user is logged in
And navigates to the checkout page
When the user attempts payment with incorrect payment details
Then the system displays an error message for invalid payment details
@TC-177
Scenario: Attempt payment without entering payment details
Given the user is logged in
And navigates to the checkout page
When the user attempts payment without entering payment details
Then the system displays an error message for missing payment details
@TC-177
Scenario: Verify application behavior when payment is declined
Given the user is logged in
And navigates to the checkout page
When the payment is declined
Then the system displays an error message for declined payment
@TC-177
Scenario: Verify application behavior when payment gateway is unavailable
Given the user is logged in
And navigates to the checkout page
When the payment gateway is unavailable
Then the system displays an error message for unavailable payment gateway
@TC-177
Scenario: Verify application behavior when network connection is lost during payment
Given the user is logged in
And navigates to the checkout page
When the network connection is lost during payment
Then the system displays an error message for network connection issues
@TC-177
Scenario: Attempt payment with expired payment method
Given the user is logged in
And navigates to the checkout page
When the user attempts payment with expired payment method
Then the system displays an error message for expired payment method
@TC-177
Scenario: Verify application behavior when payment is successful but confirmation message is delayed
Given the user is logged in
And navigates to the checkout page
When the payment is successful but the confirmation message is delayed
Then the system eventually displays the confirmation message after a delay