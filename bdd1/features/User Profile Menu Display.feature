Feature: User Profile Menu Display
As a User,
I want to see all the admin related menu items on the home page
So that I can access them easily after logging into COCO and navigating to my user profile
@3
Scenario: Display of Admin Related Menus in User Profile
Given I am logged into the COCO application
When I navigate to my user profile
Then I should see the following admin related menu items:
| Menu Item   |
| User name   |
| Mail ID     |
| Home        |
| Dashboards  |
| Version     |
| Logout      |
And all the listed menu items should be displayed prominently on the home page for a user profile