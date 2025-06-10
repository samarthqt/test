Feature: Change Password Functionality
As a user
I want to change my password from my account settings
So that I can ensure my account security
@25
Scenario: Change password with correct current password
Given the user is logged into their account
When the user navigates to the account settings
And the user enters the correct current password
And the user enters a new password that meets complexity requirements
And the user confirms the new password
Then the system changes the password
And the user receives a confirmation message
And the password change request is logged for security auditing
@25
Scenario: Change password with incorrect current password
Given the user is logged into their account
When the user navigates to the account settings
And the user enters an incorrect current password
Then the system displays an error message
And the password change request is not processed
@25
Scenario: Reset forgotten password
Given the user has forgotten their password
When the user navigates to the password reset page
And the user enters their email address
Then the system sends a password reset link to the user's email
And the user can set a new password using the reset link
@25
Scenario: Password change complies with data protection regulations
Given the user is changing their password
Then the system ensures the password change process complies with GDPR and other data protection regulations