Feature: Verify system behavior when the phone number in IDP is updated during the sign-in process
Scenario: Update phone number during sign-in process
Given a user account is linked to an IDP with a valid phone number
And the user has access to the IDP management interface
When the user initiates sign-in using email "user@example.com" and password "SecurePass123"
Then the user should receive an OTP prompt for the current phone number
Scenario: Update phone number in IDP
When the user updates the phone number in the IDP to a new number "+0987654321"
Then the IDP should reflect the new phone number
Scenario: Enter OTP sent to old phone number
When the user attempts to enter the OTP sent to the old phone number "+1234567890"
Then the user should receive an error message indicating the OTP is invalid
Scenario: Request new OTP after phone number update
When the user requests a new OTP after phone number update
Then the user should receive the OTP on the new phone number "+0987654321"
Scenario: Enter new OTP for successful sign-in
When the user enters the new OTP "112233" received on the updated phone number
Then the user should successfully sign in with the new OTP
Scenario: Verify system logs for phone number update
Then the system logs should show timestamped phone number update and OTP requests
Scenario: Check user notifications for phone number change
Then the user should receive a notification of phone number update
Scenario: Attempt sign-in with old phone number after update
When the user attempts to sign in with the old phone number
Then the user should receive an error message indicating phone number mismatch
Scenario: Verify new phone number in account settings
Then the user's account settings should display the updated phone number
Scenario: Simulate network failure during OTP request
When a network failure is simulated during the OTP request after phone number update
Then the system should retry OTP sending or prompt the user to retry
Scenario: Update phone number back to old number during sign-in
When the user attempts to update the phone number back to the old number during sign-in
Then the IDP should allow or reject the update based on policy
Scenario: Verify OTP delivery to reverted phone number
When the phone number update is successful
Then the OTP should be sent to the reverted phone number if allowed
Scenario: Check for security alerts due to frequent phone number changes
Then the system should log any alerts or flags for security review
Scenario: Additional verification steps due to phone number changes
Then the user may be prompted for additional verification based on policy
Scenario: Ensure valid and secure sign-in session after phone number update
Then the user should remain securely signed in without session invalidation