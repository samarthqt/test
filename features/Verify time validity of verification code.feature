Feature: Verify time validity of verification code
Scenario: Receive the verification code via SMS
Given the user has received a verification code
When the user receives the verification code via SMS
Then the verification code "123456" is received
Scenario: Enter the code within 3 minutes
Given the user has received the verification code
When the user waits for 3 minutes before entering the code
Then the code is still valid and accepted by the system
Scenario: Enter the code after 6 minutes
Given the user has received the verification code
When the user waits for 6 minutes before entering the code
Then the code is expired and not accepted by the system
Scenario: Enter the code multiple times within 5 minutes
Given the user has received the verification code
When the user attempts to enter the code multiple times within 5 minutes
Then the code is accepted each time within the validity period
Scenario: Display message when code expires
Given the user has received the verification code
When the code expires
Then the system displays "Verification code expired" message
Scenario: Check system logs for code expiration
Given the user has received the verification code
When the code expires
Then the system logs show the code expiration timestamp
Scenario: Use the code after logging out and back in within 5 minutes
Given the user has received the verification code
When the user logs out and logs back in within 5 minutes
Then the code is still valid and accepted
Scenario: Use the code after a system restart within 5 minutes
Given the user has received the verification code
When the system is restarted within 5 minutes
Then the code is still valid and accepted
Scenario: Request a new code after expiration
Given the user has received the verification code
When the code expires
Then the user can request a new code
Scenario: Handle code entry errors during validity period
Given the user has received the verification code
When the user enters the code incorrectly during the validity period
Then the system prompts for correct code entry without affecting validity
Scenario: Prevent code reuse after expiration
Given the user has received the verification code
When the code expires
Then the expired code cannot be reused
Scenario: Use the code with incorrect formatting during validity period
Given the user has received the verification code
When the user enters the code with incorrect formatting during the validity period
Then the system rejects incorrectly formatted code
Scenario: Simultaneous code entries from different devices
Given the user has received the verification code
When the code is entered simultaneously from different devices within the validity period
Then the code is valid on all devices
Scenario: Handle network delays in code entry
Given the user has received the verification code
When there are network delays in code entry
Then the code remains valid despite network delays
Scenario: Multiple verification requests within the validity period
Given the user has received the verification code
When the user makes multiple verification requests within the validity period
Then the system issues a new code for each request and maintains validity