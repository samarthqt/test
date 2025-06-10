Feature: Verify visibility of the 'Login with SSO' button on the COCO login screen
@TC-1
Scenario: Check 'Login with SSO' button visibility
Given I have access to the COCO application login screen
When I navigate to the COCO login screen
Then the login screen is displayed
And 'Login with SSO' button is visible on the login screen