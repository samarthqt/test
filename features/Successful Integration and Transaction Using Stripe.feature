Feature: Successful Integration and Transaction Using Stripe
@TC-309
Scenario: Verify successful integration and transaction using Stripe
Given Stripe account setup is completed
When I navigate to the payment page
Then the payment page is displayed correctly
And API keys are configured
When I select Stripe as the payment method
Then Stripe payment method is selected
When I enter valid credit card details
Then credit card details are accepted
When I enter valid billing address
Then billing address is accepted
When I enter valid email address
Then email address is accepted
When I enter product ID and amount to be charged
Then product ID and amount are accepted
When I submit the payment
Then payment is processed successfully
When I verify transaction confirmation message
Then transaction confirmation message is displayed
When I check Stripe dashboard for transaction record
Then transaction record is present in Stripe dashboard
When I verify email notification for transaction
Then email notification is received
When I log out from the application
Then user is logged out successfully
When I log back into the application
Then user is logged in successfully
When I check order history for transaction
Then transaction is present in order history
When I verify customer support is available for transaction queries
Then customer support is available
When I ensure transaction details are logged for auditing
Then transaction details are logged