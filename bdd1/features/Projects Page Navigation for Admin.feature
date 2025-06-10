Feature: Projects Page Navigation for Admin
@2
Scenario: Navigate to Projects page as Admin
Given I am logged into COCO as an Admin
And I can view Admin profile menu options
When I click on the projects menu option
Then I should be redirected to the projects page
And I should see the "create new project" option on the projects page