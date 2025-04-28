Feature: Verify OTP Sent to IDP Phone Number During Sign-In
Scenario: Ensure OTP is sent to the phone number stored in IDP during the sign-in process
Given a user account exists in the system with email "user@example.com" and phone number "+1234567890"
And the phone number is stored in the IDP
When the user navigates to the sign-in page of the application
Then the sign-in page is displayed
Scenario: Enter user credentials for sign-in
Given the user is on the sign-in page
When the user enters the email "user@example.com" in the email field
Then the email is entered correctly
When the user enters the password "Password123" in the password field
Then the password is entered correctly
Scenario: Process sign-in and send OTP
Given the user has entered valid credentials
When the user clicks on the "Sign In" button
Then the system processes the sign-in request
And an OTP is sent to the phone number "+1234567890"
Scenario: Verify and use OTP for sign-in
Given an OTP is sent to the phone number
When the user verifies the OTP received on the phone
Then the OTP matches the one sent by the system
When the user enters the OTP in the OTP verification field on the application
Then the OTP is entered correctly
When the user submits the OTP for verification
Then the system verifies the OTP
And the user is redirected to the homepage upon successful OTP verification
Scenario: Log out and confirm OTP consistency
Given the user is on the homepage
When the user logs out from the application
Then the user is logged out successfully
When the user repeats the sign-in process
Then OTP is consistently sent to the phone number stored in IDP
Scenario: Confirm OTP dispatch and validity
Given the user is checking the SMS logs
When the user verifies the OTP dispatch
Then SMS logs show OTP dispatch to "+1234567890"
And no duplicate OTPs are sent for a single sign-in attempt
And the OTP is valid for a specific period (e.g., 5 minutes)
Scenario: Attempt to use an expired OTP
Given an OTP is expired
When the user attempts to use the expired OTP for sign-in
Then the system rejects the expired OTP