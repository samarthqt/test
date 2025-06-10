Feature: Login Functionality on COCO
Scenario: Display "Login with SSO" button on the login screen
@1
Given I am on the COCO login screen
When I look at the login options
Then I should see a new button "Login with SSO" displayed on the login screen