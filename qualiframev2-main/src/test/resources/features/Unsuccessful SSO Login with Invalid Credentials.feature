Feature: Unsuccessful SSO Login with Invalid Credentials
@TC-8
Scenario: Ensure appropriate error messages are displayed for unsuccessful SSO login attempts
Given the admin user account exists in the system
And I navigate to the COCO login screen
Then the login screen is displayed with all expected fields and buttons
And the admin username is "admin_user"
And SSO integration is configured and active
When I verify the presence of the 'Login with SSO' button on the login screen
Then the 'Login with SSO' button is visible on the login screen
And the admin SSO credentials are "invalid_sso_credentials"
When I click on the 'Login with SSO' button
Then the system redirects to the SSO authentication page
When I enter invalid SSO credentials "admin_user" and "invalid_sso_credentials" and submit
Then the system displays an error message indicating the credentials are invalid
And I verify that the admin user is not logged into the system
Then the login screen remains visible, and the user is not redirected to the home screen