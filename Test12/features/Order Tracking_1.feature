Feature: Order Tracking
Users can track order delivery via website/app, cancel/return orders per merchant policy. Users should receive tracking numbers for shipped orders. The system must update order status in real-time. Users should be able to cancel or return orders following merchant policies. Notifications should be sent for status updates. The system should handle tracking errors and notify users appropriately.
@44
Scenario: User receives tracking number for shipped order
Given an order has been shipped
When the user views the order details
Then the user should see a tracking number for the order
@44
Scenario: Order status updates in real-time
Given an order is in transit
When the order status changes
Then the system should update the order status in real-time
@44
Scenario: User cancels an order following merchant policy
Given an order is eligible for cancellation
When the user requests to cancel the order
Then the order should be canceled according to merchant policy
@44
Scenario: User returns an order following merchant policy
Given an order is eligible for return
When the user requests to return the order
Then the order should be returned according to merchant policy
@44
Scenario: Notification sent for order status update
Given an order status has changed
When the system updates the status
Then the user should receive a notification about the status update
@44
Scenario: Handling tracking errors
Given there is an error in tracking the order
When the user attempts to track the order
Then the system should notify the user about the tracking error