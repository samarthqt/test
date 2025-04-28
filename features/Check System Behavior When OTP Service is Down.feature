Feature: Check System Behavior When OTP Service is Down
Scenario: Verify system behavior during OTP service downtime
Given OTP service is temporarily disabled
When the user navigates to the sign-in page
Then the user is presented with the sign-in page
Scenario: Validate email and password entry
Given the user is on the sign-in page
When the user enters the registered email "user@example.com" and password "securePassword123"
Then the system validates the email and password
Scenario: Attempt to send OTP
Given the user has entered valid credentials
When the user clicks on the 'Sign In' button
Then the system attempts to send an OTP
Scenario: System response when OTP service is down
Given the OTP service is down
When the system attempts to send an OTP
Then the system displays an error message indicating OTP service is unavailable
Scenario: Suggest alternative authentication methods
Given the OTP service is down
When the system cannot send an OTP
Then the system suggests alternative authentication methods
Scenario: Resend OTP attempt during service downtime
Given the OTP service is down
When the user attempts to resend OTP
Then the system displays a consistent error message for failed OTP resend
Scenario: Check system logs for OTP service failure
Given the OTP service is down
When checking system logs
Then logs reflect OTP service downtime
Scenario: User notification for OTP service downtime
Given the OTP service is down
When the user attempts to sign in
Then the user receives a notification about the OTP service issue
Scenario: Test fallback mechanism for authentication
Given the OTP service is down
When the system activates a fallback mechanism
Then the fallback mechanism is activated successfully
Scenario: System recovery post-OTP service restoration
Given the OTP service is restored
When the system resumes normal operations
Then the system resumes normal OTP dispatch post-recovery
Scenario: Temporary OTP service restoration
Given the OTP service is temporarily restored
When the system handles the restoration
Then the system handles temporary restoration gracefully
Scenario: System response time during OTP service outage
Given the OTP service is down
When the system processes requests
Then the response time aligns with expected standards during the outage
Scenario: Sign-in attempt with incorrect OTP during service outage
Given the OTP service is down
When the user attempts sign-in with an incorrect OTP
Then the system consistently prompts an error for incorrect OTP
Scenario: Capture user experience feedback for OTP service outage
Given the OTP service is down
When the user provides feedback
Then user feedback is captured for service improvement
Scenario: System ability to handle peak sign-in attempts during outage
Given the OTP service is down
When peak sign-in attempts occur
Then the system manages peak attempts without crashing