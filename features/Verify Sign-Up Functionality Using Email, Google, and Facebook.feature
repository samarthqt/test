Feature: Verify Sign-Up Functionality Using Email, Google, and Facebook
@TC-296
Scenario: Navigate to the sign-up page
Given the user accesses the application
When the user navigates to the sign-up page
Then the sign-up page is displayed
@TC-296
Scenario: Sign up using email
Given the user is on the sign-up page
When the user enters a valid email "user@example.com" and password "Password123"
And submits the sign-up form
Then the sign-up form is submitted successfully
And email confirmation is sent
@TC-296
Scenario: Sign up using Google account
Given the user is on the sign-up page
When the user attempts to sign up using a Google account "google_user@gmail.com"
And authorizes Google account access
Then the Google sign-up process is completed successfully
@TC-296
Scenario: Sign up using Facebook account
Given the user is on the sign-up page
When the user attempts to sign up using a Facebook account "facebook_user@facebook.com"
And authorizes Facebook account access
Then the Facebook sign-up process is completed successfully
@TC-296
Scenario: Verify login after sign-up
Given the user has signed up successfully
When the user attempts to log in
Then the user is able to log in successfully
@TC-296
Scenario: Prevent duplicate account creation
Given the user has an existing account
When the user attempts to sign up with the same email
Then the system prevents the creation of duplicate accounts
@TC-296
Scenario: Sign up with invalid email format
Given the user is on the sign-up page
When the user enters an invalid email format
Then the system alerts the user to the invalid email format
@TC-296
Scenario: Ensure accurate logging of sign-up actions
Given the user is on the sign-up page
When the user completes the sign-up process
Then the system logs sign-up actions accurately
@TC-296
Scenario: Verify account status post sign-up
Given the user has signed up successfully
When the user checks the account status
Then the account status is active and accessible