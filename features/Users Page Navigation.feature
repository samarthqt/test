Feature: Users Page Navigation
@TC-4
Scenario: Verify that an Admin user can navigate to the Users page
Given the Admin user logs in to the COCO application
When the Admin user enters username "adminUser" and password "adminPassword"
Then the Admin user is logged in successfully
And the Admin profile menu options are visible
When the Admin user clicks on the 'Users' menu option
Then the user is redirected to the Users page
And the 'Create New User' option is displayed on the Users page