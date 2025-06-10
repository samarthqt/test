Feature: Login functionality for CoCo application
@TC-3
Scenario: Login with empty credentials
Given the CoCo URL is accessible
When I launch the CoCo URL in a web browser
Then the CoCo login page is displayed
When I leave the username field empty
And I leave the password field empty
And I click on the Login button
Then the login attempt fails
And an error message 'Username and password cannot be empty' is displayed