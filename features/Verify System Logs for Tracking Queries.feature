Feature: Verify System Logs for Tracking Queries
@TC-216
Scenario: Navigate to the system's logging configuration page
Given I have access to the system's logging configuration
When I navigate to the system's logging configuration page
Then the logging configuration page is displayed
@TC-216
Scenario: Verify tracking queries are enabled in the configuration
Given I am on the logging configuration page
When I check the tracking queries setting
Then tracking queries are confirmed to be enabled
@TC-216
Scenario: Execute a product search query in the application
Given I have access to the application
When I execute a product search query
Then the product search query is executed successfully
@TC-216
Scenario: Access system logs and filter by the current date
Given I have access to the system logs
When I filter the logs by the current date
Then system logs for the current date are displayed
@TC-216
Scenario: Locate the log entry for the executed product search query
Given I have the system logs for the current date
When I search for the log entry of the executed product search query
Then the log entry for the product search query is found
@TC-216
Scenario: Verify details of the log entry
Given I have located the log entry for the product search query
When I check the details of the log entry
Then log entry details match the executed query
@TC-216
Scenario: Check if the User ID is logged correctly
Given I have the log entry for the product search query
When I verify the User ID in the log entry
Then User ID is correctly logged in the system
@TC-216
Scenario: Ensure the log entry includes Query Type information
Given I have the log entry for the product search query
When I check the Query Type information in the log entry
Then Query Type information is present in the log entry
@TC-216
Scenario: Examine the log entry for error messages or warnings
Given I have the log entry for the product search query
When I examine the log entry for any error messages or warnings
Then no error messages or warnings are present
@TC-216
Scenario: Repeat query execution and logging verification for different query types
Given I have access to the application
When I execute different types of queries and check their log entries
Then log entries are correctly recorded for all query types
@TC-216
Scenario: Check system logs for unauthorized access attempts
Given I have access to the system logs
When I check the logs for any unauthorized access attempts
Then no unauthorized access attempts are logged
@TC-216
Scenario: Verify log entries are stored in a secure location
Given I have access to the system logs
When I check the storage location of log entries
Then log entries are stored securely
@TC-216
Scenario: Ensure log entries can be exported for audit purposes
Given I have access to the system logs
When I attempt to export log entries for audit purposes
Then log entries are exportable for audits
@TC-216
Scenario: Check if system logs are retained for a specified period
Given I have access to the system logs
When I check the retention period of system logs
Then system logs are retained as per the configured period
@TC-216
Scenario: Confirm log entries are accessible only to authorized personnel
Given I have access to the system logs
When I check accessibility of log entries
Then log entries are accessible only to authorized users