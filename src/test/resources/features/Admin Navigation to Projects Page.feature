Feature: Admin Navigation to Projects Page
@TC-2
Scenario: Verify that Admin can navigate to the 'projects' page and view the 'create new project' option
Given the admin user is logged in successfully
When the admin user navigates to the user profile section
Then the admin profile menu options are visible
When the admin user clicks on the 'Projects' menu option
Then the user is redirected to the 'projects' page
And the 'create new project' option is visible on the 'projects' page