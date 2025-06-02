Feature: Verify error message is displayed when signing up with an already registered email
As a user attempting to sign up,
I want the system to display an error message
when I try to sign up with an already registered email.
@TC-54
Scenario: Display error message for already registered email
Given the user navigates to the application URL "https://example.com"
When the user clicks on the "Sign Up" button
Then sign-up options are displayed
When the user enters the registered email "registered@example.com" in the email field
And the user enters a new password "newPassword" in the password field
And the user clicks on "Sign Up" to proceed
Then the system processes the sign-up request
And the system checks email registration status
Then an error message indicating the email is already registered is displayed
And the error message includes guidance for recovering password or contacting support
@TC-54
Scenario: Successful sign-up with a different email
Given the user navigates to the application URL "https://example.com"
When the user clicks on the "Sign Up" button
Then sign-up options are displayed
When the user enters a different email in the email field
And the user enters a new password in the password field
And the user clicks on "Sign Up" to proceed
Then the sign-up is successful with a different email
And email confirmation is received for the new account
And no duplicate account is created
@TC-54
Scenario: Verify system logs and adherence to policies
Given the user attempts to sign up with an already registered email
When the error message is displayed
Then the system logs the error event
And privacy policies are adhered to
And terms and conditions are displayed during sign-up attempt
And support contact information is available