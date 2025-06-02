Feature: Large File Upload Efficiency
@TC-317
Scenario: Verify successful login to the system
Given the user has valid credentials
When the user logs into the system
Then the user is successfully logged in
@TC-317
Scenario: Navigate to file upload section
Given the user is logged into the system
When the user navigates to the file upload section
Then the file upload section is displayed
@TC-317
Scenario Outline: Upload and verify large file
Given the user is in the file upload section
When the user selects File <FileSize> for upload
And initiates the upload process for File <FileSize>
Then File <FileSize> uploads successfully without errors
And the integrity of File <FileSize> is confirmed
Examples:
| FileSize |
| 500MB    |
| 1GB      |
| 2GB      |
| 5GB      |
| 10GB     |
@TC-317
Scenario: Check system resource utilization during uploads
Given multiple files are being uploaded
When the system resource utilization is checked
Then resource utilization remains within acceptable limits
@TC-317
Scenario: Monitor system performance metrics post-upload
Given multiple files have been uploaded
When the system performance metrics are monitored
Then performance metrics indicate efficient handling of uploads
@TC-317
Scenario: Verify error messages or logs during uploads
Given files are being uploaded
When error messages or logs are generated
Then no critical errors or warnings are logged
@TC-317
Scenario: Ensure user notifications for upload completion
Given a file upload is completed
When the system sends notifications
Then the user is notified accurately upon upload completion
@TC-317
Scenario: Test system recovery from interrupted uploads
Given an upload is interrupted
When the system attempts to recover
Then the system recovers and resumes upload without data loss
@TC-317
Scenario: Assess impact of concurrent large file uploads
Given multiple large files are uploaded concurrently
When the system handles these uploads
Then the system handles concurrent uploads efficiently