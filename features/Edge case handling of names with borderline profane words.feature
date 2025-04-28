Feature: Edge case handling of names with borderline profane words
Scenario: Verify that the system correctly handles names with borderline profane words without blocking legitimate account creations
Given the profanity filter is configured and active
When the user navigates to the account creation page
Then the account creation page is displayed
When the user enters 'borderlineProfaneUser1' in the username field
Then the username is entered successfully
When the user enters 'borderline@example.com' in the email field
Then the email is entered successfully
When the user enters 'Password123!' in the password field
Then the password is entered successfully
When the user submits the account creation form
Then the system processes the input data
When the system checks the username against the profanity list
Then the system performs a profanity check
Then verify the system correctly handles borderline words without blocking
Then borderline words do not block legitimate account creation
When checking the system's response to exact matches of borderline words
Then exact matches of borderline words are flagged
When ensuring the system allows account creation for non-exact matches
Then account creation is allowed for non-exact matches
When verifying system logs for relevant events for borderline word checks
Then relevant events are logged
When checking the system's response time for borderline word checks
Then response time is within acceptable limits
When ensuring the profanity filter is case-insensitive
Then profanity detection is case-insensitive
When verifying the profanity filter is updated with new borderline words
Then profanity filter updates are successful
When ensuring the system can differentiate between contextually acceptable and unacceptable uses
Then the system differentiates contextually acceptable uses
When checking for any false positives in profanity detection
Then no false positives in profanity detection