Feature: 2FA Code Entry at Expiration Boundary
@TC-246
Scenario: Navigate to the login page
Given 2FA must be enabled for the account
And the user account exists
When the user navigates to the login page
Then the user is directed to the login page
@TC-246
Scenario: Enter valid username and password
Given a valid username and password
When the user enters valid credentials
Then the credentials are accepted
@TC-246
Scenario: Generate a 2FA code using the authenticator app
Given access to a valid 2FA code generator
When the user generates a 2FA code using the authenticator app
Then a 2FA code is generated
@TC-246
Scenario: Wait until the 2FA code is close to expiration
Given the 2FA code is generated
When the user waits until the 2FA code is close to expiration
Then the 2FA code is near expiration
@TC-246
Scenario: Enter the 2FA code and attempt to login
Given the 2FA code is near expiration
And the network conditions are stable and unstable
When the user enters the 2FA code and attempts to login
Then the login attempt is processed
@TC-246
Scenario: Observe system behavior for code entry at expiration boundary
Given the login attempt is processed
When the code entry is at expiration boundary
Then the system handles code expiration correctly
@TC-246
Scenario: Verify success or failure based on code validity
Given the system handles code expiration correctly
When verifying the code validity
Then login succeeds or fails appropriately
@TC-246
Scenario: Check for error messages if login fails
Given login fails due to expired code
When checking for error messages
Then an error message is displayed for expired code
@TC-246
Scenario: Test system response time for processing 2FA code
Given the user enters a 2FA code
When testing system response time
Then the system processes the code promptly
@TC-246
Scenario: Attempt login with a new code immediately after expiration
Given the previous code has expired
When attempting login with a new code immediately after expiration
Then login succeeds with a new valid code
@TC-246
Scenario: Review system logs for code expiration events
Given login attempts are made
When reviewing system logs
Then code expiration events are logged
@TC-246
Scenario: Check system behavior under unstable network conditions
Given network conditions are unstable
When checking system behavior
Then the system handles network instability gracefully
@TC-246
Scenario: Test login attempts on different devices
Given the user attempts login
When testing on different devices (mobile and desktop)
Then login behavior is consistent across devices
@TC-246
Scenario: Verify system prompts for new code generation after expiration
Given the previous code has expired
When verifying system prompts
Then the system prompts for new code generation
@TC-246
Scenario: Ensure user is directed to retry login with a valid code
Given the user is prompted to retry login
When ensuring retry login
Then the user is directed to retry login with a valid code