Feature: Navigation and Verification of Users Page
As an Admin user, I want to navigate to the Users page and verify the presence of the "create new User" option.
@3
Scenario: Successful login as Admin user
Given I am on the CoCO login page
When I enter valid Admin credentials
And I click on the login button
Then I should be logged in successfully
@3
Scenario: Ability to view Admin profile menu options
Given I am logged in as an Admin user
When I navigate to the Admin profile menu
Then I should see all available menu options
@3
Scenario: Redirection to Users page via projects menu option
Given I am logged in as an Admin user
When I click on the projects menu option
Then I should be redirected to the Users page
@3
Scenario: Verify "create new User" option on Users page
Given I am on the Users page
Then I should see the "create new User" option available