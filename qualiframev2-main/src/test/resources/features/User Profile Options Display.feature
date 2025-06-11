Feature: User Profile Options Display
@3
Scenario: Verify user-related menus are displayed correctly on the homepage
Given the user is logged in successfully
When the user navigates to the user profile section
Then the user profile section is displayed
And the 'User name' menu item is displayed
And the 'Mail ID' menu item is displayed
And the 'Home' menu item is displayed
And the 'Dashboards' menu item is displayed
And the 'Version' menu item is displayed
And the 'Logout' menu item is displayed