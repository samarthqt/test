Feature: Verify user access to order tracking information
@TC-201
Scenario: User logs in and views order tracking information
Given the user has an active account
And the user logs in to the system using valid user credentials
Then the user is successfully logged in and redirected to the dashboard
And the user has placed orders with tracking information available
@TC-201
Scenario: User navigates to Order History
Given the user is on the dashboard
When the user navigates to the 'Order History' section
Then the user is presented with a list of past orders
@TC-201
Scenario: User selects an order to view details
Given the user is on the 'Order History' section
When the user selects an order with ID 54321 to view its details
Then the order details are displayed, including tracking information
@TC-201
Scenario: Verify visibility of the tracking number
Given the user is viewing the order details
Then the tracking number TRACK12345 is visible in the order details
@TC-201
Scenario: User views detailed tracking information
Given the tracking number TRACK12345 is visible
When the user clicks on the tracking number
Then the system redirects to the carrier's website showing detailed tracking information
@TC-201
Scenario: Verify accuracy of tracking information
Given the user is on the carrier's website
Then the tracking information matches the data provided by the carrier
@TC-201
Scenario: System handling of invalid tracking numbers
Given the user enters an invalid tracking number
Then the system displays a user-friendly error message for invalid tracking numbers
@TC-201
Scenario: Simulate tracking information update
Given the carrier updates tracking information
Then the system updates the tracking information in real-time
@TC-201
Scenario: System response to tracking information unavailability
Given tracking information is temporarily unavailable
Then the system informs the user that tracking information is temporarily unavailable
@TC-201
Scenario: Test responsiveness on mobile devices
Given the user accesses the tracking information page on a mobile device
Then the tracking information page is fully responsive and displays correctly
@TC-201
Scenario: Verify tracking information visibility on order status change
Given the order status changes
Then tracking information remains visible regardless of order status changes
@TC-201
Scenario: Access tracking information with an expired session
Given the user's session has expired
When the user attempts to access tracking information
Then the system prompts the user to log in again to access tracking information
@TC-201
Scenario: Verify presence of a help link for tracking issues
Given the user is viewing tracking information
Then a help link is available, directing users to support for tracking issues
@TC-201
Scenario: Handle multiple tracking requests simultaneously
Given multiple tracking requests are made simultaneously
Then the system efficiently handles multiple tracking requests without performance degradation
@TC-201
Scenario: Simulate a network failure
Given a network failure occurs
When the user attempts to fetch tracking information
Then the system provides an error message and retries fetching tracking information after network restoration