Feature: Update Mobile Number Flow Trigger When No Phone Number in IDP
Scenario: Trigger 'Update Mobile Number' flow when no phone number is found in IDP
Given the user account exists in the system
And no phone number is stored in the IDP
When the user navigates to the sign-in page of the application
Then the sign-in page is displayed
When the user enters the email "user@example.com" in the email field
Then the email is entered correctly
When the user enters the password "Password123" in the password field
Then the password is entered correctly
When the user clicks on the 'Sign In' button
Then the system processes the sign-in request
When the system checks for the presence of a phone number in IDP
Then the system detects no phone number in IDP
When the system triggers the 'Update Mobile Number' flow
Then the 'Update Mobile Number' flow is initiated
When the user enters a new phone number in the 'Update Mobile Number' screen
Then the new phone number is entered correctly
When the user submits the new phone number for verification
Then the system processes the new phone number
When the system sends an OTP to the new phone number
Then an OTP is sent to the new phone number
When the user verifies the OTP received on the new phone number
Then the OTP matches the one sent by the system
When the user enters the OTP in the OTP verification field on the application
Then the OTP is entered correctly
When the user submits the OTP for verification
Then the system verifies the OTP
When the OTP verification is successful
Then the user is redirected to the homepage
When the user logs out from the application
Then the user is logged out successfully
When the user repeats the sign-in process
Then the updated phone number is used for OTP dispatch