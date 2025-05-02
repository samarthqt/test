Feature: Product Availability Alert
Scenario: User subscribes to product availability alerts
Given a user is on the product page
And the product is currently out of stock
When the user subscribes to receive availability alerts
Then the user should receive a confirmation of subscription
Scenario: Product comes back in stock
Given a product is out of stock
And users have subscribed to availability alerts for the product
When the product comes back in stock
Then notify all subscribed users via email
Scenario: User receives notification of product availability
Given a user has subscribed to receive alerts for a specific product
And the product is back in stock
When the system sends an availability notification
Then the user should receive an email notifying that the product is available
Scenario: User views notification details
Given a user has received an email notification about product availability
When the user opens the email
Then the email should contain details about the product
And a link to the product page
Scenario: User unsubscribes from product availability alerts
Given a user is subscribed to product availability alerts
When the user chooses to unsubscribe from alerts
Then the user should receive confirmation of unsubscription
And the user should no longer receive notifications for the product availability