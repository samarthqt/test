Feature: Missed Reset Email in Spam or Junk Folder
Scenario: Ensure users are informed to check spam or junk folders if they do not receive the password reset email.
Given the user has requested a password reset
And user's email provider has a spam or junk folder
When the user navigates to the login page
Then the login page is displayed
When the user clicks on 'Forgot Password?' link
Then the password reset page is displayed
When the user enters the registered email "user@domain.com" in the email field
Then the email is entered in the field
When the user clicks on the 'Submit' button
Then the system processes the request
When the user waits for the password reset email to arrive in the inbox
Then the email is not found in the inbox
When the user checks the spam/junk folder for the email
Then the email is found in the spam/junk folder
When the user verifies the system's message advises checking spam/junk folders
Then the system displays: "Check your spam/junk folder if you do not see the email in your inbox."
When the user marks the reset email as 'Not Spam' to move it to the inbox
Then the email is moved to the inbox
When the user opens the password reset email and follows the link
Then the password reset page is accessed via the link
When the user completes the password reset process
Then the password is successfully reset
When the user attempts to log in with the new password
Then the login is successful with the new password
When the user requests another password reset and verifies if the email goes to spam again
Then the email arrives in the inbox, not spam
When the user checks if the email provider's spam filter settings can be adjusted
Then settings allow adjustment to prevent future spam classification
When the user sends a test email to the same address to verify spam settings
Then the test email arrives in the inbox
When the user verifies if the email content is marked as safe by the email provider
Then the email content is marked as safe, ensuring future delivery to inbox