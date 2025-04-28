Feature: Delayed Messaging Update on 'Check your Email' Screen for Brand Two
Scenario: Test the system's handling of delayed messaging updates for Brand Two users
Given a user is registered with Brand Two and has initiated an email verification process
When the user initiates the email verification process
Then the user should be directed to the 'Check your Email' screen
And the message "Please check your email for the verification link." should be displayed
Scenario: Simulate delay in messaging update for Brand Two users
Given the user is on the 'Check your Email' screen
When a delay in the messaging update is simulated
Then the message should update after a delay
And the expected message "Please check your email for the verification link." should be displayed
Scenario: Verify the final message after delay for Brand Two users
Given there is a delay in the messaging update
When the final message is displayed after the delay
Then the final message should be correct and match the expected message
Scenario: Ensure user is not confused by delayed messaging update
Given there is a delay in the messaging update
When the user views the delayed message
Then the user should not be confused by the delayed messaging update