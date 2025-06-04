Feature: SSO Error Handling for Network Issues
@TC-9
Scenario: Ensure appropriate error messages are displayed for network-related issues during SSO login
Given an admin user account exists in the system
And the admin username is "admin_user"
And SSO integration is configured and active
When I navigate to the COCO login screen
Then the login screen is displayed with all expected fields and buttons
And the 'Login with SSO' button is visible on the login screen
When I click on the 'Login with SSO' button
Then the system redirects to the SSO authentication page
When I simulate a network failure during SSO credential submission
Then an error message is displayed indicating network issues
And the admin user is not logged into the system
And the login screen remains visible
And the user is not redirected to the dashboard