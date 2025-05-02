Feature: User Login
Scenario: Successful login with valid email and password
Given the user is on the login page
When the user enters a valid email and password
And clicks on the login button
Then the user should be redirected to their account homepage
Scenario: Unsuccessful login with invalid email
Given the user is on the login page
When the user enters an invalid email and a valid password
And clicks on the login button
Then an error message should be displayed indicating invalid email
Scenario: Unsuccessful login with invalid password
Given the user is on the login page
When the user enters a valid email and an invalid password
And clicks on the login button
Then an error message should be displayed indicating invalid password
Scenario: Unsuccessful login with both invalid email and password
Given the user is on the login page
When the user enters an invalid email and an invalid password
And clicks on the login button
Then an error message should be displayed indicating invalid credentials
Scenario: Unsuccessful login with empty email and password fields
Given the user is on the login page
When the user leaves the email and password fields empty
And clicks on the login button
Then an error message should be displayed indicating that fields cannot be empty
Scenario: Password reset option is available
Given the user is on the login page
When the user clicks on the "Forgot Password?" link
Then the user should be redirected to the password reset page
Scenario: Remember me option is available
Given the user is on the login page
When the user sees the "Remember Me" checkbox
Then the user should be able to select or deselect the checkbox
Scenario: Successful logout
Given the user is logged into their account
When the user clicks on the logout button
Then the user should be redirected to the login page