Feature: Negative test for system recovery from network failure during sign-in
Scenario: Validate system behavior when network failure persists throughout the sign-in attempt
Given User has a valid account
And Network connection is initially stable
When User navigates to the sign-in page
Then Sign-in page is displayed with email and password fields
Scenario: Enter valid credentials and simulate network failure
Given User has a valid account
And Network connection is initially stable
When User enters a valid email address "user@example.com" in the email field
And User enters a valid password "validPassword123" in the password field
And User simulates a persistent network failure using the network failure tool
Then Network connection is interrupted and remains down
Scenario: Handle persistent network error during sign-in
Given Network connection is interrupted
When User attempts to click on the 'Sign In' button
Then System displays a persistent network error message
And System continues to display network error message after a predefined timeout period
And System does not automatically retry; prompts user to retry manually
Scenario: Restore network connection and retry sign-in
Given Network connection is interrupted
When User restores the network connection after a prolonged period
And User attempts to click on the 'Sign In' button again
Then User is successfully signed in, and the home page is displayed
Scenario: System logging and behavior during network failure
Given Persistent network failure occurs
When User attempts to sign in
Then System logs appropriate error messages for the persistent failure
And System consistently displays error messages and prompts user action
And No partial sign-in attempts are recorded during network failure
And User session is not initiated until successful sign-in
Scenario: UI behavior during persistent failure and recovery
Given Persistent network failure occurs
When User attempts to interact with the UI
Then UI remains responsive, and user is informed of network status
Scenario: Handle invalid credentials during network failure
Given Persistent network failure occurs
When User enters invalid email/password
Then System handles invalid credentials gracefully and prompts retry