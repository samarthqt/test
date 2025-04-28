Feature: Successful Sign-In with OTP Verification via IDP Phone Number
Scenario: Verify successful sign-in when OTP is successfully verified via IDP phone number
Given the user account exists in the system
And the phone number is stored in IDP
When the user navigates to the sign-in page of the application
Then the sign-in page is displayed
When the user enters the email "user@example.com" in the email field
Then the email is entered correctly
When the user enters the password "Password123" in the password field
Then the password is entered correctly
When the user clicks on the "Sign In" button
Then the system processes the sign-in request
When the OTP is sent to the phone number stored in IDP
Then an OTP is sent to the phone number "+1234567890"
When the user verifies the OTP received on the phone
Then the OTP matches the one sent by the system
When the user enters the OTP in the OTP verification field on the application
Then the OTP is entered correctly
When the user submits the OTP for verification
Then the system verifies the OTP
When the OTP is successfully verified
Then the user is redirected to the homepage
When the user logs out from the application
Then the user is logged out successfully
Scenario: Confirm OTP sending consistency
Given the sign-in process is repeated
Then OTP is consistently sent to the phone number stored in IDP
Scenario: Confirm OTP dispatch in SMS logs
When checking the SMS logs
Then SMS logs show OTP dispatch to "+1234567890"
Scenario: Verify no duplicate OTPs are sent for a single sign-in attempt
When a single sign-in attempt is made
Then only one OTP is sent per sign-in attempt
Scenario: Check OTP validity period
When checking if the OTP is valid for a specific period (e.g., 5 minutes)
Then the OTP is valid for the specified period
Scenario: Attempt to use an expired OTP for sign-in
When an expired OTP is used for sign-in
Then the system rejects the expired OTP