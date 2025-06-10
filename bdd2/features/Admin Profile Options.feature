Feature: Admin Profile Options
@2
Scenario: Verify admin related menus are displayed on user profile
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
@2
Scenario: Verify all listed menu items are displayed on the home page for an Admin profile
Given I am logged into COCO as an Admin
When I navigate to the home page
Then I should see all the listed menu items displayed for an Admin profile