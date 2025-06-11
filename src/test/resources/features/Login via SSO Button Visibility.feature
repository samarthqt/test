Feature: Login via SSO Button Visibility
@TC-1
Scenario: Verify that the 'Login with SSO' button is displayed on the COCO login screen
Given the CoCo URL is accessible
When I launch the CoCo URL in a web browser
Then the CoCo login page is displayed
And the standard login option is visible
When I observe the login options available on the screen
Then the 'Login with SSO' button is displayed
@TC-1
Scenario: Successful login via SSO
Given the 'Login with SSO' button is displayed on the CoCo login screen
When I click on the 'Login with SSO' button
Then the SSO login process is initiated
When I enter valid SSO credentials
And I submit the SSO credentials
Then the SSO credentials are accepted
And the user is successfully logged into CoCo
And the user is redirected to the homepage after SSO login
Then the user is on the CoCo homepage