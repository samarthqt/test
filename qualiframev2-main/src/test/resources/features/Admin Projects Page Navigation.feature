Feature: Admin Projects Page Navigation
@2
Scenario: Admin user navigates to Projects page and verifies the Create New Project option
Given the admin user is logged in successfully
And the admin profile menu options are visible
When the admin user clicks on the 'Projects' menu option
Then the user is redirected to the Projects page
And the Projects page is displayed
And the 'Create New Project' option is available on the Projects page