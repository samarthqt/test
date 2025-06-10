Feature: Successful Login with Valid Credentials
@TC-1
Scenario: Verify that users can log in successfully with valid credentials
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