Feature: Logging of Verification Attempts
Scenario: Verify logging of verification attempts for audit purposes
Given system logging is enabled
When a verification attempt is initiated by entering the code
Then the system logs the attempt with a timestamp and user ID
Scenario: Log separate attempts for incorrect code entries
Given system logging is enabled
When an incorrect code is entered and retried
Then the system logs each attempt separately
Scenario: Verify log entry contains relevant details
Given system logging is enabled
When a verification attempt is initiated
Then the log entry includes IP address and device information
Scenario: Log successful and failed verification attempts
Given system logging is enabled
When verification attempts are made
Then both successful and failed attempts are logged
Scenario: Log expiration of verification codes
Given system logging is enabled
When a verification code expires
Then the code expiration is logged with a timestamp
Scenario: Log verification attempts from different locations
Given system logging is enabled
When verification attempts are made from different locations
Then log entries show location details for each attempt
Scenario: Log multiple attempts within a short time frame
Given system logging is enabled
When multiple verification attempts are made within a short time frame
Then each attempt is logged with precise timestamps
Scenario: Log attempts using different verification methods
Given system logging is enabled
When verification attempts are made using different methods
Then log entries indicate the method used for each attempt
Scenario: System's handling of log entries during peak activity
Given system logging is enabled
When verification attempts are made during peak activity periods
Then logs are maintained accurately without loss of data
Scenario: Filter logs by user ID
Given system logging is enabled
When logs are filtered by user ID
Then logs display attempts for a specific user ID
Scenario: Export logs for audit purposes
Given system logging is enabled
When logs are exported for audit purposes
Then logs can be exported in a readable format for audits
Scenario: Handling of log entries with incorrect data
Given system logging is enabled
When log entries contain incorrect data
Then the system alerts for incorrect log data without affecting the logging process
Scenario: Archive old log entries
Given system logging is enabled
When old log entries are archived
Then old log entries are archived without affecting current logging
Scenario: Response to log entry errors
Given system logging is enabled
When log entry errors occur (e.g., missing data)
Then the system alerts for errors and maintains log integrity
Scenario: Behavior with simultaneous verification attempts from multiple users
Given system logging is enabled
When simultaneous verification attempts are made from multiple users
Then each user's attempt is logged separately and accurately