Feature: System Accepts Names with Whitelisted Words
Scenario: Create an account with a name containing a whitelisted word
Given the user is on the account creation page
When the user navigates to the account creation page
Then the account creation page is displayed
When the user enters "Hooker" in the first name field
Then the first name "Hooker" is entered in the field
When the user enters "Smith" in the last name field
Then the last name "Smith" is entered in the field
When the user enters "hooker.smith@example.com" in the email field
Then the email "hooker.smith@example.com" is entered in the field
When the user enters "SecurePass123!" in the password field
Then the password "SecurePass123!" is entered in the field
When the user clicks on the "Create Account" button
Then the account creation process is initiated
Then verify that the account is created successfully
And the user is redirected to the welcome page with a success message
Then check the system logs for any errors during the account creation process
And no errors related to account creation are found in the system logs
When the user attempts to log in with the newly created account credentials
Then the user is able to log in successfully with the new account
Then verify the user receives a confirmation email about the account creation
And the user receives a confirmation email with account details
Then check the database to ensure the account details are stored correctly
And the database reflects the correct account details for "Hooker Smith"
Then monitor the server performance during the account creation process
And server performance remains stable during the account creation
When the account creation process is repeated with different names containing whitelisted words
Then the account is created successfully with different names containing whitelisted words
Then ensure the account creation process is reflected across all user-related services
And all user-related services reflect the newly created account
Then verify that the profanity filter does not trigger for names containing whitelisted words
And the profanity filter does not trigger for the name "Hooker Smith"