Feature: Verify notifications are sent via email and SMS using SendGrid or Twilio
@TC-324
Scenario: Verify notifications are sent via both email and SMS
Given User "Emily Davis" has a valid account with email "emily@example.com" and phone number "+1234567890"
When User logs into the application using valid credentials
Then User is successfully logged in and navigated to the homepage
@TC-324
Scenario: Navigate to notification settings
Given User is on the homepage
When User navigates to notification settings
Then Notification settings page is displayed with options for email and SMS notifications
@TC-324
Scenario: Verify email and phone number registration
Given User is on the notification settings page
When User ensures email and phone number are correctly registered
Then Email and phone number are verified and saved
@TC-324
Scenario: Trigger notifications by placing an order
Given User is on the homepage
When User places an order
Then Order is successfully placed and notifications are triggered
@TC-324
Scenario: Verify email notification is sent using SendGrid
Given Notifications are triggered
When User checks for email notification
Then Email notification is received with order details
@TC-324
Scenario: Verify SMS notification is sent using Twilio
Given Notifications are triggered
When User checks for SMS notification
Then SMS notification is received with order details
@TC-324
Scenario: Check format and content of email notification
Given Email notification is received
When User checks the format and content of the email notification
Then Email notification is correctly formatted and contains accurate order information
@TC-324
Scenario: Check format and content of SMS notification
Given SMS notification is received
When User checks the format and content of the SMS notification
Then SMS notification is correctly formatted and contains accurate order information
@TC-324
Scenario: Verify logging of notification delivery status
Given Notifications are sent
When User verifies logging of notification delivery status
Then Notification delivery status is logged for auditing purposes
@TC-324
Scenario: Log out from the application
Given User is on the homepage
When User logs out from the application
Then User is successfully logged out
@TC-324
Scenario: Re-log into the application and check notification history
Given User is logged out
When User re-logs into the application and navigates to notification history
Then Notification history displays recent notifications with delivery status
@TC-324
Scenario: Resend notifications if delivery fails
Given Notifications have a delivery status
When User attempts to resend notifications if delivery fails
Then System allows resending of notifications and logs the attempt
@TC-324
Scenario: Edit notification preferences to disable SMS
Given User is on the notification settings page
When User edits notification preferences to disable SMS
Then SMS notifications are disabled and only email notifications are sent
@TC-324
Scenario: Verify notification settings after placing another order
Given SMS notifications are disabled
When User places another order
Then Only email notification is sent for the new order
@TC-324
Scenario: Verify system response when email sending fails
Given Email notification is expected
When Email sending fails
Then System logs the failure and provides options to retry or contact support