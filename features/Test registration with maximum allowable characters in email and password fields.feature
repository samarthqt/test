Feature: Test registration with maximum allowable characters in email and password fields
@TC-329
Scenario: Verify registration with maximum allowable characters in email and password fields
Given the user registration page is accessible
When the user navigates to the registration page of the application
Then the registration page is displayed
@TC-329
Scenario: Enter maximum allowable characters in email and password fields
Given the maximum character limits for email and password fields are understood
When the user enters the maximum allowable characters in the email field
Then the email is entered successfully
When the user enters the maximum allowable characters in the password field
Then the password is entered successfully
@TC-329
Scenario: Complete registration with valid data
Given all required registration fields are filled with valid data
When the user clicks on the 'Register' button
Then the registration process is initiated
@TC-329
Scenario: Verify registration confirmation
When the registration confirmation message is displayed
Then the registration confirmation message is displayed
When the user verifies the email received for registration confirmation
Then the email confirmation is received successfully
@TC-329
Scenario: Log in using registered credentials
When the user attempts to log in using the registered email and password
Then the user is able to log in successfully
@TC-329
Scenario: Check user profile for registration details
When the user checks the user profile for registration details
Then the user profile displays correct registration details
@TC-329
Scenario: Verify email and password storage
When the system stores the email and password
Then the email and password are stored completely
@TC-329
Scenario: Log out from the application
When the user logs out from the application
Then the user is logged out successfully
@TC-329
Scenario: Reset password using registered email
When the user attempts to reset the password using the registered email
Then the password reset link is sent to the email
@TC-329
Scenario: Verify password reset functionality
When the user resets the password using the maximum allowable characters
Then the password reset is successful
@TC-329
Scenario: Check system logs for errors during registration
When the system logs are checked for errors during registration
Then no errors are logged in the system
@TC-329
Scenario: Ensure registration data encryption in the database
When the registration data is stored in the database
Then the registration data is encrypted