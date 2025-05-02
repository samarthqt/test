Feature: Email Notifications for Order Status Changes
Scenario: Send email notification when order is shipped
Given a user has placed an order
When the order status changes to "shipped"
Then an email notification should be sent to the user
And the email should contain the order details
And the email should indicate that the order has been shipped
Scenario: Send email notification when order is delivered
Given a user has placed an order
When the order status changes to "delivered"
Then an email notification should be sent to the user
And the email should contain the order details
And the email should indicate that the order has been delivered
Scenario: Do not send email notification for other status changes
Given a user has placed an order
When the order status changes to "processing"
Then no email notification should be sent to the user
Scenario: Verify email contains correct user information
Given a user has placed an order
When the order status changes to "shipped"
Then an email notification should be sent to the user
And the email should contain the user's name and email address
Scenario: Verify email is not sent if user opts out of notifications
Given a user has placed an order
And the user has opted out of email notifications
When the order status changes to "shipped"
Then no email notification should be sent to the user