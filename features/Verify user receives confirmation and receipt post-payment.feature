Feature: Verify user receives confirmation and receipt post-payment
Scenario: Ensure user is redirected to the payment confirmation page
Given the user has completed a purchase transaction with User ID 12345
When the user navigates to the payment confirmation page
Then the user is redirected to the payment confirmation page
@TC-72
Scenario: Verify the presence of a confirmation message indicating successful payment
Given the user is on the payment confirmation page
Then a confirmation message is displayed with transaction details
And the payment method used is Credit Card
@TC-72
Scenario: Check that the user receives an email receipt
Given the user has completed a payment transaction of $100
When the transaction is successful
Then an email receipt is sent to the user's registered email address
@TC-72
Scenario: Verify the email receipt contains accurate transaction details
Given the user receives an email receipt
Then the email receipt includes transaction amount, payment method, and date
And the email is sent to user@example.com
@TC-72
Scenario: Ensure the receipt is accessible from the user's account page
Given the user has a completed transaction
Then the receipt is available in the user's account under transaction history
@TC-72
Scenario: Validate the format and content of the confirmation message
Given the user is on the payment confirmation page
Then the confirmation message is clear and correctly formatted
@TC-72
Scenario: Check the system logs for the transaction entry
Given a transaction has been completed
Then the transaction details are accurately logged in the system
@TC-72
Scenario: Verify the receipt is downloadable from the email
Given the user receives an email receipt
Then the receipt can be downloaded as a PDF from the email
@TC-72
Scenario: Ensure the user can print the receipt directly from the account page
Given the user accesses the receipt from the account page
Then a print option is available for the receipt on the account page
@TC-72
Scenario: Check the receipt for any discrepancies in transaction details
Given the user accesses the receipt
Then the receipt details match the transaction details in the system
@TC-72
Scenario: Confirm receipt generation does not delay the transaction process
Given the user completes a transaction
Then receipt generation is instantaneous and does not affect transaction speed
@TC-72
Scenario: Verify receipt accessibility on different devices (mobile/desktop)
Given the user has access to the receipt
Then the receipt is accessible and viewable on various devices
@TC-72
Scenario: Ensure receipt is stored securely and is only accessible by the user
Given the user has completed a transaction
Then the receipt is stored securely with proper access controls
@TC-72
Scenario: Check for duplicate receipt generation
Given the user completes a transaction
Then no duplicate receipts are generated for the same transaction
@TC-72
Scenario: Verify receipt includes all necessary legal and regulatory information
Given the user receives a receipt
Then the receipt complies with legal and regulatory standards