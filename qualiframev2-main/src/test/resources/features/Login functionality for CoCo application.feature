Feature: Login functionality for CoCo application
@1
Scenario: Successful login with valid credentials
Given the user has a valid username and password
When the user launches the CoCo URL in a web browser
Then the CoCo login page is displayed
And the CoCo URL is accessible
When the user enters "validUser" in the username field
Then the username is entered correctly
When the user enters "validPass123" in the password field
Then the password is entered correctly
When the user clicks on the Login button
Then the user is redirected to the homepage
And the homepage is displayed with user-specific content
@1
Scenario: Unsuccessful login with invalid credentials
Given the CoCo URL is accessible
When I launch the CoCo URL in a web browser
Then the CoCo login page should be displayed
When I enter 'invalidUser' in the username field
And I enter 'wrongPass' in the password field
And I click on the Login button
Then the login attempt should fail
And an error message 'Invalid username or password' should be displayed
@1
Scenario: Login with empty credentials
Given the CoCo URL is accessible
When I launch the CoCo URL in a web browser
Then the CoCo login page is displayed
When I leave the username field empty
And I leave the password field empty
And I click on the Login button
Then the login attempt fails
And an error message 'Username and password cannot be empty' is displayed