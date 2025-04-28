Feature: Verify system's fallback mechanism when both IDP and Auth0 phone numbers are unavailable
Scenario: Check the system's fallback mechanism during sign-in without phone numbers
Given a user account without a phone number in IDP and Auth0
And access to fallback mechanism settings
When the user initiates sign-in using email "user@example.com" and password "FallbackPass123"
Then the system attempts to retrieve the phone number from IDP
And IDP returns no phone number
When the system attempts to retrieve the phone number from Auth0
Then Auth0 returns no phone number
And the system triggers the fallback mechanism
Then the user is prompted to provide a new phone number
When the user enters a valid new phone number
Then the system accepts the new phone number and sends an OTP
When the user enters the OTP received on the new phone number
Then the sign-in is successful with the OTP
And the user receives a notification about fallback mechanism activation
When checking system logs for fallback mechanism activation
Then logs show activation of fallback mechanism with details
When the user attempts sign-in with an invalid new phone number
Then the system rejects the phone number and prompts for a valid one
When the user skips providing a new phone number
Then the system prompts again or provides alternative verification methods
When checking if fallback mechanism logs are accessible for audit
Then logs are available for audit purposes
And ensure the system does not lock the user account due to fallback mechanism activation
Then the user account remains active without lockout
When verifying if any security alerts are triggered due to fallback mechanism activation
Then the system logs any alerts or flags for security review
And check if the user receives guidance or support during fallback mechanism activation
Then the user receives appropriate guidance or support