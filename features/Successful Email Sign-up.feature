Feature: Successful Email Sign-up
@TC-51
Scenario: Navigate to the sign-up page
Given the user has access to the sign-up page
When the user navigates to the sign-up page
Then the sign-up page loads successfully
@TC-51
Scenario: Enter a valid email address
Given the user has no existing account with the test email
When the user enters a valid email address in the email field
Then the email address is accepted without errors
@TC-51
Scenario: Enter a strong password
Given the user has a valid email address
When the user enters a strong password in the password field
Then the password is accepted and meets strength criteria
@TC-51
Scenario: Fill in required user details
Given the user has entered a valid email address and strong password
When the user fills in the required user details (e.g., name, date of birth)
Then the user details are accepted without errors
@TC-51
Scenario: Agree to terms and conditions
Given the user has filled in the required user details
When the user agrees to the terms and conditions
Then the terms and conditions are agreed upon
@TC-51
Scenario: Click the 'Sign Up' button
Given the user has agreed to the terms and conditions
When the user clicks the 'Sign Up' button
Then user registration is successful and a confirmation message is displayed
@TC-51
Scenario: Receive confirmation email
Given the user has successfully registered
When the user checks the email inbox for a confirmation email
Then the confirmation email is received in the inbox
@TC-51
Scenario: Verify email through confirmation link
Given the user has received a confirmation email
When the user clicks the confirmation link in the email
Then the email is verified and the user is directed to the welcome page
@TC-51
Scenario: Log in with registered email and password
Given the user has verified their email
When the user attempts to log in with the registered email and password
Then login is successful and the user is directed to the dashboard
@TC-51
Scenario: Verify account details on the dashboard
Given the user is on the dashboard
When the user verifies the account details
Then account details are accurate and reflect the registration information
@TC-51
Scenario: Log out and log back in
Given the user is logged into the dashboard
When the user logs out and attempts to log back in
Then the user can log back in successfully with the registered credentials
@TC-51
Scenario: Check for error messages during sign-up
Given the user is attempting to sign up
When the user completes the sign-up process
Then no error messages are displayed during the sign-up process
@TC-51
Scenario: Verify password recovery option
Given the user has a registered account
When the user attempts to recover the password
Then the password recovery process functions correctly
@TC-51
Scenario Outline: Test sign-up process on different devices and browsers
Given the user is attempting to sign up on <device> using <browser>
When the user completes the sign-up process
Then the sign-up process works consistently across devices and browsers
Examples:
| device   | browser  |
| desktop  | Chrome   |
| desktop  | Firefox  |
| mobile   | Safari   |
| tablet   | Edge     |
@TC-51
Scenario: Handle duplicate email registration attempts
Given the user is attempting to register with an existing email
When the user tries to sign up
Then the system prevents duplicate registrations and provides appropriate feedback