Feature: Prevent Unauthorized Access to Account Preferences
@TC-38
Scenario: Log in to the user account with restricted access
Given a user with User ID "67890" and restricted access
When the user attempts to log in
Then the user should be successfully logged in with restricted access
@TC-38
Scenario: Navigate to the account preferences page
Given the user is logged in with restricted access
When the user navigates to the account preferences page
Then access to account preferences should be denied
@TC-38
Scenario: Attempt to change the account password
Given the user is logged in with restricted access
When the user attempts to change the account password
Then the system should prevent password change and display an error message
@TC-38
Scenario: Verify system logs for unauthorized access attempt
Given the user attempted unauthorized access
When checking system logs
Then unauthorized attempt should be logged with user ID and timestamp
@TC-38
Scenario: Check for any security notifications sent to the user
Given the user attempted unauthorized access
When checking for security notifications
Then the user should receive a notification about the unauthorized attempt
@TC-38
Scenario: Attempt to access other restricted settings
Given the user is logged in with restricted access
When the user attempts to access other restricted settings
Then access should be denied for all restricted settings
@TC-38
Scenario: Verify the effectiveness of security measures
Given multiple unauthorized access attempts have been made
When evaluating security measures
Then security measures should effectively prevent unauthorized access
@TC-38
Scenario: Ensure user session is terminated after multiple unauthorized attempts
Given multiple unauthorized access attempts have been made
When checking user session status
Then session should be terminated to prevent further attempts
@TC-38
Scenario: Attempt to bypass security using different methods
Given the user is attempting to bypass security
When using different methods
Then all bypass attempts should be unsuccessful
@TC-38
Scenario: Check system response to unauthorized access from different devices
Given unauthorized access attempts from different devices
When assessing system response
Then system should consistently prevent access from all devices
@TC-38
Scenario: Verify user account lockout after repeated unauthorized attempts
Given repeated unauthorized access attempts
When checking account status
Then account should be locked after a specified number of attempts
@TC-38
Scenario: Check for any error messages during unauthorized access attempts
Given unauthorized access attempts are made
When reviewing system messages
Then clear error messages should be displayed for each attempt
@TC-38
Scenario: Ensure unauthorized access attempts are reported to admin
Given unauthorized access attempts are made
When checking admin notifications
Then admin should be notified of all unauthorized attempts
@TC-38
Scenario: Test system response to unauthorized access during peak times
Given unauthorized access attempts during peak times
When evaluating system performance
Then system should maintain security and prevent access during peak times
@TC-38
Scenario: Verify user feedback mechanism for reporting unauthorized attempts
Given unauthorized access attempts are made
When users attempt to report them
Then users should be able to report unauthorized attempts easily