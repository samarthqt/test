Feature: Refund Processing through Integrated Gateways
@TC-176
Scenario: Verify refund processing through integrated gateways
Given the user is logged into the application with valid credentials
When the user navigates to the 'Order History' section
Then the order history is displayed with past transactions
When the user selects a transaction eligible for refund
Then the transaction details are displayed
When the user clicks on the 'Request Refund' button
Then the refund request form is displayed
When the user enters refund amount and reason for refund
Then the refund details are entered successfully
When the user selects the payment gateway for processing the refund
Then the payment gateway is selected
When the user submits the refund request
Then the refund request is submitted successfully
When the user verifies the refund status in the transaction history
Then the refund status is updated in the transaction history
When the user checks email notification for refund confirmation
Then an email notification is received with refund confirmation
When the user verifies the refund amount is credited back to the original payment method
Then the refund amount is credited back to the original payment method
When the user logs out from the application
Then the user is logged out successfully
@TC-176
Scenario: Repeat refund process using a different payment gateway
Given the user has completed a refund process using one payment gateway
When the user repeats the process using a different payment gateway
Then the refund is processed successfully through the different gateway
@TC-176
Scenario Outline: Attempt refund with invalid conditions
Given the user is on the refund request form
When the user attempts to refund an amount greater than the original transaction
Then the system displays an error message for invalid refund amount
Examples:
| Invalid Condition                             | Error Message                                  |
| greater than the original transaction amount  | invalid refund amount                          |
| without selecting a payment gateway           | missing payment gateway selection              |
| with an invalid transaction ID                | invalid transaction ID                         |
@TC-176
Scenario: Attempt refund without selecting a payment gateway
Given the user is on the refund request form
When the user attempts refund without selecting a payment gateway
Then the system displays an error message for missing payment gateway selection
@TC-176
Scenario: Attempt refund with an invalid transaction ID
Given the user is on the refund request form
When the user attempts refund with an invalid transaction ID
Then the system displays an error message for invalid transaction ID