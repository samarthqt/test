Feature: Login Functionality on COCO Login Screen
As a user, I want to have an additional option to login via SSO on the COCO login screen so that I can authenticate using single sign-on.
@1
Scenario: Display "Login with SSO" button on the login screen
Given I am on the COCO login screen
Then I should see a button labeled "Login with SSO"
@1
Scenario: Login via SSO
Given I am on the COCO login screen
When I click on the "Login with SSO" button
Then I should be redirected to the SSO login page
@1
Scenario: Successful SSO login
Given I am on the SSO login page
When I enter valid SSO credentials
And I submit the SSO login form
Then I should be logged into the COCO application
@1
Scenario: Unsuccessful SSO login with invalid credentials
Given I am on the SSO login page
When I enter invalid SSO credentials
And I submit the SSO login form
Then I should see an error message indicating invalid credentials
@1
Scenario: Cancel SSO login
Given I am on the SSO login page
When I choose to cancel the login process
Then I should be redirected back to the COCO login screen