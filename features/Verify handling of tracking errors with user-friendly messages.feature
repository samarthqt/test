Feature: Verify handling of tracking errors with user-friendly messages
@TC-203
Scenario: Verify login and navigation to Order History
Given the user logs in with valid credentials
Then the user is redirected to the dashboard
And 39 orders have been placed with tracking information
When the user navigates to the 'Order History' section
Then the user sees a list of past orders
@TC-203
Scenario: Verify order details display
Given the user selects an order with ID 98765
Then the order details are displayed with tracking information
@TC-203
Scenario: Verify system response to invalid tracking number
Given the user manually enters an invalid tracking number "INVALID123" for the order
When the system attempts to fetch tracking information
Then the system displays a user-friendly error message indicating the tracking number is invalid
@TC-203
Scenario: Simulate network failure during tracking retrieval
Given a network failure occurs during tracking information retrieval
Then the system provides an error message indicating a network issue and suggests retrying
@TC-203
Scenario: Verify system response when carrier's API is down
Given the carrier's API is down
Then the system informs the user that the carrier's service is temporarily unavailable
@TC-203
Scenario: Verify handling of delayed responses from carrier's API
Given the carrier's API response is delayed
Then the system displays a message indicating a delay in fetching tracking information
@TC-203
Scenario: Test system response to 404 error from carrier's API
Given a 404 error is received from the carrier's API
Then the system provides a message indicating the tracking information could not be found
@TC-203
Scenario: Verify handling of 500 error from carrier's API
Given a 500 error is received from the carrier's API
Then the system informs the user of a server error and suggests trying again later
@TC-203
Scenario: Simulate incomplete tracking information
Given the tracking information is incomplete
Then the system displays a message indicating incomplete tracking information and suggests contacting support
@TC-203
Scenario: Verify logging of tracking errors
Given tracking errors occur
Then tracking errors are logged accurately for auditing and troubleshooting purposes
@TC-203
Scenario: Check system response when switching carriers
Given the user switches carriers for tracking an order
Then the system updates the carrier information and attempts to fetch new tracking data
@TC-203
Scenario: Test system response to retry attempts by user
Given the user attempts to retry fetching tracking information
Then the system allows retry attempts and provides feedback on the status of each attempt
@TC-203
Scenario: Verify presence of help link for tracking issues
Given the user encounters tracking issues
Then a help link is available, directing users to support for tracking issues