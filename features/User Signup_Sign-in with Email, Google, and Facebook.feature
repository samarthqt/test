Feature: User Signup/Sign-in with Email, Google, and Facebook
@TC-7
Scenario: Navigate to the signup/sign-in page
Given the user navigates to the signup/sign-in page
Then the signup/sign-in page is displayed with options for email, Google, and Facebook
@TC-7
Scenario: Sign up using email
Given the user is on the signup/sign-in page
When the user attempts to sign up using email "testuser@example.com"
Then the user is successfully signed up using email
@TC-7
Scenario: Sign in using email
Given the user is logged out
When the user attempts to sign in using email "testuser@example.com"
Then the user is successfully signed in using email
@TC-7
Scenario: Sign up using Google
Given the user is logged out
When the user attempts to sign up using Google account linked to "testuser@example.com"
Then the user is successfully signed up using Google account
@TC-7
Scenario: Sign in using Google
Given the user is logged out
When the user attempts to sign in using Google account linked to "testuser@example.com"
Then the user is successfully signed in using Google account
@TC-7
Scenario: Sign up using Facebook
Given the user is logged out
When the user attempts to sign up using Facebook account linked to "testuser@example.com"
Then the user is successfully signed up using Facebook account
@TC-7
Scenario: Sign in using Facebook
Given the user is logged out
When the user attempts to sign in using Facebook account linked to "testuser@example.com"
Then the user is successfully signed in using Facebook account
@TC-7
Scenario: Verify account details in user profile
Given the user is signed in
When the user navigates to the user profile
Then the user profile correctly displays account information
@TC-7
Scenario: Check for welcome emails or messages
Given the user has signed up
When the user checks their email or messages
Then a welcome email or message is received upon signup
@TC-7
Scenario: Sign in using incorrect credentials
Given the user is on the signup/sign-in page
When the user attempts to sign in using incorrect credentials
Then sign-in fails and an error message is displayed
@TC-7
Scenario: Verify security of the signup/sign-in process
Given the user is on the signup/sign-in page
When the user examines the security measures
Then security measures such as CAPTCHA are in place
@TC-7
Scenario: Check browser console for errors
Given the user is signing up or signing in
When the user checks the browser console
Then no errors are logged in the console
@TC-7
Scenario: Sign up with an already registered email
Given the user is on the signup/sign-in page
When the user attempts to sign up with an already registered email "testuser@example.com"
Then an error message indicates the email is already registered
@TC-7
Scenario: Check for password reset options
Given the user is on the signup/sign-in page
When the user checks for options to reset password if forgotten
Then a password reset option is available
@TC-7
Scenario: Verify logout functionality
Given the user is signed in
When the user attempts to log out
Then the user is successfully logged out