Feature: Test login functionality with maximum allowed concurrent users
@TC-9
Scenario: Verify the system handles the maximum number of concurrent user logins without performance degradation
Given the application login page is displayed
And user accounts are set up and active
When User 1 enters valid credentials and clicks 'Login'
Then User 1 is successfully logged in and redirected to the dashboard
@TC-9
Scenario: Verify multiple users can log in concurrently
Given User 1 is logged in
When User 2 enters valid credentials and clicks 'Login'
Then User 2 is successfully logged in and redirected to the dashboard
@TC-9
Scenario: Verify login with maximum concurrent users
Given multiple users are logging in
When the maximum concurrent user limit is reached
Then all users are able to log in successfully without errors
And system performance remains stable with acceptable response times
@TC-9
Scenario: Verify system response when exceeding maximum concurrent user limit
Given the maximum concurrent user limit is reached
When an additional user attempts to log in
Then the system displays an error message indicating maximum user limit reached
@TC-9
Scenario: Verify login after user logout
Given a user is logged out
When a new user attempts to log in
Then the new user is able to log in successfully
@TC-9
Scenario: Verify session management and user activity tracking
When checking active sessions
Then all active sessions are tracked accurately and terminated upon logout
@TC-9
Scenario: Verify system logs during concurrent logins
When checking system logs
Then no unexpected errors or warnings are recorded in the system logs
@TC-9
Scenario: Evaluate user experience during peak concurrent usage
When users navigate and interact with the system
Then users experience smooth navigation and interaction without delays
@TC-9
Scenario: Test system recovery after reaching maximum user limit
Given the system has reached the maximum user limit
When the user count decreases below the limit
Then the system returns to normal operation
@TC-9
Scenario: Check database for accurate session records
When checking the database for session records
Then the database accurately reflects active and inactive sessions
@TC-9
Scenario: Verify security protocols during concurrent logins
When concurrent logins occur
Then security protocols are enforced without compromise
@TC-9
Scenario: Test system alerts for unauthorized access attempts
When an unauthorized access attempt occurs
Then alerts are triggered for any unauthorized access attempts
@TC-9
Scenario: Ensure logout functionality works correctly under load
When users attempt to log out
Then users can log out successfully without issues