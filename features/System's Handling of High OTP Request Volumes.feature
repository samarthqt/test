Feature: System's Handling of High OTP Request Volumes
Scenario: Check system's ability to handle high OTP request volumes during peak hours
Given the user is on the sign-in page
When the user enters the registered email "user@example.com" and password "securePassword123"
And clicks on the 'Sign In' button
Then the system initiates the OTP sending process
Scenario: Simulate high OTP request volumes
Given the system is simulating peak hour traffic
When high OTP request volumes are generated
Then the system manages high volumes without failure
Scenario: Verify system's response time under peak conditions
Given the system is under peak condition simulation
When checking the system's response time
Then the response time aligns with expected standards
Scenario: Check system logs for performance metrics
Given the system is under load
When checking the system logs
Then logs reflect system's performance under load
Scenario: Test system's fallback mechanism for high traffic
Given high traffic conditions are simulated
When the system's fallback mechanism is triggered
Then the fallback mechanism is activated successfully
Scenario: Verify system's ability to prioritize OTP requests
Given high OTP request volumes
When the system processes requests
Then the system prioritizes requests effectively
Scenario: Check user notification for delayed OTP during peak hours
Given peak hour traffic conditions
When an OTP request is delayed
Then the user receives notification about potential delays
Scenario: Attempt to resend OTP during peak hours
Given peak hour traffic conditions
When the user attempts to resend OTP
Then the system handles resend requests efficiently
Scenario: Verify system's recovery process post-peak hours
Given peak hour traffic has subsided
When checking the system's recovery process
Then the system resumes normal OTP dispatch post-peak
Scenario: Simulate temporary network slowdown during peak hours
Given peak hour traffic conditions
When a temporary network slowdown occurs
Then the system manages slowdown without crashing
Scenario: Check user experience feedback for peak hour performance
Given peak hour conditions
When collecting user experience feedback
Then user feedback is captured for service improvement
Scenario: Verify system's ability to scale during peak hours
Given peak hour traffic conditions
When the system scales to manage load
Then the system scales effectively
Scenario: Test system's ability to handle concurrent OTP requests
Given high OTP request volumes
When concurrent OTP requests are made
Then the system manages concurrent requests without failure