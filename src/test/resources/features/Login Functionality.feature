Feature: Login Functionality
@1
Scenario: Successful login with valid credentials
Given I launch the CoCo URL
When I enter a valid username
And I enter a valid password
And I click on the Login button
Then I should be successfully logged in
And I should be redirected to the homepage
@1
Scenario: Unsuccessful login with invalid credentials
Given I launch the CoCo URL
When I enter an invalid username
And I enter an invalid password
And I click on the Login button
Then I should not be logged in
And an appropriate error message should be displayed