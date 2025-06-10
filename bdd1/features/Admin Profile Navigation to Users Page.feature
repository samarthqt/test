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
@3
Scenario: Redirect to Users page from Projects menu
Given I am logged into COCO as an Admin
And I can see the admin profile menu options
When I click on the "Projects" menu option
Then I should be redirected to the Users page
@3
Scenario: Verify "Create new User" option on Users page
Given I am on the Users page as an Admin
When I view the page options
Then I should see the "Create new User" option