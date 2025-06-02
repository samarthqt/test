Feature: Test Unauthorized User Attempts for Cancellations or Returns
@TC-219
Scenario: Unauthorized user attempts to initiate cancellation
Given the user logs into the account with User ID 99999
And navigates to the order history section
And selects the order with Order ID 11223
And the order details page is displayed with status "Delivered"
And cancellation and return options are visible on the page
When the user attempts to initiate a cancellation for the order
Then the system restricts unauthorized users from proceeding
And an error message is displayed for unauthorized attempts
And unauthorized access attempts are logged
And the user receives notifications for unauthorized attempts
And the order status remains unchanged after unauthorized attempts
And restrictions are consistent on all devices
And an authentication prompt is displayed for unauthorized users
@TC-219
Scenario: Unauthorized user attempts to initiate return
Given the user logs into the account with User ID 99999
And navigates to the order history section
And selects the order with Order ID 11223
And the order details page is displayed with status "Delivered"
And cancellation and return options are visible on the page
When the user attempts to initiate a return for the order
Then the system restricts unauthorized users from proceeding
And an error message is displayed for unauthorized attempts
And unauthorized access attempts are logged
And the user receives notifications for unauthorized attempts
And the order status remains unchanged after unauthorized attempts
And restrictions are consistent on all devices
And an authentication prompt is displayed for unauthorized users