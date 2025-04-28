Feature: Delayed Messaging Update on 'Check your Email' Screen for Brand Three
Scenario: Test the system's handling of delayed messaging updates on the 'Check your Email' screen for Brand Three users.
Given a user is registered with Brand Three and has initiated an email verification process
When the user initiates the email verification process for Brand Three
Then the user is directed to the 'Check your Email' screen
And the message "Please check your email for the verification link." is displayed
Scenario: Simulate a delay in the messaging update
Given the user is on the 'Check your Email' screen for Brand Three
When a delay in the messaging update is simulated
Then the message updates after a delay
And the expected message is "Please check your email for the verification link."
Scenario: Verify the final message displayed after the delay
Given the message updates after a delay
When the final message is displayed
Then the final message is correct and matches the expected message
Scenario: Ensure the delay does not confuse the user
Given the user experiences a delayed messaging update
When the user reads the final message
Then the user is not confused by the delayed messaging update