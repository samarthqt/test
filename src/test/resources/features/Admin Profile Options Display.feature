Feature: Admin Profile Options Display
As an Admin,
I want to see all Admin related menus on the home page
So that I can access the functionalities relevant to my role
@2
Scenario: Verify Admin related menus are displayed on home page
Given I am logged into COCO as an Admin
When I navigate to the user profile
Then the following Admin related menus should be displayed:
| User name  |
| Mail ID    |
| Home       |
| Projects   |
| Users      |
| Dashboards |
| Prompts    |
| Version    |
| Logout     |