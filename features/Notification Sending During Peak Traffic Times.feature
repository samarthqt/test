Feature: Notification Sending During Peak Traffic Times
@TC-326
Scenario: Simulate peak traffic conditions
Given I have access to the system during peak traffic times
When I simulate peak traffic conditions using appropriate tools
Then Peak traffic conditions are successfully simulated
@TC-326
Scenario: Navigate to the notification system dashboard
Given I am on the system homepage
When I navigate to the notification system dashboard
Then User is successfully navigated to the dashboard
@TC-326
Scenario: Create a new notification
Given I am on the notification system dashboard
When I select "Create New Notification"
Then Notification creation form is displayed
@TC-326
Scenario: Enter valid email format in the email field
Given I am on the notification creation form
When I enter valid email format "user@example.com" in the email field
Then Email format is accepted without errors
@TC-326
Scenario: Enter valid SMS format in the SMS field
Given I am on the notification creation form
When I enter valid SMS format "+1234567890" in the SMS field
Then SMS format is accepted without errors
@TC-326
Scenario: Send notification during peak traffic
Given I have entered valid email and SMS formats
When I attempt to send the notification during peak traffic
Then Notification should be sent successfully, albeit with potential delays
@TC-326
Scenario: Monitor system performance metrics during notification sending
Given Notification is being sent during peak traffic
When I monitor system performance metrics
Then System performance metrics should indicate load but no critical failures
@TC-326
Scenario: Check system logs for errors or exceptions
Given Notification has been sent during peak traffic
When I check system logs for any errors or exceptions
Then Logs should not contain critical errors
@TC-326
Scenario: Verify notification delivery to recipients
Given Notification has been sent during peak traffic
When I verify notification delivery to the intended recipients
Then Recipients should receive the notification successfully
@TC-326
Scenario: Assess system recovery time post-peak traffic
Given Peak traffic has subsided
When I assess system recovery time
Then System should recover to normal performance levels quickly
@TC-326
Scenario: Repeat notification sending during non-peak times
Given I am sending notifications during non-peak times
When I send the notification
Then Notifications should be sent more quickly during non-peak times
@TC-326
Scenario: Verify system scalability during peak load
Given The system is under peak load
When I verify system scalability
Then System should scale resources appropriately to handle peak load
@TC-326
Scenario: Ensure system stability during peak traffic
Given The system is under peak traffic conditions
When I ensure system stability
Then System should remain stable and responsive
@TC-326
Scenario: Verify user feedback during delays
Given Notification sending might be delayed
When I verify user feedback
Then User should receive feedback about potential delays
@TC-326
Scenario: Check for unhandled exceptions during peak traffic
Given The system is under peak traffic conditions
When I check for any unhandled exceptions
Then No unhandled exceptions should be present