Feature: Unsuccessful Login with Incorrect Username
@TC-4
Scenario: Attempt login with an incorrect username and verify that login is unsuccessful
Given the user account is created and activated
When the user navigates to the login page of the application
Then the login page is displayed with username and password fields
When the user enters "incorrect_user" in the username field
And the user enters "valid_password" in the password field
And the user clicks on the "Login" button
Then the system processes the login request
And the login attempt is unsuccessful
And an error message is displayed
And the error message is clear and informative
And the error message states that the username/password is incorrect