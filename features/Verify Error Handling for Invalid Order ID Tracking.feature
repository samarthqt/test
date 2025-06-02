Feature: Verify Error Handling for Invalid Order ID Tracking
@TC-79
Scenario: User logs in to the account using valid credentials
Given the user has valid credentials
When the user logs in to the account
Then the user is successfully logged in and redirected to the dashboard
@TC-79
Scenario: Navigate to the 'Order Tracking' section from the dashboard
Given the user is on the dashboard
When the user navigates to the 'Order Tracking' section
Then the 'Order Tracking' section is displayed with a list of orders eligible for tracking
@TC-79
Scenario: Enter an invalid order ID in the tracking search field
Given the user is in the 'Order Tracking' section
When the user enters an invalid order ID "00000"
Then the system displays an error message indicating the order ID is invalid
@TC-79
Scenario: Attempt to track the order with the invalid ID
Given the user has entered an invalid order ID "00000"
When the user attempts to track the order
Then the system prevents tracking and displays an error message
@TC-79
Scenario: Verify the error message provides guidance on correcting the order ID
Given the system displays an error message for invalid order ID
Then the error message suggests checking the order ID and trying again
@TC-79
Scenario: Check if the user can retry tracking with a valid order ID
Given the user has entered an invalid order ID previously
When the user enters a valid order ID
Then the user can successfully track the order
@TC-79
Scenario: Ensure the system logs the invalid tracking attempt for auditing purposes
Given the user has attempted to track an order with an invalid ID
Then the invalid tracking attempt is logged in the system for review
@TC-79
Scenario: Test the system's response to multiple invalid tracking attempts
Given the user attempts to track orders with multiple invalid IDs
Then the system consistently displays error messages for repeated invalid attempts
@TC-79
Scenario: Verify the user receives a notification for invalid tracking attempts
Given the user has attempted to track an order with an invalid ID
Then the user receives a notification regarding the invalid tracking attempt
@TC-79
Scenario: Check if the user can access help or support for tracking issues
Given the user is facing issues with order tracking
When the user seeks help or support
Then help or support options are available for tracking issues
@TC-79
Scenario: Ensure the user can navigate back to the dashboard from the tracking page
Given the user is in the 'Order Tracking' section
When the user chooses to navigate back to the dashboard
Then the user is redirected to the dashboard without any issues
@TC-79
Scenario: Log out from the user account
Given the user is logged in
When the user logs out from the account
Then the user is successfully logged out and redirected to the login page