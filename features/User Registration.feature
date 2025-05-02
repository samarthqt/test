Feature: User Registration
Scenario: Successful user registration
Given the user is on the registration page
When the user enters a valid name
And the user enters a valid email
And the user enters a valid password
And the user submits the registration form
Then the user account should be created successfully
And the user should be redirected to the homepage
Scenario: Registration with an already registered email
Given the user is on the registration page
When the user enters a valid name
And the user enters an email that is already registered
And the user enters a valid password
And the user submits the registration form
Then the user should see an error message indicating the email is already registered
Scenario: Registration with invalid email format
Given the user is on the registration page
When the user enters a valid name
And the user enters an invalid email format
And the user enters a valid password
And the user submits the registration form
Then the user should see an error message indicating the email format is invalid
Scenario: Registration with weak password
Given the user is on the registration page
When the user enters a valid name
And the user enters a valid email
And the user enters a weak password
And the user submits the registration form
Then the user should see an error message indicating the password is too weak
Scenario: Registration with missing details
Given the user is on the registration page
When the user leaves the name field empty
And the user enters a valid email
And the user enters a valid password
And the user submits the registration form
Then the user should see an error message indicating the name is required
Given the user is on the registration page
When the user enters a valid name
And the user leaves the email field empty
And the user enters a valid password
And the user submits the registration form
Then the user should see an error message indicating the email is required
Given the user is on the registration page
When the user enters a valid name
And the user enters a valid email
And the user leaves the password field empty
And the user submits the registration form
Then the user should see an error message indicating the password is required