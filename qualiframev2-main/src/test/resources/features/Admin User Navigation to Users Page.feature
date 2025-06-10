Feature: Admin User Navigation to Users Page
@3
Scenario: Admin user should be able to navigate to Users page and view options
Given the admin user is logged in successfully
When the user navigates to the user profile section
Then the admin profile menu options are displayed
When the admin clicks on the 'Projects' menu option
Then the admin user is redirected to the Users page
And the Users page is displayed
And the 'Create new User' option is available on the Users page