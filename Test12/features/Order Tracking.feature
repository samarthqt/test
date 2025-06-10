Feature: Order Tracking
@5
Scenario: View order status and tracking numbers
Given a user has placed an order
When the user navigates to the order tracking page on the website/app
Then the user should be able to view the order status
And the user should be able to view the tracking number
@5
Scenario: Track order delivery via website/app
Given a user has a tracking number
When the user enters the tracking number on the order tracking page
Then the user should be able to track the order delivery
@5
Scenario: Handle tracking errors gracefully
Given a user enters an invalid tracking number
When the system processes the tracking request
Then the system should display an error message gracefully
@5
Scenario: Receive notifications for delivery updates
Given a user has subscribed to delivery notifications
When there is an update on the order delivery
Then the user should receive a notification with the delivery update
@5
Scenario: Support order cancellations and returns
Given a user wants to cancel or return an order
When the user initiates a cancellation or return request
Then the application should process the request as per merchant policy
@5
Scenario: Log all order tracking interactions
Given a user views or updates order tracking information
When the interaction occurs
Then the system should log the interaction details
@5
Scenario: Ensure tracking data is updated in real-time
Given a change in order status or delivery information
When the system updates the tracking data
Then the updated information should be available in real-time to the user
@5
Scenario: Offer a user-friendly tracking interface
Given a user accesses the order tracking page
When the user interacts with the tracking features
Then the interface should be user-friendly and easy to navigate
@5
Scenario: Compliance with merchant policies for cancellations and returns
Given a user requests a cancellation or return
When the application processes the request
Then the application should comply with the merchant's policies
@5
Scenario: Ensure data consistency across order tracking details
Given a user views order tracking details
When the user checks multiple sources of tracking information
Then the data should be consistent across all sources