Feature: Voice Integration for Banking
Scenario: Perform basic banking tasks using voice commands
Given a user has a voice assistant integrated with their banking app
When the user gives a voice command to check their balance
Then the system should process the command within 5 seconds
And the system should provide the account balance to the user
When the user gives a voice command to transfer funds
And the transaction amount is below the multi-factor authentication threshold
Then the system should process the command within 5 seconds
And the system should transfer the funds as requested
When the user gives a voice command to transfer funds
And the transaction amount is above the multi-factor authentication threshold
Then the system should request multi-factor authentication
And the user provides valid authentication
Then the system should process the command within 5 seconds
And the system should transfer the funds as requested
When the user gives a voice command to view transaction history
Then the system should process the command within 5 seconds
And the system should provide the transaction history to the user
Scenario: Logging and notifications for voice command executions
Given a user has performed a banking task using a voice command
Then the system must log the voice interaction for audit purposes
When a voice command execution is successful
Then the user should be notified of the successful execution
When a voice command execution fails
Then the user should be notified of the failed execution