Feature: Simultaneous Login Attempts from Different Locations
@TC-299
Scenario: Successful login from Location 1
Given a user account exists with username "user@example.com" and password "ValidPassword123"
When the user attempts to login from Location 1 (New York, USA) with valid credentials
Then the user is successfully logged in from Location 1
@TC-299
Scenario: Simultaneous login attempt from Location 2
Given the user is logged in from Location 1
When the user attempts to login from Location 2 (London, UK) with the same credentials
Then the system detects a simultaneous login attempt and prompts for verification
When the user completes the verification process for Location 2
Then the user is successfully logged in from Location 2
And the session from Location 1 remains active
@TC-299
Scenario: Simultaneous login attempt from Location 3 with verification failure
Given the user is logged in from Location 1 and Location 2
When the user attempts to login from Location 3 with the same credentials
Then the system prompts for verification due to multiple active sessions
When the user fails the verification process for Location 3
Then the user is not logged in from Location 3
@TC-299
Scenario: Logging out from Location 1
Given the user is logged in from Location 1 and Location 2
When the user logs out from Location 1
Then the user is logged out from Location 1
And the session from Location 2 remains active
@TC-299
Scenario: Login from a different device at Location 2
Given the user is logged in from Location 2
When the user attempts to login from a different device at Location 2
Then the system prompts for verification due to device change
When the user completes the verification process for the new device
Then the user is successfully logged in from the new device at Location 2
@TC-299
Scenario: Login attempt from Location 4 with incorrect credentials
When the user attempts to login from Location 4 with incorrect credentials
Then the system displays an error message indicating incorrect credentials
@TC-299
Scenario: Login from Location 4 with correct credentials after failed attempts
Given multiple failed login attempts from Location 4
When the user attempts to login from Location 4 with correct credentials
Then the system prompts for additional verification due to previous failed attempts
@TC-299
Scenario: Monitoring system logs for simultaneous login attempts
When monitoring system logs for login attempts
Then the system logs capture all login attempts with timestamps and locations
@TC-299
Scenario: Security alerts for simultaneous login attempts
When checking for security alerts generated due to simultaneous login attempts
Then security alerts are generated and sent to the user's registered email or phone
@TC-299
Scenario: Session timeout behavior for multiple active sessions
Given multiple active sessions
When verifying session timeout behavior
Then sessions time out independently based on inactivity