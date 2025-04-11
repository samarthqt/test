Feature: User Account Creation and Authentication
Scenario: Create an account using email
Given a user navigates to the account creation page
When the user enters a valid email and password
And the user submits the registration form
Then the account is created successfully
And a success notification is displayed
Scenario: Create an account using Google
Given a user navigates to the account creation page
When the user chooses to register using Google
And the user completes the Google authentication process
Then the account is created successfully
And a success notification is displayed
Scenario: Create an account using Facebook
Given a user navigates to the account creation page
When the user chooses to register using Facebook
And the user completes the Facebook authentication process
Then the account is created successfully
And a success notification is displayed
Scenario: Log in using email and password
Given a user navigates to the login page
When the user enters a valid email and password
And the user submits the login form
Then the user is logged in successfully
And a success notification is displayed
Scenario: Log in using Google
Given a user navigates to the login page
When the user chooses to log in using Google
And the user completes the Google authentication process
Then the user is logged in successfully
And a success notification is displayed
Scenario: Log in using Facebook
Given a user navigates to the login page
When the user chooses to log in using Facebook
And the user completes the Facebook authentication process
Then the user is logged in successfully
And a success notification is displayed
Scenario: Forgot password functionality
Given a user navigates to the login page
When the user clicks on the forgot password link
And the user enters their registered email
Then a password reset link is sent to the user's email
Scenario: Invalid login attempt
Given a user navigates to the login page
When the user enters an invalid email or password
And the user submits the login form
Then an error message is displayed
Scenario: Logging successful login attempts
Given a user logs in successfully
Then the login attempt is recorded in the system logs
Scenario: Logging failed login attempts
Given a user attempts to log in with invalid credentials
Then the failed login attempt is recorded in the system logs
Scenario: Social media login complies with OAuth standards
Given a user logs in using Google or Facebook
Then the authentication process complies with OAuth standards
Scenario: Secure account creation and login
Given a user creates an account or logs in
Then the process is secure and prevents unauthorized access
And user credentials are encrypted and stored securely