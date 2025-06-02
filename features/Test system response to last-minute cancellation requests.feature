Feature: Test system response to last-minute cancellation requests
Scenario: Validate system handling of cancellation requests made just before shipping
@TC-220
Given a user account with valid credentials
And an order with ID 12345 is placed and ready for shipping
When the user logs into the system
Then the user successfully logs into the system
@TC-220
When the user navigates to the 'Order History' section
Then the Order History page displays all past orders
@TC-220
When the user selects the order with ID 12345
Then the order details for ID 12345 are displayed
And the shipping status is 'Ready for dispatch'
@TC-220
When the user clicks on 'Cancel Order' button
Then a cancellation confirmation dialog appears
@TC-220
When the user confirms cancellation by clicking 'Yes'
Then the order status changes to 'Cancelled'
@TC-220
Then a notification email for cancellation is received
@TC-220
When the user checks refund initiation status
Then the refund process is initiated for the cancelled order
@TC-220
When the user navigates to the 'Refund Status' section
Then the refund status is displayed as 'Processing'
@TC-220
When the user logs out from the user account
Then the user successfully logs out from the system
@TC-220
When the user attempts to track the cancelled order
Then the system displays 'Order Cancelled, no tracking available'
@TC-220
When the user checks the order status in the database
Then the database reflects order status as 'Cancelled'
@TC-220
When the user verifies system logs for cancellation request
Then logs contain entry for cancellation request and status update
@TC-220
When the system performance is checked under cancellation load
Then the system performance remains optimal with no delays
@TC-220
When the user reviews the user interface for cancellation process
Then the UI is user-friendly and intuitive for cancellation requests
@TC-220
When customer support availability for cancellation queries is ensured
Then customer support is available and responsive to queries