Feature: Test session expiration after a period of inactivity
@TC-88
Scenario: Verify user session expiration after inactivity
Given User is logged into the system using valid credentials
When User navigates to the dashboard and performs no action
Then Dashboard is displayed without any interaction
@TC-88
Scenario: Wait for inactivity period and verify session expiration
Given User remains inactive for 30 minutes
When User attempts to perform an action after 30 minutes
Then User session expires and is redirected to the login page
And Notification is displayed indicating session expiration
@TC-88
Scenario: Re-login after session expiration
Given User session has expired
When User attempts to log in again
Then User successfully logs in again
@TC-88
Scenario: Verify session expiration setting in configuration
Given Session timeout configuration is accessible
Then Session timeout is correctly set to 30 minutes
@TC-88
Scenario: Check system logs for session expiration events
Given System logs are accessible
Then Logs contain entries for session expiration at the 30-minute mark
@TC-88
Scenario: Repeat inactivity test with different timeout setting
Given Session timeout configuration is set to 15 minutes
When User remains inactive for 15 minutes
Then User session expires after 15 minutes of inactivity
@TC-88
Scenario: Attempt to access restricted page after session expiration
Given User session has expired
When User attempts to access a restricted page
Then Access is denied and redirected to the login page
@TC-88
Scenario: Verify session expiration handling in different browsers
Given Different browsers are used to access the system
Then Session expiration behaves consistently across different browsers
@TC-88
Scenario: Check for error messages during session expiration
Given User session expires
Then No error messages are displayed during session expiration
@TC-88
Scenario: Test session expiration with multiple user accounts
Given Multiple user accounts are logged in simultaneously
When Users remain inactive for the specified inactivity period
Then All sessions expire correctly after the inactivity period
@TC-88
Scenario: Verify session expiration handling on mobile devices
Given Mobile devices are used to access the system
Then Session expiration behaves consistently on mobile devices
@TC-88
Scenario: Check for security vulnerabilities related to session expiration
Given Session expiration occurs
Then Session expiration does not expose any security vulnerabilities