Feature: Error message display on unsuccessful login
@TC-6
Scenario: Display appropriate error message on unsuccessful login attempt
Given the user navigates to the login page
And the login page displays username and password fields
When the user enters "valid_user" in the username field
And the user enters "incorrect_password" in the password field
And the user clicks on the login button
Then the system processes the login attempt
And the login is unsuccessful, and the user remains on the login page
And an appropriate error message indicating incorrect password is displayed
And the error message is clear and provides guidance on next steps