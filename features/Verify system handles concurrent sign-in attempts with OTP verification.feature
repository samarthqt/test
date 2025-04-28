Feature: Verify system handles concurrent sign-in attempts with OTP verification
Scenario: Concurrent sign-in attempts with OTP verification
Given User accounts are created and active
And OTP service is operational
When User1 initiates sign-in using email "user1@example.com" and password "Password123"
Then User1 receives an OTP prompt after entering credentials
When User2 initiates sign-in concurrently using email "user2@example.com" and password "Password456"
Then User2 receives an OTP prompt after entering credentials
When User1 enters the OTP "123456"
Then User1 successfully signs in
When User2 enters the OTP "654321"
Then User2 successfully signs in
When User3 attempts sign-in using email "user3@example.com" and password "Password789" while User1 and User2 are signing in
Then User3 receives an OTP prompt after entering credentials
When User3 enters an incorrect OTP
Then User3 receives an error message for incorrect OTP
When User3 retries sign-in with the correct OTP
Then User3 successfully signs in
When User1 attempts concurrent sign-in from different devices
Then Both devices receive OTP prompts
When User1 enters the OTP on the first device
Then User1 successfully signs in on the first device
When User1 attempts to enter the same OTP on the second device
Then User1 receives an error message as the OTP is already used
When User1 requests a new OTP on the second device
Then User1 receives a new OTP prompt
When User1 enters the new OTP on the second device
Then User1 successfully signs in on the second device
When User2 initiates a sign-in attempt with an expired OTP
Then User2 receives an error message for expired OTP
When User2 requests a new OTP and enters it
Then User2 successfully signs in with the new OTP
Then Verify system logs for concurrent sign-in attempts
And System logs show all concurrent sign-in attempts with timestamps