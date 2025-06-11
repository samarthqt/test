Feature: User Profile Menu Display
Scenario: Display user profile menus upon login
@3
Given the user is logged into COCO
When the user navigates to the user profile
Then the following admin-related menus should be displayed:
| Menu        |
| User name   |
| Mail ID     |
| Home        |
| Dashboards  |
| Version     |
| Logout      |
Scenario: Verify menu items on the home page for user profile
@3
Given the user is on the home page
When the user views the menu items
Then the following menu items should be displayed:
| Menu        |
| User name   |
| Mail ID     |
| Home        |
| Dashboards  |
| Version     |
| Logout      |