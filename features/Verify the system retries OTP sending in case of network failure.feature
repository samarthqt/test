Feature: Verify the system retries OTP sending in case of network failure
Scenario: System handles network failure and retries OTP sending
Given a user account with a valid phone number
And the user initiates sign-in using email "user@example.com" and password "SafePass123"
When the system prompts for OTP
And a network failure is simulated before OTP is sent
Then the system detects the network failure
And the system attempts to resend OTP after a brief delay
And logs show timestamped OTP resend attempts
Scenario: System successfully sends OTP after network restoration
Given network connectivity is restored
When the system sends OTP to the user
Then the user receives the OTP
And the user enters the OTP received
Then the sign-in is successful
Scenario: System handles intermittent network connectivity
Given intermittent network connectivity during OTP sending
When the system attempts to send OTP
Then the system handles intermittent failures and retries sending
And the user receives a single valid OTP; duplicates are invalidated
Scenario: System notifies user of network issues
Given network issues occur during OTP sending
When the system detects network issues
Then the user receives a notification about network issues and retry attempts
Scenario: System handles expired OTP after network recovery
Given an expired OTP after network recovery
When the user attempts sign-in with the expired OTP
Then the user receives an error message for the expired OTP
And the user requests a new OTP
Then the user receives a new OTP successfully
Scenario: System behavior with prolonged network failure
Given network failure persists beyond a threshold
When the system detects prolonged network failure
Then the system prompts the user to check network or try later
And the user account remains active without lockout
Scenario: System logs alerts and provides guidance for network issues
Given repeated OTP resend attempts due to network issues
When the system logs alerts for review
Then the user receives appropriate guidance or compensation if applicable