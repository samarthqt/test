Feature: Enable 2FA via Account Settings
@TC-243
Scenario: Enable 2FA using SMS
Given the user account is active with User ID: 12345
When the user navigates to account settings
Then the account settings page is displayed
And 2FA options must be available
When the user locates the 2FA section
Then the 2FA section is visible with options
When the user selects SMS as the 2FA method
Then the SMS option is selected
When the user enters a valid phone number for SMS verification
Then the phone number "+1234567890" is entered successfully
When the user submits the SMS verification request
Then the SMS verification request is submitted
When the user verifies receipt of SMS verification code
Then the SMS verification code is received
When the user enters the SMS verification code
Then the SMS verification code is entered successfully
When the user confirms 2FA setup via SMS
Then the 2FA setup via SMS is confirmed
@TC-243
Scenario: Enable 2FA using Email
Given the user switches to email as the 2FA method
Then the email option is selected
When the user enters a valid email address for verification
Then the email address "user@example.com" is entered successfully
When the user submits the email verification request
Then the email verification request is submitted
When the user verifies receipt of email verification code
Then the email verification code is received
When the user enters the email verification code
Then the email verification code is entered successfully
When the user confirms 2FA setup via email
Then the 2FA setup via email is confirmed
@TC-243
Scenario: Enable 2FA using Authenticator App
Given the user switches to authenticator app as the 2FA method
Then the authenticator app option is selected
When the user enables authenticator app for verification
Then the authenticator app is enabled successfully
When the user verifies receipt of authenticator app code
Then the authenticator app code is received
When the user enters the authenticator app code
Then the authenticator app code is entered successfully
When the user confirms 2FA setup via authenticator app
Then the 2FA setup via authenticator app is confirmed
@TC-243
Scenario: Verify 2FA status in user profile
Given the user has completed 2FA setup via SMS, email, and authenticator app
When the user checks the 2FA status in user profile
Then the 2FA status shows as enabled