Feature: Verify maximum OTP attempts handling
Scenario: Check system's response when maximum allowed OTP attempts are reached
Given the user has access to OTP functionality
And the user is logged into the system
When the user navigates to the OTP verification page
Then the OTP verification page is displayed
Scenario: Enter incorrect OTP codes
Given the user is on the OTP verification page
When the user enters the first incorrect OTP code "123456"
Then the system displays an error message for incorrect OTP
When the user attempts OTP verification with the second incorrect OTP code "654321"
Then the system displays an error message for incorrect OTP
When the user attempts OTP verification with the third incorrect OTP code "000000"
Then the system blocks further attempts and displays a message indicating maximum attempts reached
Scenario: Verify account lockout after maximum attempts
Given the user has reached the maximum OTP attempts
When the user checks their account status
Then the account is temporarily locked, and the user is notified
Scenario: Check system logs for OTP attempts and lockout
When the user checks the system logs
Then the system logs contain entries for each OTP attempt and lockout
Scenario: Verify system guidance after lockout
When the user checks the system guidance for next steps after lockout
Then the system provides clear guidance on next steps after lockout
Scenario: Attempt OTP verification after lockout period
Given the lockout period has expired
When the user attempts OTP verification
Then the system allows new OTP attempts
Scenario: Check system's response time for lockout message
When the user reaches maximum OTP attempts
Then the system promptly displays the lockout message
Scenario: Verify security measures during lockout period
When the user attempts unauthorized access during lockout
Then the system maintains security with no unauthorized access
Scenario: Test with valid OTP after lockout
Given the lockout period has expired
When the user enters a valid OTP
Then the system accepts the valid OTP and completes verification
Scenario: Attempt to bypass lockout using different device
When the user attempts to bypass lockout using a different device
Then the system detects and blocks attempts to bypass lockout
Scenario: Verify user notification methods for lockout status
When the user checks their notification channels
Then the user is notified of lockout status through multiple channels
Scenario: Test system behavior under high OTP request volumes
When the system receives high OTP request volumes
Then the system maintains performance and security under high request volumes
Scenario: Ensure system logs contain detailed information for auditing
When the user checks the system logs for auditing
Then the system logs contain detailed information for auditing OTP attempts and lockouts