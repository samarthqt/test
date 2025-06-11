Feature: Admin Navigation to Users Page
@TC-3
Scenario: Verify that Admin can navigate to the 'Users' page and view the 'create new User' option
Given the admin user is logged in successfully
When the admin user navigates to the Admin profile menu
Then the Admin profile menu options are visible
When the admin user clicks on the 'Users' menu option
Then the user is redirected to the 'Users' page
And the 'Create new User' option is visible on the 'Users' page