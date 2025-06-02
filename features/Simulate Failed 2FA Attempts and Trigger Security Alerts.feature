Feature: Simulate Failed 2FA Attempts and Trigger Security Alerts
@TC-248
Scenario: Simulate failed 2FA attempts and verify security alerts are triggered
Given a user account exists with 2FA enabled
When the user navigates to the login page
Then the user is directed to the login page
@TC-248
Scenario: Enter valid username and password
Given the user is on the login page
When the user enters valid username and password
Then the credentials are accepted
@TC-248
Scenario: Enter an invalid 2FA code and attempt to login
Given the user has entered valid credentials
When the user enters an invalid 2FA code "654321" and attempts to login
Then the login attempt fails due to invalid 2FA code
@TC-248
Scenario: Observe system behavior for failed 2FA attempt
Given the user has attempted to login with an invalid 2FA code
When observing the system behavior
Then the system handles the failed attempt correctly
@TC-248
Scenario: Verify security alert is triggered for failed attempt
Given a failed 2FA attempt has occurred
When checking for security alerts
Then a security alert is sent to the user
@TC-248
Scenario: Check system logs for failed 2FA attempt events
Given a failed 2FA attempt has occurred
When checking the system logs
Then failed attempt events are logged
@TC-248
Scenario: Attempt multiple failed 2FA logins in succession
Given multiple failed 2FA attempts are made in succession
When checking for security alerts
Then a security alert is triggered for each failed attempt
@TC-248
Scenario: Verify system response time for security alerts
Given a failed 2FA attempt has occurred
When checking the response time for security alerts
Then security alerts are sent promptly
@TC-248
Scenario: Check if user account is temporarily locked after multiple failed attempts
Given multiple failed 2FA attempts have occurred
When checking the user account status
Then the user account is locked after multiple failures
@TC-248
Scenario: Test login attempts on different devices
Given the user attempts to login on mobile and desktop devices
When observing login behavior
Then login behavior is consistent across devices
@TC-248
Scenario: Review system behavior under stable network conditions
Given stable network conditions
When observing system behavior
Then the system handles network conditions gracefully
@TC-248
Scenario: Verify user can reset account lock after failed attempts
Given the user account is locked after failed attempts
When the user attempts to reset the account lock
Then the user can reset the account lock
@TC-248
Scenario: Ensure user is notified of account lock and reset procedures
Given the user account is locked
When checking for notifications
Then the user receives notification of lock and reset procedures
@TC-248
Scenario: Check if system provides guidance for correct 2FA code entry
Given the user is attempting to enter a 2FA code
When checking for guidance
Then the system provides guidance for correct code entry
@TC-248
Scenario: Test system response to failed attempts under unstable network conditions
Given unstable network conditions
When observing system response to failed attempts
Then the system handles network instability gracefully