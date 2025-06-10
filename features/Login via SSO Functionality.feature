Feature: Login via SSO Functionality
@TC-2
Scenario: Verify the functionality of logging in using the 'Login with SSO' button
Given I have access to the COCO application login screen
When I navigate to the COCO login screen
Then the login screen should be displayed
And SSO integration should be configured
When I click on the 'Login with SSO' button
Then I should be redirected to the SSO login page
And I enter valid SSO credentials
Then the credentials should be accepted
When I submit the SSO login form
Then I should be logged into the COCO application successfully