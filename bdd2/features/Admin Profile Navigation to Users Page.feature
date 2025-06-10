Feature: Admin Profile Navigation to Users Page
@3
Scenario: Admin navigates to Users page via Projects menu
Given I am logged into COCO as an Admin
When I click on the Projects menu option
Then I should be redirected to the Users page
@3
Scenario: Verify "Create new User" option on Users page
Given I am on the Users page as an Admin
Then I should see the "Create new User" option displayed