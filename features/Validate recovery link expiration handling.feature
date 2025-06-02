Feature: Validate recovery link expiration handling
Ensure that recovery links expire correctly after the designated time period.
@TC-120
Scenario: Initiate password recovery process and receive recovery link
Given a user account with email verification enabled
When the user initiates the password recovery process
Then a recovery link is sent to the user's email "user@example.com"
@TC-120
Scenario: Access recovery link within expiration time
Given a recovery link sent to the user's email
When the user accesses the email and clicks on the recovery link within 24 hours
Then the user is directed to the password recovery page successfully
@TC-120
Scenario: Attempt to use recovery link after expiration time
Given a recovery link sent to the user's email
When the user attempts to use the recovery link after 24 hours
Then the user receives an error message indicating the link has expired
@TC-120
Scenario: Verify system logs for link expiration events
Given a recovery link sent to the user's email
When the recovery link expires
Then the system logs show the link expiration timestamp
@TC-120
Scenario: Request a new recovery link after expiration
Given a recovery link has expired
When the user requests a new recovery link
Then a new recovery link is sent to the user's email