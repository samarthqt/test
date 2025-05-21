Feature: User Registration
""
Scenario: Successful user registration with valid details
Given the user is on the registration page
When the user enters valid details in all required fields
| Field        | Value            |
| First Name   | John             |
| Last Name    | Doe              |
| Email        | john.doe@example.com |
| Password     | Password123      |
| Confirm Password | Password123  |
And the user submits the registration form
Then the user account should be created successfully
"    And the user should see a confirmation message ""Registration successful"""
""
Scenario: User registration with missing required fields
Given the user is on the registration page
"    When the user leaves the ""Email"" field empty"
And the user enters valid details in other required fields
| Field        | Value            |
| First Name   | Jane             |
| Last Name    | Smith            |
| Password     | Password123      |
| Confirm Password | Password123  |
And the user submits the registration form
"    Then the user should see an error message ""Email is required"""
""
Scenario: User registration with invalid email format
Given the user is on the registration page
"    When the user enters an invalid email format ""john.doe.com"""
And the user enters valid details in other required fields
| Field        | Value            |
| First Name   | John             |
| Last Name    | Doe              |
| Password     | Password123      |
| Confirm Password | Password123  |
And the user submits the registration form
"    Then the user should see an error message ""Invalid email format"""
""
Scenario: User registration with password mismatch
Given the user is on the registration page
"    When the user enters ""Password123"" in the ""Password"" field"
"    And the user enters ""Password321"" in the ""Confirm Password"" field"
And the user enters valid details in other required fields
| Field        | Value            |
| First Name   | John             |
| Last Name    | Doe              |
| Email        | john.doe@example.com |
And the user submits the registration form
"    Then the user should see an error message ""Passwords do not match"""
""
Scenario: User registration with already registered email
Given the user is on the registration page
"    When the user enters an email ""john.doe@example.com"" that is already registered"
And the user enters valid details in other required fields
| Field        | Value            |
| First Name   | John             |
| Last Name    | Doe              |
| Password     | Password123      |
| Confirm Password | Password123  |
And the user submits the registration form
"    Then the user should see an error message ""Email is already registered"""
```