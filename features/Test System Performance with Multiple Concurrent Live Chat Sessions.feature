Feature: Test System Performance with Multiple Concurrent Live Chat Sessions
@TC-102
Scenario: Log in to the user account using valid credentials
Given the live chat feature is enabled
When the user logs in using valid credentials
Then the user is successfully logged in
@TC-102
Scenario: Navigate to the live chat section of the application
Given the user is logged in
When the user navigates to the live chat section
Then the user is directed to the live chat page
@TC-102
Scenario: Initiate a live chat session
Given the user is on the live chat page
When the user initiates a live chat session
Then the live chat session is successfully initiated
@TC-102
Scenario: Simulate multiple concurrent live chat sessions
Given the session simulator is available
When multiple concurrent live chat sessions are simulated
Then the system handles multiple concurrent sessions without performance degradation
@TC-102
Scenario: Verify system response time for each chat session
Given multiple concurrent sessions are active
When the system response time is measured for each chat session
Then the response time remains within acceptable limits for all sessions
@TC-102
Scenario: Check system logs for errors related to chat session handling
Given multiple concurrent sessions are active
When the system logs are checked
Then no errors related to chat session handling are logged
@TC-102
Scenario: Verify system behavior when maximum concurrent sessions are reached
Given the maximum number of concurrent sessions is reached
When the system behavior is observed
Then the system gracefully handles the maximum session limit without crashing
@TC-102
Scenario: Attempt to initiate additional sessions beyond the maximum limit
Given the maximum session limit is reached
When additional sessions are attempted
Then the system prevents initiation of additional sessions beyond the limit
@TC-102
Scenario: Check if the system prioritizes sessions based on user role or importance
Given multiple concurrent sessions are active
When session prioritization is checked
Then sessions are prioritized correctly if applicable
@TC-102
Scenario: Verify system notifications for users when session limits are reached
Given the maximum session limit is reached
When session limits are reached
Then users receive notifications if session limits are reached
@TC-102
Scenario: Monitor system resource usage during multiple concurrent sessions
Given multiple concurrent sessions are active
When system resource usage is monitored
Then resource usage remains within acceptable limits
@TC-102
Scenario: Attempt to end all sessions simultaneously
Given multiple concurrent sessions are active
When all sessions are ended simultaneously
Then the system handles simultaneous session termination gracefully
@TC-102
Scenario: Check system recovery time after handling maximum concurrent sessions
Given the maximum number of concurrent sessions was reached
When the system recovery time is checked
Then the system recovery time is within acceptable limits
@TC-102
Scenario: Verify system performance during business hours compared to outside business hours
Given the system is active during business and outside business hours
When system performance is compared
Then system performance is consistent across different times
@TC-102
Scenario: Attempt to initiate sessions using different user roles
Given different user roles are available
When sessions are initiated using different user roles
Then system response is consistent across different user roles