Feature: Access Order Tracking with Invalid Credentials
@TC-345
Scenario: Attempt to log in to the web platform using invalid credentials
Given the user has an account with invalid credentials
When the user attempts to log in using the username "invalid_user"
Then the error message "Invalid username or password" is displayed
@TC-345
Scenario: Attempt to log in to the mobile app using invalid credentials
Given the user has an account with invalid credentials
When the user attempts to log in using the password "wrong_password"
Then the error message "Invalid username or password" is displayed in the mobile app
@TC-345
Scenario: Check the login attempt limit on the web platform
Given the user attempts to log in multiple times with invalid credentials
When the login attempts exceed the limit
Then the user is prevented from logging in
@TC-345
Scenario: Check the login attempt limit on the mobile app
Given the user attempts to log in multiple times with invalid credentials on the mobile app
When the login attempts exceed the limit
Then the user is prevented from logging in
@TC-345
Scenario: Verify account lockout mechanism after consecutive failed attempts
Given the user attempts to log in consecutively with invalid credentials
When the failed attempts exceed the limit
Then the account is temporarily locked
@TC-345
Scenario: Attempt to reset the password using invalid credentials
Given the user attempts to reset the password with invalid credentials
When the reset attempt is made
Then the error message "Invalid username or email" is displayed
@TC-345
Scenario: Check if error messages are consistent across web and mobile platforms
Given the user receives error messages on both web and mobile platforms
When the error messages are displayed
Then they are consistent across both platforms
@TC-345
Scenario: Verify that no order tracking information is accessible
Given the user has invalid credentials
When the user attempts to access order tracking information
Then the information is inaccessible
@TC-345
Scenario: Attempt to access order tracking using a locked account
Given the account is locked due to exceeded invalid login attempts
When the user attempts to access order tracking
Then the error message "Account is locked" is displayed
@TC-345
Scenario: Check system logs for invalid login attempts
Given multiple invalid login attempts are made
When the system logs are checked
Then the invalid login attempts are recorded with timestamps
@TC-345
Scenario: Verify system performance during multiple invalid login attempts
Given multiple invalid login attempts are made
When the system handles these attempts
Then there is no performance degradation
@TC-345
Scenario: Attempt to log in using valid credentials after account lockout period
Given the account lockout period has ended
When the user logs in using valid credentials
Then the login is successful
@TC-345
Scenario: Check for security alerts triggered by invalid login attempts
Given multiple invalid login attempts are made
When the system checks for security alerts
Then alerts are triggered and logged
@TC-345
Scenario: Verify the user is guided to recover their account after failed login attempts
Given the user has failed login attempts
When the user is presented with recovery options
Then the user is guided to recover their account
@TC-345
Scenario: Log out from the web and mobile platforms
Given the user is logged in on both platforms
When the user logs out
Then the user is successfully logged out from both platforms