Feature: Login Functionality
@1
Scenario: Verify the presence of "Login with SSO" button on the COCO login screen
Given I have launched the CoCo URL
When I am on the login screen
Then I should see a button labeled "Login with SSO" displayed on the screen