Feature: Login attempt with incorrect password
@TC-5
Scenario: Verify that login is unsuccessful when an incorrect password is used
Given the user is on the login page
When the user enters "valid_user" in the username field
And the user enters "incorrect_password" in the password field
And the user clicks on the login button
Then the login attempt is unsuccessful, and the user remains on the login page
And an appropriate error message is displayed
And the error message states that the username/password is incorrect