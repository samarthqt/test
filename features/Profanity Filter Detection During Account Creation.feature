Feature: Profanity Filter Detection During Account Creation
Scenario: User attempts to bypass profanity filter with special characters
Given the profanity filter is configured and active in the system
When the user navigates to the account creation page
Then the account creation page is displayed
When the user enters "pr@f@neUser1" in the username field
Then the username is entered successfully
When the user enters "test@example.com" in the email field
Then the email is entered successfully
When the user enters "Password123!" in the password field
Then the password is entered successfully
And the user submits the account creation form
Then the system processes the input data
When the system checks the username against the profanity list
Then the system detects a profanity attempt using special characters
And the system blocks the account creation process
And an error message "Profanity detected in username" is displayed
Then no account is created in the system
And the user is prompted to enter a different username
When the user attempts to create the account with a non-profane username
Then the account creation is successful
And the system logs contain the profanity detection event
When checking the system's response time for profanity detection
Then the response time is within acceptable limits
And the profanity filter is case-insensitive
And the profanity filter is updated with new words
Then profanity filter updates are successful