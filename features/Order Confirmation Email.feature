Feature: Order Confirmation Email
Scenario: Send order confirmation email after purchase completion
Given a user completes a purchase on the retail platform
When the transaction is successfully processed
Then an order confirmation email should be sent to the user's registered email address
And the email should contain details of the transaction including order number, items purchased, total amount, and billing information
And the user should receive the email within a reasonable time frame after the purchase completion
Scenario: Ensure order confirmation email is not sent for failed transactions
Given a user attempts to make a purchase on the retail platform
When the transaction fails
Then no order confirmation email should be sent to the user
Scenario: Verify order confirmation email content
Given a user has completed a purchase
When the order confirmation email is received
Then the email should contain the correct order number
And the email should list all the items purchased
And the email should show the correct total amount
And the email should include accurate billing information
Scenario: Resend order confirmation email upon user request
Given a user has completed a purchase
And the user requests a resend of the order confirmation email
When the request is processed
Then the order confirmation email should be resent to the user's registered email address
Scenario: Handle invalid email addresses during order confirmation
Given a user completes a purchase
And the user's registered email address is invalid
When the system attempts to send the order confirmation email
Then the system should log an error indicating the invalid email address
And no order confirmation email should be sent
And the user should be notified to update their email address