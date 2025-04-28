Feature: Negative test for sign-in during peak traffic
Scenario: Validate system behavior when sign-in attempts exceed server capacity during peak traffic
Given the server is under simulated peak load beyond capacity
And the user has a valid account with email "user@example.com" and password "validPassword123"
When the user navigates to the sign-in page
Then the sign-in page should be displayed with email and password fields
Scenario: Attempt sign-in during peak traffic
Given the server is under simulated peak load beyond capacity
When the user enters a valid email address in the email field
And the user enters a valid password in the password field
And the user clicks on the 'Sign In' button
Then the system may delay or deny sign-in due to traffic load
And appropriate error messages or retry prompts are displayed
Scenario: Repeated sign-in attempts during peak traffic
Given the server is under simulated peak load beyond capacity
When the user attempts to sign in repeatedly
Then the system handles repeated attempts gracefully without crashing
Scenario: Verify system logs for capacity-related errors
Given the server is under simulated peak load beyond capacity
When the user attempts to sign in
Then capacity-related errors are logged for auditing
Scenario: Sign-in with multiple users exceeding server capacity
Given the server is under simulated peak load beyond capacity
When multiple users attempt to sign in
Then the system manages excess load without significant failures
Scenario: Verify UI behavior during excessive peak traffic
Given the server is under simulated peak load beyond capacity
When the user navigates the UI
Then the UI remains responsive, and the user is informed of delays
Scenario: Test system's ability to queue sign-in requests during peak traffic
Given the server is under simulated peak load beyond capacity
When the user attempts to sign in
Then the system queues requests and processes them as capacity allows
Scenario: Ensure no data corruption occurs during excessive peak traffic
Given the server is under simulated peak load beyond capacity
When the user attempts to sign in
Then no data corruption occurs; user data remains intact
Scenario: Verify system's failover mechanisms during peak traffic overload
Given the server is under simulated peak load beyond capacity
When the user attempts to sign in
Then failover mechanisms activate and manage overload effectively
Scenario: Test with invalid email/password during peak traffic overload
Given the server is under simulated peak load beyond capacity
When the user enters an invalid email/password
Then the system handles invalid credentials gracefully and prompts retry
Scenario: Check for any session management issues during excessive peak traffic
Given the server is under simulated peak load beyond capacity
When the user attempts to sign in
Then session management is handled correctly, with no issues