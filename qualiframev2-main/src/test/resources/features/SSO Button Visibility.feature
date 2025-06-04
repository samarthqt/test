Feature: SSO Button Visibility
To ensure a seamless login experience for users, the 'Login with SSO' button should always be visible on the login screen.
@TC-3
Scenario: Verify the visibility of the 'Login with SSO' button on the login screen
Given an admin user account exists in the system
And SSO integration is configured and active
When the user navigates to the COCO login screen
Then the login screen should be displayed with all expected fields and buttons
And the 'Login with SSO' button should be visible on the login screen