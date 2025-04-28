Feature: Password Reset with Multiple Accounts Linked to Same Email
Scenario: Verify system behavior when multiple accounts are linked to the same email for password reset
Given multiple accounts exist with the same email
When the user navigates to the login page
Then the login page is displayed
When the user clicks on the 'Forgot Password?' link
Then the password reset page is displayed
When the user enters the shared email "user@domain.com" in the email field
And clicks on the 'Submit' button
Then the system processes the request
And the system prompts to select an account for password reset
Then the system displays: "Select the account you wish to reset the password for."
When the user selects Account 1 for password reset
Then the system processes the request for Account 1
And the user checks the email inbox for the reset link for Account 1
Then the password reset email for Account 1 is received
When the user completes the password reset process for Account 1
Then the password for Account 1 is successfully reset
When the user repeats the reset process for Account 2
Then the system processes the request for Account 2
And the user checks the email inbox for the reset link for Account 2
Then the password reset email for Account 2 is received
When the user completes the password reset process for Account 2
Then the password for Account 2 is successfully reset
When the user attempts to log in with new passwords for both accounts
Then the logins are successful with new passwords
When the user verifies if the system logs show entries for both password reset requests
Then logs indicate separate entries for each account's reset
When the user attempts to reset the password again for the same email
Then the system prompts to select an account again
When the user verifies if any security measures are triggered by multiple resets for the same email
Then no unnecessary security measures are triggered