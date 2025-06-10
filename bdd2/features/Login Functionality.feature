Feature: Login Functionality
@1
Scenario: Display "Login with SSO" button on the login screen
Given I have launched the CoCo URL
Then I should see a button labeled "Login with SSO" on the login screen
@1
Scenario: Successful login with valid credentials
Given I have launched the CoCo URL
When I enter a valid username and password
And I click on the Login button
Then I should be redirected to the homepage
@1
Scenario: Unsuccessful login with invalid credentials
Given I have launched the CoCo URL
When I enter an invalid username and password
And I click on the Login button
Then I should see an appropriate error message indicating unsuccessful login