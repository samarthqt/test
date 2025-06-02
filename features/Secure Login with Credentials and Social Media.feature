Feature: Secure Login with Credentials and Social Media
@TC-297
Scenario: Login with valid credentials
Given the user navigates to the login page
When the user enters valid username "user@example.com" and password "ValidPassword123"
And clicks on the 'Login' button
Then the user is successfully logged in and redirected to the dashboard
@TC-297
Scenario: Logout from the account
Given the user is logged in
When the user logs out of the account
Then the user is redirected to the login page
@TC-297
Scenario: Login with Facebook
Given the user navigates to the login page
When the user selects 'Login with Facebook'
Then the Facebook login page is displayed
When the user enters Facebook credentials and logs in
Then the user is successfully logged in through Facebook and redirected to the dashboard
@TC-297
Scenario: Logout from the account after Facebook login
Given the user is logged in through Facebook
When the user logs out of the account
Then the user is redirected to the login page
@TC-297
Scenario: Login with Google
Given the user navigates to the login page
When the user selects 'Login with Google'
Then the Google login page is displayed
When the user enters Google credentials and logs in
Then the user is successfully logged in through Google and redirected to the dashboard
@TC-297
Scenario: Verify CAPTCHA during login
Given the user navigates to the login page
When the user attempts to log in
Then CAPTCHA is displayed and required for login
@TC-297
Scenario: Check for security warnings during login
Given the user navigates to the login page
When the user attempts to log in
Then no security warnings or alerts are displayed
@TC-297
Scenario: Login from a new device
Given the user navigates to the login page from a new device
When the user attempts to log in
Then verification via email or phone is required
@TC-297
Scenario: Test login session timeout
Given the user is logged in
When the user is inactive for a period
Then the session times out and requires re-login
@TC-297
Scenario: Check HTTPS redirection during login
Given the user navigates to the login page
When the user attempts to log in
Then all login pages and redirects are secured with HTTPS
@TC-297
Scenario: Attempt login during system maintenance
Given the system is under maintenance
When the user attempts to log in
Then the user receives a maintenance notification and cannot log in