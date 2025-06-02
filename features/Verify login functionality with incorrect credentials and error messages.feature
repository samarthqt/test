Feature: Verify login functionality with incorrect credentials and error messages
@TC-86
Scenario: Attempt login with incorrect email and password
Given the user navigates to the login page
When the user enters an email "invaliduser@example.com" and password "WrongPass123"
And clicks on the 'Login' button
Then the system displays an error message indicating incorrect credentials
And the error message clearly states the reason for login failure
@TC-86
Scenario: Attempt login with valid email but incorrect password
Given the user navigates to the login page
When the user enters a valid email and incorrect password "WrongPass123"
And clicks on the 'Login' button
Then the system displays an error message indicating incorrect password
@TC-86
Scenario: Attempt login with incorrect email but correct password
Given the user navigates to the login page
When the user enters an incorrect email "invaliduser@example.com" and correct password
And clicks on the 'Login' button
Then the system displays an error message indicating incorrect email
@TC-86
Scenario: Check error message for empty email field
Given the user navigates to the login page
When the user leaves the email field empty
And clicks on the 'Login' button
Then the system prompts to enter email
@TC-86
Scenario: Check error message for empty password field
Given the user navigates to the login page
When the user leaves the password field empty
And clicks on the 'Login' button
Then the system prompts to enter password
@TC-86
Scenario: Attempt login with incorrect credentials multiple times
Given the user navigates to the login page
When the user enters incorrect credentials multiple times
Then the system displays consistent error messages for each attempt
@TC-86
Scenario: Verify system behavior after multiple failed login attempts
Given the user navigates to the login page
When the user attempts login with incorrect credentials multiple times
Then the system triggers security measures after several failed attempts
@TC-86
Scenario: Check for accessibility of error messages
Given the user navigates to the login page
When the user attempts login with incorrect credentials
Then error messages are accessible and clearly visible
@TC-86
Scenario: Attempt login with valid credentials after failed attempts
Given the user navigates to the login page
When the user enters valid credentials
Then the user is able to log in successfully with correct credentials
@TC-86
Scenario: Verify error message on mobile devices
Given the user navigates to the login page on a mobile device
When the user attempts login with incorrect credentials
Then error messages are displayed correctly on mobile devices
@TC-86
Scenario: Check error message for login attempt without internet connection
Given the user navigates to the login page
When the user attempts login without internet connection
Then the system displays an error message indicating network issue
@TC-86
Scenario: Verify system logs for failed login attempts
Given the user navigates to the login page
When the user attempts login with incorrect credentials
Then system logs contain records of failed login attempts