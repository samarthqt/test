Feature: Password Reset During Server Maintenance
Scenario: Inform users when attempting password reset during server maintenance
Given server maintenance is scheduled
When the user navigates to the login page
Then the login page is displayed
Scenario: User attempts password reset during maintenance
Given the user is on the password reset page
When the user clicks on 'Forgot Password?' link
Then the password reset page is displayed
When the user enters the registered email "user@domain.com" in the email field
Then the email is entered in the field
When the user clicks on the 'Submit' button
Then the system processes the request
And the system displays a maintenance message "Service is currently unavailable due to maintenance. Please try again later."
Scenario: Access the password reset page again during maintenance
When the user attempts to access the password reset page again during maintenance
Then access is blocked with a maintenance message
Scenario: Check maintenance schedule communication
When the maintenance schedule is communicated to users ahead of time
Then users are informed of maintenance schedule via email or notification
Scenario: Attempt login during server maintenance
When the user attempts to log in during server maintenance
Then login is unsuccessful with a maintenance message
Scenario: Verify alternative contact methods during maintenance
When verifying if any alternative contact methods are provided during maintenance
Then the system provides contact information for support during maintenance
Scenario: Check system logs for maintenance-related entries
When checking the system logs for maintenance-related entries
Then logs indicate maintenance mode is active
Scenario: Access other parts of the system during maintenance
When trying to access other parts of the system during maintenance
Then access is restricted with a maintenance message
Scenario: System resumes normal operations post-maintenance
When verifying if the system resumes normal operations post-maintenance
Then the system functions normally after maintenance period ends
Scenario: Password reset immediately after maintenance ends
When attempting password reset immediately after maintenance ends
Then the password reset process is successful
Scenario: Queued password reset requests processed post-maintenance
When checking if any queued password reset requests are processed post-maintenance
Then queued requests are processed successfully
Scenario: Verify system performance immediately after maintenance
When verifying system performance immediately after maintenance
Then system performance is optimal post-maintenance