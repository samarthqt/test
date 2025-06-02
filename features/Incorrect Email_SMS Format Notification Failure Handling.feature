Feature: Incorrect Email/SMS Format Notification Failure Handling
@TC-325
Scenario: Navigate to the notification system dashboard
Given the user accesses the notification system
When the user navigates to the notification system dashboard
Then the user should be successfully navigated to the dashboard
@TC-325
Scenario: Create a new notification with incorrect email format
Given the user is on the notification system dashboard
When the user selects "Create New Notification"
Then the notification creation form should be displayed
When the user enters incorrect email format "invalid.email.com" in the email field
Then the system should validate the email format and display an error message
@TC-325
Scenario: Create a new notification with incorrect SMS format
Given the notification creation form is displayed
When the user enters incorrect SMS format "1234abc" in the SMS field
Then the system should validate the SMS format and display an error message
@TC-325
Scenario: Attempt to send notification with incorrect formats
Given the user has entered incorrect email and SMS formats
When the user attempts to send the notification
Then the notification sending should be blocked due to incorrect formats
@TC-325
Scenario: Check error logs for incorrect format messages
Given the notification sending is blocked
When the user checks the error logs
Then the error logs should contain messages about the incorrect formats
@TC-325
Scenario Outline: Repeat steps with various incorrect formats
Given the user is on the notification creation form
When the user enters incorrect email format "<email>" in the email field
And the user enters incorrect SMS format "<sms>" in the SMS field
And the user attempts to send the notification
Then similar error messages should be displayed for the incorrect formats
Examples:
| email               | sms                |
| missing@domain      | +123456            |
| user@domain.c       | phone@domain.com   |
@TC-325
Scenario: Verify system behavior with multiple incorrect formats
Given the user enters multiple incorrect formats simultaneously
When the user attempts to send the notification
Then the system should handle multiple errors gracefully and display appropriate messages
@TC-325
Scenario: Send notifications with correct formats
Given the user enters correct email and SMS formats
When the user attempts to send the notification
Then the notifications should be sent successfully without errors
@TC-325
Scenario: Check system logs for unhandled exceptions
Given the notifications are sent successfully
When the user checks the system logs
Then no unhandled exceptions should be present
@TC-325
Scenario: Ensure system stability after handling errors
Given the system has handled errors
When the user interacts with the system
Then the system should return to a stable and responsive state
@TC-325
Scenario: Verify user feedback for format errors
Given the user has entered incorrect email or SMS formats
When the system displays error messages
Then the user should receive clear and informative feedback about the error