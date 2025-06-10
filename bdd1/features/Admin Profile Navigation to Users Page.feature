Feature: Admin Profile Navigation to Users Page
@3
Scenario: Navigate to Users page from Admin profile
Given I am logged into COCO as an Admin
When I navigate to the user profile
Then the following admin related menus should be displayed:
| Menu Item  |
| User name  |
| Mail ID    |
| Home       |
| Projects   |
| Users      |
| Dashboards |
| Prompts    |
| Version    |
| Logout     |
When I click on the "Users" menu option
Then I should be redirected to the Users page
And I should see the option to "create new User" on the Users page