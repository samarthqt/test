Feature: Password Reset with Incorrect Email
Scenario: Verify that the system does not send a password reset link when an incorrect email is entered
Given the user has an account with a registered email
And the user is on the login page
When the user clicks on "Forgot Password?" link
Then the password reset page is displayed
When the user enters the incorrect email "user@wrongdomain.com" in the email field
And the user clicks on the "Submit" button
Then the system processes the request
And no email is received in the inbox or spam/junk folder for "user@wrongdomain.com"
And the system displays an error message: "Email not recognized."
Scenario: Attempt login with incorrect email
Given the user is on the login page
When the user attempts to login with the incorrect email "user@wrongdomain.com"
Then the login fails with a message indicating incorrect credentials
Scenario: Password reset with correct email
Given the user is on the password reset page
When the user tries resetting the password with the correct email
Then the password reset email is sent to the correct email
Scenario: Check system logs for incorrect email attempt
Given the user has attempted a password reset with an incorrect email
When the system logs are checked
Then logs indicate an incorrect email attempt without errors
Scenario: Verify security measures for multiple incorrect attempts
Given the user attempts multiple incorrect email entries
When the system checks for security measures
Then no security measures are triggered for a single incorrect attempt
Scenario: Enter valid email format not registered in the system
Given the user is on the password reset page
When the user enters a valid email format that is not registered
Then the system displays "Email not recognized" message
Scenario: Enter email with special characters
Given the user is on the password reset page
When the user enters an email with special characters and submits
Then the system processes but does not send a reset link
Scenario: Enter email with valid domain but incorrect local part
Given the user is on the password reset page
When the user enters an email with a valid domain but incorrect local part
Then the system displays "Email not recognized" message
Scenario: Attempt password reset with non-existent email domain
Given the user is on the password reset page
When the user attempts a password reset with a non-existent email domain
Then the system does not send a reset link and shows "Email not recognized" message