Feature: Order Delivery Tracking
@45
Scenario: Access order tracking on web platform
Given a user is authenticated on the web platform
When the user navigates to the order tracking feature
Then the user should be able to view the delivery status of their order
@45
Scenario: Access order tracking on mobile app
Given a user is authenticated on the mobile app
When the user navigates to the order tracking feature
Then the user should be able to view the delivery status of their order
@45
Scenario: View tracking information
Given a user is on the order tracking page
When the tracking information is displayed
Then it should include current status, estimated delivery time, and carrier details
@45
Scenario: Real-time tracking updates
Given a user is viewing the tracking information
When the order status is updated by the carrier
Then the system should update the tracking information in real-time
@45
Scenario: Receive notifications for status changes
Given a user has an order being tracked
When the status of the order changes
Then the user should receive a notification about the status change
@45
Scenario: Secure tracking access
Given an unauthenticated user tries to access order tracking
When the user attempts to view tracking information
Then the system should deny access and prompt for authentication
@45
Scenario: Error handling for tracking issues
Given a user encounters an issue with tracking
When an error occurs
Then the system should display a user-friendly error message
@45
Scenario: Logging tracking access and updates
Given a user accesses the order tracking feature
When the user views or updates tracking information
Then the system must log the access and updates for auditing purposes
@45
Scenario: Seamless integration with shipping carriers
Given the system is integrated with shipping carriers
When tracking information is fetched
Then the integration should be seamless and reliable