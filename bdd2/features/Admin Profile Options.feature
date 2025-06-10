Feature: Admin Profile Options
@2
Scenario: Navigate to projects page and verify create new project option
Given I am logged into COCO as an Admin
When I navigate to the user profile
And I click on the projects menu option
Then I should be redirected to the projects page
And I should see the "create new project" option on the projects page