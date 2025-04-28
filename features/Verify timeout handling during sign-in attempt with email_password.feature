Feature: Verify timeout handling during sign-in attempt with email/password
Scenario: Ensure the system correctly handles timeouts during a sign-in attempt using email and password
Given the user has an existing account with valid email "user@example.com" and password "CorrectPassword123"
And the system has a defined timeout period for sign-in attempts of 30 seconds
When the user navigates to the sign-in page
Then the sign-in page is displayed with fields for email and password
Scenario: Enter valid credentials and initiate sign-in
Given the user is on the sign-in page
When the user enters a valid email "user@example.com" in the email field
And the user enters a valid password "CorrectPassword123" in the password field
And the user clicks the 'Sign In' button
Then the sign-in attempt is initiated
Scenario: Simulate timeout during sign-in
Given the sign-in attempt is initiated
When a delay longer than the timeout period is simulated before the server responds
Then the system waits for a response
And the system displays a timeout error message
Scenario: Verify timeout error message
Given a timeout error message is displayed
Then the error message is clear and informative
And the error message provides guidance on what to do next
Scenario: Attempt sign-in again after timeout
Given a timeout has occurred
When the user attempts to sign in again with the same credentials
Then the sign-in is successful if credentials are correct
Scenario: System behavior after timeout
Given a timeout has occurred
Then the user can attempt to sign in again
And the session is terminated and the user needs to re-enter credentials
And the timeout event is logged in the system
Scenario: Option to extend timeout period
Given a timeout has occurred
Then the system provides an option to extend the timeout period if applicable
Scenario: Consistency of timeout handling
Given a timeout has occurred
Then the timeout handling is consistent across different browsers
And the timeout handling is consistent across different devices
Scenario: Security of timeout error message
Given a timeout error message is displayed
Then the error message does not expose any sensitive information