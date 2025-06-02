Feature: Verify Confirmation Sent Only for Successful Transactions
@TC-185
Scenario: Confirmation message is sent for a successful transaction
Given I am logged into the user account
When I select a product or service to purchase
And I proceed to the checkout page
And I enter valid payment details
And I complete the transaction
Then I should receive a confirmation message for the successful transaction
@TC-185
Scenario: No confirmation message is sent for a failed transaction due to invalid payment details
Given I am logged into the user account
When I perform a transaction with invalid payment details
Then the transaction should fail
And I should not receive a confirmation message for the failed transaction
@TC-185
Scenario: Confirmation messages are sent only for successful transactions of different products/services
Given I am logged into the user account
When I select different products or services to purchase
And I proceed to the checkout page
And I enter valid payment details
And I complete each transaction
Then I should receive confirmation messages only for successful transactions
@TC-185
Scenario: No confirmation message is sent for a failed transaction due to insufficient funds
Given I am logged into the user account
When I attempt a purchase with insufficient funds
Then the transaction should fail
And I should not receive a confirmation message for the failed transaction
@TC-185
Scenario: Confirmation message includes transaction details
Given I have completed a successful transaction
Then the confirmation message should contain the transaction ID, amount, and product/service details
@TC-185
Scenario: Verify timestamp on the confirmation message
Given I have completed a successful transaction
Then the timestamp on the confirmation message should match the time of successful transaction completion
@TC-185
Scenario: Transaction history reflects only successful transactions with received confirmations
Given I am logged into the user account
When I check the transaction history
Then the transaction history should reflect only successful transactions with received confirmations
@TC-185
Scenario: Failed transactions are logged without sending confirmations
Given I am logged into the user account
When I perform a failed transaction
Then the failed transaction should be logged
And no confirmation should be sent to the user