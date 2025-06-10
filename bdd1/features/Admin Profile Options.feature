Feature: Admin Profile Options
Scenario: Verify admin related menus are displayed on home page
@2
Given I am logged into COCO as an Admin
When I navigate to the user profile
Then the following admin related menus should be displayed:
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