Feature: Verify error handling during server downtime or maintenance
Scenario: Ensure the system correctly handles sign-in attempts during server downtime or maintenance periods
Given scheduled server maintenance period is known
And system is capable of simulating server downtime
When I simulate server downtime or maintenance period
Then server is in downtime or maintenance mode
Scenario: Attempt to sign in during server downtime
Given I navigate to the sign-in page
And sign-in page is displayed with fields for email and password
When I enter a valid email "user@example.com" in the email field
And I enter a valid password "CorrectPassword123" in the password field
And I click the 'Sign In' button
Then the sign-in attempt is initiated
And the system displays an error message indicating server downtime
And the error message provides guidance on what to do next
And the system provides an estimated time for server availability (if applicable)
And downtime event is logged in the system
Scenario: Attempt to sign in after server is back online
Given the server is back online
When I attempt to sign in again
Then sign-in is successful if credentials are correct
Scenario: Verify system guidance and error handling consistency
Given the system provides guidance on alternative sign-in methods during downtime (if applicable)
Then error handling is consistent across different browsers
And error handling is consistent across different devices
And error message does not expose any sensitive information
Scenario: Validate system maintenance notice
Given the system provides a maintenance notice prior to downtime (if applicable)
Then the maintenance notice is displayed before downtime