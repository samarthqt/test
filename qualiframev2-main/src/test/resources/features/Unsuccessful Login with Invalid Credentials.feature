Feature: Unsuccessful Login with Invalid Credentials
@TC-2
Scenario: Ensure login fails with invalid credentials and an error message is displayed
Given the CoCo URL is accessible
When I launch the CoCo URL in a web browser
Then the CoCo login page should be displayed
When I enter 'invalidUser' in the username field
And I enter 'wrongPass' in the password field
And I click on the Login button
Then the login attempt should fail
And an error message 'Invalid username or password' should be displayed