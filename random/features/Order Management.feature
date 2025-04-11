Feature: Order Management
Scenario: View past orders
Given a user is logged into the order management system
When the user navigates to the past orders section
Then the user should see a list of their past orders
And each order should display the order status and payment details
Scenario: Track delivery status
Given a user has placed an order
When the user navigates to the order details page
Then the user should be able to track the delivery status of the order
And the delivery status should be updated on both the website and mobile app
Scenario: Cancel an order
Given a user has placed an order
And the order is eligible for cancellation
When the user selects the cancel option for the order
Then the order should be successfully canceled
And the user should receive a notification of the order status change
Scenario: Request a return
Given a user has received an order
And the order is eligible for return based on the merchant's return policy
When the user selects the request return option for the order
Then the return request should be successfully placed
And the user should receive a notification of the return status change
Scenario: Invalid operations
Given a user attempts to perform an invalid operation on an order
When the system detects the invalid operation
Then an error message should be displayed to the user
Scenario: Logging order management operations
Given a user performs any order management operation
When the operation is completed
Then the system should log the details of the operation for tracking purposes