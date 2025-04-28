Feature: Verify SMS with 6-digit code after entering email and password
Scenario: User receives a 6-digit verification code via SMS after entering email and password
Given the user has a valid phone number linked to their account
And the SMS service is operational
When the user navigates to the login page
Then the login page is displayed
Scenario: Entering email and password for login
Given the user is on the login page
When the user enters email "user@example.com" in the email field
Then the email is entered correctly
When the user enters password "correct_password" in the password field
Then the password is entered correctly
Scenario: User authentication and SMS verification
Given the user has entered correct email and password
When the user clicks on the "Login" button
Then the user is authenticated and redirected to the verification page
When the user waits to receive a 6-digit verification code via SMS on the registered phone number
Then an SMS with a 6-digit code is received on the user's phone
Scenario: Entering the received verification code
Given the user has received the SMS with the verification code
When the user enters the received 6-digit code in the verification field
Then the verification code is entered correctly
When the user clicks on the "Verify" button
Then the verification is successful and the user is logged in
Scenario: Post-login checks
Given the user is logged in
When the user checks the account dashboard for any alerts or notifications
Then no alerts or notifications related to verification issues are found
Scenario: Logout and re-login to verify consistent behavior
Given the user is logged in
When the user logs out from the account
Then the user is logged out successfully
When the user repeats the login process
Then SMS verification is consistently received and successful
Scenario: Verification of SMS logs and cross-device consistency
Given the user has logged in successfully
When the user checks SMS logs for the sent verification code
Then logs show the SMS was sent successfully
When the user attempts login from a different device
Then SMS verification works correctly on a different device
Scenario: System log checks and SMS compliance
Given the user has logged in successfully
When the user checks system logs for any errors related to SMS delivery
Then no errors related to SMS delivery are found in system logs
When the user verifies the SMS format and content for compliance
Then SMS format and content comply with standards
Scenario: SMS delivery time verification
Given the user has logged in successfully
When the user ensures the SMS delivery time is within acceptable limits
Then SMS is delivered within the expected time frame