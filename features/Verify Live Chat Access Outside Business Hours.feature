Feature: Verify Live Chat Access Outside Business Hours
@TC-100
Scenario: Verify login to user account using valid credentials
Given the user has valid account credentials
When the user logs in to the application
Then the user should be successfully logged in
@TC-100
Scenario: Navigate to live chat section
Given the user is logged in
When the user navigates to the live chat section of the application
Then the user should be directed to the live chat page
@TC-100
Scenario: Attempt to start a live chat session outside business hours
Given the user is on the live chat page
When the user attempts to start a live chat session outside business hours
Then the system should display a message indicating live chat is unavailable outside business hours
@TC-100
Scenario: Verify the message content and clarity
Given the system displays a message for unavailable live chat
When the user reads the message
Then the message should clearly state the business hours and alternative contact options
@TC-100
Scenario: Check for alternative support options
Given the live chat is unavailable outside business hours
When the user checks for alternative support options
Then the system should offer alternative support options such as email or phone support
@TC-100
Scenario: Attempt to access live chat URL directly via browser
Given the user has the live chat URL
When the user attempts to access the live chat URL directly via browser
Then access should be restricted and the unavailable message should be displayed
@TC-100
Scenario: Verify if the chat button is disabled outside business hours
Given the user is on the live chat page outside business hours
When the user checks the chat button
Then the chat button should be disabled and not clickable
@TC-100
Scenario: Check system logs for any errors related to chat access attempts
Given the user attempts to access live chat outside business hours
When the system logs are checked
Then no errors should be logged and access attempts should be recorded as expected
@TC-100
Scenario: Verify system behavior during business hours
Given the user is on the live chat page during business hours
When the user attempts to access live chat
Then live chat should be accessed successfully
@TC-100
Scenario: Attempt to schedule a live chat session outside business hours
Given the user is on the live chat page outside business hours
When the user attempts to schedule a live chat session
Then the system should not allow scheduling outside business hours
@TC-100
Scenario: Check business hours display in application settings
Given the user accesses application settings
When the user checks the business hours display
Then business hours should be displayed accurately and can be updated if necessary
@TC-100
Scenario: Verify user notifications for live chat availability changes
Given the business hours have changed
When the user checks notifications
Then users should receive notifications if business hours change
@TC-100
Scenario: Access live chat using different user roles
Given different user roles exist
When users attempt to access live chat outside business hours
Then the system response should be consistent across different user roles
@TC-100
Scenario: Check system logs for user attempts to access chat outside business hours
Given the user attempts to access chat outside business hours
When the system logs are checked
Then user attempts should be logged correctly in the system
@TC-100
Scenario: Verify system performance during and outside business hours
Given the system is operational
When the system performance is compared during business hours and outside business hours
Then system performance should be unaffected by changes in business hours