Feature: Admin Profile Options
@2
Scenario: Navigate to Projects page as an Admin
Given I am logged into COCO as an Admin
When I navigate to the user profile
Then I should see the "Projects" menu option
@2
Scenario: Redirect to Projects page from Admin profile
Given I am logged into COCO as an Admin
And I navigate to the user profile
When I click on the "Projects" menu option
Then I should be redirected to the Projects page
@2
Scenario: Verify "Create New Project" option on Projects page
Given I am logged into COCO as an Admin
And I have navigated to the Projects page
Then I should see the "Create New Project" option on the Projects page