Feature: Admin Navigation to Projects Page
As an Admin user
I want to navigate to the "Projects" page
So that I can manage projects effectively
@2
Scenario: Successful login as Admin user
Given I am on the CoCO login page
When I enter valid Admin credentials
And I click on the login button
Then I should be logged in successfully
@2
Scenario: View Admin profile menu options
Given I am logged in as an Admin user
When I navigate to the profile menu
Then I should see the Admin profile menu options
@2
Scenario: Navigate to Projects page
Given I am logged in as an Admin user
And I can see the Admin profile menu options
When I click on the "Projects" menu option
Then I should be redirected to the Projects page
@2
Scenario: Verify "create new project" option on the Projects page
Given I am on the Projects page
When I look at the available options
Then I should see the "create new project" option