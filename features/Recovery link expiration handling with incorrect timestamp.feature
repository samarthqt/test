Feature: Recovery link expiration handling with incorrect timestamp
@TC-121
Scenario: Initiate password recovery process for the user account
Given a user account with email verification enabled
And the user email is "user@example.com"
When the user initiates the password recovery process
Then a recovery link is sent to the user's email
@TC-121
Scenario: Access recovery link within incorrect expiration time
Given the user has received a recovery link
When the user accesses the email and clicks on the recovery link within 48 hours
Then the user receives an error message indicating the link has expired
@TC-121
Scenario: Verify system logs for incorrect expiration handling
Given the user attempted to use an expired recovery link
When the system logs are checked
Then the system logs show handling of incorrect expiration timestamp
@TC-121
Scenario: Attempt to use recovery link with a future timestamp
Given a recovery link with a future timestamp
When the user attempts to use the recovery link
Then the user receives an error message indicating the link is invalid
@TC-121
Scenario: Request a new recovery link with correct expiration timestamp
Given the user requests a new recovery link
When the system sends the recovery link
Then a new recovery link is sent to the user's email with the correct expiration timestamp