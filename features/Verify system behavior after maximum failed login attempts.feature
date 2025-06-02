Feature: Verify system behavior after maximum failed login attempts
@TC-56
Scenario: User account is locked after maximum failed login attempts
Given the user account "test_user" exists in the system
And the maximum failed login attempts limit is configured to 5
When the user opens the login page
Then the login page is displayed
@TC-56
Scenario: Enter incorrect credentials until account is locked
Given the username "test_user"
And the password "incorrect_password"
When the user enters the username "test_user"
And enters the password "incorrect_password"
And clicks the "Login" button
Then the system displays an error message indicating incorrect credentials
When the user repeats the login attempt 5 times
Then the system locks the user account after the fifth attempt
@TC-56
Scenario: Attempt to login with correct credentials after account lock
Given the user account is locked
When the user attempts to login using correct credentials
Then the system displays a message indicating the account is locked
@TC-56
Scenario: Verify account status in admin panel after lock
Given the user account is locked
When the admin checks the account status in the admin panel
Then the account is marked as locked
@TC-56
Scenario: Request password recovery for locked account
Given the user account is locked
When the user requests password recovery for the locked account
Then the system sends a recovery email to the user
@TC-56
Scenario: Unlock account using recovery options
Given the user has received a recovery email
When the user attempts to unlock the account using recovery options
Then the account is unlocked and the user can log in successfully
@TC-56
Scenario: Verify login attempt logs in the system
Given the user account was locked after 5 failed attempts
When the admin verifies login attempt logs in the system
Then logs show 5 failed attempts followed by account lock
@TC-56
Scenario: Check system notifications for account lock
Given the user account is locked
When the system sends notification of account lock to the user
Then the user receives the account lock notification
@TC-56
Scenario: Verify account status change after successful recovery
Given the user has successfully recovered the account
When the admin verifies the account status change
Then the account status is updated to active
@TC-56
Scenario: Attempt login with incorrect credentials after account unlock
Given the user account is unlocked
When the user attempts login with incorrect credentials
Then the system displays incorrect credentials message
@TC-56
Scenario: Verify system behavior for concurrent failed login attempts
Given multiple users attempt to login with incorrect credentials concurrently
When the system verifies login attempts
Then the system locks account after reaching maximum attempts
@TC-56
Scenario: Check system logs for concurrent login attempts
Given multiple users attempted to login concurrently
When the admin checks system logs for concurrent login attempts
Then logs accurately reflect concurrent failed attempts