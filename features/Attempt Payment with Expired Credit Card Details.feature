Feature: Attempt Payment with Expired Credit Card Details
@TC-310
Scenario: Verify the system's response when attempting payment with expired credit card details
Given I am on the payment page
When I select Stripe as the payment method
And I enter expired credit card details
Then I should see an error message for expired credit card
When I enter a valid billing address
Then the billing address should be accepted
When I enter a valid email address
Then the email address should be accepted
When I enter a product ID and the amount to be charged
Then the product ID and amount should be accepted
When I attempt to submit the payment
Then the payment submission should fail with an error message
And the error message details should be clear and informative
When I check the Stripe dashboard for a failed transaction record
Then the failed transaction record should not be present in the Stripe dashboard
When I verify no email notification is received for the failed transaction
Then no email notification should be received
When I log out from the application
Then I should be logged out successfully
When I log back into the application
Then I should be logged in successfully
When I check order history for the failed transaction
Then the failed transaction should not be present in order history
When I verify customer support is available for transaction queries
Then customer support should be available
When I ensure failed transaction details are logged for auditing
Then the failed transaction details should be logged