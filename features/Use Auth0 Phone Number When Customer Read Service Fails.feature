Feature: Use Auth0 Phone Number When Customer Read Service Fails
Scenario: Verify system uses Auth0 phone number as backup when an error occurs from Customer Read service
Given a user account exists in the system
And the phone number is stored in Auth0
When the user navigates to the sign-in page of the application
Then the sign-in page is displayed
When the user enters the email "user@example.com" in the email field
Then the email is entered correctly
When the user simulates an error in Customer Read service
And enters the password "Password123" in the password field
Then the password is entered correctly
When the user clicks on the 'Sign In' button
Then the system processes the sign-in request
When an error in the Customer Read service is simulated
Then the system falls back to using the Auth0 phone number
And an OTP is sent to the phone number +1234567890
When the user verifies the OTP received on the phone
Then the OTP matches the one sent by the system
When the user enters the OTP in the OTP verification field on the application
Then the OTP is entered correctly
When the user submits the OTP for verification
Then the system verifies the OTP
And the user is redirected to the homepage upon successful OTP verification
When the user logs out from the application
Then the user is logged out successfully
When the user repeats the sign-in process
Then Auth0 phone number is consistently used when Customer Read service fails
When the user checks the SMS logs
Then SMS logs show OTP dispatch to +1234567890
When the user verifies that no duplicate OTPs are sent for a single sign-in attempt
Then only one OTP is sent per sign-in attempt