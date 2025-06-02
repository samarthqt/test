Feature: Login with Incorrect Credentials
@TC-298
Scenario: Attempt login with valid username and invalid password
Given the user navigates to the login page
When the user enters a valid username "user@example.com" and an invalid password "InvalidPassword123"
And clicks on the 'Login' button
Then the system displays an error message indicating incorrect password
@TC-298
Scenario: Attempt login with invalid username and password
Given the user navigates to the login page
When the user enters an invalid username and password
And clicks on the 'Login' button
Then the system displays an error message indicating invalid credentials
@TC-298
Scenario: Attempt login with empty username and password fields
Given the user navigates to the login page
When the user leaves the username and password fields empty
And clicks on the 'Login' button
Then the system prompts to enter valid credentials
@TC-298
Scenario: Attempt login with special characters in username
Given the user navigates to the login page
When the user enters a username with special characters
And clicks on the 'Login' button
Then the system displays an error message indicating invalid username format
@TC-298
Scenario: Attempt login with valid username and empty password
Given the user navigates to the login page
When the user enters a valid username "user@example.com" and leaves the password field empty
And clicks on the 'Login' button
Then the system prompts to enter a password
@TC-298
Scenario: Attempt login with valid username and incorrect password multiple times
Given the user navigates to the login page
When the user enters a valid username "user@example.com" and incorrect password multiple times
And clicks on the 'Login' button each time
Then the system locks the account after several failed attempts
@TC-298
Scenario: Check for password recovery option after failed login attempts
Given the user navigates to the login page
When the user fails to login multiple times
Then the password recovery option is available
@TC-298
Scenario: Attempt login with a password exceeding maximum length
Given the user navigates to the login page
When the user enters a valid username "user@example.com" and a password exceeding maximum length
And clicks on the 'Login' button
Then the system displays an error message indicating password length exceeded
@TC-298
Scenario: Verify CAPTCHA requirement after multiple failed login attempts
Given the user navigates to the login page
When the user fails to login multiple times
Then CAPTCHA is required after several failed login attempts
@TC-298
Scenario: Attempt login with incorrect credentials from a different IP address
Given the user navigates to the login page
When the user enters incorrect credentials from a different IP address
And clicks on the 'Login' button
Then the system displays an error message and logs the attempt
@TC-298
Scenario: Attempt login with an expired account
Given the user navigates to the login page
When the user enters credentials for an expired account
And clicks on the 'Login' button
Then the system displays an error message indicating account expiration
@TC-298
Scenario: Attempt login with a deactivated account
Given the user navigates to the login page
When the user enters credentials for a deactivated account
And clicks on the 'Login' button
Then the system displays an error message indicating account deactivation
@TC-298
Scenario: Attempt login with incorrect credentials during system maintenance
Given the user navigates to the login page
When the user enters incorrect credentials during system maintenance
And clicks on the 'Login' button
Then the system displays a maintenance notification and login is not possible