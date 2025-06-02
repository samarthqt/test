Feature: Verify notification of delivery status changes via email/SMS
@TC-200
Scenario: User receives notification for delivery status change to 'In Transit'
Given the user has an active account with email "user@example.com" and phone number "+1234567890"
And the user has logged in with valid credentials
And the user has placed an order with ID 12345
When the user navigates to the 'Order History' section
And selects the order with ID 12345 to view its details
And simulates a change in the delivery status to 'In Transit'
Then the system updates the delivery status to 'In Transit'
And an email notification is received indicating the status change to 'In Transit'
And an SMS notification is received indicating the status change to 'In Transit'
@TC-200
Scenario: User receives notification for delivery status change to 'Delivered'
Given the delivery status of order ID 12345 is 'In Transit'
When the delivery status is changed to 'Delivered'
Then the system updates the delivery status to 'Delivered'
And an email notification is received indicating the status change to 'Delivered'
And an SMS notification is received indicating the status change to 'Delivered'
@TC-200
Scenario: Verify notification logs and content accuracy
Given the notifications for order ID 12345 have been sent
When the user checks the notification logs in the system
Then log entries confirm the delivery of email and SMS notifications for each status change
And notifications include order ID, new status, and timestamp of the update
@TC-200
Scenario: Handle failed delivery status update gracefully
Given the system is simulating a failed delivery status update
When the failure occurs
Then the system handles the failure gracefully and retries sending the notification
@TC-200
Scenario: Verify no duplicate notifications are sent
Given multiple status changes have occurred for order ID 12345
When checking the notifications sent
Then each status change results in a single email and SMS notification
@TC-200
Scenario: Notifications are sent to updated contact information
Given the user updates their email to "newuser@example.com" and phone number to "+0987654321"
When the notification process is repeated
Then notifications are sent to the updated email and phone number
@TC-200
Scenario: No notifications are sent to deactivated accounts
Given the user's account is deactivated
When a delivery status change occurs
Then no notifications are sent to the deactivated account