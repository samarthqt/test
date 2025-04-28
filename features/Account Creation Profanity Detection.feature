Feature: Account Creation Profanity Detection
Scenario: System blocks account creation due to detected profanity
Given the profanity filter is configured and active in the system
When I navigate to the account creation page
Then the account creation page is displayed
When I enter "profanityUser1" in the username field
Then the username is entered successfully
When I enter "test@example.com" in the email field
Then the email is entered successfully
When I enter "Password123!" in the password field
Then the password is entered successfully
When I submit the account creation form
Then the system processes the input data
When the system checks the username against the profanity list
Then the system detects profanity in the username
When the system blocks the account creation process
Then the account creation is blocked
When the system displays an error message indicating profanity detection
Then the error message "Profanity detected in username" is displayed
Then no account is created in the system
When the user is prompted to enter a different username
Then the user is prompted to change the username
When I attempt to create the account with a non-profane username
Then the account creation is successful
Then verify system logs contain the profanity detection event
Then the profanity detection event is logged
Then check system's response time for profanity detection
Then the response time is within acceptable limits
Then ensure the profanity filter is case-insensitive
Then the profanity detection is case-insensitive
Then verify the profanity filter is updated with new words
Then the profanity filter updates are successful