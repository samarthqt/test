Feature: User Login
""
As a user,
I want to log in to my account using my email and password,
So that I can access my account securely.
""
Background:
Given the user is on the login page
""
Scenario Outline: Successful login with valid credentials
"    When the user enters a valid email ""<email>"" and password ""<password>"""
And clicks the login button
Then the user should be redirected to the account dashboard
""
Examples:
| email            | password   |
| user@example.com | password1  |
| test@domain.com  | password2  |
""
Scenario: Unsuccessful login with invalid email
"    When the user enters an invalid email ""invalid@example.com"" and a valid password ""password1"""
And clicks the login button
Then an error message should be displayed indicating invalid email or password
""
Scenario: Unsuccessful login with invalid password
"    When the user enters a valid email ""user@example.com"" and an invalid password ""wrongpassword"""
And clicks the login button
Then an error message should be displayed indicating invalid email or password
""
Scenario: Unsuccessful login with empty email and password fields
When the user leaves the email and password fields empty
And clicks the login button
Then an error message should be displayed indicating that email and password are required
""
Scenario: Unsuccessful login with empty email field
"    When the user leaves the email field empty and enters a valid password ""password1"""
And clicks the login button
Then an error message should be displayed indicating that email is required
""
Scenario: Unsuccessful login with empty password field
"    When the user enters a valid email ""user@example.com"" and leaves the password field empty"
And clicks the login button
Then an error message should be displayed indicating that password is required
""
Scenario: Check password visibility toggle
"    When the user enters a password ""password1"""
And clicks the password visibility toggle
Then the password should be visible in plain text
When the user clicks the password visibility toggle again
Then the password should be hidden
""
Scenario: Remember me functionality
"    When the user enters a valid email ""user@example.com"" and password ""password1"""
"    And selects the ""Remember me"" checkbox"
And clicks the login button
Then the user should be redirected to the account dashboard
And the user's email should be remembered on the login page upon logout
""
Scenario: Password reset link
"    When the user clicks on the ""Forgot Password?"" link"
Then the user should be redirected to the password reset page
```
```gherkin
TCID:23