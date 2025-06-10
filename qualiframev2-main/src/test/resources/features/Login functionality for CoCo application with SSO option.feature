Feature: Login functionality for CoCo application with SSO option
@1
Scenario: Display "Login with SSO" button on the login screen
Given the CoCo URL is accessible
When I launch the CoCo URL in a web browser
Then the CoCo login page is displayed
And the "Login with SSO" button is displayed on the login screen
@1
Scenario: Successful login using SSO
Given the "Login with SSO" button is displayed on the login screen
When I click on the "Login with SSO" button
Then I am redirected to the SSO login page
When I enter valid SSO credentials
And I submit the SSO login form
Then I am redirected to the homepage
And the homepage is displayed with user-specific content
@1
Scenario: Unsuccessful login using SSO with invalid credentials
Given the "Login with SSO" button is displayed on the login screen
When I click on the "Login with SSO" button
Then I am redirected to the SSO login page
When I enter invalid SSO credentials
And I submit the SSO login form
Then the login attempt fails
And an error message 'Invalid SSO credentials' is displayed