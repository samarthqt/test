Feature: Order Tracking
""
As a user,
I want to have real-time order tracking information,
So that I can monitor the status of my orders efficiently.
""
Background:
Given the user is logged into the application
And the user has placed an order
""
Scenario: View real-time order tracking information
"    Given the user navigates to the ""Order Tracking"" section"
When the user selects an order to track
Then the system should display the current status of the order
And the system should display the expected delivery date
And the system should display the current location of the order
""
Scenario: Order status updates in real-time
Given the user is viewing the tracking information of an order
When the order status changes
Then the system should update the order status in real-time
And the user should be notified of the status change
""
Scenario: Error handling for unavailable tracking information
Given the user selects an order to track
When the tracking information is unavailable
Then the system should display an error message
And the system should provide an option to retry
""
Scenario: Access order tracking without logging in
Given the user is not logged into the application
"    When the user attempts to access the ""Order Tracking"" section"
Then the system should prompt the user to log in
```