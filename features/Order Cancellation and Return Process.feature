Feature: Order Cancellation and Return Process
@TC-78
Scenario: Verify successful login and navigation to dashboard
Given the user is on the login page
When the user logs in with valid credentials "User ID: 12345"
Then the user is successfully logged in and redirected to the dashboard
@TC-78
Scenario: Navigate to 'Order History' section
Given the user is on the dashboard
When the user navigates to the 'Order History' section
Then the 'Order History' section is displayed with a list of past orders
@TC-78
Scenario: Select an order eligible for cancellation or return
Given the user is in the 'Order History' section
When the user selects an order with Order ID: 67890
Then order details are displayed with options for cancellation or return
@TC-78
Scenario: Cancel an eligible order
Given the user has selected an order eligible for cancellation
When the user attempts to cancel the order by selecting the cancellation option
Then the cancellation request is processed, and the user receives confirmation
@TC-78
Scenario: Verify cancellation reason is recorded
Given the user has cancelled an order
When the user selects a cancellation reason as "Changed Mind"
Then the cancellation reason matches the user's selection
@TC-78
Scenario: Ensure order status is updated to 'Cancelled'
Given the user has cancelled an order
Then the order status changes to 'Cancelled' in the order history
@TC-78
Scenario: Return an eligible order
Given the user has selected an order eligible for return
When the user selects the return option
Then the return request is processed, and the user receives confirmation
@TC-78
Scenario: Verify return reason is recorded
Given the user has returned an order
When the user selects a return reason as "Defective Item"
Then the return reason matches the user's selection
@TC-78
Scenario: Ensure order status is updated to 'Returned'
Given the user has returned an order
Then the order status changes to 'Returned' in the order history
@TC-78
Scenario: Check notifications for cancellation or return status changes
Given the user has cancelled or returned an order
Then the user receives notifications for any changes in order status
@TC-78
Scenario: Verify refund processing for cancelled or returned orders
Given the user has cancelled or returned an order
Then the refund is processed and credited to the user's account or original payment method
@TC-78
Scenario: View refund details in order history
Given the user has received a refund for a cancelled or returned order
Then refund details are accurately displayed in the order history
@TC-78
Scenario: Test system response to invalid cancellation or return requests
Given the user attempts an invalid cancellation or return request
Then the system displays appropriate error messages for invalid requests
@TC-78
Scenario: Navigate back to the dashboard from the cancellation/return page
Given the user is on the cancellation/return page
When the user navigates back to the dashboard
Then the user is redirected to the dashboard without any issues
@TC-78
Scenario: Log out from the user account
Given the user is on the dashboard
When the user logs out
Then the user is successfully logged out and redirected to the login page