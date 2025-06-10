Feature: User Profile Options
@3
Scenario: Verify user profile menu items are displayed
Given I am logged into COCO
When I navigate to the user profile
Then the following menu items should be displayed:
| Menu Item   |
| User name   |
| Mail ID     |
| Home        |
| Dashboards  |
| Version     |
| Logout      |