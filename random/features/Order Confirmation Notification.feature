Feature: Order Confirmation Notification
Scenario: Successful order confirmation via email
Given a user has completed the checkout process
When the order is placed successfully
Then the user should receive an order confirmation email
And the email should include the order number
And the email should include the shipping address
And the email should include the items purchased
And the email should include the estimated delivery date
And a notification should confirm successful order placement
And the system should log the order confirmation notification
Scenario: Successful order confirmation via SMS
Given a user has completed the checkout process
When the order is placed successfully
Then the user should receive an order confirmation SMS
And the SMS should include the order number
And the SMS should include the shipping address
And the SMS should include the items purchased
And the SMS should include the estimated delivery date
And a notification should confirm successful order placement
And the system should log the order confirmation notification
Scenario: Failed order confirmation notification
Given a user has completed the checkout process
When there is a failure in sending the order confirmation
Then an error message should be displayed to the user
And the system should log the failed order confirmation attempt