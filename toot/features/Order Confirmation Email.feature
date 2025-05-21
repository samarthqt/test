Feature: Order Confirmation Email
""
Scenario: Send order confirmation email upon purchase completion
Given a user has completed a purchase
When the purchase transaction is successful
Then an order confirmation email should be sent to the user's registered email address
And the email should contain the order details including order ID, items purchased, total amount, and delivery address
And the email should be sent from the correct sender email address for order confirmations
""
Scenario: Do not send order confirmation email if purchase fails
Given a user attempts to complete a purchase
When the purchase transaction fails
Then no order confirmation email should be sent to the user
""
Scenario: Retry sending order confirmation email if initial attempt fails
Given a user has completed a purchase
And the initial attempt to send an order confirmation email fails
When the system retries sending the email
Then the order confirmation email should be successfully sent to the user's registered email address
""
Scenario: Log email sending status
Given a user has completed a purchase
When an order confirmation email is sent
Then the system should log the status of the email sending process
And the log should include whether the email was successfully sent or if there were any errors
```
```gherkin
TCID:15