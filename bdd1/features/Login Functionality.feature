Feature: Login Functionality
As an Admin/User, I want to be able to log in to the CoCo application using valid credentials so that I can access the homepage.
@1
Scenario: Successful login with valid credentials
Given I launch the CoCo URL
When I enter valid username and password
And I click on the Login button
Then I should be successfully logged in
And I should be redirected to the homepage
@1
Scenario: Unsuccessful login with invalid credentials
Given I launch the CoCo URL
When I enter invalid username and/or password
And I click on the Login button
Then I should not be logged in
And an appropriate error message should be displayed on the login page
@1
Scenario: Display of SSO login option
Given I launch the CoCo URL
Then I should see a button labeled "Login with SSO" on the login screen