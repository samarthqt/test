Feature: WebAppInvalidUsername
As a user, I want to receive an error message when I attempt to log in with an invalid username, so that I know the login attempt was unsuccessful.
@4
Scenario Outline: Attempt login with invalid username
Given Launch the web application login page
When User enters "<invalid_username>" in the username field
And User enters "<password>" in the password field
And User clicks the login button
Then User should see an error message "<error_message>"
Examples:
| invalid_username | password | error_message            |
| invalidUser123   | pass123  | Invalid username entered |
| testUser!@#      | pass456  | Invalid username entered |