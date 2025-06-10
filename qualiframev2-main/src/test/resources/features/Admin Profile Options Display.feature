Feature: Admin Profile Options Display
@TC-4
Scenario: Verify that all admin-related menus are displayed correctly on the homepage
Given the admin user is logged in successfully
When the user navigates to the user profile section
Then the user profile section is displayed
And 'User name' menu item is displayed
And 'Mail ID' menu item is displayed
And 'Home' menu item is displayed
And 'Projects' menu item is displayed
And 'Users' menu item is displayed
And 'Dashboards' menu item is displayed
And 'Prompts' menu item is displayed
And 'Version' menu item is displayed
And 'Logout' menu item is displayed