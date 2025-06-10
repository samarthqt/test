Feature: User Profile Menu Display
Scenario: Verify user profile menu items are displayed after login
@3
Given the user is logged into COCO
When the user navigates to the user profile
Then the following admin related menus should be displayed:
| Menu Item   |
| User name   |
| Mail ID     |
| Home        |
| Dashboards  |
| Version     |
| Logout      |
Scenario: Verify home page displays all user profile menu items
@3
Given the user is logged into COCO
When the user navigates to the home page
Then the following menu items should be displayed:
| Menu Item   |
| User name   |
| Mail ID     |
| Home        |
| Dashboards  |
| Version     |
| Logout      |