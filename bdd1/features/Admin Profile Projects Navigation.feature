Feature: Admin Profile Projects Navigation
@2
Scenario: Navigate to Projects page from Admin Profile
Given I am logged into COCO as an Admin
And I can view admin profile menu options
When I click on the "Projects" menu option
Then I should be redirected to the Projects page
And I should see the "create new project" option on the Projects page