Feature: Verify OTP Sent to International Phone Number
Scenario: Verify system behavior when OTP is sent to an international phone number in IDP
Given a user has an international phone number registered in the IDP
When the user navigates to the sign-in page
Then the user is presented with the sign-in page
Scenario: Validate email and password for OTP dispatch
Given the user is on the sign-in page
When the user enters the registered email and password
Then the system validates the email and password
Scenario: Initiate OTP sending process
Given the email and password are validated
When the user clicks on the 'Sign In' button
Then the system initiates the OTP sending process
Scenario: Confirm OTP sent to international phone number
Given the OTP sending process is initiated
When the system sends the OTP
Then the OTP is successfully sent to the international phone number
Scenario: Enter and verify received OTP
Given the OTP is sent to the user
When the user enters the received OTP on the verification page
Then the OTP is accepted and the user is signed in
Scenario: Verify format of international phone number
Given the user is signed in
When the system checks the phone number format
Then the phone number is stored in the correct international format
Scenario: Check system logs for OTP dispatch confirmation
Given the OTP is sent
When checking the system logs
Then logs confirm OTP dispatch to the international number
Scenario: Resend OTP despite network delay
Given there is a network delay
When the user requests to resend the OTP
Then the OTP is resent successfully despite the network delay
Scenario: Verify OTP expiration time for international numbers
Given an OTP is sent
When checking the OTP expiration time
Then the OTP expiration aligns with system standards
Scenario: Attempt sign-in with incorrect OTP
Given the user enters an incorrect OTP
When the system validates the OTP
Then the system prompts an error message for incorrect OTP
Scenario: Check if OTP is logged correctly for auditing
Given an OTP is sent and verified
When checking the system logs
Then OTP dispatch and verification are logged
Scenario: Handle multiple OTP requests to international numbers
Given multiple OTP requests are made to international numbers
When the system processes these requests
Then the system handles multiple requests without failure
Scenario: Test OTP dispatch to different international regions
Given a user in a different international region requests an OTP
When the system sends the OTP
Then the OTP is successfully sent to various international regions
Scenario: System behavior when OTP is delayed
Given the OTP sending process is delayed
When the user waits for the OTP
Then the system provides an appropriate message for delayed OTP
Scenario: Verify user sign-in with OTP after international travel
Given the user has traveled internationally
When the user signs in with the OTP
Then the user signs in successfully with the OTP post-travel