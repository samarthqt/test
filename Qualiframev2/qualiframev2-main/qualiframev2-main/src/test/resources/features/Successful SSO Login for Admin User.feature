Feature: Successful SSO Login for Admin User
@TC-7
Scenario: Verify that an Admin user can successfully log in using the SSO option
Given an Admin user account exists in the system
And SSO integration is configured and active
When the user navigates to the COCO login screen
Then the login screen is displayed with all expected fields and buttons
And the 'Login with SSO' button is visible on the login screen
When the user clicks on the 'Login with SSO' button
Then the system redirects to the SSO authentication page
When the user enters valid SSO credentials "admin_user", "valid_sso_credentials" and submits
Then the credentials are accepted
And the user is redirected back to the application
Then the admin user is successfully logged into the system
And the home screen is displayed, indicating successful login