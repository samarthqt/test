Feature: Password Recovery Email Secure Link
@TC-118
Scenario: Verify that the system sends a password recovery email with a secure link
Given a user account with a registered email "user@example.com"
When the user navigates to the login page
Then the login page is displayed
When the user clicks on the "Forgot Password" link
Then the "Forgot Password" page is displayed
When the user enters the registered email address "user@example.com"
Then the email address is accepted
When the user submits the password recovery request
Then a confirmation message for password recovery is displayed
When the user checks the registered email inbox for the recovery email
Then the password recovery email is received
When the user opens the password recovery email
Then the email content is displayed
When the user verifies the presence of a secure link in the email
Then a secure link is present in the email
When the user clicks on the secure link
Then the link redirects to the password reset page
When the user ensures the password reset page is secure (HTTPS)
Then the password reset page is secured with HTTPS
When the user logs out of any active sessions
Then the user is logged out successfully