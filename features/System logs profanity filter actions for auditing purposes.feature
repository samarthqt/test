Feature: System logs profanity filter actions for auditing purposes
Scenario: Enable profanity filter in the system settings
Given the profanity filter is disabled
When the user enables the profanity filter in the system settings
Then the profanity filter is enabled successfully
Scenario: Enter a profane word in the input field
Given the profanity filter is enabled
When the user enters a profane word "badword" in the input field
Then the profanity filter blocks the input and logs the action
Scenario: Enter a non-profane word in the input field
Given the profanity filter is enabled
When the user enters a non-profane word "hello" in the input field
Then the input is accepted and no action is logged by the profanity filter
Scenario: Enter a borderline profane word in the input field
Given the profanity filter is enabled
When the user enters a borderline profane word "heck" in the input field
Then the system evaluates the word and logs the decision taken by the profanity filter
Scenario: Enter special characters in the input field
Given the profanity filter is enabled
When the user enters special characters "@#$%" in the input field
Then the system accepts the input and logs no action by the profanity filter
Scenario: Enter a mix of profane and non-profane words in the input field
Given the profanity filter is enabled
When the user enters mixed content "hello badword" in the input field
Then the profanity filter blocks the input and logs the action
Scenario: Review the system logs for entries related to the profanity filter
Given the system logs are accessible
When the user reviews the system logs
Then the logs contain detailed entries for each action taken by the profanity filter
Scenario: Verify the timestamp and details of each log entry
Given the system logs are accessible
When the user verifies the timestamp and details of each log entry
Then each log entry has a correct timestamp and detailed information about the action
Scenario: Check logs accessibility to authorized personnel only
Given the system logs are secured
When a user attempts to access the logs
Then logs are accessible only to authorized users
Scenario: Attempt to edit a log entry
Given the system logs are secured
When a user attempts to edit a log entry
Then the system does not allow editing of log entries
Scenario: Attempt to delete a log entry
Given the system logs are secured
When a user attempts to delete a log entry
Then the system does not allow deletion of log entries
Scenario: Check if logs are stored for a predefined retention period
Given the system has a configured retention policy
When the user checks the logs
Then logs are retained according to the configured retention policy
Scenario: Verify if logs are backed up regularly
Given the system has regular backups
When the user verifies the backup process
Then logs are included in regular system backups
Scenario: Simulate a system crash and verify log integrity post-recovery
Given the system experiences a crash
When the system recovers
Then logs remain intact and accessible after system recovery
Scenario: Review the audit trail for any anomalies
Given the system logs are available
When the user reviews the audit trail
Then the audit trail matches the actions logged by the profanity filter