Feature: Sign-in behavior for users signed up with both Facebook and Apple
Scenario: User attempts to sign in with email/password after signing up with Facebook and Apple
Given the user has signed up using both Facebook and Apple accounts
When the user navigates to the sign-in page
Then the sign-in page is displayed
When the user enters the email associated with the Facebook and Apple accounts
Then the email field accepts input
When the user enters the password associated with the email
Then the password field accepts input
When the user clicks on the 'Sign In' button
Then the system processes the sign-in request
Then verify if the system allows sign-in with email/password
Then sign-in is successful or blocked based on system rules
Then check for any error messages or notifications
Then appropriate error message is displayed if sign-in is blocked
Scenario: User attempts to sign in using Facebook
When the user attempts sign-in using Facebook
Then sign-in is successful using Facebook
Scenario: User attempts to sign in using Apple
When the user attempts sign-in using Apple
Then sign-in is successful using Apple
Scenario: Verify user profile details after sign-in
When the user signs in successfully
Then profile details match the signed-up information
Scenario: User logs out from the account
When the user logs out from the account
Then the user is successfully logged out
Scenario: Repeat sign-in attempt using different browsers
When the user repeats sign-in attempt using different browsers
Then system behavior is consistent across browsers
Scenario: Check system logs for sign-in attempts
When the user checks system logs for sign-in attempts
Then logs accurately reflect sign-in attempts and outcomes
Scenario: Verify system security measures during sign-in
When the user signs in
Then security measures are enforced without errors
Scenario: Test sign-in attempt during high traffic conditions
When the user attempts sign-in during high traffic conditions
Then the system handles high traffic without performance issues
Scenario: Check user session management post sign-in
When the user signs in successfully
Then user session is managed correctly