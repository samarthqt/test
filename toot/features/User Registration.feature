Feature: User Registration
""
As a new user,
I want to create an account with basic details,
So that I can access the features of the application.
""
Scenario: Successful user registration with valid details
Given I am on the registration page
When I enter valid details such as username, email, and password
And I submit the registration form
Then I should see a confirmation message
And I should be redirected to the login page
""
Scenario: Registration with an already registered email
Given I am on the registration page
"    And I have an existing account with the email ""test@example.com"""
"    When I enter ""test@example.com"" as my email"
And I fill in other valid details
And I submit the registration form
Then I should see an error message indicating the email is already registered
""
Scenario: Registration with a weak password
Given I am on the registration page
When I enter a password that does not meet the security requirements
And I fill in other valid details
And I submit the registration form
Then I should see an error message indicating the password is too weak
""
Scenario: Registration with missing required fields
Given I am on the registration page
When I leave one or more required fields empty
And I submit the registration form
Then I should see an error message indicating the fields are required
""
Scenario: Registration with invalid email format
Given I am on the registration page
When I enter an invalid email format
And I fill in other valid details
And I submit the registration form
Then I should see an error message indicating the email format is invalid
""
Scenario: Registration with mismatched password confirmation
Given I am on the registration page
When I enter a password and a different password in the confirmation field
And I fill in other valid details
And I submit the registration form
Then I should see an error message indicating the passwords do not match
```
```gherkin
TCID:2