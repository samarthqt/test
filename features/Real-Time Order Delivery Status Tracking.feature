Feature: Real-Time Order Delivery Status Tracking
Users can track the delivery status of their orders in real-time.
@TC-77
Scenario: Verify user can log in and access the dashboard
Given the user has valid credentials
When the user logs into the account
Then the user is successfully logged in and redirected to the dashboard
@TC-77
Scenario: Navigate to the 'Order Tracking' section
Given the user is on the dashboard
When the user navigates to the 'Order Tracking' section
Then the 'Order Tracking' section is displayed with a list of orders eligible for tracking
@TC-77
Scenario: View delivery status of an order
Given the user is in the 'Order Tracking' section
When the user selects an order to view its delivery status
Then the delivery status is displayed, showing the current location and estimated delivery time
@TC-77
Scenario: Verify tracking number and carrier information
Given the user is viewing the delivery status of an order
Then the tracking number and carrier information are correctly displayed
@TC-77
Scenario: Check real-time updates of order status
Given the user is viewing the delivery status of an order
Then the current status of the order is updated in real-time
@TC-77
Scenario: Ensure estimated delivery time is accurate
Given the user is viewing the delivery status of an order
Then the estimated delivery time is accurate and updated as needed
@TC-77
Scenario: Verify notifications for delivery status changes
Given the user is viewing the delivery status of an order
Then the user receives notifications for any changes in delivery status
@TC-77
Scenario: View detailed tracking history
Given the user is viewing the delivery status of an order
When the user accesses tracking history
Then the tracking history shows past locations and statuses of the package
@TC-77
Scenario: Contact carrier for more information
Given the user is viewing the delivery status of an order
When the user attempts to contact the carrier
Then contact information for the carrier is available and accessible
@TC-77
Scenario: Download tracking information as a PDF
Given the user is viewing the delivery status of an order
When the user attempts to download tracking information as a PDF
Then tracking information is successfully downloaded and contains accurate details
@TC-77
Scenario: System response to network latency or connectivity issues
Given the user is viewing the delivery status of an order
When there is network latency or connectivity issues
Then the system displays appropriate error messages or retries the connection
@TC-77
Scenario: Navigate back to the dashboard
Given the user is on the tracking page
When the user navigates back to the dashboard
Then the user is redirected to the dashboard without any issues
@TC-77
Scenario: Log out from the user account
Given the user is logged in
When the user logs out from the account
Then the user is successfully logged out and redirected to the login page