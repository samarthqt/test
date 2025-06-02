Feature: Verify login functionality using email/password and social media accounts
@TC-84
Scenario: Verify login with email and password
Given the user is on the login page
When the user enters valid email "user@example.com" and password "Password123"
And clicks on the 'Login' button
Then the user is successfully logged in and redirected to the homepage
@TC-84
Scenario: Verify logout functionality
Given the user is logged in
When the user logs out from the application
Then the user is logged out and redirected to the login page
@TC-84
Scenario: Verify login with Facebook account
Given the user is on the login page
When the user clicks on the 'Login with Facebook' button
And enters valid Facebook credentials
And authorizes the application
Then the user is logged in via Facebook and redirected to the homepage
@TC-84
Scenario: Verify user profile information from Facebook
Given the user is logged in via Facebook
Then the user profile information matches the data from the linked social media account
@TC-84
Scenario: Verify login with Google account
Given the user is on the login page
When the user attempts to log in using Google account
Then the user is redirected to Google login page and can log in successfully
@TC-84
Scenario: Verify error message for incorrect email/password
Given the user is on the login page
When the user enters incorrect email or password
Then an appropriate error message is displayed for incorrect login credentials
@TC-84
Scenario: Attempt login without entering any credentials
Given the user is on the login page
When the user attempts to log in without entering any credentials
Then the system prompts the user to enter credentials
@TC-84
Scenario: Check login page responsiveness on mobile devices
Given the user is accessing the login page on a mobile device
Then the login page is responsive and functions correctly on mobile devices
@TC-84
Scenario: Verify login attempts with maximum concurrent users
Given multiple users attempt to log in concurrently
Then the system handles multiple login attempts efficiently without downtime
@TC-84
Scenario: Verify login with Twitter account
Given the user is logged out
When the user attempts to log in with Twitter account
Then the user can log in successfully using Twitter credentials
@TC-84
Scenario: Verify session timeout after inactivity
Given the user is logged in
When the user remains inactive for a defined period
Then the user session expires
@TC-84
Scenario: Check login page for accessibility compliance
Given the user is on the login page
Then the login page meets accessibility standards