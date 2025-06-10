Feature: Navigation to Projects Page as Admin
@2
Scenario: Admin user navigates to the Projects page
Given I am logged into CoCO as an Admin user
Then I should see the Admin profile menu options
When I click on the projects menu option
Then I should be redirected to the projects page
And I should see the "create new project" option on the projects page