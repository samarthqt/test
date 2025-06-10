Feature: User Sign-up/Sign-in
@22
Scenario: User signs up using email
Given the user is on the sign-up page
When the user enters a valid email address and password
And the user submits the form
Then the system should create a new account
And the system should validate the email address
And the user should be logged in
@22
Scenario: User signs up using Google credentials
Given the user is on the sign-up page
When the user chooses to sign up with Google
Then the system should authenticate using Google credentials
And the user should be logged in
@22
Scenario: User signs up using Facebook credentials
Given the user is on the sign-up page
When the user chooses to sign up with Facebook
Then the system should authenticate using Facebook credentials
And the user should be logged in
@22
Scenario: User signs in using email and password
Given the user has an existing account
And the user is on the sign-in page
When the user enters a valid email and password
And the user submits the form
Then the user should be logged in
@22
Scenario: User signs in using Google credentials
Given the user has an existing account
And the user is on the sign-in page
When the user chooses to sign in with Google
Then the system should authenticate using Google credentials
And the user should be logged in
@22
Scenario: User signs in using Facebook credentials
Given the user has an existing account
And the user is on the sign-in page
When the user chooses to sign in with Facebook
Then the system should authenticate using Facebook credentials
And the user should be logged in
@22
Scenario: System handles login errors gracefully
Given the user is on the sign-in page
When the user enters an invalid email or password
And the user submits the form
Then the system should display an error message
@22
Scenario: User recovers password
Given the user is on the sign-in page
When the user clicks on "Forgot Password"
And the user enters a valid email address
Then the system should send a password recovery email
@22
Scenario: System logs authentication activities
Given the user signs in successfully
Then the system should log the authentication activity for security purposes
@22
Scenario: System complies with GDPR for data protection
Given the user signs up or signs in
Then the system should ensure compliance with GDPR for data protection