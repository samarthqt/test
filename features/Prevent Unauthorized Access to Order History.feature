Feature: Prevent Unauthorized Access to Order History
@TC-195
Scenario: Attempt to log in with invalid credentials
Given the user is on the login page
When the user enters invalid User ID "54321" and Password "wrongpass"
Then the system prevents login and displays an error message
@TC-195
Scenario: Navigate to the 'Order History' section without logging in
Given the user is on the home page
When the user navigates to the 'Order History' section
Then access to the order history page is denied
@TC-195
Scenario: Try to access the order history using a different user's account
Given the user is logged in with a valid account
When the user attempts to access another user's order history
Then the system prevents access to another user's order history
@TC-195
Scenario: Use session hijacking techniques to access order history
Given a user has hijacked a session
When the user attempts to access the order history
Then the system's security mechanisms prevent unauthorized access
@TC-195
Scenario: Attempt to view order history with expired session
Given the user's session has expired
When the user attempts to view order history
Then access is denied and the user is prompted to log in again
@TC-195
Scenario: Check system logs for unauthorized access attempts
Given the system is running
When unauthorized access attempts occur
Then unauthorized access attempts are logged for audit purposes
@TC-195
Scenario: Verify security measures in place to prevent unauthorized access
Given the system has security measures like encryption and authentication
When unauthorized access attempts occur
Then security measures are effectively preventing access
@TC-195
Scenario: Test access prevention mechanisms during peak usage times
Given the system is experiencing peak usage
When unauthorized access attempts occur
Then security measures remain effective even during peak times
@TC-195
Scenario: Attempt to access order history using SQL injection
Given the user attempts SQL injection on the order history page
When the system processes the request
Then the system's security mechanisms prevent SQL injection attacks
@TC-195
Scenario: Verify access prevention across different browsers
Given the user is accessing the system using different browsers
When unauthorized access attempts occur
Then access prevention measures work consistently across different web browsers
@TC-195
Scenario: Check for performance and response time during unauthorized access attempts
Given the system is running
When unauthorized access attempts occur
Then the system handles unauthorized access attempts efficiently without delays
@TC-195
Scenario: Test access prevention with various internet connection speeds
Given the user has different internet connection speeds
When unauthorized access attempts occur
Then unauthorized access prevention remains effective regardless of internet connection speed
@TC-195
Scenario: Verify access prevention on different devices
Given the user is accessing the system on different devices (desktop, mobile)
When unauthorized access attempts occur
Then unauthorized access prevention works seamlessly across different devices
@TC-195
Scenario: Check for any error messages during unauthorized access attempts
Given unauthorized access attempts occur
When the system processes the request
Then appropriate error messages are displayed, indicating access is denied
@TC-195
Scenario: Ensure user is redirected to login page after failed access attempts
Given the user attempts unauthorized access
When access is denied
Then user is redirected to the login page, prompting them to enter valid credentials