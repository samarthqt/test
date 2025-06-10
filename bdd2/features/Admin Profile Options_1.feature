Feature: Admin Profile Options
@3
Scenario: Navigate to Users page as an Admin profile
Given I am logged into COCO as an Admin
When I navigate to the user profile
Then I should see the following admin related menus displayed:
| Menu Item   |
| User name   |
| Mail ID     |
| Home        |
| Projects    |
| Users       |
| Dashboards  |
| Prompts     |
| Version     |
| Logout      |
@3
Scenario: Redirect to Users page from Projects menu
Given I am logged into COCO as an Admin
When I click on the Projects menu option
Then I should be redirected to the Users page
@3
Scenario: Verify "create new User" option on the Users page
Given I am on the Users page
Then I should see the "create new User" option available