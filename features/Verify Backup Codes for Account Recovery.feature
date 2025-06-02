Feature: Verify Backup Codes for Account Recovery
@TC-247
Scenario: Verify backup codes are provided and can be used for account recovery when 2FA is enabled
Given the user account exists
And 2FA is enabled for the account
When the user navigates to the login page
Then the user is directed to the login page
@TC-247
Scenario: Login with valid username and password
Given the user is on the login page
When the user enters valid username and password
Then the credentials are accepted
@TC-247
Scenario: Attempt to login without 2FA code
Given the user has entered valid credentials
When the user attempts to login without 2FA code
Then the system prompts for 2FA code
@TC-247
Scenario: Select 'Use backup code' option
Given the system prompts for 2FA code
When the user selects 'Use backup code' option
Then the backup code entry field is displayed
@TC-247
Scenario: Enter a valid backup code
Given the backup code entry field is displayed
When the user enters a valid backup code
Then the backup code is accepted
@TC-247
Scenario: Verify successful login using the backup code
Given the backup code is accepted
When the user logs in using the backup code
Then the user is logged in successfully
@TC-247
Scenario: Check if backup code is marked as used
Given the user has logged in successfully
When the backup code is checked for usage
Then the backup code is marked as used
@TC-247
Scenario: Attempt login with an already used backup code
Given the backup code is marked as used
When the user attempts login with an already used backup code
Then an error message is displayed for used code
@TC-247
Scenario: Verify unused backup codes remain valid
Given there are unused backup codes
When the user attempts login with an unused backup code
Then the unused codes are valid for login
@TC-247
Scenario: Check system logs for backup code usage events
Given the user has used a backup code for login
When the system logs are checked
Then backup code usage events are logged
@TC-247
Scenario: Test login attempts on different devices
Given the user has valid backup codes
When the user attempts login on mobile and desktop devices
Then login behavior is consistent across devices
@TC-247
Scenario: Verify system prompts for new backup code generation if all codes are used
Given all backup codes are used
When the user attempts to generate a new backup code
Then the system prompts for new code generation
@TC-247
Scenario: Ensure user is directed to retry login with a valid backup code
Given the user has attempted login with an invalid backup code
When the system prompts the user
Then the user is directed to retry login with a valid backup code
@TC-247
Scenario: Review system behavior under stable network conditions
Given the user is attempting login
When the network conditions are stable
Then the system handles network conditions gracefully
@TC-247
Scenario: Verify user can view remaining backup codes in account settings
Given the user is logged into their account
When the user navigates to account settings
Then the user can view remaining backup codes