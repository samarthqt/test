Feature: Projects Page Navigation
@TC-3
Scenario: Verify that an Admin user can navigate to the Projects page
Given the Admin user logs into the COCO application with username "adminUser" and password "adminPassword"
Then the Admin user is logged in successfully
And the Admin profile menu options are visible
When the Admin user clicks on the 'Projects' menu option
Then the user is redirected to the Projects page
And the 'Create New Project' option is displayed on the Projects page