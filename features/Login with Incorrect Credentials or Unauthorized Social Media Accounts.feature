Feature: Login with Incorrect Credentials or Unauthorized Social Media Accounts
@TC-8
Scenario: Attempt login with incorrect email and password
Given the user navigates to the login page
When the user attempts to login using email "wronguser@example.com" and password "wrongpassword"
Then the login should fail
And an error message "Invalid email or password." should be displayed
@TC-8
Scenario: Attempt login using unauthorized Google account
Given the user navigates to the login page
When the user attempts to login using an unauthorized Google account
Then the login should fail
And an error message "Google account not recognized." should be displayed
@TC-8
Scenario: Attempt login using unauthorized Facebook account
Given the user navigates to the login page
When the user attempts to login using an unauthorized Facebook account
Then the login should fail
And an error message "Facebook account not recognized." should be displayed
@TC-8
Scenario: Check account lockout after multiple failed attempts
Given the user has failed login attempts exceeding the allowed limit
Then the account should be locked
@TC-8
Scenario: Verify options for recovering a locked account
Given the account is locked
When the user checks for recovery options
Then account recovery options should be provided
@TC-8
Scenario: Attempt to login with valid credentials post-lockout
Given the account is locked
When the user attempts to login with valid credentials
Then the login should fail due to account lockout
@TC-8
Scenario: Check browser console for errors during login attempts
When the user attempts to login
Then no unexpected errors should be logged in the browser console
@TC-8
Scenario: Verify security measures such as CAPTCHA during login
Given multiple failed login attempts
Then CAPTCHA should be presented
@TC-8
Scenario: Attempt login from a different device with incorrect credentials
Given the user navigates to the login page on a different device
When the user attempts to login using incorrect credentials
Then the login should fail
And an error message should be displayed
@TC-8
Scenario: Check for system performance issues during failed login attempts
When the user attempts multiple failed logins
Then the system should perform efficiently without lag
@TC-8
Scenario: Verify the logout functionality after failed login attempts
Given the user has attempted multiple failed logins
Then the user should remain logged out