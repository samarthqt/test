Feature: Attempt Checkout with Expired Payment Method
@TC-294
Scenario: Navigate to the checkout page
Given a user account with items in cart
When the user navigates to the checkout page
Then the checkout page is displayed
@TC-294
Scenario: Enter expired payment details
Given expired payment method details
When the user enters expired payment details including card number, expiry date, and CVV
Then payment details are entered
@TC-294
Scenario: Attempt to submit expired payment information
Given payment method is Credit Card
When the user attempts to submit the payment information
Then the system prevents submission due to expired payment method
@TC-294
Scenario: Verify error message for expired payment method
Given card number is 4111 1111 1111 1111
When the system displays an error message
Then the error message indicates payment method is expired
@TC-294
Scenario: Prompt to update payment information
Given expiry date is 01/21
When checking for prompts to update payment information
Then the user is prompted to update payment information
@TC-294
Scenario: Attempt checkout with updated payment method
Given CVV is 456
When the user attempts checkout with updated payment method
Then checkout proceeds with valid payment method
@TC-294
Scenario: Verify transaction history for failed attempt
When verifying transaction history for failed attempt with expired method
Then the failed transaction is logged with reason for failure
@TC-294
Scenario: Ensure system does not process transaction with expired method
When ensuring system does not process transaction with expired method
Then the transaction is not processed
@TC-294
Scenario: Test system response with different expired payment methods
When testing system response with different expired payment methods
Then all expired methods are rejected with appropriate error messages
@TC-294
Scenario: Simulate network interruption during payment submission
When simulating network interruption during payment submission
Then the system alerts user and does not process transaction
@TC-294
Scenario: Check system logs for error handling and alerts
When checking system logs for error handling and alerts
Then logs capture error and user actions accurately
@TC-294
Scenario: Verify user receives notification for failed transaction
When verifying user receives notification for failed transaction
Then notification is sent with details of failure
@TC-294
Scenario: Test system response to incorrect CVV with expired method
When testing system response to incorrect CVV with expired method
Then the system alerts user to both expired method and incorrect CVV
@TC-294
Scenario: Attempt checkout with expired method from mobile device
When attempting checkout with expired method from mobile device
Then same error messages and prompts are displayed on mobile
@TC-294
Scenario: Ensure user can update payment details easily from error prompt
When ensuring user can update payment details easily from error prompt
Then the user is able to update payment details successfully