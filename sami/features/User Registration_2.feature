Feature: User Registration
TCID:63
""
As a user, I want to be able to create an account using my basic details so that I can access the platform.
""
Background:
Given the user is on the registration page
""
Scenario: Successful user registration with valid details
When the user enters a valid username
And the user enters a valid email address
And the user enters a valid password
And the user confirms the password
And the user submits the registration form
Then the user should see a confirmation message
And the user account should be created successfully
""
Scenario: Registration with an already registered email
When the user enters a valid username
And the user enters an email address that is already registered
And the user enters a valid password
And the user confirms the password
And the user submits the registration form
Then the user should see an error message indicating the email is already in use
""
Scenario: Registration with invalid email format
When the user enters a valid username
And the user enters an invalid email address
And the user enters a valid password
And the user confirms the password
And the user submits the registration form
Then the user should see an error message indicating the email format is invalid
""
Scenario: Registration with mismatched passwords
When the user enters a valid username
And the user enters a valid email address
And the user enters a password
And the user enters a different password in the confirm password field
And the user submits the registration form
Then the user should see an error message indicating the passwords do not match
""
Scenario: Registration with missing required fields
When the user leaves the username field empty
Or the user leaves the email field empty
Or the user leaves the password field empty
Or the user leaves the confirm password field empty
And the user submits the registration form
Then the user should see an error message indicating that all fields are required
""
Scenario: Registration with password not meeting complexity requirements
When the user enters a valid username
And the user enters a valid email address
And the user enters a password that does not meet complexity requirements
And the user confirms the password
And the user submits the registration form
Then the user should see an error message indicating the password does not meet complexity requirements
```gherkin
TCID:64