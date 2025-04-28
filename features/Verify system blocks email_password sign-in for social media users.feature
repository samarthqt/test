Feature: Verify system blocks email/password sign-in for social media users
Scenario: System blocks sign-in attempt using email/password for users signed up with social media
Given User has signed up using social media accounts
When User navigates to the sign-in page
Then Sign-in page is displayed
Scenario: Enter email associated with social media accounts
When User enters the email "user_social@example.com"
Then Email field accepts input
Scenario: Enter password associated with the email
When User enters the password "socialPassword123"
Then Password field accepts input
Scenario: Click on the 'Sign In' button
When User clicks on the 'Sign In' button
Then System processes the sign-in request
Scenario: Verify system blocks sign-in with email/password
Then Sign-in is blocked with an appropriate error message
Scenario: Attempt sign-in using Facebook
When User attempts sign-in using Facebook
Then Sign-in is successful using Facebook
Scenario: Attempt sign-in using Apple
When User attempts sign-in using Apple
Then Sign-in is successful using Apple
Scenario: Check for consistency in error messages across browsers
Then Error messages are consistent across browsers
Scenario: Verify system logs for blocked sign-in attempts
Then Logs accurately reflect blocked attempts
Scenario: Check system security measures during blocked sign-in
Then Security measures are enforced without errors
Scenario: Test blocked sign-in attempt during high traffic conditions
Then System handles high traffic without performance issues
Scenario: Verify user session management post blocked sign-in
Then User session is not created
Scenario: Check error message consistency across different devices
Then Error messages are consistent across devices
Scenario: Verify system behavior when incorrect email/password is entered
When User enters incorrect email/password
Then Appropriate error message is displayed
Scenario: Check for any notifications or guidance provided to the user
Then User is guided to use social media sign-in