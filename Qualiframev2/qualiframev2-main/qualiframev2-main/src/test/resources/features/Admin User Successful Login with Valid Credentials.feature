Feature: Admin User Successful Login with Valid Credentials
Scenario: Verify admin user can successfully log in with valid credentials
@TC-1
Given an admin user account is created and activated
When the admin navigates to the login page of the application
Then the login page is displayed with username and password fields
When the admin enters "admin_user" in the username field
Then the username is entered in the username field
When the admin enters "valid_password" in the password field
Then the password is entered in the password field
And the password is masked with asterisks or dots
When the admin clicks on the "Login" button
Then the system processes the login request
Then the admin user is redirected to the home screen
And admin-specific menus and options are visible on the home screen
When the admin logs out from the admin account
Then the user is logged out and redirected to the login page