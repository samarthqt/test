Feature: Account Creation Without Profanity in Names
Scenario: Verify account creation without profanity in names
Given the user is on the account creation page
When the user navigates to the account creation page
Then the account creation page is displayed
Scenario: Enter valid first and last name
When the user enters "John" in the first name field
Then the first name "John" is entered in the field
When the user enters "Doe" in the last name field
Then the last name "Doe" is entered in the field
Scenario: Enter valid email and password
When the user enters "john.doe@example.com" in the email field
Then the email "john.doe@example.com" is entered in the field
When the user enters "SecurePass123!" in the password field
Then the password "SecurePass123!" is entered in the field
Scenario: Create account and verify success
When the user clicks on the "Create Account" button
Then the account creation process is initiated
And the account is created successfully
And the user is redirected to the welcome page with a success message
Scenario: Verify system logs and login functionality
When the system logs are checked for any errors during the account creation process
Then no errors related to account creation are found in the system logs
When the user attempts to log in with the newly created account credentials
Then the user is able to log in successfully with the new account
Scenario: Verify confirmation email and database storage
When the user receives a confirmation email about the account creation
Then the user receives a confirmation email with account details
When the database is checked to ensure the account details are stored correctly
Then the database reflects the correct account details for "John Doe"
Scenario: Monitor server performance and repeat process
When the server performance is monitored during the account creation process
Then the server performance remains stable during the account creation
When the account creation process is repeated with different valid names
Then the account is created successfully with different valid names
Scenario: Verify account creation across services and profanity filter
When the account creation process is reflected across all user-related services
Then all user-related services reflect the newly created account
When verifying that the profanity filter does not trigger for non-profane names
Then the profanity filter does not trigger for the name "John Doe"