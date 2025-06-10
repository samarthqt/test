Feature: Login Functionality
@1
Scenario: Successful login with valid credentials
Given I launch the CoCo URL
And I enter a valid username
And I enter a valid password
When I click on the Login button
Then I should be redirected to the homepage
@1
Scenario: Unsuccessful login with invalid credentials
Given I launch the CoCo URL
And I enter an invalid username
And I enter an invalid password
When I click on the Login button
Then I should see an appropriate error message
@1
Scenario: Unsuccessful login with valid username and invalid password
Given I launch the CoCo URL
And I enter a valid username
And I enter an invalid password
When I click on the Login button
Then I should see an appropriate error message
@1
Scenario: Unsuccessful login with invalid username and valid password
Given I launch the CoCo URL
And I enter an invalid username
And I enter a valid password
When I click on the Login button
Then I should see an appropriate error message