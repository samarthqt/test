Feature: Users Page Navigation and Functionality
@3
Scenario: Navigate to Users page via Admin profile
Given I am logged into COCO as an Admin
And I can view the admin profile menu options
When I click on the Users menu option
Then I should be redirected to the Users page
And I should see the "create new User" option on the Users page