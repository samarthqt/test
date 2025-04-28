Feature: Verify behavior when incorrect OTP is entered
Scenario: Incorrect OTP entry during verification process
Given the user has initiated an OTP verification process
And the user has received an OTP
When the user navigates to the OTP verification screen
Then the OTP verification screen is displayed
When the user enters an incorrect OTP "123456" in the OTP field
Then the system accepts the input and allows submission
When the user clicks on the "Verify" button
Then the system processes the OTP
And the system displays an error message indicating incorrect OTP
When the user attempts to re-enter the OTP
Then the user is allowed to re-enter the OTP
When the user enters the correct OTP "654321" in the OTP field
Then the system accepts the input and allows submission
When the user clicks on the "Verify" button
Then the system processes the OTP
And the system successfully verifies the OTP and proceeds to the next step
Scenario: Multiple incorrect OTP entries
Given the user attempts to enter the incorrect OTP multiple times
Then the system should limit the number of attempts
And display a warning after several failed attempts
When the user checks if the account gets locked after multiple incorrect OTP attempts
Then the account remains unlocked
But the system may impose a temporary block on further OTP attempts
Scenario: Error logging and resend OTP option
When the user checks system logs for error logging when incorrect OTP is entered
Then the system logs the incorrect OTP attempt in the logs
When the user verifies if the "Resend OTP" option is available
Then the "Resend OTP" option is available for the user
When the user clicks on "Resend OTP"
Then a new OTP is sent to the registered phone number
Scenario: Behavior with new OTP after resend
Given a new OTP is sent after clicking "Resend OTP"
When the user enters an incorrect OTP after the new OTP is sent
Then the system should validate the new OTP and not accept the old incorrect OTP
Scenario: Notifications for incorrect OTP entries
When the user checks if they receive any notification or alert for incorrect OTP entries
Then the user receives an alert or notification for repeated incorrect OTP entries