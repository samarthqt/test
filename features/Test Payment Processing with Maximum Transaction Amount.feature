Feature: Test Payment Processing with Maximum Transaction Amount
@TC-311
Scenario: Verify payment processing when the transaction amount reaches the maximum limit
Given the user navigates to the payment page
Then the payment page is displayed correctly
@TC-311
Scenario: Select Stripe as the payment method
When the user selects Stripe as the payment method
Then Stripe payment method is selected
@TC-311
Scenario: Enter valid credit card details
When the user enters valid credit card details
Then the credit card details are accepted
@TC-311
Scenario: Enter valid billing address
When the user enters a valid billing address
Then the billing address is accepted
@TC-311
Scenario: Enter valid email address
When the user enters a valid email address
Then the email address is accepted
@TC-311
Scenario: Enter product ID and maximum amount to be charged
When the user enters the product ID and maximum amount to be charged
Then the product ID and maximum amount are accepted
@TC-311
Scenario: Submit the payment
When the user submits the payment
Then the payment is processed successfully
@TC-311
Scenario: Verify transaction confirmation message
Then the transaction confirmation message is displayed
@TC-311
Scenario: Check Stripe dashboard for transaction record
Then the transaction record is present in the Stripe dashboard
@TC-311
Scenario: Verify email notification for transaction
Then the email notification for the transaction is received
@TC-311
Scenario: Log out from the application
When the user logs out from the application
Then the user is logged out successfully
@TC-311
Scenario: Log back into the application
When the user logs back into the application
Then the user is logged in successfully
@TC-311
Scenario: Check order history for transaction
Then the transaction is present in the order history
@TC-311
Scenario: Verify customer support is available for transaction queries
Then customer support is available for transaction queries
@TC-311
Scenario: Ensure transaction details are logged for auditing
Then transaction details are logged for auditing