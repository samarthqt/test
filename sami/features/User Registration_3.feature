Feature: User Registration
""
As a new user
I want to be able to create an account with basic details
So that I can access the system with my own credentials
""
Scenario: Successful user registration with valid details
Given I am on the user registration page
"    When I enter valid details such as ""John Doe"" for name, ""john.doe@example.com"" for email, ""password123"" for password"
And I submit the registration form
"    Then I should see a confirmation message ""Registration successful"""
And I should be redirected to the login page
""
Scenario: Registration with an already registered email
Given I am on the user registration page
"    And the email ""john.doe@example.com"" is already registered"
"    When I enter ""John Doe"" for name, ""john.doe@example.com"" for email, ""password123"" for password"
And I submit the registration form
"    Then I should see an error message ""Email is already registered"""
""
Scenario: Registration with invalid email format
Given I am on the user registration page
"    When I enter ""John Doe"" for name, ""john.doe.com"" for email, ""password123"" for password"
And I submit the registration form
"    Then I should see an error message ""Invalid email format"""
""
Scenario: Registration with a weak password
Given I am on the user registration page
"    When I enter ""John Doe"" for name, ""john.doe@example.com"" for email, ""pass"" for password"
And I submit the registration form
"    Then I should see an error message ""Password is too weak"""
""
Scenario: Registration with missing details
Given I am on the user registration page
When I leave the name field empty
"    And I enter ""john.doe@example.com"" for email, ""password123"" for password"
And I submit the registration form
"    Then I should see an error message ""Name is required"""
""
"    When I enter ""John Doe"" for name"
And I leave the email field empty
"    And I enter ""password123"" for password"
And I submit the registration form
"    Then I should see an error message ""Email is required"""
""
"    When I enter ""John Doe"" for name"
"    And I enter ""john.doe@example.com"" for email"
And I leave the password field empty
And I submit the registration form
"    Then I should see an error message ""Password is required"""
```
```gherkin
TCID:67