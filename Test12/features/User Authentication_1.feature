Feature: User Authentication
@10
Scenario: User signs up using email
Given the user is on the sign-up page
When the user enters a valid email and password
And the user submits the sign-up form
Then the system sends a confirmation email
And the user receives a successful sign-up message
@10
Scenario: User signs up using Google credentials
Given the user is on the sign-up page
When the user chooses to sign up with Google
And the user provides valid Google credentials
Then the system sends a confirmation email
And the user receives a successful sign-up message
@10
Scenario: User signs up using Facebook credentials
Given the user is on the sign-up page
When the user chooses to sign up with Facebook
And the user provides valid Facebook credentials
Then the system sends a confirmation email
And the user receives a successful sign-up message
@10
Scenario: User signs in with email and password
Given the user is on the sign-in page
When the user enters valid email and password
And the user submits the sign-in form
Then the user is successfully signed in
@10
Scenario: User signs in with Google credentials
Given the user is on the sign-in page
When the user chooses to sign in with Google
And the user provides valid Google credentials
Then the user is successfully signed in
@10
Scenario: User signs in with Facebook credentials
Given the user is on the sign-in page
When the user chooses to sign in with Facebook
And the user provides valid Facebook credentials
Then the user is successfully signed in
@10
Scenario: User encounters error message for incorrect login credentials
Given the user is on the sign-in page
When the user enters invalid email or password
And the user submits the sign-in form
Then an error message is displayed
@10
Scenario: Password recovery process
Given the user is on the password recovery page
When the user enters a valid email
And the user submits the password recovery form
Then the system sends a password recovery email
And the user can reset the password securely
@10
Scenario: User changes password securely
Given the user is logged in
When the user navigates to the change password page
And the user enters the current password and new password
And the user submits the change password form
Then the password is changed successfully
@10
Scenario: Two-factor authentication setup
Given the user is logged in
When the user navigates to the two-factor authentication setup page
And the user completes the setup process
Then two-factor authentication is enabled for the user
@10
Scenario: System logs authentication attempts
Given the user attempts to sign in
When the user submits the sign-in form
Then the system logs the authentication attempt
@10
Scenario: Authentication complies with industry security standards
Given the user is on the authentication page
Then the authentication process complies with industry security standards
@10
Scenario: Intuitive user interface for authentication
Given the user is on the authentication page
Then the user interface guides the user through the authentication process intuitively