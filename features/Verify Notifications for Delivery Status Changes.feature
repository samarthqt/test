Feature: Verify Notifications for Delivery Status Changes
Ensure users receive notifications for any changes in delivery status. User must have a valid order with tracking enabled and notification settings turned on.
@TC-209
Scenario: User logs into the account
Given the user has a valid order ID "67890"
When the user logs into the account
Then the user should be successfully logged in
@TC-209
Scenario: User navigates to the 'Order History' section
When the user navigates to the 'Order History' section
Then the order history page should display all past and current orders
@TC-209
Scenario: User selects the order with tracking number XYZ789
Given the tracking number is "XYZ789"
When the user selects the order with tracking number XYZ789
Then the order details should be displayed, including tracking information
@TC-209
Scenario: User checks notification settings for the order
Given the notification email is "user@example.com"
And the notification phone is "+1234567890"
When the user checks notification settings for the order
Then notification settings should be enabled
@TC-209
Scenario: Simulate change in package status to 'Out for Delivery'
When a change in package status is simulated to 'Out for Delivery'
Then a notification should be sent to the user regarding the status change
@TC-209
Scenario: Verify email notification for status change
When the user checks the email notifications
Then an email notification should be received with the updated status
@TC-209
Scenario: Verify SMS notification for status change
When the user checks the SMS notifications
Then an SMS notification should be received with the updated status
@TC-209
Scenario: Simulate delivery completion
When delivery completion is simulated
Then a notification should be sent to the user regarding delivery completion
@TC-209
Scenario: Verify email notification for delivery completion
When the user checks the email notifications
Then an email notification should be received confirming delivery
@TC-209
Scenario: Verify SMS notification for delivery completion
When the user checks the SMS notifications
Then an SMS notification should be received confirming delivery
@TC-209
Scenario: User logs out of the account
When the user logs out of the account
Then the user should be successfully logged out
@TC-209
Scenario: User logs back into the account
When the user logs back into the account
Then the user should be successfully logged in again
@TC-209
Scenario: User navigates to the 'Order History' section again
When the user navigates to the 'Order History' section again
Then the order history page should display all past and current orders
@TC-209
Scenario: User selects the order with tracking number XYZ789 again
When the user selects the order with tracking number XYZ789 again
Then the order details should be displayed, including updated tracking information
@TC-209
Scenario: Verify notifications are logged in the notification history
When the user checks the notification history
Then the notification history should display all sent notifications for the order